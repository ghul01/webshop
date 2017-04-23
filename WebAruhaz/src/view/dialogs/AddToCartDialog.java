/**
 * 
 */
package view.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import view.Labels;
import view.WebShopGUI;
import webshop.Main;

/**
 * @author Attila
 *
 */
public class AddToCartDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = -9211627210705886206L;

	private WebShopGUI gui;

	private JTextField idTextField = new JTextField(16);
	private JSpinner pieceSpinner = new JSpinner();
	
    private JButton okButton = new JButton(Labels.ok);
    private JButton cancelButton = new JButton(Labels.cancel);
    
	public AddToCartDialog(WebShopGUI gui, boolean modal) {
		super(gui.getWindow(),modal);
		this.gui=gui;
		
		this.setTitle(Labels.cart_add_id);
		

		
		JPanel settingPanel = createSettingPanel();
		
		JPanel buttonPanel = createButtonPanel();
		
		JPanel dialogPanel = createDialogPanel(settingPanel,buttonPanel);
		
		getContentPane().add(dialogPanel);
		
		pack();
		
		setLocationRelativeTo(gui.getWindow());
		
		setVisible(true);
	}
	

	private JPanel createSettingPanel() {
		JPanel settingPanel = new JPanel();
		settingPanel.setLayout(new GridLayout(4, 1));

		settingPanel.add(new JLabel(Labels.id));
		settingPanel.add(idTextField);
		
		settingPanel.add(new JLabel(Labels.piece));
		settingPanel.add(pieceSpinner);
		pieceSpinner.setValue(1);
		
		return settingPanel;
	}

	private JPanel createDialogPanel(JPanel settingPanel, JPanel buttonPanel) {
		JPanel dialogPanel = new JPanel();
		dialogPanel.setLayout(new BorderLayout());
		dialogPanel.add(settingPanel, BorderLayout.CENTER);
		dialogPanel.add(buttonPanel, BorderLayout.SOUTH);
		return dialogPanel;
	}
	
	private JPanel createButtonPanel() {
		JPanel buttonPanel = new JPanel();

        // A panel elrendezése folytonos, középre igazítva
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Hozzáadjuk az ok gombot, és figyelünk rá
        buttonPanel.add(okButton);
        okButton.addActionListener(this);

        // Hozzáadjuk a cancel gombot, és figyelünk rá
        buttonPanel.add(cancelButton);
        cancelButton.addActionListener(this);

        return buttonPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton){
			if ((Integer) pieceSpinner.getValue() > 0) {
				if (gui.getController().findProductById(
						Integer.parseInt(idTextField.getText()))) {
					if (gui.getController().addPorductToCartById(
							Main.getUsername(), Integer.parseInt(
									idTextField.getText()),
							(Integer)pieceSpinner.getValue())) {
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(
								gui.getWindow(),
								Labels.cart_add_product_error,
								Labels.error,
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				} else {
					JOptionPane.showMessageDialog(
							gui.getWindow(),
							Labels.product_not_found,
							Labels.error,
							JOptionPane.ERROR_MESSAGE);
					return;
				}				
			} else {
				JOptionPane.showMessageDialog(
						gui.getWindow(),
						Labels.piece_error,
						Labels.error,
						JOptionPane.ERROR_MESSAGE);
				return;
			}			
		} else if (e.getSource() == cancelButton){
			setVisible(false);
		}
	}

}
