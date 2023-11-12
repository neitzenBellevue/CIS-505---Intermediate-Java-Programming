/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package GradeBookApp;

public class Student {
    private String firstName;
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String courseName;
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

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

    public static void writeStudents(Student[] students, String FileName){

    }

    public static void readStudents(String fileName){

    }
}
