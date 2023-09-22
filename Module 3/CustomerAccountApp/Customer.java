/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package CustomerAccountApp;

public class Customer {

    // The following are Class Variables
    private String customer;
    private String address;
    private String city;
    private String zip;

    // This is the default constructor class. It sets the default parameters.
    public Customer() {
        this.customer = new String("Nolan Eitzen");
        this.address = new String("19221 Costanzo Plaza, APT 3B");
        this.city = new String("Elkhorn");
        this.zip = new String("68022");
    } // End Customer()

    /*
     * This constructor class allows users to set each class variable.
     * @param customer String
     * @param address String
     * @param city String
     * @param zip String
     */
    public Customer(String customer, String address, String city, String zip){
        this.customer = customer;
        this.address = address;
        this.city = city;
        this.zip = zip;
    } // End Customer(String, String, String, String)


    // This method overrides the default toString method. It returns a string containing all private variables.
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("  Name: " + customer + "\n");
        str.append("  Address: " + address + "\n");
        str.append("  City: " + city + "\n");
        str.append("  Zip: " + zip + "\n");
        return str.toString();
    } // End toString

    /*
     * This setter method overrides the customer class variable
     * @param customer String
     */
    public void setCustomer(String customer) {
        this.customer = customer;
    } // End setCustomer

    /*
     * This setter method overrides the address class variable
     * @param address String
     */
    public void setAddress(String address) {
        this.address = address;
    } // End setAddress

    /*
     * This setter method overrides the city class variable.
     * @param city String
     */
    public void setCity(String city) {
        this.city = city;
    } // End setCity

    /*
     * This setter method overrides the zip class variable.
     * @param zip String
     */
    public void setZip(String zip) {
        this.zip = zip;
    } // End setZip

    // This getter method returns the customer class variable.
    public String getCustomer() {
        return customer;
    } // End getCustomer

    // This getter method returns the address class variable.
    public String getAddress() {
        return address;
    } // End getAddress

    // This getter method returns the city class variable
    public String getCity() {
        return city;
    } // End getCity

    // This getter method returns the zip class variable.
    public String getZip() {
        return zip;
    } // End getZip
} // End Customer Class