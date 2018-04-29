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

public class PanelWithdraw extends JPanel{
	ArrayList<BankAccount> inside;
	public PanelWithdraw(JFrame frame, ArrayList<BankAccount> overall) {
		inside = overall;
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel accNumLbl = new JLabel("Account Number: ");
		JTextField accNumFld = new JTextField();
		JLabel withdrawAmLbl = new JLabel("Withdraw Amount: $");
		JTextField withdrawAmFld = new JTextField();
		JButton withdrawBtn = new JButton("Withdraw");
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(accNumLbl, gbc);
		
		gbc.gridx = 1;
		accNumFld.setPreferredSize(new Dimension(150,50));
		this.add(accNumFld, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(withdrawAmLbl, gbc);
		
		gbc.gridx = 1;
		withdrawAmFld.setPreferredSize(new Dimension(150,50));
		this.add(withdrawAmFld, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		withdrawBtn.setPreferredSize(new Dimension(150,50));
		this.add(withdrawBtn, gbc);
		
		withdrawBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean Found = false;
					for(int i = 0; i < inside.size(); i++) {
						 if(accNumFld.getText().equals("" + inside.get(i).getAccNum()))
					        {
							 	inside.get(i).withdraw(Integer.parseInt(withdrawAmFld.getText()));
					            Found = true;
					            JOptionPane.showMessageDialog(frame, "Withdraw Successful");
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
					JOptionPane withdrawError = new JOptionPane();
					withdrawError.showMessageDialog(frame,"Please Make Sure Your Withdraw Abides By the Rules");
				}	
				
			}
		});
	}
}
