/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package GradeBookApp;

public class Student {
    private String firstName;
    private String lastName;
    private String courseName;
    private String grade;

    /*
     * This constructor takes 4 strings and assigns them to the class variables.
     * @param firstName String
     * @param lastName String
     * @param courseName String
     * @param grade String
     */
    public Student(String firstName, String lastName, String courseName, String grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseName = courseName;
        this.grade = grade;
    } // end Student(String, String, String, String)

    // The following method returns the class variables in CSV format.
    public String toString(){
        StringBuilder csv = new StringBuilder();
        csv.append(firstName + ", ");
        csv.append(lastName + ", ");
        csv.append(courseName + ", ");
        csv.append(grade + "\n");
        return csv.toString();
    } // End toString

    public void writeStudents(Student[] students, String FileName){

    }

    public void readStudents(String fileName){

    }
}
