import java.util.ArrayList;

public class Reporting {
    private ArrayList<Manufacturer> manufacturers;                                                                  // List of manufacturers

    public Reporting() {                                                                                            // Constructor
        manufacturers = new ArrayList<>();                                                                          // Create an empty list
    }

    public void addManufacturer(Manufacturer manufacturer) {                                                        // Add a manufacturer to the list
        manufacturers.add(manufacturer);
    }

    public ArrayList<Manufacturer> getManufacturers() {                                                            // Get the list of manufacturers
        return manufacturers;
    }

    public CarModel getMostExpensiveCarModelSold() {                                                               // Find the most expensive car model sold
        if (manufacturers.size() == 0) {                                                                           // If no manufacturers exist, return null
            return null;
        }

        CarModel mostExpensive = null;

        for (int i = 0; i < manufacturers.size(); i++) {
            CarModel expensiveCar = manufacturers.get(i).getMostExpensiveCarModel();

            if (expensiveCar != null) {                                                                           // Check if car exists
                if (mostExpensive == null || expensiveCar.getSalesPrice() > mostExpensive.getSalesPrice()) {
                    mostExpensive = expensiveCar;                                                                 // Update most expensive car
                }
            }
        }
        return mostExpensive;
    }

public Manufacturer getManufacturerWithHighestRevenue(String type) {                                         // Find the manufacturer with the most revenue for a given car type
    if (manufacturers.size() == 0) {                                                                         // If no manufacturers exist, return null
        return null;
    }

    Manufacturer highestManufacturer = null;
    double highestRevenue = 0;

    for (int i = 0; i < manufacturers.size(); i++) {
        double revenue = manufacturers.get(i).getTotalRevenueByType(type);

        if (revenue > highestRevenue) {                                                                      // Check if revenue is higher
            highestRevenue = revenue;
            highestManufacturer = manufacturers.get(i);
        }
    }
    return highestManufacturer;
}

public ArrayList<CarModel> getCarModelsAbovePrice(double price) {                                            // Get all car models that are above a certain price
    ArrayList<CarModel> expensiveCars = new ArrayList<>();

    for (int i = 0; i < manufacturers.size(); i++) {
        ArrayList<CarModel> carsFromManufacturer = manufacturers.get(i).getCarModelsAbovePrice(price);

        for (int j = 0; j < carsFromManufacturer.size(); j++) {                                             // Add all expensive cars from this manufacturer to the list
            expensiveCars.add(carsFromManufacturer.get(j));
        }
    }
    return expensiveCars;
}
}
