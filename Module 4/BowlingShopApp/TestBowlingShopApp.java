/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package BowlingShopApp;
import java.util.Scanner;

public class TestBowlingShopApp {

    // This method prints the app menu.
    public static void displayMenu(){
        System.out.println("\n  Menu Options");
        System.out.println("    1. <b> Bowling Balls");
        System.out.println("    2. <a> Bowling Bags");
        System.out.println("    3. <s> Bowling Shoes");
        System.out.println("    4. <x> To exit");
        System.out.print("\n  Please choose an option: ");
    } // End displayMenu

    /*
     * The main method runs the program.
     * @param args String[]
     */
    public static void main(String[] args) {
        // These variables are used throughout the menu loop. Print line is needed once, thus it is not in the loop.
        System.out.println("  Welcome to the Bowling Shop\n");
        Scanner menuScanner = new Scanner(System.in);
        String scannerInput = new String();
        GenericQueue<Product> products = new GenericQueue<Product>();

        // This menu loop continues until the user inputs "x".
        while(!scannerInput.equals("x")){
            displayMenu();
            scannerInput = menuScanner.nextLine();
            products = ProductDB.getProducts(scannerInput);
            if (scannerInput.equals("a") || scannerInput.equals("b") || scannerInput.equals("s")) 
                System.out.println("\n  --Product Listing--"); // This is to prevent cases where they put in non-recognized input from printing this line.
            while (products.size() > 0){
                System.out.println(products.dequeue()); // products.dequeue() should implicitly return the toString() method of whatever object it returns.
                System.out.println();
            } // End dequeue loop
        } // End menu loop
        System.out.println("\n  End of line...");
    } // End main(String)
} // End TestBowlingShopApp
