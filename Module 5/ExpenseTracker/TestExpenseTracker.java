/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package ExpenseTracker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {
    
    // This method returns a string containing the transaction menu.
    public static String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n  Menu Options\n");
        stringBuilder.append("    1. View Transactions\n");
        stringBuilder.append("    2. Add Transactions\n");
        stringBuilder.append("    3. View Expense\n\n");
        stringBuilder.append("  Please choose an option: ");
        return stringBuilder.toString();
    } // End menu()

    /*
     * The following main method runs the Expense Tracker app.
     * @param args String[]
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean programLoop = true;
        System.out.println("  Welcome to the Expense Tracker");
        while(programLoop){
            int input = ValidatorIO.getInt(sc, menu());
            switch(input){
                case 1: // This case writes all transactions in a file to the command line.
                    try{
                        ArrayList<Transaction> transactions = TransactionIO.findAll();
                        System.out.println("\n  Monthly Expenses\n");
                        for (Transaction trans : transactions){
                            System.out.println(trans.toString());
                        }
                    }
                    catch(IOException io){
                        System.out.println("\n  Exception: " + io.getMessage());
                    }
                    break;
                case 2: // This case prompts the user to create a new transaction. It adds it to the trans ArrayList. Once loop has been ended it writes all transactions.
                    boolean transLoop = true;
                    ArrayList<Transaction> trans = new ArrayList<Transaction>();
                    while(transLoop){
                        
                            Transaction tran = new Transaction();
                            tran.setDescription(ValidatorIO.getString(sc, "\n  Enter the description: ")); 
                            tran.setAmount(ValidatorIO.getDouble(sc, "  Enter the amount: "));         
                            trans.add(tran);
                            if(!ValidatorIO.getString(sc, "\n  Add another transaction? (y/n): ").equalsIgnoreCase("y")){
                                transLoop = false;
                                System.out.println();
                            }
                    } // End while(transLoop)
                    try{
                        TransactionIO.bulkInsert(trans);
                    }
                    catch(IOException io){
                        System.out.println("\n  Exception: " + io.getMessage());
                    } 
                    break;
                case 3:
                    double total = 0;
                    try{
                        for(Transaction transactions : TransactionIO.findAll()){
                            total += transactions.getAmount();
                        }
                    }
                    catch(IOException io){
                        System.out.println("\n  Exception: " + io.getMessage());
                    }
                    System.out.printf("\n  Your total monthly expense is $%6.2f\n\n", total);
                    break;
            } // End switch(input)
            if(!ValidatorIO.getString(sc, "  Continue? (y/n): ").equalsIgnoreCase("y")){
                programLoop = false;
                System.out.println("\n  Program terminated by user...");
            }
        } // End while(programLoop)
    } // End main(String[])
} // End TestExpenseTracker
