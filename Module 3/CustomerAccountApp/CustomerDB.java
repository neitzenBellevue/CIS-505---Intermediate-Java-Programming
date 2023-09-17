/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

package CustomerApp;

public class CustomerDB {

    // This method checks for an ID match and returns an object. If no match happens
    public static Customer getCustomer(int id){
        //This if/else statement checks if id = 1007, 1008, or 1009 then creates a unique value. Or returns the default constructor.
        if(id == 1007 || id == 1008 || id == 1009) {
            if(id == 1007){
                Customer cus1007 = new Customer("  Bob Robert", "  191 Main Street", "  New York", "  13153");
                return cus1007;
            }
            else if (id == 1008){
                Customer cus1008 = new Customer("  Rob Bobert", "  123 2nd Street", "  Omaha", "  68136");
                return cus1008;
            }
            else {
                Customer cus1009 = new Customer("  Bob Robert", "  186 3rd Street", "  Council Bluffs", "  68033");
                return cus1009;
            }
        }
        else {
            Customer cusNoMatch = new Customer();
            return cusNoMatch;
        }
    } // End getCustomer
} // End CustomerDB Class
