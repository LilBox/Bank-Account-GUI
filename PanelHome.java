import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelHome extends JPanel{
	ArrayList<BankAccount> inside;
	public PanelHome() 
	{
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();	
		
		BufferedImage bankjpg = null;
		try {
			bankjpg = ImageIO.read(new File("brain.jpg"));
			
		}
		catch(IOException e1) {
			e1.printStackTrace();
		}
		JLabel picHomeLbl = new JLabel(new ImageIcon(bankjpg));

		JLabel welcomeLbl = new JLabel("Welcome to Kenny's Bank Account System");
		
		gbc.gridx = 0;
		gbc.gridy =	1;	
		this.add(picHomeLbl, gbc);
		
		gbc.gridy = 0;
		add(welcomeLbl,gbc);
		
		
		
		
	
	}
}



