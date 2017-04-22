package model;

import java.util.List;
import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;

import model.bean.Category;
import model.bean.City;
import model.bean.Customer;
import model.bean.Product;

@SuppressWarnings("unused")
public class WebShopDAODBImpl implements WebShopDAO {

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
//TODO Implementálás

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
}
