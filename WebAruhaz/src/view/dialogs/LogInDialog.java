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
import javax.swing.JTextField;

import model.bean.Customer;
import view.Labels;
import view.WebShopGUI;

/**
 * @author Attila
 *
 */
public class LogInDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = -4279317972516441060L;

	private WebShopGUI gui;
	
	private JTextField nameTextField = new JTextField(16);
	private JTextField passwordTextField = new JTextField(16);

    private JButton okButton = new JButton(Labels.ok);
    private JButton cancelButton = new JButton(Labels.cancel);
    
	public LogInDialog(WebShopGUI gui, boolean modal) {
		super(gui.getWindow(),modal);
		this.gui=gui;

		this.setTitle(Labels.log_in);
		
		JPanel settingPanel = createSettingPanel();
		
		JPanel buttonPanel = createButtonPanel();
		
		JPanel dialogPanel = createDialogPanel(settingPanel,buttonPanel);
		
		getContentPane().add(dialogPanel);
		
		pack();
		
		setLocationRelativeTo(gui.getWindow());
		
		setVisible(true);
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

        // A panel elrendez�se folytonos, k�z�pre igaz�tva
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Hozz�adjuk az ok gombot, �s figyel�nk r�
        buttonPanel.add(okButton);
        okButton.addActionListener(this);

        // Hozz�adjuk a cancel gombot, �s figyel�nk r�
        buttonPanel.add(cancelButton);
        cancelButton.addActionListener(this);

        return buttonPanel;
	}
	private JPanel createSettingPanel(){
		JPanel settingPanel = new JPanel();
		settingPanel.setLayout(new GridLayout(4, 1));
		
		settingPanel.add(new JLabel(Labels.user_name));
		settingPanel.add(nameTextField);
		

		settingPanel.add(new JLabel(Labels.password));
		settingPanel.add(passwordTextField);

		return settingPanel;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (okButton == e.getSource()){
			// TODO Auto-generated method stub	
			if (nameTextField.getText().isEmpty()){
				JOptionPane.showMessageDialog(
						gui.getWindow(),
						Labels.customer_name_is_required,
						Labels.error,
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if (passwordTextField.getText().isEmpty()){
				JOptionPane.showMessageDialog(
						gui.getWindow(),
						Labels.customer_password_is_required,
						Labels.error,
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			Customer customer = new Customer();
			customer.setName(nameTextField.getText());
			customer.setPassword(passwordTextField.getText());
			if(!gui.getController().logInCustomer(customer)){
				// Ha az logInCustomer false-t ad vissza akkor egy hiba�zenetet
                // �runk ki egy error dialogra(JOptionPane.ERROR_MESSAGE)
                JOptionPane.showMessageDialog(
                        gui.getWindow(),
                        Labels.customer_not_exists,
                        Labels.error,
                        JOptionPane.ERROR_MESSAGE);
			} else {
				// Ha az logInCustomer true-t ad vissza akkor bez�rjuk a dial�gust
                setVisible(false);
			}
			
			
		} else if (cancelButton == e.getSource()) {
            // cancel eset�n egyszer�en bez�rjuk az ablakot
            setVisible(false);
        }
	}

}
