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

        // az elsõ vásárló hozzáadása, elvárjuk, hogy sikeres legyen
        Customer customer = new Customer();

        customer.setName("same");

        boolean succeeded = dao.signUpCustomer(customer);

        assertBoolean(succeeded, true, "Nem sikerült hozzáadni az elsõ vásárlót!");

        // azanos nevû vásárló hozzáadása, elvárjuk, hogy !sikertelen! legyen
        Customer existingCustomer = new Customer();

        existingCustomer.setName("same");

        succeeded = dao.signUpCustomer(existingCustomer);

        assertBoolean(succeeded, false, "Sikerült hozzáadni azonos nevû vásárlót!");
	}
	
	private static void assertBoolean(boolean actual, boolean expected, String message) {
        if (actual != expected) {
            System.out.println(String.format("TESZT HIBA: %1$s", message));
        }
    }
}
