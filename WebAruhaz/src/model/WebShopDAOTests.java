/**
 * 
 */
package model;

import model.bean.Customer;

/**
 * @author Attila
 *
 */
public class WebShopDAOTests {
	public static void main(String[] args) {
        TestAddCustomerWithSameName();
    }
	public static void TestAddCustomerWithSameName() {
        WebShopDAO dao = new WebShopDAOMemImpl();

        // az els� v�s�rl� hozz�ad�sa, elv�rjuk, hogy sikeres legyen
        Customer customer = new Customer();

        customer.setName("same");

        boolean succeeded = dao.signUpCustomer(customer);

        assertBoolean(succeeded, true, "Nem siker�lt hozz�adni az els� v�s�rl�t!");

        // azanos nev� v�s�rl� hozz�ad�sa, elv�rjuk, hogy !sikertelen! legyen
        Customer existingCustomer = new Customer();

        existingCustomer.setName("same");

        succeeded = dao.signUpCustomer(existingCustomer);

        assertBoolean(succeeded, false, "Siker�lt hozz�adni azonos nev� v�s�rl�t!");
	}
	
	private static void assertBoolean(boolean actual, boolean expected, String message) {
        if (actual != expected) {
            System.out.println(String.format("TESZT HIBA: %1$s", message));
        }
    }
}
