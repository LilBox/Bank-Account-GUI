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

public class PanelFindBalance extends JPanel{
	ArrayList<BankAccount> inside;
	public PanelFindBalance(JFrame frame, ArrayList<BankAccount> overall) {
		inside = overall;
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel accNumLbl = new JLabel("Account Number: ");
		JTextField accNumFld = new JTextField();
		JButton getBalBtn = new JButton("Get Balance");
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(accNumLbl, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		accNumFld.setPreferredSize(new Dimension(150,50));
		this.add(accNumFld, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		getBalBtn.setPreferredSize(new Dimension(150,50));
		this.add(getBalBtn, gbc);
		
		getBalBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					boolean found = false;
					for(int i = 0; i < inside.size() ; i++) {
						if(accNumFld.getText().equals("" + inside.get(i).getAccNum()))
				        {
				            found = true;
				            JOptionPane.showMessageDialog(frame, "This Bank Account Has A Balance of: $" + inside.get(i).getBalance());
				        }
					}
					if(!found) {
						JOptionPane.showMessageDialog(frame, "Bank Account Not Found");
					}
				}
				catch(NullPointerException g) {
					JOptionPane removeEmpty = new JOptionPane();
					removeEmpty.showMessageDialog(frame,"Please Fill Out Each Field");
				}
				catch(IllegalArgumentException f) {
					JOptionPane removeError = new JOptionPane();
					removeError.showMessageDialog(frame,"Please Make Sure Your Balance Finding Abides By the Rules");
				}
			}
		});
	}
}
