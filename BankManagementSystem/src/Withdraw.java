package BankManagementSystem;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Withdraw {

	public Withdraw( Account acc,Database database,ArrayList<Account> accounts) {
		
		JFrame  frame =Main.Frame(350, 210);
		JLabel title = Main.Label("Withdraw", 23);
		JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JLabel label = Main.Label("Amount", 20);
		JTextField am = Main.TextField(20);
		panel.add(label);
		panel.add(am);
		JPanel panel2 = new JPanel( new BorderLayout());
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel2.setBackground(null);
		JButton withdraw = Main.Button("Withdraw", 19);
		withdraw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					 Double.parseDouble(am.getText().toString());
				} catch (Exception w) {
					JOptionPane.showMessageDialog(frame, "Amount must be number");
					return;
				}
				double amount = Double.parseDouble(am.getText().toString());
				acc.setBalance(acc.getBalance() - amount); 
				JOptionPane.showMessageDialog(frame,"operation done successfully!");
				database.saveAccounts(accounts);
				frame.dispose();
			}
		});
		panel2.add(withdraw);
		frame.add(title,BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2,BorderLayout.SOUTH);
		frame.setVisible(true);
	}
}
