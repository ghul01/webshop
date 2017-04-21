/**
 * 
 */
package model.bean;

/**
 * @author Attila
 *
 */
public class Customer {
	private String name;
	private String password;
	private int balance;
	private boolean regular_customer;
	private String home_address;
	private String city_address;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	 /**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param name the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	/**
	 * @return the regular_customer
	 */
	public boolean isRegular_customer() {
		return regular_customer;
	}
	/**
	 * @param regular_customer the regular_customer to set
	 */
	public void setRegular_customer(boolean regular_customer) {
		this.regular_customer = regular_customer;
	}
	/**
	 * @return the home_address
	 */
	public String getHome_address() {
		return home_address;
	}
	/**
	 * @param home_address the home_address to set
	 */
	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}
	/**
	 * @return the city_address
	 */
	public String getCity_address() {
		return city_address;
	}
	/**
	 * @param city_address the city_address to set
	 */
	public void setCity_address(String city_address) {
		this.city_address = city_address;
	}
	public String toString(){
		return name;
	}
}
