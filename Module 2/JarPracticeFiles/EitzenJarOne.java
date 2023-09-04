/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */
public class EitzenJarOne {
    public static void main(String[] args) {
        EitzenJarOne jarOne = new EitzenJarOne();
        EitzenJarTwo jarTwo = new EitzenJarTwo();
        jarOne.Test();
        jarTwo.Test();
    }

    public void Test(){
        System.out.println("This is Jar one.");
    }
}
