import java.util.ArrayList;

/**
 * Class to represent the Manufacturer with stored Car Models 
 */
public class Manufacturer {
    private String name;
    private ArrayList<CarModel> carModels;

    /**
     * Constructs a Manufacturer with the name given
     * @param name Stores the name of the Manufacturer 
     */
    public Manufacturer(String name) {
        this.name = name;
        carModels = new ArrayList<CarModel>(); 
    }

    /**
     * Retrieves the manufacturer's name
     * @return Name of the manufacturer
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the list of car models associated with the manufacturer
     * @return Returns a list of Car Models 
     */
    public ArrayList<CarModel> getCarModels() {
        return carModels;
    }

    /**
     * Updates the manufacturer's stored name 
     * @param name The new name of the Manufacturer 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adds a new car model to the manufacturer's list
     * @param carModel The new Car Model to be added 
     */
    public void addCarModel(CarModel carModel) {
        carModels.add(carModel);
    }

    /**
     * Finds the most expensive Car Model and returns it to the user 
     * @return The most expensive car model, or returns null if no Models exist 
     */
    public CarModel getMostExpensiveCarModel() {
        if (carModels.isEmpty()) {
            return null;
        }

        CarModel mostExpensive = carModels.get(0);
        for (CarModel car : carModels) {
            if (car.getSalesPrice() > mostExpensive.getSalesPrice()) {
                mostExpensive = car;
            }
        }
        return mostExpensive;
    }

    /**
     * Calculates the total revenue generated by a specific Car Model Type 
     * @param type The type of car to filter by.
     * @return The total revenue from sales of the specified car type
     */
    public double getTotalRevenueByType(String type) {
        double total = 0;
        for (CarModel car : carModels) {
            if (car.getType().equalsIgnoreCase(type)) {
                total += car.getSalesPrice() * car.getNumberSold();
            }
        }
        return total;
    }

    /**
     * Shows a list of car models that have a price above a given amount
     * @param price The price threshold
     * @return Returns a list of Car Models above the given price 
     */
    public ArrayList<CarModel> getCarModelsAbovePrice(double price) {
        ArrayList<CarModel> result = new ArrayList<>();
        for (CarModel car : carModels) {
            if (car.getSalesPrice() > price) {
                result.add(car);
            }
        }
        return result;
    }
}