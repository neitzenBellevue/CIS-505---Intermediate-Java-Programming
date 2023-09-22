/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package BowlingShopApp;

public class Ball extends Product{
    // The following is the Ball class private variable.
    private String color;

    // The default Ball constructor calls the super() constructor and assigns an empty String to the color variable.
    public Ball(){
        super(); // This is implicitly called, but added to clarify.
        this.color = "";
    } // End Ball()

    // This overridden toString() method appends the color private variable to the super class's toString() method.
    public String toString(){
        String tempString = new String();
        tempString = super.toString();
        tempString += "  Color: " + color;
        return tempString;        
    } // End toString()

    // This getter method returns the color class variable.
    public String getColor() {
        return color;
    } // End getColor()

    /*
     * This setter method takes a String and assigns it to the color class variable.
     * @param color String
     */
    public void setColor(String color) {
        this.color = color;
    } // End setColor()
} // End Product
