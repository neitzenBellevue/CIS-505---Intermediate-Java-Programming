/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */
public class TestFanApp {
    //This is for testing the Fan.Java class
    public static void main(String[] args) {
        Fan defaultFan = new Fan();
        Fan argumentFan = new Fan(2, true, 3 , "Red");

        System.out.println(defaultFan);
        System.out.println(argumentFan);
    }
}
