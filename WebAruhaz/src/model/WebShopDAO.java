/**
 * 
 */
package model;

import java.util.List;

import model.bean.*;

/**
 * @author Attila
 *
 */
public interface WebShopDAO {
	public boolean signUpCustomer(Customer customer);
	public boolean logInCustomer(Customer customer);
	public List<City> getCities();
}
