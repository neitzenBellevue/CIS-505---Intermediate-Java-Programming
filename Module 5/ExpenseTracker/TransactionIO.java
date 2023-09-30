/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package ExpenseTracker;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {
    // This variables create a new file. File name is static and final.
    private static final String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);

    /*
     * This method takes an arraylist and prints the contents to a file.
     * @param transactions ArrayList<Transaction>
     * @exception IOException
     */
    public static void bulkInsert (ArrayList<Transaction> transactions) throws IOException{
        PrintWriter output = null;
        // The following checks if the file already exists. If it exists it appends to the file.
        if(file.exists()){
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
          }
        else{
            output = new PrintWriter(FILE_NAME);
        }
        // Goes thru each object in transactions and adds to the File.
        for(Transaction transaction : transactions){
            output.print(transaction.getDate() + " ");
            output.print(transaction.getDescription() + " ");
            output.println(transaction.getAmount());
        }
        output.close();
    } // End bulkInsert(ArrayList<Transaction>)

    // This method loops thru the file and creates transactions. The transactions are returned thru an arraylist.
    public static ArrayList<Transaction> findAll() throws IOException{
        Scanner input = new Scanner(file);
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        // This while loop goes through the file and creates transactions. Adds transactions to the ArrayList.
        while(input.hasNext()){
            Transaction tempTransaction = new Transaction();
            tempTransaction.setDate(input.next());
            tempTransaction.setDescription(input.next());
            tempTransaction.setAmount(input.nextDouble());
            transactions.add(tempTransaction);
        } // End while(input.hasnext())
        return transactions;
    } // End findAll()
} // End TransactionIO
