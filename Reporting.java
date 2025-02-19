import java.util.ArrayList;

/**
 * Manages the reporting system for car manufacturers and their data
 */
public class Reporting {
    private ArrayList<Manufacturer> manufacturers;

    /**
     * Initializes the Reporting system with an empty list of manufacturers
     */
    public Reporting() {
        manufacturers = new ArrayList<>();
    }

    /**
     * Adds a manufacturer to the list
     * @param manufacturer The name of the manufacturer to be added
     */
    public void addManufacturer(Manufacturer manufacturer) {
        manufacturers.add(manufacturer);
    }
  
    /**
     * Retrieves the list of manufacturers
     * @return A list of all stored Manufacturers 
     */
    public ArrayList<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    /**
     * Finds the most expensive Car Model sold and returns it to the user
     * @return Returns the most expensive Car Model sold, or returns null if none is found
     */
    public CarModel getMostExpensiveCarModelSold() {
        if (manufacturers.size() == 0) {
            return null;
        }

        CarModel mostExpensive = null;

        for (int i = 0; i < manufacturers.size(); i++) {
            CarModel expensiveCar = manufacturers.get(i).getMostExpensiveCarModel();

            if (expensiveCar != null) {
                if (mostExpensive == null || expensiveCar.getSalesPrice() > mostExpensive.getSalesPrice()) {
                    mostExpensive = expensiveCar;
                }
            }
        }
        return mostExpensive;
    }

    /**
     * Works out the manufacturer with the highest revenue for a specific car type
     * @param type The type of car to check revenue for
     * @return Returns the manufacturer with the highest revenue, or returns null if no Manufacturer exists 
     */
    public Manufacturer getManufacturerWithHighestRevenue(String type) {
        if (manufacturers.size() == 0) {
            return null;
        }

        Manufacturer highestManufacturer = null;
        double highestRevenue = 0;

        for (int i = 0; i < manufacturers.size(); i++) {
            double revenue = manufacturers.get(i).getTotalRevenueByType(type);

            if (revenue > highestRevenue) {
                highestRevenue = revenue;
                highestManufacturer = manufacturers.get(i);
            }
        }
        return highestManufacturer;
    }

    /**
     * Retrieves a list of car models that have a selling price above a certain value
     * @param price The min price to search for 
     * @return A list of car models above the given price 
     */
    public ArrayList<CarModel> getCarModelsAbovePrice(double price) {
        ArrayList<CarModel> expensiveCars = new ArrayList<>();

        for (int i = 0; i < manufacturers.size(); i++) {
            ArrayList<CarModel> carsFromManufacturer = manufacturers.get(i).getCarModelsAbovePrice(price);

            for (int j = 0; j < carsFromManufacturer.size(); j++) {
                expensiveCars.add(carsFromManufacturer.get(j));
            }
        }
        return expensiveCars;
    }
}