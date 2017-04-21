/**
 * 
 */
package controller;

import java.util.List;

import model.*;
import model.bean.City;
import model.bean.Customer;
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
	private WebShopDAO dao = new WebShopDAOMemImpl();
	
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
	
}
