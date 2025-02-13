import java.util.ArrayList;

public class Manufacturer {
    private String name;
    private ArrayList<CarModel> carModels; // Stores car models made by this manufacturer

    // Constructor
    public Manufacturer(String name) {
        this.name = name;
        carModels = new ArrayList<CarModel>(); // Initialize the list
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
}
