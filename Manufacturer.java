import java.util.ArrayList;

public class Manufacturer {
    private String name;
    private ArrayList<CarModel> carModels;

    // Constructor
    public Manufacturer(String name) {
        this.name = name;
        carModels = new ArrayList<CarModel>(); // Initialise the list
    }

    // Getters
    public String getName() {
        return name;
    }

    public ArrayList<CarModel> getCarModels() {
        return carModels;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    // Method to add a car model
    public void addCarModel(CarModel carModel) {
        carModels.add(carModel);
    }

     // Method to find the most expensive car model
     public CarModel getMostExpensiveCarModel() {
        if (carModels.isEmpty()) {
            return null; // Return null if no car models exist
        }

        CarModel mostExpensive = carModels.get(0);
        for (CarModel car : carModels) {
            if (car.getSalesPrice() > mostExpensive.getSalesPrice()) {
                mostExpensive = car;
            }
        }
        return mostExpensive;
    }

    // Method to calculate total revenue for a specific car type
    public double getTotalRevenueByType(String type) {
        double total = 0;
        for (CarModel car : carModels) {
            if (car.getType().equalsIgnoreCase(type)) {
                total += car.getSalesPrice() * car.getNumberSold();
            }
        }
        return total;
    }

    // Method to get all car models above a certain price
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
