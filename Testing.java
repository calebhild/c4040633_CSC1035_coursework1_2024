import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Manufacturers
        Manufacturer volkswagen = new Manufacturer("Volkswagen");
        Manufacturer vauxhall = new Manufacturer("Vauxhall");
        Manufacturer mazda = new Manufacturer("Mazda");

        // Create Car Models
        CarModel up = new CarModel("Up", 1000, 16000, 500, "Hatchback");
        CarModel polo = new CarModel("Polo", 1200, 17500, 615, "Hatchback");
        CarModel corsa = new CarModel("Corsa", 1300, 28000, 475, "Hatchback");
        CarModel golf = new CarModel("Golf", 1600, 25250, 750, "Hatchback");
        CarModel mx5 = new CarModel("MX5", 900, 34150, 200, "Hatchback");

        // Add Car Models to Manufacturers
        volkswagen.addCarModel(up);
        volkswagen.addCarModel(polo);
        volkswagen.addCarModel(golf);
        vauxhall.addCarModel(corsa);
        mazda.addCarModel(mx5);

        // Create Reporting
        Reporting report = new Reporting();
        report.addManufacturer(volkswagen);
        report.addManufacturer(vauxhall);
        report.addManufacturer(mazda); // Add Mazda to the report for comparison

        // Menu loop
        while (true) {
            System.out.println("\nCar Sales Management Menu System");
            System.out.println("1. Display the priciest car sold");
            System.out.println("2. Display the manufacturer with the highest earnings");
            System.out.println("3. Display cars priced above a specific amount");
            System.out.println("4. Exit");
            System.out.print("Please enter your selection: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            if (choice == 1) {
                CarModel expensiveCar = report.getMostExpensiveCarModelSold();
                if (expensiveCar != null) {
                    System.out.println("Most Expensive Car: " + expensiveCar.getName() + " (£" + expensiveCar.getSalesPrice() + ")");
                } else {
                    System.out.println("No cars available.");
                }

            } else if (choice == 2) {
                System.out.print("Enter car type (Hatchback, Saloon, Estate): ");
                String carType = scanner.nextLine();
                Manufacturer topManufacturer = report.getManufacturerWithHighestRevenue(carType);
                if (topManufacturer != null) {
                    System.out.println("Top Manufacturer for " + carType + ": " + topManufacturer.getName());
                } else {
                    System.out.println("No manufacturer found.");
                }

            } else if (choice == 3) {
                System.out.print("Enter minimum price (£): ");
                double priceLimit = scanner.nextDouble();
                System.out.println("Cars costing more than £" + priceLimit + ":");
                for (CarModel car : report.getCarModelsAbovePrice(priceLimit)) {
                    System.out.println(car.getName() + " (£" + car.getSalesPrice() + ")");
                }

            } else if (choice == 4) {
                System.out.println("quitting...");
                scanner.close();
                break;

            } else {
                System.out.println("ERROR: Invalid Choice!");
            }
        }
    }
}