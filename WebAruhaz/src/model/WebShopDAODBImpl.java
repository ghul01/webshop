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
	    ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
	    Connection conn = ods.getConnection("SYSTEM","SYSTEM");
	    Statement st = conn.prepareStatement(sql);
			System.out.println( sql );
			st.executeUpdate(sql);
			conn.close();
			return true;
		}catch ( SQLException ex ) {
			ex.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean signUpCustomer(Customer customer) {
		boolean rvSucces = false;
		
		for(City city:getCities()){
			String sql="";
			if (city.getZip_code().equals(customer.getCity_address()))
				sql = "INSERT INTO FELHASZNALOK(NEV, JELSZO, LAKCIM, VAROS_NEV) VALUES ('"+
					customer.getName()+"','"+
					customer.getPassword()+"','"+
					customer.getHome_address()+"','"+
					city.getCity_name()+"')";
			rvSucces = doTheSQL(sql);
		}
		return rvSucces;
	}

	@Override
	public boolean logInCustomer(Customer customer) {
		boolean rvSucces = false;
		String sql = "SELECT COUNT(*) FROM FELHASZNALOK WHERE NEV='"+customer.getName()+"' AND JELSZO='"+customer.getPassword()+"'";
		rvSucces=doTheSQL(sql);
		return rvSucces;
	}

	@Override
	public List<City> getCities() {
		List<City> cities = new ArrayList<City>();
		Connection conn;
		OracleDataSource ods;
		PreparedStatement pst;
		ResultSet rs;
		try {
			ods = new OracleDataSource(); 
			Class.forName("oracle.jdbc.OracleDriver");
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			conn = ods.getConnection("SYSTEM", "SYSTEM");

			String szkript = "SELECT * FROM VAROS";
			
			pst = conn.prepareStatement(szkript);
			rs = pst.executeQuery();		
			while(rs.next()){
				City city = new City();
				city.setCity_name(rs.getString("V_NEV"));
				city.setZip_code(rs.getString("IRSZ"));
				
				System.out.println(city.getCity_name() + " " + city.getZip_code());
					
				cities.add(city);
			}
			
			
		} catch (Exception e){
			e.printStackTrace();
		} 
		
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
