package model;

import java.util.ArrayList;
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
	public boolean doTheSQL(String sql){
		try {
		OracleDataSource ods = new OracleDataSource();
	    ods.setURL("jdbc:oracle:thin:hr/hr@//orania.inf.u-szeged.hu:1521/kabinet");
	    Connection conn = ods.getConnection("HR","HR");
	    Statement st = conn.createStatement();
			System.out.println( sql );
			st.executeUpdate("INSERT INTO Customers " + 
	                "VALUES (1001, 'Simpson', 'Mr.', 'Springfield', 2001)");
			conn.close();
			return true;
		}catch ( SQLException ex ) {
			ex.printStackTrace();
			return false;
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
		List<City> cities = new ArrayList<City>();
		// TODO Auto-generated method stub
		return cities;
	}

	@Override
	public List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public List<Product> getProducts() {
		List<Product> products = new ArrayList<Product>();
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public List<Product> getProductsByCategory(Category category) {
		List<Product> products = new ArrayList<Product>();
		// TODO Auto-generated method stub
		return products;
	}

	@Override
	public String getBalance(String userName) {
		String rvBalance = "0";
		// TODO Auto-generated method stub
		return rvBalance;
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
		List<Cart> carts = new ArrayList<Cart>();
		// TODO Auto-generated method stub
		return carts;
	}
}
