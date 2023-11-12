/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package GradeBookApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

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
        csv.append(grade + " \n");
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
            pw.close();
            
        } catch (FileNotFoundException e) {
            
        }
    } // End writeStudents(Student[], String)

    public static Student[] readStudents(String fileName){
        //The following determines how many students are in the CSV file.
        BufferedReader reader;
        int lines = 0;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
        Student[] students = new Student[lines];
            try {
                int i = 0;
                Scanner scanner = new Scanner(new File(fileName));
                scanner.useDelimiter(", ");
                for(Student student : students){
                    student = new Student(scanner.next(), scanner.next(), scanner.next(), scanner.nextLine());
                    students[i] = student;
                    i++;
                }
            } catch (FileNotFoundException e) {
        
            }
        for(Student student : students) student.setGrade(student.getGrade().substring(2)); // This removes an extra comma and space.
        return students;
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
