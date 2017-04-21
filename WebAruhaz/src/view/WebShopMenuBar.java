/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import view.dialogs.SignInDialog;

/**
 * @author Attila
 *
 */
public class WebShopMenuBar extends JMenuBar implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -143840565706992902L;
	@SuppressWarnings("unused")
	private WebShopGUI gui;
	
	public WebShopMenuBar(WebShopGUI gui) {
		super();
		this.gui = gui;
		
		createMenuPoint(Labels. user,Labels.log_in, Labels.sign_in);
	}

    private void createMenuPoint(String name, String... subnames) {
        // Létrehozunk egy menupontot az elsõ paraméter alapján
        JMenu menu = new JMenu(name);

        // A menupontot hozzáadjuk a BookShopMenuBar-hoz
        this.add(menu);

        // Az egyes menu itemeket a maradék paraméter értékeivel hozzuk létre
        for (String subname : subnames) {
            JMenuItem menuItem = new JMenuItem(subname);

            menu.add(menuItem);

            // Minden egyes menu itemet figyelünk
            // A menu itemek esetén a megfigyelést az ActionListener interfész
            // biztosítja, ezért a menubar implementálja ezt az interfészt és
            // felülírja az actionPerformed metódust
            menuItem.addActionListener(this);
        }
    }
     
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals(Labels.sign_in)){
			new SignInDialog(gui, true);
		}
		// TODO Auto-generated method stub

	}

}
