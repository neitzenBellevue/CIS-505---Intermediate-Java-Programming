/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */
public class Fan {
    //The following are the Class Variables
    final static int STOPPED = 0;
    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    //Default Constructor Method
    public Fan(){
        speed = STOPPED;
        on = false;
        radius = 6;
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

    // This overrides the default toString variable. Returns a descriptive string.
    public String toString(){
        String ldescription = new String();
        if (getOn()){
            ldescription = "The fan is " + getColor() + " with a radius of " + getRadius() + " and the fan is on.";
        }
        else{
            ldescription = "The fan is " + getColor() + " with a radius of " + getRadius() + " and the fan is off.";
        }
        return ldescription;
    } // End toString

    //This is a Accessor method for the "speed" variable
    public int getSpeed(){
        return speed;
    } // End getSpeed

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
     * This is a mutator method for the variable "speed". Checks if newSpeed is valid then assigns it. Else, does not change.
     * @param newSpeed int
     */
    public void setSpeed(int newSpeed){
        if(newSpeed > 0 || newSpeed < 4){
            speed = newSpeed;
        }
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
