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
public class BalanceCheckDialog extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3084982645214566930L;
	
	private WebShopGUI gui;
	
	private JTextField currentBalanceTextField = new JTextField(16);
	private JSpinner increasementSpinner = new JSpinner();
	
    private JButton okButton = new JButton(Labels.ok);
    private JButton cancelButton = new JButton(Labels.cancel);
	
	public BalanceCheckDialog(WebShopGUI gui, boolean modal) {
		super(gui.getWindow(),modal);
		this.gui=gui;

		this.setTitle(Labels.balance);

		
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
		
		settingPanel.add(new JLabel(Labels.balance));
		settingPanel.add(currentBalanceTextField);
		currentBalanceTextField.setEditable(false);
		currentBalanceTextField.setText(gui.getController().getBalance(Main.getUsername()));

		settingPanel.add(new JLabel(Labels.increase_balance));
		settingPanel.add(increasementSpinner);

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
		if(okButton == e.getSource()){
			if ((Integer)increasementSpinner.getValue()>=0) {
				if (gui.getController().increaseBalance(Main.getUsername(),(Integer)increasementSpinner.getValue())){
		            setVisible(false);	
				} else {
					JOptionPane.showMessageDialog(
							gui.getWindow(),
							Labels.balance_increasement_error,
							Labels.error,
							JOptionPane.ERROR_MESSAGE);
					return;
				}
			} else {
				JOptionPane.showMessageDialog(
						gui.getWindow(),
						Labels.increasement_not_negative,
						Labels.error,
						JOptionPane.ERROR_MESSAGE);
				return;
			}
		} else if (cancelButton == e.getSource()) {
            // cancel esetén egyszerûen bezárjuk az ablakot
            setVisible(false);
        }
	}

}
