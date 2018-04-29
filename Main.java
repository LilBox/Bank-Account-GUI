import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Main extends JFrame{
	private ArrayList <BankAccount> bankOverall = new ArrayList<BankAccount>();
	public Main() {
		
		CardLayout cl = new CardLayout();
		
		this.setBounds(0,0,1000,600);
		this.setTitle("Bank Account");
		
		JPanel overall = new JPanel();
		overall.setLayout(cl);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu accountMenu = new JMenu("Account");
		JMenuItem addAccMenu = new JMenuItem("Add Account");
		JMenuItem removeAccMenu = new JMenuItem("Remove Account");
		JMenu transactionMenu = new JMenu("Transactions");
		JMenuItem depositMenu = new JMenuItem("Deposit");
		JMenuItem withdrawMenu = new JMenuItem("Withdraw");
		JMenuItem transferMenu = new JMenuItem("Transfer");
		JMenuItem homeMenu = new JMenuItem("Home");
		JMenuItem findBalMenu = new JMenuItem("Find Balance");
		
		accountMenu.add(addAccMenu);
		accountMenu.add(removeAccMenu);
		transactionMenu.add(depositMenu);
		transactionMenu.add(withdrawMenu);
		transactionMenu.add(transferMenu);
		transactionMenu.add(findBalMenu);
		
		menuBar.add(accountMenu);
		menuBar.add(transactionMenu);
		menuBar.add(homeMenu);
		menuBar.setVisible(true);
		this.setJMenuBar(menuBar);
		
		PanelHome homePanel = new PanelHome();
		overall.add(homePanel,"homePanel");
		PanelAdd addPanel = new PanelAdd(this, bankOverall);
		overall.add(addPanel,"addPanel");
		PanelRemove removePanel = new PanelRemove(this, bankOverall);
		overall.add(removePanel,"removePanel");
		PanelTransfer transferPanel = new PanelTransfer(this, bankOverall);
		overall.add(transferPanel,"transferPanel");
		PanelDeposit depositPanel = new PanelDeposit(this, bankOverall);
		overall.add(depositPanel,"depositPanel");
		PanelWithdraw withdrawPanel = new PanelWithdraw(this, bankOverall);
		overall.add(withdrawPanel, "withdrawPanel");
		PanelFindBalance findBalancePanel = new PanelFindBalance(this,bankOverall);
		overall.add(findBalancePanel, "findPanel");
		
		addAccMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent e) {
				cl.show(overall, "addPanel");
			}
		});

		removeAccMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent e) {
				cl.show(overall, "removePanel");
			}
		});

		depositMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent e) {
				cl.show(overall, "depositPanel");
			}
		});

		withdrawMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent e) {
				cl.show(overall, "withdrawPanel");
			}
		});

		transferMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed (ActionEvent e) {
				cl.show(overall, "transferPanel");
			}
		});
		
		homeMenu.addActionListener(new ActionListener() {	
			public void actionPerformed (ActionEvent e) {
				cl.show(overall, "homePanel");
			}
		});
		
		findBalMenu.addActionListener(new ActionListener() {	
			public void actionPerformed (ActionEvent e) {
				cl.show(overall, "findPanel");
			}
		});
		
		cl.show(overall,"homePanel");
		add(overall);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main();
	}
}