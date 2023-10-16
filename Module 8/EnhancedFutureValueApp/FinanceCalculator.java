/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package EnhancedFutureValueApp;

public class FinanceCalculator {
    private static int MONTHS_IN_YEAR = 12;
    
    /*
     * This method takes three values and calculates the future value of the money.
     * @param monthlyPayment double
     * @param rate double
     * @param years int
     */
    public static double calculateFutureValue(double monthlyPayment, double rate, int years){
        int months = years * MONTHS_IN_YEAR;
        double presentValue = monthlyPayment * months;
        double interestRate = 1 + rate / 100;
        return presentValue * Math.pow(interestRate, months);
    } // End calculateFutureValue(double, double, int)
}
