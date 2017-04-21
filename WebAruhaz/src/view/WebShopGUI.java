/**
 * 
 */
package view;

import java.awt.Container;

import javax.swing.JFrame;

import controller.WebShopController;

/**
 * @author Attila
 *
 */
public class WebShopGUI {
	private JFrame window;
	private WebShopController controller;

	private static void LogIn() {
		// TODO Auto-generated method stub
		
	}
	
	public WebShopGUI(WebShopController controller) {
		this.controller = controller;
	}

	public void startGUI() {
		// A GUI kirajzolására és az azon történõ események kezelésére a Java egy külön szálat használ.
        // Ezen a szálon indítjuk el a createAndShowGUI() metódust.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }			
        });
	}

	private void createAndShowGUI() {
		// Elõállítjuk az alkalmazás címsorát
        //   - ha meg volt adva usernév, akkor azt írjuk bele,
        //   - ha nem, akkor "ismeretlen"-t tüntetünk fel
		String title = String.format(Labels.main_window_title_format, controller.getUsername() == null ? Labels.main_window_title_unknown_user : controller.getUsername());
		
		// A JFrame egy magas szintû konténer, egy ablak címmel és kerettel.
        window = new JFrame(title);

        // Ha bezárjuk az ablakot, akkor alapértelmezésben azt csak elrejtjuk.
        // Ezt a viselkedést módosítjuk arra, hogy az ablak ténylegesen záródjon be.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Gyártunk egy bookMenuBar objektumot
        WebShopMenuBar bookMenuBar = new WebShopMenuBar(this);

        // Amit rárakunk a Book Shop ablakunkra
        window.setJMenuBar(bookMenuBar);

        // Az ablaknak beállítjuk a méretét
        window.setSize(800,600);

        // Készen vagyunk, megjeleníthetjük az ablakot
        window.setVisible(true);
	}
	
	public void setActualContent(Container container){
		// tartalmat mindig a content pane-hez kell hozzáadni
        // vagy content pane-ként beállítani.
        window.setContentPane(container);
        window.setVisible(true);
	}
	

    /**
     * Visszaadja az alkalmazás fõablakát. A metódus az alkalmazás belsõ
     * vázának, infrastruktúrájának részét képezi, minden alkalmazásban szükség
     * van rá.
     */
    public JFrame getWindow() {
        return window;
    }

    /**
     * Visszaadja az alkalmazás controllerét. A metódus az alkalmazás belsõ
     * vázának, infrastruktúrájának részét képezi, minden alkalmazásban szükség
     * van rá.
     */
    public WebShopController getController() {
        return controller;
    }
	
}
