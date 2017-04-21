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
		// A GUI kirajzol�s�ra �s az azon t�rt�n� esem�nyek kezel�s�re a Java egy k�l�n sz�lat haszn�l.
        // Ezen a sz�lon ind�tjuk el a createAndShowGUI() met�dust.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }			
        });
	}

	private void createAndShowGUI() {
		// El��ll�tjuk az alkalmaz�s c�msor�t
        //   - ha meg volt adva usern�v, akkor azt �rjuk bele,
        //   - ha nem, akkor "ismeretlen"-t t�ntet�nk fel
		String title = String.format(Labels.main_window_title_format, controller.getUsername() == null ? Labels.main_window_title_unknown_user : controller.getUsername());
		
		// A JFrame egy magas szint� kont�ner, egy ablak c�mmel �s kerettel.
        window = new JFrame(title);

        // Ha bez�rjuk az ablakot, akkor alap�rtelmez�sben azt csak elrejtjuk.
        // Ezt a viselked�st m�dos�tjuk arra, hogy az ablak t�nylegesen z�r�djon be.
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Gy�rtunk egy bookMenuBar objektumot
        WebShopMenuBar bookMenuBar = new WebShopMenuBar(this);

        // Amit r�rakunk a Book Shop ablakunkra
        window.setJMenuBar(bookMenuBar);

        // Az ablaknak be�ll�tjuk a m�ret�t
        window.setSize(800,600);

        // K�szen vagyunk, megjelen�thetj�k az ablakot
        window.setVisible(true);
	}
	
	public void setActualContent(Container container){
		// tartalmat mindig a content pane-hez kell hozz�adni
        // vagy content pane-k�nt be�ll�tani.
        window.setContentPane(container);
        window.setVisible(true);
	}
	

    /**
     * Visszaadja az alkalmaz�s f�ablak�t. A met�dus az alkalmaz�s bels�
     * v�z�nak, infrastrukt�r�j�nak r�sz�t k�pezi, minden alkalmaz�sban sz�ks�g
     * van r�.
     */
    public JFrame getWindow() {
        return window;
    }

    /**
     * Visszaadja az alkalmaz�s controller�t. A met�dus az alkalmaz�s bels�
     * v�z�nak, infrastrukt�r�j�nak r�sz�t k�pezi, minden alkalmaz�sban sz�ks�g
     * van r�.
     */
    public WebShopController getController() {
        return controller;
    }
	
}
