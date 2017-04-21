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
			setCity_name("B�k�scsaba");
			setZip_code("5600");
		}});
		add(new City(){{
			setCity_name("Orosh�za");
			setZip_code("5900");
		}});
		add(new City(){{
			setCity_name("Szeged");
			setZip_code("6700");
		}});
		add(new City(){{
			setCity_name("H�dmez�v�s�rhely");
			setZip_code("6800");
		}});
		}};
	/**
	 * Hozz�ad egy {@link Customer}-t az adatt�rhoz.
     *
     * @param customer A t�roland� {@link Customer}.
     * @return Igaz, ha sikeresen t�rolva, hamis, egy�bk�nt. 
	 */
	@Override
	public boolean signUpCustomer(Customer customer) {
		if(!checkCustomerNameUnique(customer)){
			return false;
		}
		boolean isStored = customers.add(customer);

		System.out.println("�gyfelek: "+customers.toString());
		
		return isStored;
	}
	/**
	 * Ellen�rzi a {@link #customers} egyedis�g�t.
	 * 
	 * @param newCustomer Az �jonnal felveend� {@link Customer}
	 * @return True ha a n�v egyedi, false egy�bbk�nt.
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
		boolean rvIsValid = false;
		for (Customer c : customers) {
			if (c.getName().equals(customer.getName())){
				if (c.getPassword().equals(customer.getPassword()))
					rvIsValid = true;
				break;
			}
		}
		return rvIsValid;
	}
	@Override
	public List<City> getCities() {
		return cities;
	} 
	
	
}
