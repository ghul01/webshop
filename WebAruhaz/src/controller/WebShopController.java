/**
 * 
 */
package controller;

import java.util.List;

import model.*;
import model.bean.City;
import model.bean.Customer;
import view.WebShopGUI;

/**
 * @author Attila
 *
 */
/**
 * Ez az oszt�ly vez�rli az eg�sz programot, valamint a view �s model csomagokat
 * k�ti �ssze. Itt tal�lhat� az �zleti logika (business logic) is.
 */
public class WebShopController {
	private static String username;
	private static String password;
	private WebShopDAO dao = new WebShopDAOMemImpl();
	
	/**
	 * Elind�tja Az alkalmaz�s desktopra specializ�lt user interface-�t.
	 */
	public void startDesktop() {
		WebShopGUI vc = new WebShopGUI(this);
		
		 vc.startGUI();
	}

	/**
	 * @return the username
	 */
	public static String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public static void setUsername(String username) {
		WebShopController.username = username;
	}

	/**
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public static void setPassword(String password) {
		WebShopController.password = password;
	}

	public boolean signUpCustomer(Customer customer){
		return dao.signUpCustomer(customer);
	}
	public boolean logInCustomer(Customer customer){
		return dao.logInCustomer(customer);
	}
	public List<City> getCities(){
		return dao.getCities();
	}
	
}
