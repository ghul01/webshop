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
	
	public List<Customer> customers = new ArrayList<Customer>();
	@SuppressWarnings("serial")
	public List<City> cities = new ArrayList<City>() {{
		add(new City(){{
			setCity_name("Békéscsaba");
			setZip_code("5600");
		}});
		add(new City(){{
			setCity_name("Orosháza");
			setZip_code("5900");
		}});
		add(new City(){{
			setCity_name("Szeged");
			setZip_code("6700");
		}});
		add(new City(){{
			setCity_name("Hódmezõvásárhely");
			setZip_code("6800");
		}});
		}};
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
	@Override
	public List<City> getCities() {
		/*List<City> cities = new ArrayList<City>();
		City city = new City();
		city.setCity_name("Békéscsaba");
		city.setZip_code("5600");
		cities.add(city);*/
		return cities;
	} 
	
	
}
