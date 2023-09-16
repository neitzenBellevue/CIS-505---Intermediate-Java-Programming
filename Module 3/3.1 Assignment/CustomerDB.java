/*
 * Eitzen, N. (2023). CIS 505 Intermediate Java Programming. Bellevue University
 */

 import Customer;

public class CustomerDB {

    // This method checks for an ID match and returns an object. If no match happens
    public static Customer getCustomer(int id){
        if(id == 1007){
            return Customer cus1007 = new Customer("Bob Robert", "191 Main Street", "New York", "13153");
        }
        if (id == 1008){
            return Customer cus1008 = new Customer("Rob Bobert", "123 2nd Street", "Omaha", "68136");
        }
        if (id == 1009){
            return Customer cus1009 = new Customer("Bob Robert", "186 3rd Street", "Council Bluffs", "68033");
        }
        if (id != 1007 || id != 1008 || id != 1009){
            return Customer cusNoMatch = new Customer();
        }
    } // End getCustomer
} // End CustomerDB Class
