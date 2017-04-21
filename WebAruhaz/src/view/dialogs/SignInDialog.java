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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.Labels;
import view.WebShopGUI;

/**
 * @author Attila
 *
 */
public class SignInDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = -3665166175344019275L;

	private JTextField nameTextField = new JTextField(16);
	private JTextField passwordTextField = new JTextField(16);
	private JTextField reEnteredPasswordTextField = new JTextField(16);
	private JComboBox<String> cityCombo;
	private JTextField homeAddressTextField = new JTextField(16);
	
    private JButton okButton = new JButton(Labels.ok);
    private JButton cancelButton = new JButton(Labels.cancel);
    
	private WebShopGUI gui;
	
	public SignInDialog(WebShopGUI gui, boolean modal) {
		super(gui.getWindow(),modal);
		this.gui=gui;
		
		this.setTitle(Labels.sign_in);
		
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

	private JPanel createSettingPanel() {
		JPanel settingPanel = new JPanel();
		
		settingPanel.setLayout(new GridLayout(5, 2));
		
		settingPanel.add(new JLabel(Labels.user_name));
		settingPanel.add(nameTextField);
		

		settingPanel.add(new JLabel(Labels.password));
		settingPanel.add(passwordTextField);

		settingPanel.add(new JLabel(Labels.re_enter_password));
		settingPanel.add(reEnteredPasswordTextField);
		
		settingPanel.add(new JLabel(Labels.city_address));
		cityCombo = new JComboBox<String>();
		settingPanel.add(cityCombo);

		settingPanel.add(new JLabel(Labels.home_address));
		settingPanel.add(homeAddressTextField);

		return settingPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (cancelButton == e.getSource()) {
            // cancel esetén egyszerûen bezárjuk az ablakot
            setVisible(false);
        }
	}

}
