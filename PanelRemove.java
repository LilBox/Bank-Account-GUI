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

public class PanelRemove extends JPanel{
	ArrayList<BankAccount> inside;
	public PanelRemove() {
		super();
	}
	public PanelRemove(JFrame frame, ArrayList<BankAccount> overall) {
		inside = overall;
		this.setVisible(true);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
	
		JList accNumType = new JList();
		JLabel accNumLbl = new JLabel("Enter Account Number: ");
		JTextField accNumFld = new JTextField();
		JButton RemoveAccBtn = new JButton("Remove Account");

		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(accNumLbl, gbc);
		
		gbc.gridx = 1;
		accNumFld.setPreferredSize(new Dimension(150,50));
		this.add(accNumFld, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		RemoveAccBtn.setPreferredSize(new Dimension(150,50));
		this.add(RemoveAccBtn, gbc);
		
		RemoveAccBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean found = false;
					for(int i = 0; i < inside.size(); i++) {
						if(inside.get(i).getAccNum() == Integer.parseInt(accNumFld.getText())) {
							found = true;
							inside.remove(i);
							i--;
						}
					}
					if(found) {
						JOptionPane removeSuccess = new JOptionPane();
						removeSuccess.showMessageDialog(frame,"Removal Successful With Account Number: " + accNumFld.getText());
					}
					else {
						JOptionPane removeFail = new JOptionPane();
						removeFail.showMessageDialog(frame,"Removal Unsuccessful With Account Number: " + accNumFld.getText());
					}
				}
				catch(NullPointerException g) {
					JOptionPane removeEmpty = new JOptionPane();
					removeEmpty.showMessageDialog(frame,"Please Fill Out Each Field");
				}
				catch(IllegalArgumentException f) {
					JOptionPane removeError = new JOptionPane();
					removeError.showMessageDialog(frame,"Please Make Sure Your Account Addition Abides By the Rules");
				}
			}
			
		});
		
	}
}
