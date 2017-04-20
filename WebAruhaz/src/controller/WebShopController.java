/**
 * 
 */
package controller;

/**
 * @author Attila
 *
 */
/**
 * Ez az osztály vezérli az egész programot, valamint a view és model csomagokat
 * köti össze. Itt található az üzleti logika (business logic) is.
 */
public class WebShopController {
	private static String username;
	private static String password;
	
	public void startDesktop() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the username
	 */
	public static String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public static void setUsername(String username) {
		WebShopController.username = username;
	}

	/**
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public static void setPassword(String password) {
		WebShopController.password = password;
	}

}
