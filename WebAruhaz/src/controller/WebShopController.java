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
 * Ez az oszt�ly vez�rli az eg�sz programot, valamint a view �s model csomagokat
 * k�ti �ssze. Itt tal�lhat� az �zleti logika (business logic) is.
 */
public class WebShopController {
	private WebShopDAO dao = new WebShopDAOMemImpl();
	
	/**
	 * Elind�tja Az alkalmaz�s desktopra specializ�lt user interface-�t.
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
