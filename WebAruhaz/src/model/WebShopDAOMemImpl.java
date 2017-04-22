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
	
	@SuppressWarnings("serial")
	public List<Category> categories = new ArrayList<Category>(){{
		add(new Category(){{
			setName("Könyvek");
		}});
		add(new Category(){{
			setName("Szórakozás");
		}});
		add(new Category(){{
			setName("Elektronika");
		}});
		add(new Category(){{
			setName("Kertészkedés");
		}});
		add(new Category(){{
			setName("Szépség ápolás");
		}});
		add(new Category(){{
			setName("Egészség");
		}});
		add(new Category(){{
			setName("Gyerek játékok");
		}});
		add(new Category(){{
			setName("Öltözködés");
		}});
		add(new Category(){{
			setName("Ékszerek");
		}});
		add(new Category(){{
			setName("Saját készítésû");
		}});
		add(new Category(){{
			setName("Sport");
		}});
		add(new Category(){{
			setName("Jármû");
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
	@Override
	public List<Category> getCategories() {
		return categories;
	} 
	
	
}
