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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
	
	public Login( ArrayList<Account> accounts, Database database, int lastaccid) {
		
		JFrame frame = Main.Frame(500, 270);
		JLabel title = Main.Label("Welcome to bank management system", 23);
		JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JLabel label1 = Main.Label("Account id", 20);
		JTextField id = Main.TextField(20);
		JLabel label2 = Main.Label("Passcode",20);
		JPasswordField passcode = Main.PasswordField(20);
		panel.add(label1);
		panel.add(id);
		panel.add(label2);
		panel.add(passcode);
		JPanel panel2 = new JPanel(new GridLayout(1, 2, 10, 10));
		panel2.setBackground(null);
		panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10 ));
		JButton login = Main.Button("Login", 19);
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String id0 = id.getText().toString();
				@SuppressWarnings("deprecation")
				String passcode0 = passcode.getText().toString();
				
				try {
					 Integer.parseInt(id0);
				} catch(Exception w) {
					JOptionPane.showMessageDialog(frame, "id must be integer");
					return;
				}
				try {
					 Integer.parseInt(passcode0);
				} catch(Exception w) {
					JOptionPane.showMessageDialog(frame, "passcode must be digits");
					return;
				}
				
				
				 int id = Integer.parseInt(id0);
				 int passcode = Integer.parseInt(passcode0);
				 Account account = new Account();
					boolean exist = false;
					for(Account acc : accounts) {
						if (acc.getAccid() == id && acc.getPasscode() == passcode) {
							exist = true;
							account = acc;
					}
				}
				       if (exist) {
                            new Menu( account, database, accounts);
				    	    frame.dispose();
				     } else {
				    	 JOptionPane.showMessageDialog(frame,"Account does't exist");
				       }	  
				 
			}
		});
		JButton createacc = Main.Button("Create new account", 19);
		createacc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateAccount( lastaccid, accounts, database);
				frame.dispose();
				
		  }
		});
		panel2.add(login);
		panel2.add(createacc);
		frame.add(title,BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(panel2,BorderLayout.SOUTH);
		frame.setVisible(true);
	}

	
	}
	
	

