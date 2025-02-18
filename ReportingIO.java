import java.util.Scanner;

public class ReportingIO {
    private Reporting report;
    private Scanner scanner;

    public ReportingIO(Reporting report) {
        this.report = report;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nCar Sales Management Menu System");
            System.out.println("1. Display the priciest car sold");
            System.out.println("2. Display the manufacturer with the highest earnings");
            System.out.println("3. Display cars priced above a specific amount");
            System.out.println("4. Exit");
            System.out.print("Please enter your selection: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    displayMostExpensiveCar();
                    break;
                case 2:
                    displayManufacturerWithHighestRevenue();
                    break;
                case 3:
                    displayCarsAbovePrice();
                    break;
                case 4:
                    System.out.println("Quitting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("ERROR: Invalid Choice!");
            }
        }
    }

    private void displayMostExpensiveCar() {
        CarModel expensiveCar = report.getMostExpensiveCarModelSold();
        if (expensiveCar != null) {
            System.out.println("Most Expensive Car: " + expensiveCar.getName() + " (£" + expensiveCar.getSalesPrice() + ")");
        } else {
            System.out.println("No cars available.");
        }
    }

    private void displayManufacturerWithHighestRevenue() {
        System.out.print("Enter car type (Hatchback, Saloon, Estate): ");
        String carType = scanner.nextLine();
        Manufacturer topManufacturer = report.getManufacturerWithHighestRevenue(carType);
        if (topManufacturer != null) {
            System.out.println("Top Manufacturer for " + carType + ": " + topManufacturer.getName());
        } else {
            System.out.println("No manufacturer found.");
        }
    }

    private void displayCarsAbovePrice() {
        System.out.print("Enter minimum price (£): ");
        double priceLimit = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.println("Cars costing more than £" + priceLimit + ":");
        for (CarModel car : report.getCarModelsAbovePrice(priceLimit)) {
            System.out.println(car.getName() + " (£" + car.getSalesPrice() + ")");
        }
    }
}