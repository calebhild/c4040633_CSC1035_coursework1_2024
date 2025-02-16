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
}
