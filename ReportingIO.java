import java.util.Scanner;

/**
 * Allows User interactions with the system 
 */
public class ReportingIO {
    private Reporting report;
    private Scanner scanner;

    /**
     * Constructs a ReportingIO instance 
     * @param report The reporting system instance
     */
    public ReportingIO(Reporting report) {
        this.report = report;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main Menu with 6 options to the user 
     */
    public void displayMenu() {
        while (true) {
            System.out.println("\nCar Sales System - Main Menu");
            System.out.println("1. Add a new manufacturer");
            System.out.println("2. Add a new car model");
            System.out.println("3. Show all manufacturers");
            System.out.println("4. Show car models from a specific manufacturer");
            System.out.println("5. View sales and Statistics");
            System.out.println("6. Exit the system");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    addManufacturer();
                    break;
                case 2:
                    addCarModel();
                    break;
                case 3:
                    showManufacturers();
                    break;
                case 4:
                    showCarModelsByManufacturer();
                    break;
                case 5:
                    viewReports();
                    break;
                case 6:
                    System.out.println("--Exiting system-- ");
                    scanner.close();
                    return;
                default:
                    System.out.println("--INVALID OPTION--");
            }
        }
    }

    /**
     * Allows the user to enter a manufacturer and add it to the system 
     */
    private void addManufacturer() {
        System.out.print("Please enter the manufacturer's name: ");
        String name = scanner.nextLine();
        report.addManufacturer(new Manufacturer(name));
        System.out.println("--Manufacturer successfully added--");
    }

    /**
     * Allows the user to add a car model to associate to the manufacturer provided 
     */
    private void addCarModel() {
        System.out.print("Enter the name of the manufacturer: ");
        String manufacturerName = scanner.nextLine();
        Manufacturer manufacturer = findManufacturer(manufacturerName);
        if (manufacturer == null) {
            System.out.println("--NO MANUFACTURER FOUND--");
            return;
        }
        
        System.out.print("Enter the car model name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the weight of the car: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter the selling price: ");
        double salesPrice = scanner.nextDouble();
        System.out.print("Enter the number of units sold: ");
        int numberSold = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Specify the Car type (Hatchback, Saloon, Estate): ");
        String type = scanner.nextLine();
        
        manufacturer.addCarModel(new CarModel(name, weight, salesPrice, numberSold, type));
        System.out.println("--Car model has been successfully added--");
    }

    /**
     * Finds a manufacturer by name
     * @param name Name of the manufacturer
     * @return Returns the Manufacturer found, if no Manufacturer found returns null
     */
    private Manufacturer findManufacturer(String name) {
        for (Manufacturer m : report.getManufacturers()) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;
    }

    /**
     * Displays a list of all manufacturers
     */
    private void showManufacturers() {
        System.out.println("\nList of Manufacturers:");
        for (Manufacturer m : report.getManufacturers()) {
            System.out.println("- " + m.getName());
        }
    }

    /**
     * Displays car models from the specified Manufacturer
     */
    private void showCarModelsByManufacturer() {
        System.out.print("Enter the name of the manufacturer: ");
        String manufacturerName = scanner.nextLine();
        Manufacturer manufacturer = findManufacturer(manufacturerName);
        if (manufacturer == null) {
            System.out.println("--NO MATCHING MANUFACTURERS FOUND--.");
            return;
        }
        
        System.out.println("\nCar Models from " + manufacturer.getName() + ":");
        for (CarModel car : manufacturer.getCarModels()) {
            System.out.println(car.getName() + " - Price: £" + car.getSalesPrice());
        }
    }

    /**
     * Displays the sales/ Statistics menu
     */
    private void viewReports() {
        System.out.println("\nSales and Revenue Reports");
        System.out.println("1. Most expensive car model sold");
        System.out.println("2. Manufacturer with the highest earnings");
        System.out.println("3. Cars that sold above a set price");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                showMostExpensiveCar();
                break;
            case 2:
                showTopManufacturerByRevenue();
                break;
            case 3:
                showCarsAbovePrice();
                break;
            default:
                System.out.println("--INVALID OPTION--");
        }
    }

    /**
     * Displays the most expensive car model sold
     */
    private void showMostExpensiveCar() {
        CarModel expensiveCar = report.getMostExpensiveCarModelSold();
        if (expensiveCar != null) {
            System.out.println("The most expensive car sold is " + expensiveCar.getName() + ", priced at £" + expensiveCar.getSalesPrice());
        } else {
            System.out.println("No car sales data available.");
        }
    }

    /**
     * Displays the manufacturer with the highest revenue for the specified Car Type
     */
    private void showTopManufacturerByRevenue() {
        System.out.print("Enter a car type (Hatchback, Saloon, Estate): ");
        String carType = scanner.nextLine();
        Manufacturer topManufacturer = report.getManufacturerWithHighestRevenue(carType);
        if (topManufacturer != null) {
            System.out.println("The top earning manufacturer for " + carType + " is " + topManufacturer.getName());
        } else {
            System.out.println("No data available for that car type.");
        }
    }

    /**
     * Displays cars that were sold for more than a certain price
     */
    private void showCarsAbovePrice() {
        System.out.print("Enter the minimum price (£): ");
        double priceLimit = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.println("These cars were sold for more than £" + priceLimit + ":");
        for (CarModel car : report.getCarModelsAbovePrice(priceLimit)) {
            System.out.println("- " + car.getName() + " (£" + car.getSalesPrice() + ")");
        }
    }
}
