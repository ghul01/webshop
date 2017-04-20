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
}
