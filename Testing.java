public class Testing {
    public static void main(String[] args) {
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
        report.addManufacturer(mazda);

        // Start ReportingIO 
        ReportingIO reportingIO = new ReportingIO(report);
        reportingIO.displayMenu();
    }
}
