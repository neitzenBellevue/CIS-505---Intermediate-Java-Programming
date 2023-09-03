/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */
public class Fan {
    //The following are the Class Variables
    final int STOPPED = 0;
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 2;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    //Default Constructor Method
    public Fan(){
        int speed = STOPPED;
        boolean on = false;
        double radius = 6;
        color = new String("White");
    } // End Fan

    /*
     * This constructor initiates each variable a fan has.
     * @param newSpeed int
     * @param isOn boolean
     * @param newRadius double
     * @param newColor string
     */
    public Fan(int newSpeed, boolean isOn, double newRadius, String newColor){
        setSpeed(newSpeed);
        setOn(isOn);
        setRadius(newRadius);
        setColor(newColor);
    } // End Fan(int, bool, double, String)

    //This is a Accessor method for the "speed" variable
    public int getSpeed(){
        return speed;
    } // End getSpeed

    public String toString(){
        if getOn(){

        }
        else{

        }
    }

    //This is a Accessor method for the "on" variable
    public boolean getOn(){
        return on;
    } // End getOn
    
    //This is a Accessor method for the "radius" variable
    public double getRadius(){
        return radius;
    } // End getRadius

    //This is a Accessor method for the "color" variable
    public String getColor(){
        return color;
    } // End getColor

    /*
     * This is a mutator method for the variable "speed"
     * @param newSpeed int
     */
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    } // End setSpeed

    /*
     * This is a mutator method for the variable "on"
     * @param isOn boolean
     */
    public void setOn(boolean isOn){
        on = isOn;
    } // End setOn

    /*
     * This is a mutator method for the variable "radius"
     * @param newRadius double
     */
    public void setRadius(double newRadius){
        radius = newRadius;
    } // End SetRadius

    /*
     * This is a mutator method for the variable "color"
     * @param newColor String
     */
    public void setColor(String newColor){
        color = newColor;
    } //End setColor
}// end Fan
