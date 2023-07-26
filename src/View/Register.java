
package View;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Controller.SQLite;
import Model.HashCreator;
import Model.User;

public class Register extends javax.swing.JPanel {

    public Frame frame;
    private SQLite sqlite;
    private HashCreator hashCreator;
    
    public Register() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerBtn = new javax.swing.JButton();
        passwordFld = new javax.swing.JPasswordField();
        usernameFld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        confpassFld = new javax.swing.JPasswordField();
        backBtn = new javax.swing.JButton();
        
        hashCreator = new HashCreator();

        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerBtn.setText("REGISTER");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					registerBtnActionPerformed(evt);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        passwordFld.setBackground(new java.awt.Color(240, 240, 240));
        passwordFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        usernameFld.setBackground(new java.awt.Color(240, 240, 240));
        usernameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        confpassFld.setBackground(new java.awt.Color(240, 240, 240));
        confpassFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        confpassFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confpassFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "CONFIRM PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        backBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        backBtn.setText("<Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usernameFld)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordFld, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confpassFld, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(200, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(confpassFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) throws NoSuchAlgorithmException {//GEN-FIRST:event_registerBtnActionPerformed
    	String username = usernameFld.getText().toLowerCase();
    	String password = passwordFld.getText();
    	String confirmPassword = confpassFld.getText();
    	
    	// Checks if the username, password, and confirm password is not empty upon clicking register button
    	if(!username.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty()) {
    		// Checks if the username is 6 to 30 charcters long
    		if(username.length() < 6 || username.length() > 30) {
    			javax.swing.JOptionPane.showMessageDialog(null, "Choose a username 6-30 characters long.", "Register Message", JOptionPane.PLAIN_MESSAGE);
    		} else {
    			boolean isUsernameValid = true;
        		boolean isPasswordValid = true;
        		
        		ArrayList<User> users = sqlite.getUsers();
                for(int nCtr = 0; nCtr < users.size(); nCtr++){
                	// Check the Username is valid and unique from the Database
                    if(username.compareTo(users.get(nCtr).getUsername()) == 0) {
                    	javax.swing.JOptionPane.showMessageDialog(null, "Username is already exists", "Register Message", JOptionPane.PLAIN_MESSAGE);
                    	isUsernameValid = false;
                    	usernameFld.setText("");
                    	break;
                    }
                }
                
                // Checks for the password based from the criteria given
                if(isUsernameValid) {
                	boolean isValid = true;
                	String validationMessage = "";
                	if (password.length() < 8 || password.length() > 32) {
        	            isValid = false;
        	            validationMessage += "Password must be between 8 and 32 characters long.\n";
        	        }
        	        if (!password.matches(".*[A-Z].*")) {
        	            isValid = false;
        	            validationMessage += "Password must contain at least one uppercase letter.\n";
        	        }
        	        if (!password.matches(".*[a-z].*")) {
        	            isValid = false;
        	            validationMessage += "Password must contain at least one lowercase letter.\n";
        	        }
        	        if (!password.matches(".*\\d.*")) {
        	            isValid = false;
        	            validationMessage += "Password must contain at least one digit.\n";
        	        }
        	        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
        	            isValid = false;
        	            validationMessage += "Password must contain at least one symbol.\n";
        	        }
        	        
        	        if(!isValid){
        	        	isPasswordValid = false;
        	        	javax.swing.JOptionPane.showMessageDialog(null, validationMessage, "Register Message", JOptionPane.PLAIN_MESSAGE);
        	        }
                }
                
                // Checks if the password and confirm password is match
                if(isPasswordValid && isUsernameValid) {
                	// Match passwords
                	if(password.compareTo(confirmPassword) == 0) {
                		// Creating a Timestamp
        				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        				LocalDateTime now = LocalDateTime.now();  
        			    System.out.println(dtf.format(now));
        			    
        			    // Authentication Logs
        			    sqlite.addLogs("Register", username, "Successful", dtf.format(now).toString());
        			    
                		// Notifies the user that the account has been registered
                		javax.swing.JOptionPane.showMessageDialog(null, "Account has been registered!", "Register Message", JOptionPane.PLAIN_MESSAGE);
                		
                		// Registers the account in the database
        	        	frame.registerAction(usernameFld.getText(), hashCreator.createMD5Hash(passwordFld.getText()), confpassFld.getText());
        	        	
        	        	// Clears the username, password, and confirm password field
        	        	frame.registerPnl.usernameFld.setText("");
        	        	frame.registerPnl.passwordFld.setText("");
        	        	frame.registerPnl.confpassFld.setText("");
        	        	
        	        	// Proceeds to the login page
        	        	frame.loginNav();
        	        // Unmatched password
                	} else {
                		// Notifies the user that the password and confirm password does not match
                		javax.swing.JOptionPane.showMessageDialog(null, "Password and Confirm password does not match", "Register Message", JOptionPane.PLAIN_MESSAGE);
        	        
                		// Clears the password and confirm password 
        	        	frame.registerPnl.passwordFld.setText("");
        	        	frame.registerPnl.confpassFld.setText("");
                	}
                    }
    		}
    	} else {
		 	javax.swing.JOptionPane.showMessageDialog(null, "Complete the form", "Register Message", JOptionPane.PLAIN_MESSAGE);
		}
    }//GEN-LAST:event_registerBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
    	
    	// Clears the username, password, and confirm password upon navigating
    	frame.registerPnl.usernameFld.setText("");
    	frame.registerPnl.passwordFld.setText("");
    	frame.registerPnl.confpassFld.setText("");
    	
        frame.loginNav();
    }//GEN-LAST:event_backBtnActionPerformed

 // Create a init function
 	public void init(SQLite db) {
 		this.sqlite = db;
 	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPasswordField confpassFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField passwordFld;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration//GEN-END:variables
}
