/**
 * 
 */
package model;

import java.util.ArrayList;
import java.util.List;

import model.bean.*;

/**
 * @author Attila
 *
 */
public class WebShopDAOMemImpl implements WebShopDAO {
	@SuppressWarnings("unused")
	private static int id;
	
	List<Customer> customers = new ArrayList<Customer>();
	List<City> cities = new ArrayList<City>();
	/**
	 * Hozzáad egy {@link Customer}-t az adattárhoz.
     *
     * @param customer A tárolandó {@link Customer}.
     * @return Igaz, ha sikeresen tárolva, hamis, egyébként. 
	 */
	@Override
	public boolean signUpCustomer(Customer customer) {
		if(!checkCustomerNameUnique(customer)){
			return false;
		}
		boolean isStored = customers.add(customer);

		System.out.println("Ügyfelek: "+customers.toString());
		
		return isStored;
	}
	/**
	 * Ellenõrzi a {@link #customers} egyediségét.
	 * 
	 * @param newCustomer Az újonnal felveendõ {@link Customer}
	 * @return True ha a név egyedi, false egyébbként.
	 */
	private boolean checkCustomerNameUnique(Customer newCustomer){
		boolean rvIsValid = true;
		for (Customer customer : customers) {
			if(customer.getName().equals(newCustomer.getName())){
				rvIsValid=false;
				break;
			}
		}
		return rvIsValid;
	}
	@Override
	public boolean logInCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	} 
	
	
}
