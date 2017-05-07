/**
 * 
 */
package webshop;

import controller.WebShopController;

/**
 * @author Attila
 * 
 * 
 */
public class Main {

	private static String username;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StartApp();
	}

	private static void StartApp() {
		WebShopController controller = new WebShopController();
		
		controller.startDesktop();
		
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
	public static void setUsername(String newUsername) {
		username = newUsername;
	}
}
