/**
 * 
 */
package webshop;

import controller.WebShopController;

/**
 * @author Attila
 *
 */
public class main {

	private static String username;
	private static String password;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogIn();
		StartApp();
	}

	private static void StartApp() {
		WebShopController controller = new WebShopController();
		
		controller.setUsername(username);
		controller.setPassword(password);
		
		controller.startDesktop();
		
	}

	private static void LogIn() {
		// TODO Auto-generated method stub
		
	}

}
