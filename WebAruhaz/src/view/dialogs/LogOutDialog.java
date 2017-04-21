/**
 * 
 */
package view.dialogs;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import view.Labels;
import view.WebShopGUI;
import webshop.main;

/**
 * @author Attila
 *
 */
public class LogOutDialog extends JDialog implements ActionListener {

	
	
	private static final long serialVersionUID = 5315929730341308127L;
    private JButton okButton = new JButton(Labels.ok);
    
	public LogOutDialog(WebShopGUI gui, boolean modal) {
		super(gui.getWindow(),modal);
		setLayout(new GridLayout(2, 1));
		this.setTitle(Labels.log_out);
		
		add(new JLabel(Labels.log_out_succes));
		okButton.addActionListener(this);
		add(okButton);

		pack();
		
		setLocationRelativeTo(gui.getWindow());
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (okButton == e.getSource()) {
			main.setUsername(null);
            setVisible(false);
        }
	}

}
