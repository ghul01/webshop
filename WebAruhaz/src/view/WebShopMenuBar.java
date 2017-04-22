/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import view.dialogs.LogInDialog;
import view.dialogs.LogOutDialog;
import view.dialogs.SignInDialog;
import webshop.Main;

/**
 * @author Attila
 *
 */
public class WebShopMenuBar extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = -143840565706992902L;
	private WebShopGUI gui;
	
	public WebShopMenuBar(WebShopGUI gui) {
		super();
		this.gui = gui;
		
		createMenuPoint(Labels.user, Labels.log_in, Labels.sign_in, Labels.log_out);
		createStoreMenuPoint();
	}

    private void createStoreMenuPoint() {
    	JMenu store = new JMenu(Labels.store);
    	this.add(store);
    	JMenuItem all = new JMenuItem(Labels.list_all_product); 
    	store.add(all);
    	JMenuItem news = new JMenuItem(Labels.list_new_products);
    	store.add(news);
    	JMenu categoryMenu = new JMenu(Labels.list_by_categories);
    	store.add(categoryMenu);
    	for (model.bean.Category category:gui.getController().getCategories()){
    		JMenuItem item = new JMenuItem(category.getName());
    		categoryMenu.add(item);
    	}
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
		if(actionCommand.equals(Labels.log_in)){
			if (Main.getUsername()==null){
			new LogInDialog(gui,true);
			gui.updateTitle();
			} else {
					JOptionPane.showMessageDialog(
							gui.getWindow(),
							Labels.customer_already_logged_in,
							Labels.error,
							JOptionPane.ERROR_MESSAGE);
					return;
			}
		} else if (actionCommand.equals(Labels.log_out)){
			new LogOutDialog(gui,true);
			gui.updateTitle();
		} else if (actionCommand.equals(Labels.sign_in)){
			new SignInDialog(gui, true);
		}
		// TODO Auto-generated method stub

	}

}
