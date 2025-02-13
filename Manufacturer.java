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

public CarModel
getMostExpensiveCarModel (){
    if (carModels.size() == 0){
        return null // Return null if no car model excists 
    }
    CarModel mostExpensive = carModels.get(0);
    for (int i =1; i < carModels.size(); i++)
    {
        if (carModels.get(i).getSalesPrice() > mostExpensive.getSalesPrice()){
            mostExpensive = carModels.get(i);
        }
    }
    return mostExpensive;
}