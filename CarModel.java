/**
 * Represents a car model with details such as name, weight, price, sales numbers, and type
 */
public class CarModel {
    private String name;
    private double weight;
    private double salesPrice;
    private int numberSold;
    private String type; 

    /**
     * Constructs a Car Model object with these attributes 
     * 
     * @param name       The name of the Car Model
     * @param weight     The weight of the car (in kg)
     * @param salesPrice The sales price of the Car
     * @param numberSold The total number of units sold
     * @param type       The type of the car e.g. (Hatchback, Saloon, or Estate)
     */
    public CarModel(String name, double weight, double salesPrice, int numberSold, String type) {
        this.name = name;
        this.weight = weight;
        this.salesPrice = salesPrice;
        this.numberSold = numberSold;
        this.type = type;
    }

    /**
     * Retrieves the name of the Car Model
     * 
     * @return Name of the Car Model
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the weight of the Car
     * 
     * @return Returns the weight of the Car in KG 
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Retrieves the sales price of the Car
     * 
     * @return Returns the price of which the Car is sold at 
     */
    public double getSalesPrice() {
        return salesPrice;
    }

    /**
     * Retrieves the total number of units sold for the Car Model
     * 
     * @return The total number of Cars sold
     */
    public int getNumberSold() {
        return numberSold;
    }

    /**
     * Retrieves the Car Type
     * 
     * @return Returns the Car Type 
     */
    public String getType() {
        return type;
    }

    /**
     * Updates the name of the Car Model to the new one
     * 
     * @param name Returns the new name of the Car Model 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Updates the Weight of the Car to the new one
     * 
     * @param weight Returns the new weight of the Car
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Updates the sales price of the Car to the new one 
     * 
     * @param salesPrice Returns the updated price at which the Car is sold 
     */
    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    /**
     * Updates the number of units sold for this Car model
     * 
     * @param numberSold The updated units of the Car sold 
     */
    public void setNumberSold(int numberSold) {
        this.numberSold = numberSold;
    }

    /**
     * Updates the type of the Car to the new one 
     * 
     * @param type Returns the new Car Type 
     */
    public void setType(String type) {
        this.type = type;
    }
}
