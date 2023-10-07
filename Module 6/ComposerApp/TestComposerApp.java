/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package ComposerApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestComposerApp {
    
    // This method prints the Apps main menu. 
    private static void Menu(){
        System.out.println("\n  MENU OPTIONS");
        System.out.println("    1. View Composers");
        System.out.println("    2. Find Composer");
        System.out.println("    3. Add Composer");
        System.out.println("    4. Exit\n");
    } // End Menu()

    public static void main(String[] args) {
        Scanner menuScanner = new Scanner(System.in);
        int menuInput = 0;
        MemComposerDao composers = new MemComposerDao();
        System.out.println("  Welcome to the Composer App");
        // This loop 2checks for user input and runs the relevant tasks. 
        while(menuInput != 4){
            Menu();
            System.out.print("  Please choose an option: ");
            try{ // This Try/Catch prevents any non-integer input into this field. Prints an error and restarts menu if bad input detected. Increments menuScanner.
                menuInput = menuScanner.nextInt();
            }
            catch(InputMismatchException badInput){
                menuScanner.nextLine();
                menuInput = 0;
            }
            if(menuInput == 1){ // This option displays all composers.
                System.out.println("\n\n  --DISPLAYING COMPOSERS--");
                for(Composer composer : composers.findAll()){
                    System.out.print(composer.toString() + "\n");
                }
            } // End menu option 1
            else if(menuInput == 2){ // This option displays a composer based on their ID. If there is no composer with that ID prints an error and returns to menu.
                System.out.print("\n  Enter an ID: ");
                try{ // This try/catch checks for valid integer input. If invalid input is detected it returns to the main menu. Increments menuScanner.
                    menuInput = menuScanner.nextInt();
                    if(composers.findBy(menuInput) != null){
                    System.out.println("\n\n  --DISPLAYING COMPOSER--");
                    System.out.print(composers.findBy(menuInput).toString());
                    }
                    else{ // No instructions were given on what to do when no match is obtained. Printed a line to indicate.
                        System.out.println("\n  No ID match. Returning to Menu.");;
                    }
                    menuInput = 2; // Done to prevent exiting in case they selected ID 4.
                }
                catch(InputMismatchException badInput){
                    System.out.println("\n  Invalid Input. Returning to main menu.");
                    menuScanner.nextLine();
                    menuInput = 0;
                }
            } // End menu option 2
            else if(menuInput == 3){ // This option allows users to input a new composer.
                Composer newComposer = new Composer();
                System.out.print("\n  Enter an id: ");
                try{
                    newComposer.setId(menuScanner.nextInt());
                    menuScanner.nextLine();
                    System.out.print("  Enter a name: ");
                    newComposer.setName(menuScanner.nextLine());
                    System.out.print("  Enter a genre: ");
                    newComposer.setGenre(menuScanner.nextLine());
                    composers.insert(newComposer);
                    menuInput = 3; // Done to prevent exiting in case they selected ID 4.
                }
                catch(InputMismatchException badInput){
                    System.out.println("\n  Invalid Input. Returning to main menu.");
                    menuScanner.nextLine();
                    menuInput = 0;
                }
            } // End menu option 3.
            else if(menuInput != 4){ // No instructions where given for what to do when an invalid number is given. Decided to print error text and loop again.
                System.out.println("\n  Invalid Input. Please try again.");
            }
        } // End while(menuInput) Loop
        System.out.println("\n  End of line..."); // I could not find explicit instructions for what to display when the program exits. 
                                                    // I decided to use last weeks (Week 5) exit text.
    } // End Main(String[])
} // End TestComposerApp
