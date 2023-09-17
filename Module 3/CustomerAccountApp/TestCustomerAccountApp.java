
/* * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package CustomerApp;
import java.util.Scanner;

public class TestCustomerAccountApp  {
    public static void main(String[] args) {
        Scanner accountScanner = new Scanner(System.in);
        int userInput;
        String userString;
        Customer instanceCustomer;
        boolean loop = true;

        // This section prompts the user to input a customer ID. Uses ID to create Customer object
        System.out.println("  Welcome to the Customer Account App\n");
        System.out.print("  Enter a customer ID:\n    ex: 1007, 1008, 1009>: ");
        userInput = accountScanner.nextInt(); // No logic for what happens when the user puts a non-int was required
        instanceCustomer = CustomerDB.getCustomer(userInput);
        
        /*
         * This section involves the account menu.
         * It checks for a valid input and gives users further prompts, such as withdrawing money.
         * Prompts user to continue (y/n) at end. Account is persistent thru loop.
         */
        Account userAccount = new Account();
        while(loop){
            System.out.println();
            userAccount.displayMenu();
            userString = accountScanner.next();
            if(userString.equals("D") || userString.equals("d")){
                System.out.print("\n  Enter deposit amount: ");
                userAccount.deposit(accountScanner.nextDouble()); // No logic for what happens when the user puts a non-double was required
            }
            else if(userString.equals("W") || userString.equals("w")){
                System.out.print("\n  Enter withdraw amount: ");
                userAccount.withdraw(accountScanner.nextDouble()); // No logic for what happens when the user puts a non-double was required
            }
            else if(userString.equals("B") || userString.equals("b")){
                System.out.printf("\n  Account balance: $%6.2f\n", userAccount.getBalance());
            }
            else{
                System.out.println("\n  Error: Invalid option");
            }
            System.out.print("\n  Continue? (y/n): "); // No logic for what happens when an input that is no y/n was required. Default behavior is to loop again.
            userString = accountScanner.next();
            if(userString.equals("n")) {
                System.out.println("\n  --Customer Details--");
                System.out.print(instanceCustomer.toString());
                System.out.printf("\n  Balance as of %s is $%6.2f\n", userAccount.getTransactionDate(), userAccount.getBalance());
                loop = false;
            }
        } // End Account Menu Loop

        System.out.print("\n  End of line...");
    } // End Main
} // End TestCustomerAccountApp
