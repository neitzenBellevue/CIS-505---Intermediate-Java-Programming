package BowlingShopApp;

public class Shoe extends Product{
    private double size;

    // The default Shoe constructor calls the super() constructor and assigns 0 to the size variable.
    public Shoe(){
        super(); // This is implicitly called, but added to clarify.
        this.size = 0;
    } // End Shoe()

    // This overridden toString() method appends the size private variable to the super class's toString() method.
    public String toString(){
        String tempString = new String();
        tempString = super.toString();
        tempString += "  Shoe: " + Double.toString(size);
        return tempString; 
    } // End toString()

    // This getter method returns the size class variable.
    public double getSize() {
        return size;
    } // End getSize()

    /*
     * This setter method assigns the passed double to the size class variable.
     * @param size double
     */
    public void setSize(double size) {
        this.size = size;
    } // End setSize()
} // End Shoe
