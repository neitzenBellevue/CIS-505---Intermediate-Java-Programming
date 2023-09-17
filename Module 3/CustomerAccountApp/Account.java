/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package CustomerApp;

public class Account {
    private double balance = 200;
    
    // This getter method returns the balance class variable.
    public double getBalance() {
        return balance;
    } // End getBalance

    /*
     * This method adds any positive amount to the balance variable.
     * @param amt Double
     */
    public void deposit(double amt){
        if(amt >= 0){
            this.balance += amt;
        }
    } // End deposit

    /*
     * This method reduces the balance variable.
     * @param amt Double
     */
    public void withdraw(double amt){
        this.balance -= amt;
    } // End withdraw

    // This prints a menu for users.
    public void displayMenu(){
        System.out.println("  Account Menu");
        System.out.println("  Enter <D/d> for deposit");
        System.out.println("  Enter <W/w> for withdraw");
        System.out.println("  Enter <B/b> for balance");
        System.out.print("    Enter Option>: ");
    } // End displayMenu

    // This prints out a date. No requirements were given for what the date should be.
    public String getTransactionDate(){
        return "09-16-2023";
    } // End getTransactionDate
}
