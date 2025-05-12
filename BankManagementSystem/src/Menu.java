package BankManagementSystem;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu {
	
	public Menu( Account acc, Database database,  ArrayList<Account> accounts) {
		
		JFrame frame = Main.Frame(350, 270);
		JLabel title = Main.Label("\nWelcome  "   + acc.getFirstName()+""+ acc.getLastName(), 23);
		JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		JButton deposit = Main.Button("Deposit",  22);
		JButton withdraw = Main.Button("Withdraw",  22);
		JButton balance = Main.Button("Balance",  22);
		
				
		panel.add(deposit);
		panel.add(withdraw);
		panel.add(balance);
		
		
		deposit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 new Deposit( acc, database, accounts);
				
			}
		});
		
		withdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Withdraw(acc, database, accounts);
		}
		});
		
		balance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "your balance is:  "  + acc.getBalance());
				
		}
		});
		
		
		
		
		frame.add(title,BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		
		
		
	}

}
