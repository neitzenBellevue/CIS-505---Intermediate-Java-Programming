/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */
public class Team {
    //The following are class attributes
    private String teamName;
    private String[] players;
    private int playerCount;
    private int maxTeamSize = 20; // This was not required, but I added it to prevent users from adding more players than the maximum allowed in the players array.

    /*
     * This default constructor takes a team name and sets default values for other attributes.
     * @param setTeamName String
     */
    public Team(String setTeamName){
        this.teamName = setTeamName;
        this.players = new String[maxTeamSize];
        this.playerCount = 0;
    } // End Team(String) constructor

    /*
     * This method adds a playerName to the players[] string at the next available position. Does not work if the array is full.
     * @param playerName String
     */
    public void addPlayer(String playerName){
       if(maxTeamSize > playerCount){
        players[playerCount] = playerName;
        playerCount++;
       } else System.out.println("  You have no more room for players on the roster (Maximum is 20). " + playerName + " was not added.");
    } // End addPlayer

    /*
     * This returns the players[] attribute.
     */
    public String[] getPlayers(){
        return this.players;
    }// End getPlayers

    /*
     * This returns the playerCount attribute.
     */
    public int getPlayerCount(){
        return this.playerCount;
    } // End getPlayerCount

    /*
     * This returns the teamName attribute.
     */
    public String getTeamName(){
        return this.teamName;
    } // End getTeamName

} // End Team
