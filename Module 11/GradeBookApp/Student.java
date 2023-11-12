/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package GradeBookApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

    public static void writeStudents(Student[] students, String fileName){
        StringBuilder csv = new StringBuilder();
        for(Student student : students){
            csv.append(student.toString());
        }
        File csvOut = new File(fileName);
        try (PrintWriter pw = new PrintWriter(csvOut) ){
            pw.write(csv.toString());
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        }
    } // End writeStudents(Student[], String)

    public static void readStudents(String fileName){

    } // End readStudent(String)

    // This getter method retrieves the firstName variable.
    public String getFirstName() {
        return firstName;
    }// End getFirstName()

    /*
     * This setter method changes the firstName variable.
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } // End setFirstName

    // This getter method retrieves the grade variable.
    public String getGrade() {
        return grade;
    } // End getGrade()

    /*
     * This setter method changes the grade variable.
     * @param grade String
     */
    public void setGrade(String grade) {
        this.grade = grade;
    } // End setGrate(String)

    // This getter method retrieves the lastName variable.
    public String getLastName() {
        return lastName;
    } // End getLastName()

    /*
     * This setter method changes the lastName variable.
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    } // End setLastName(String)

    // This getter method retrieves the courseName variable.
     public String getCourseName() {
        return courseName;
    } // End getCourseName()

    /*
     * This setter method changes the courseName variable.
     * @param courseName String
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    } // End setCourseName(String)

} // End Student
