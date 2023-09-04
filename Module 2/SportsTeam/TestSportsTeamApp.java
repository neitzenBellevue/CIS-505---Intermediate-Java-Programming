/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

import java.util.Scanner;

public class TestSportsTeamApp {

    /*
     * This is the main method, used for testing the Team.Java class
     * @param args String[]
     */
    public static void main(String[] args) {
        
        // These variables/prompts do not need initialized in the loop.
        boolean continueLoop = true;
        Scanner teamNameScanner = new Scanner(System.in);
        System.out.println("\n  Welcome to the Sports Team App");

        // This while loop allows users to go thru the program for as long as desired. 
        while(continueLoop){
            // The following variables will be used to create a new Team and accept input for team and player names.
            Team testTeam;
            String teamPlayersInput;
            String[] teamPlayersSplit;
          
            // This section allows the user to input the team name thru the console.
            System.out.print("\n  Enter a team name: ");
            testTeam = new Team(teamNameScanner.nextLine());
    
            // This section allows the user to input the players names thru the console.
            System.out.print("\n  Enter the player names: \n    hint: use commas for multiple players; no spaces>: ");
            teamPlayersInput = new String(teamNameScanner.nextLine());
            teamPlayersSplit = teamPlayersInput.split(",");

            // This loop adds the prior user input to the testTeam team object's players.
            for(int i = 0; i<teamPlayersSplit.length; i++){
                testTeam.addPlayer(teamPlayersSplit[i]);
            } // End Loop

            // This section is displaying the data the user inputed above.
            System.out.println("\n  --Team Summary--");
            System.out.println("  Number of players in team: " + testTeam.getPlayerCount());
            System.out.print("  Players on team: ");
            teamPlayersSplit = testTeam.getPlayers(); // While technically teamPlayersSplit and testTeam.getPlayers are the same in this instance, that may not always be true in all cases.
        
            // This loop goes thru and prints the name of each player in the testTeam object (Which was assigned to teamPlayersSplit above)
            for(int i = 0; i<testTeam.getPlayerCount(); i++){
                if(i == 0){ // This if logic could be put outside the loop for speed. Didn't bother because the program is so simple.
                    System.out.print(teamPlayersSplit[i]);
                }
                else{
                    System.out.print("," + teamPlayersSplit[i]);
                } // End If/Else
            } // End For Loop
           
            //This loop is for the user to determine if they want to keep going. y = loop again, n = stop, anything else re-prompts the question.
            while(true){
                System.out.print("\n\n  Continue? (y/n): ");
                String lString = teamNameScanner.nextLine();
                if(lString.equals("n")) {
                    continueLoop = false;
                    System.out.println("\n  Goodbye.");
                    break;
                }
                else if (lString.equals("y")) break;
                else System.out.print("  I did not understand that. Please answer y or n.");
            } // End Continue (y/n) While Loop
        }// End Main While Loop
    }// End main
}// End TestSportsTeamApp
