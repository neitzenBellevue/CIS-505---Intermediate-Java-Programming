package BowlingShopApp;

public class Bag extends Product{
    private String type;

    public Bag(){
        super(); // This is implicitly called, but added to clarify.
        this.type = "";
    } // End Bag()

    // This overridden toString() method appends the type private variable to the super class's toString() method.
    public String toString(){
        String tempString = new String();
        tempString = super.toString();
        tempString += "  Type: " + type;
        return tempString; 
    } // End toString()

    // This getter method returns the type class variable.
    public String getType() {
        return type;
    } // End getType()

    /*
     * This setter method takes a String and assigns it to the type class variable.
     * @param type String
     */
    public void setType(String type) {
        this.type = type;
    } // End setType()
} // End Bag
