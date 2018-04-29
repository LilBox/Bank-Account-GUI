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

public class PanelDeposit extends JPanel{
	ArrayList<BankAccount> inside;
	public PanelDeposit(JFrame frame, ArrayList<BankAccount> overall) {
		inside = overall;
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel accNumLbl = new JLabel("Account Number: ");
		JTextField accNumFld = new JTextField();
		JLabel depositAmLbl = new JLabel("Deposit Amount: $");
		JTextField depositAmFld = new JTextField();
		JButton depositBtn = new JButton("Deposit");
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(accNumLbl, gbc);
		
		gbc.gridx = 1;
		accNumFld.setPreferredSize(new Dimension(150,50));
		this.add(accNumFld, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(depositAmLbl, gbc);
		
		gbc.gridx = 1;
		depositAmFld.setPreferredSize(new Dimension(150,50));
		this.add(depositAmFld, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		depositBtn.setPreferredSize(new Dimension(150,50));
		this.add(depositBtn, gbc);
		
		depositBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean Found = false;
					for(int i = 0; i < inside.size(); i++) {
						if(accNumFld.getText().equals("" + inside.get(i).getAccNum()))
						{
							inside.get(i).deposit(Integer.parseInt(depositAmFld.getText()));
					        Found = true;
					        JOptionPane.showMessageDialog(frame, "Deposit Successful");
					    }
					}
					if(!Found) {
						JOptionPane accNotFound = new JOptionPane();
						accNotFound.showMessageDialog(frame, "Account Does Not Exist");
					}
				}
				catch(NullPointerException f) {
					JOptionPane enterStuff = new JOptionPane();
					enterStuff.showMessageDialog(frame,"Please Fill Out Each Field");
				}
				catch(IllegalArgumentException g) {
					JOptionPane depositError = new JOptionPane();
					depositError.showMessageDialog(frame,"Please Make Sure Your Deposit Abides By the Rules");
				}	
				
			}
		});
	}
}
