/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package ExpenseTracker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    // The following are private class variables.
    private String date;
    private String description;
    private double amount;

    // This default constructor sets the private variables to their default values.
    public Transaction(){
        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("yyyy/MM/dd"); // Specifies the desired date format
        this.date = dateFormater.format(LocalDate.now()); // Uses the specified date format to get todays date.
        this.description = "";
        this.amount = 0;
    } // End Transaction()

    /*
     * This constructor takes three arguements and sets all class variables.
     * @param date String
     * @param description String
     * @param amount double
     */
    public Transaction(String date, String desription, double amount){
        this.date = date;
        this.description = desription;
        this.amount = amount;
    } // End Transaction(String, String, double)

    // The following overrides the default toString method. It returns a string with each class variable.
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("  Date: " + date+ "\n");
        str.append("  Description: " + description + "\n");
        str.append("  Amount: $" + amount + "\n");
        return str.toString();
    } // End toString()

    // This getter returns the amount class variable.
    public double getAmount() {
        return amount;
    } // End getAmount()

    /*
     * This setter method modifies the amount class variable.
     * @param amount double
     */
    public void setAmount(double amount) {
        this.amount = amount;
    } // End setAmount(double)

    // This getter method returns the description class variable.
    public String getDescription() {
        return description;
    } // End getDescription()

    /*
     * This setter method modifies the description class variable.
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    } // End setDescription(String)

    // This getter returns the date class variable.
    public String getDate() {
        return date;
    } // End getDate()

    /*
     * This setter method modifies the date class variable.
     * @param date String
     */
    public void setDate(String date) {
        this.date = date;
    }  // End getDate(String)
} // End Transaction
