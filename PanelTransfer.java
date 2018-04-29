import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelTransfer extends JPanel{
	ArrayList<BankAccount> inside;
	public PanelTransfer(JFrame frame, ArrayList<BankAccount> overall) {
		inside = overall;
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel accNumLbl = new JLabel("Bank Account Number (From): ");
		JTextField accNumFld = new JTextField();
		JLabel accNumToLbl = new JLabel("Bank Account Number (To): ");
		JTextField accNumToFld = new JTextField();
		JLabel transferAmLbl = new JLabel("Transfer Amount: $");
		JTextField transferAmFld = new JTextField();
		JButton transferBtn = new JButton("Transfer");
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(accNumLbl, gbc);
		
		gbc.gridx = 1;
		accNumFld.setPreferredSize(new Dimension(150,50));
		this.add(accNumFld, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(accNumToLbl, gbc);
		
		gbc.gridx = 1;
		accNumToFld.setPreferredSize(new Dimension(150,50));
		this.add(accNumToFld, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(transferAmLbl, gbc);
		
		gbc.gridx = 1;
		transferAmFld.setPreferredSize(new Dimension(150,50));
		this.add(transferAmFld, gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		transferBtn.setPreferredSize(new Dimension(150,50));
		this.add(transferBtn, gbc);
		
		transferBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean Found = false;
					for(int i = 0; i < inside.size(); i++) {
						 if(accNumFld.getText().equals("" + inside.get(i).getAccNum()))
					        {
							 	for(int j = 0; j < inside.size(); j++) {
								 	if(accNumToFld.getText().equals("" + inside.get(j).getAccNum())) {
								 		if(j == i) {
								 			JOptionPane sameAcc = new JOptionPane();
											sameAcc.showMessageDialog(frame, "You Can Not Transfer To the Same Account");
								 		}
								 		else {
								 		inside.get(i).transfer(inside.get(j), Integer.parseInt(transferAmFld.getText()));
								 		Found = true;
								 		JOptionPane.showMessageDialog(frame, "Transfer Successful");
								 		}
								 	}
							 	}
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
					JOptionPane transferError = new JOptionPane();
					transferError.showMessageDialog(frame,"Please Make Sure Your Transfer Abides By the Rules");
				}	
				
			}
		});
	}
}
