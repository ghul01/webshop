package model;

import java.util.List;
import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;
import model.bean.Cart;
import model.bean.Category;
import model.bean.City;
import model.bean.Customer;
import model.bean.Product;

@SuppressWarnings("unused")
public class WebShopDAODBImpl implements WebShopDAO {

	public WebShopDAODBImpl() {
		try{
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e){
			System.err.println("Nem sikerült betölteni a OJDBC drivet-t.");
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean signUpCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean logInCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<City> getCities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBalance(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean increaseBalance(String userName, Integer value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findProductById(int id) {
		// TODO Auto-generated method stuba
		return false;
	}

	@Override
	public boolean addPorductToCartById(String userName, int id, int piece) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Cart> getUsersCart(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
}
