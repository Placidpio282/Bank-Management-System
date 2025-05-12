package BankManagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Main {
	
	 
	static  Scanner scanner;
	 static int nextid = 0;
	 private static ArrayList<Account> accounts;
	
	public static void main(String[] args) {
		
		
		 accounts = new ArrayList<>();
		 scanner = new Scanner(System.in);
		Database database = new Database();
		accounts = database.getAccounts();
		if(accounts.size()==0) {
			nextid=1000000;
		} else {
			nextid = accounts.size()+ 1000001;
			
		}
		   
	    new Login( accounts, database,nextid);
	     
		

	}
    public static JFrame Frame(int width, int height) {
    	JFrame frame =  new JFrame("Bank Management System");
    	frame.setSize(width, height);
    	frame.setLocationRelativeTo(null);
    	frame.setLayout(new BorderLayout());
    	frame.getContentPane().setBackground(Color.white);
    	return frame;
    }
    public static JLabel Label(String text, int size) {
    	JLabel label = new JLabel(text);
    	label.setFont(new Font("Tahoma", Font.BOLD, size));
    	label.setForeground(Color.black);
    	label.setBorder(BorderFactory.createEmptyBorder(10,  10,  10, 10));
    	label.setHorizontalAlignment(SwingConstants.CENTER);
		return label;
    	
    }
    public static JTextField TextField(int size) {
    	  JTextField textField = new JTextField();
    	  textField.setFont(new Font("Tahoma", Font.BOLD, size));
    	  textField.setForeground(Color.black);
    	  textField.setHorizontalAlignment(SwingConstants.CENTER);
    	  return  textField;
    }
    public static JPasswordField PasswordField(int size) {
      JPasswordField PasswordField = new JPasswordField();
      PasswordField.setFont(new Font("Tahoma", Font.BOLD, size));
      PasswordField.setForeground(Color.black);
      PasswordField.setHorizontalAlignment(SwingConstants.CENTER);
  	  return  PasswordField;
  }
    public static JButton Button(String text,int size) {
    	JButton btn = new JButton(text);
    	btn.setFont(new Font("Tahoma", Font.BOLD, size));
    	btn.setForeground(Color.white);
    	btn.setBackground(Color.red);
    	btn.setHorizontalAlignment(SwingConstants.CENTER);
    	btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10 ));
  	  return  btn;
  }
    }
