public class Testing {
    public static void main(String[] args) {
        // Create Manufacturers
        Manufacturer volkswagen = new Manufacturer("Volkswagen");
        Manufacturer vauxhall = new Manufacturer("Vauxhall");

        // Create Car Models
        CarModel up = new CarModel("Up", 1000, 15000, 500, "hatchback");
        CarModel polo = new CarModel("Polo", 1200, 18000, 600, "hatchback");
        CarModel corsa = new CarModel("Corsa", 1300, 25000, 500, "hatchback");
        CarModel golf = new CarModel("Golf", 1600, 25000, 700, "hatchback");

        // Add Car Models to Manufacturers
        volkswagen.addCarModel(up);
        volkswagen.addCarModel(polo);
        volkswagen.addCarModel(golf);
        vauxhall.addCarModel(corsa);

        // Create Reporting
        Reporting report = new Reporting();
        report.addManufacturer(volkswagen);
        report.addManufacturer(vauxhall);

        // Test getMostExpensiveCarModelSold()
        CarModel expensiveCar = report.getMostExpensiveCarModelSold();
        if (expensiveCar != null) {
            System.out.println("Most Expensive Car Sold: " + expensiveCar.getName() + " - £" + expensiveCar.getSalesPrice());
        } else {
            System.out.println("No cars available.");
        }

        // Test getManufacturerWithHighestRevenue()
        String carType = "hatchback";
        Manufacturer topManufacturer = report.getManufacturerWithHighestRevenue(carType);
        if (topManufacturer != null) {
            System.out.println("Manufacturer with highest revenue for " + carType + ": " + topManufacturer.getName());
        } else {
            System.out.println("No manufacturer found.");
        }

        // Test getCarModelsAbovePrice()
        double priceLimit = 22000;
        System.out.println("Cars costing more than £" + priceLimit + ":");
        for (CarModel car : report.getCarModelsAbovePrice(priceLimit)) {
            System.out.println(car.getName() + " - £" + car.getSalesPrice());
        }
    }
}
