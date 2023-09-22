/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package BowlingShopApp;

public class Product {
    //The following are the private Class variables
    private String code;
    private String description;
    private double price;

    // The default constructor creates an object with an empty code and description. Price is set to 0.
    public Product(){
        this.code = "";
        this.description = "";
        this.price = 0;
    } // End Product()

    // The overridden toString() method returns the private variables each on a newline.
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("  Product Code: " + code + "\n");
        str.append("  Description: " + description + "\n");
        str.append("  Price: $" + price + "\n");
        return str.toString();
    } // End toSTring();

    // This getter method returns the code class variable.
    public String getCode() {
        return code;
    } // End getCode();

    /*
     * This setter method takes a string and assigns it to the code class variable.
     * @param code String
     */
    public void setCode(String code) {
        this.code = code;
    } // End setCode()

    // This getter method returns the description class variable.
    public String getDescription() {
        return description;
    } // End getDescription()

    /*
     * This setter method takes a string and assigns it to the description class variable.
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    } // End setDescription()

    // This getter method returns the price class variable.
    public double getPrice() {
        return price;
    } // End getPrice()

    /*
     * This setter method takes a double and assigns it to the price class variable.
     */
    public void setPrice(double price) {
        this.price = price;
    } // End setPrice()
} // End Product
