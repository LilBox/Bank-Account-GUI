import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAdd extends JPanel{
	ArrayList<BankAccount> inside;
	
	public PanelAdd() {
		super();
	}
	
	public PanelAdd(JFrame frame, ArrayList<BankAccount> overall) {
		inside = overall;
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel AccNameLbl = new JLabel("Enter Name: ");
		JTextField AccNameFld = new JTextField();
		JLabel AccBalLbl = new JLabel("Enter Balance: $");
		JTextField AccBalFld = new JTextField();
		JButton AddAccBtn = new JButton("Add Account");
		String[] arr = {"Checking Account", "Savings"};
		JList AccType = new JList(arr);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(AccNameLbl, gbc);
		

		gbc.gridx = 1;
		gbc.gridy = 0;
		AccNameFld.setPreferredSize(new Dimension(150,50));
		this.add(AccNameFld, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(AccBalLbl, gbc);
		

		gbc.gridx = 1;
		gbc.gridy = 1;
		AccBalFld.setPreferredSize(new Dimension(150,50));
		this.add(AccBalFld, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		this.add(AccType, gbc);
		
		gbc.gridx = 0;
		AddAccBtn.setPreferredSize(new Dimension(150,50));
		this.add(AddAccBtn, gbc);
		
		AddAccBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					BankAccount tempBank;
					if(((String) AccType.getSelectedValue()).equals("Checking Account")) {
						tempBank = new CheckingAccount(AccNameFld.getText(), Double.parseDouble(AccBalFld.getText()), 10, 0.05, 15);
						inside.add(tempBank);
					}
					else {
						tempBank = new SavingsAccount(AccNameFld.getText(), Double.parseDouble(AccBalFld.getText()), 0.004, 100, 15);
						inside.add(tempBank);
					}
					JOptionPane addSuccess = new JOptionPane();
					addSuccess.showMessageDialog(frame,"Account Created Successfully With Account Number: " + tempBank.getAccNum());
				
				}
				catch(NullPointerException f) {
					JOptionPane addEmpty = new JOptionPane();
					addEmpty.showMessageDialog(frame,"Please Fill Out Each Field");
				}
				catch(IllegalArgumentException g) {
					JOptionPane addError = new JOptionPane();
					addError.showMessageDialog(frame,"Please Make Sure Your Account Addition Abides By the Rules");
				}
				
			}
			
		});
		
	
	}
}
