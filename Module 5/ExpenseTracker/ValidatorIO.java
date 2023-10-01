/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package ExpenseTracker;
import java.util.Scanner;

public class ValidatorIO {

    /*
     * This method takes a scanner and string argument. It prints the string and returns a new string from the scanner.
     * @param sc Scanner
     * @param prompt String
     */
    public static String getString(Scanner sc, String prompt) {
        System.out.print(prompt);
        prompt = sc.next();
        sc.nextLine();
        return prompt; 
    } // End getString(Scanner, String)

    /*
     * This method takes a prompt and Scanner. It uses the scanner to search the prompt for an integer value and returns it.
     * @param sc Scanner
     * @param prompt String
     */
    public static int getInt(Scanner sc, String prompt){
        int input = 0;
        boolean isValid = false;

        while(!isValid){
            System.out.print(prompt);
            if(sc.hasNextInt()){
                input = sc.nextInt();
                isValid = true;
            }
            else{
                System.out.print("\n  Error! Invalid integer value.\n");
            }
            sc.nextLine();
        } // End While(!isValid)
        return input;
    } // End getInt(Scanner, String)

    /*
     * This method takes a prompt and Scanner. It uses the scanner to search the prompt for a double valuesand returns it.
     * @param sc Scanner
     * @param prompt String
     */
    public static double getDouble(Scanner sc, String prompt){
        double input = 0;
        boolean isValid = false;
        while(!isValid){
            System.out.print(prompt);
            if(sc.hasNextDouble()){
                input = sc.nextDouble();
                isValid = true;
            }
            else{
                System.out.print("\n  Error! Invalid double value.\n");
            }
            sc.nextLine();
        } // End While(!isValid)
        return input;
    } // End getDouble(Scanner, String)

} // End ValidatorIO
