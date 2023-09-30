/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package ExpenseTracker;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;

/*
    1. A private string constant data field named FILE_NAME. The default value is
    “expenses.txt”

    2. A private File data field name file. The default value is a new File instance. Use the
    FILE_NAME constant as the argument for the new file instance.
        
    3. A public static method named bulkInsert with an ArrayList<Transaction> argument
    named transactions and a return type of void. Give the signature of this method a
    “throws IOException.” In the body of the function, create a new PrintWriter variable
    named output and set the default value to null. Using an if…else statement, check if the
    file exists. For true comparisons, assign a new PrintOutStream to the output variable.
    For false comparison, set output to a new PrintWriter instance. Use the FILE_NAME
    constant as the PrintWriter instances argument. Finally, iterate over the transactions
    argument and write the objects to the file using the output.print and output.println()
    methods.

    4. A public static method named findAll with a return type of ArrayList<Transaction>.
    Give the signature of this method a “throws IOException.” In the body of the method,
    open the expenses.txt file, iterate over the lines, and return an ArrayList of transactions.
    Special note. Invoke Scanner input = new Scanner(file) to open the expenses.txt file.
    Use while (input.hasNext()) to iterate over the file and assign the data fields to a new
    instance of a transaction object. Add this object to an ArrayList of transactions and
    return it. 
 */

public class TransactionIO {
    private String FILE_NAME = "expenses.txt";
    private File file;

    public static void bulkInsert (ArrayList<Transaction> transactions) throws IOException{
        
    }


    
}
