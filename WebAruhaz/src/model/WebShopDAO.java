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
	public List<Category> getCategories();
	public List<Product> getProducts();
	public List<Product> getProductsByCategory(Category category);
	public String getBalance(String userName);
	public boolean increaseBalance(String userName, Integer value);
}
