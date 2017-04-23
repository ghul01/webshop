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
	
	@SuppressWarnings("serial")
	public List<Category> categories = new ArrayList<Category>(){{
		add(new Category(){{
			setName("K�nyvek");
		}});
		add(new Category(){{
			setName("Sz�rakoz�s");
		}});
		add(new Category(){{
			setName("Elektronika");
		}});
		add(new Category(){{
			setName("Kert�szked�s");
		}});
		add(new Category(){{
			setName("Sz�ps�g �pol�s");
		}});
		add(new Category(){{
			setName("Eg�szs�g");
		}});
		add(new Category(){{
			setName("Gyerek j�t�kok");
		}});
		add(new Category(){{
			setName("�lt�zk�d�s");
		}});
		add(new Category(){{
			setName("�kszerek");
		}});
		add(new Category(){{
			setName("Saj�t k�sz�t�s�");
		}});
		add(new Category(){{
			setName("Sport");
		}});
		add(new Category(){{
			setName("J�rm�");
		}});
	}};
	
	@SuppressWarnings("serial")
	public List<Product> products = new ArrayList<Product>(){{
		add(new Product(){{
			setProduct_id(1);
			setProduct_name("Faragott l�");
			setUnit_price(1000);
			setStock(10);
			setKategory_name("Saj�t k�sz�t�s�");
		}});
	}};
	
	public List<Cart> carts = new ArrayList<Cart>();
	
	
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
	@Override
	public List<Category> getCategories() {
		return categories;
	}
	@Override
	public List<Product> getProducts() {
		return products;
	}
	@Override
	public List<Product> getProductsByCategory(Category category) {
		List<Product> categorizedProducts = new ArrayList<Product>();
		for (Product product : products) {
			if (product.getCategory_name().equals(category.getName())) {
				categorizedProducts.add(product);
			}
		}
		return categorizedProducts;
	}
	@Override
	public String getBalance(String userName) {
		String balance="0";
		for (Customer customer : customers) {
			if (customer.getName().equals(userName)){
				balance=Integer.toString(customer.getBalance());
			}
		}
		return balance;
	}
	@Override
	public boolean increaseBalance(String userName, Integer value) {
		boolean rvIsValide = false;
		for (Customer customer : customers) {
			if (customer.getName().equals(userName)){
				customer.setBalance(customer.getBalance()+value);
				rvIsValide = true;
			}
		}
		return rvIsValide;
	}
	@Override
	public boolean findProductById(int id) {
		boolean rvIsValide = false;
		for (Product product: products) {
			if (product.getProduct_id() == id){
				rvIsValide = true;
			}
		}
		return rvIsValide;
	}
	@Override
	public boolean addPorductToCartById(String userName, int id, int piece) {
		boolean rvIsValide = false;
		for (Cart cart : carts) {
			if (cart.getUserName().equals(userName)&&cart.getProduct_id()==id) { // TODO cart id
				cart.setPiece(cart.getPiece()+piece);
				rvIsValide = true;
				break;
			}
		}
		if (!rvIsValide){
			Cart cart = new Cart();
			cart.setUserName(userName);
			cart.setProduct_id(id);
			cart.setPiece(piece);
			carts.add(cart);
			rvIsValide = true;
		}
		return rvIsValide;
	}
	@Override
	public List<Cart> getUsersCart(String userName) {
		List<Cart> usersCart = new ArrayList<Cart>();
		for (Cart cart : carts) {
			if (cart.getUserName().equals(userName)) {
				usersCart.add(cart);
			}
		}
		return usersCart;
	} 
	
	
}
