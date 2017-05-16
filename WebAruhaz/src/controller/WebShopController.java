/**
 * 
 */
package controller;

import java.util.List;

import model.*;
import model.bean.Cart;
import model.bean.Category;
import model.bean.City;
import model.bean.Customer;
import model.bean.Product;
import view.WebShopGUI;
import webshop.Main;

/**
 * @author Attila
 *
 */
/**
 * Ez az osztály vezérli az egész programot, valamint a view és model csomagokat
 * köti össze. Itt található az üzleti logika (business logic) is.
 */
public class WebShopController {
	private WebShopDAO dao = new WebShopDAODBImpl();
	
	/**
	 * Elindítja Az alkalmazás desktopra specializált user interface-ét.
	 */
	public void startDesktop() {
		WebShopGUI vc = new WebShopGUI(this);
		
		 vc.startGUI();
	}
	public boolean signUpCustomer(Customer customer){
		return dao.signUpCustomer(customer);
	}
	public boolean logInCustomer(Customer customer){
		boolean rvIsValid = dao.logInCustomer(customer);
		if (rvIsValid){
			Main.setUsername(customer.getName());
		}
		return rvIsValid;
	}
	public List<City> getCities(){
		return dao.getCities();
	}
	public List<Category> getCategories(){
		return dao.getCategories();
	}
	public List<Product> getProducts(){
		return dao.getProducts();
	}
	public List<Product> getProductsByCategory(Category category){
		return dao.getProductsByCategory(category);
	}
	public String getBalance(String userName) {
		return dao.getBalance(userName)+" HUF";
	}
	public boolean increaseBalance(String userName, Integer value) {
		return dao.increaseBalance(userName, value);
	}
	public boolean findProductById(int id){
		return dao.findProductById(id);
	}
	public boolean addPorductToCartById(String userName,int id, int piece){
		return dao.addPorductToCartById(userName, id, piece);
	}
	public List<Cart> getUsersCart(String userName) {
		return dao.getUsersCart(userName);
	}
}
