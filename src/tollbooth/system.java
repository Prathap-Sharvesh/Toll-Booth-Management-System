package tollbooth;
import java.util.*;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class system extends JFrame  {
		
	
		
		private JTextField usernameField;
	    private JPasswordField passwordField;
	    private JButton adminLoginButton;
	    private JButton userLoginButton;
	    private JLabel messageLabel;
	    
	    // Credentials for demonstration
	    private final String adminUsername = "admin";
	    private final String adminPassword = "admin123";
	    private final String userUsername = "user";
	    private final String userPassword = "user123";
	    
		private admin ad = new admin ();
		private guest g = new guest();
	    
	    public system()					//Default Constructor 
	    {
	    	setTitle(" Toll Booth System Login");
	    	setSize(400,600);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	setLocationRelativeTo(null); 		//Placed on center of the screen
	    	
	    	//Component Creation
	    	
	    	JLabel usernameLabel = new JLabel("Username");
	    	usernameField = new JTextField(20);
	    	JLabel passwordLabel = new JLabel("Password:");
	        passwordField = new JPasswordField(20);
	    	adminLoginButton = new JButton ("Admin Login");
	    	userLoginButton =  new JButton ("User Login");
	    	messageLabel = new JLabel(" ");
	    	

	        // Layout Manager 
	        setLayout(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.insets = new Insets(10, 10, 10, 10); // Add some space between components
	        
	     // Add components to the frame using GridBagLayout
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        add(usernameLabel, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 0;
	        add(usernameField, gbc);

	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        add(passwordLabel, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        add(passwordField, gbc);

	        gbc.gridx = 0;
	        gbc.gridy = 2;
	        add(adminLoginButton, gbc);

	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        add(userLoginButton, gbc);

	        gbc.gridx = 0;
	        gbc.gridy = 3;
	        gbc.gridwidth = 2;
	        add(messageLabel, gbc);
	        
	        // Action Listeners for Buttons
	        adminLoginButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String username = usernameField.getText();
	                char[] password = passwordField.getPassword();

	                // Admin login logic
	                if (username.equals(adminUsername) && new String(password).equals(adminPassword)) {
	                    messageLabel.setText("Admin Login Successful");
	                    messageLabel.setForeground(Color.GREEN);
	                    try {
							displayAdminOptions();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                } else {
	                    messageLabel.setText("Invalid Admin credentials");
	                    messageLabel.setForeground(Color.RED);
	                }
	            }
	        });

	        userLoginButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String username = usernameField.getText();
	                char[] password = passwordField.getPassword();

	                // User login logic
	                if (username.equals(userUsername) && new String(password).equals(userPassword)) {
	                    messageLabel.setText("User Login Successful");
	                    messageLabel.setForeground(Color.GREEN);
	                    try {
							displayUserOptions();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                } else {
	                    messageLabel.setText("Invalid User credentials");
	                    messageLabel.setForeground(Color.RED);
	                }
	            }
	        });
	    }
	    
	    public void displayAdminOptions() {
	        SwingUtilities.invokeLater(() -> {
	            new AdminPanel().setVisible(true);
	        });
	    }

	    
	    
	    private void displayUserOptions() throws Exception {
	        String input = JOptionPane.showInputDialog(this, "1. Search for Vehicle in Database");

	        if (input != null && input.equals("1")) {
	            int no = Integer.parseInt(JOptionPane.showInputDialog("Enter the vehicle number:"));
	            g.searchDetails(no);
	        }
	    }

	    // Main method to launch the GUI
	    public static void main(String[] args) throws Exception {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new system().setVisible(true);
	            }
	        });
	    }
}
