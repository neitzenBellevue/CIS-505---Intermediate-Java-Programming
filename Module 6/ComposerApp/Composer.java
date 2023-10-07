/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package ComposerApp;

public class Composer {
    private int id; // Instructions call this an integer, but says the default is an empty string?
    private String name;
    private String genre;

    // This default constructor initializes the class variables to be blank strings.
    public Composer(){
        this.id = 0;
        this.name = "";
        this.genre = "";
    } // End Composer()

    /*
     * This constructor initializes the class variables with user data.
     * @param id int
     * @param name String
     * @param genre String
     */
    public Composer(int id, String name, String genre){
        this.id = id;
        this.name = name;
        this.genre = genre;
    } // End Composer(int, String, String)

    // The overridden toString() method returns the private variables each on a newline.
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("  ID: " + id + "\n");
        str.append("  Name: " + name + "\n");
        str.append("  Genre: " + genre + "\n");
        return str.toString();
    } // End toString()

    // This method returns the id class variable.
    public int getId() {
        return id;
    } // End getID()

    /*
     * This method sets the class variable id.
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    } // End setId(int)

    // This method returns the name class variable.
    public String getName() {
        return name;
    } // End getName()

     /*
     * This method sets the class variable name.
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    } // end setName(String)

    // This method returns the genre class variable.
    public String getGenre() {
        return genre;
    } // End getGenre()

    /*
     * This method sets the class variable genre.
     * @param genre String
     */
    public void setGenre(String genre) {
        this.genre = genre;
    } // End setGenre(String)
} // End Composer
