
package View;

import java.util.ArrayList;

import Controller.SQLite;
import Model.HashCreator;
import Model.User;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Login extends javax.swing.JPanel {

    public Frame frame;
    private SQLite sqlite;
    private HashCreator hashCreator;
    
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
        jLabel1 = new javax.swing.JLabel();
        usernameFld = new javax.swing.JTextField();
        passwordFld = new javax.swing.JPasswordField();
        registerBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        
        hashCreator = new HashCreator();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SECURITY Svcs");
        jLabel1.setToolTipText("");

        usernameFld.setBackground(new java.awt.Color(240, 240, 240));
        usernameFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        usernameFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usernameFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "USERNAME", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        passwordFld.setBackground(new java.awt.Color(240, 240, 240));
        passwordFld.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        passwordFld.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordFld.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "PASSWORD", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        registerBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        registerBtn.setText("REGISTER");
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });

        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        loginBtn.setText("LOGIN");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					loginBtnActionPerformed(evt);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(registerBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(usernameFld)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordFld, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(usernameFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        this.setLayout(layout);
        
        // Clearing all the username and password fields
        usernameFld.setText("");
        passwordFld.setText("");
        
    }// </editor-fold>//GEN-END:initComponents

    // Create a init function
	public void init(SQLite db) {
		this.sqlite = db;
	}
	
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) throws NoSuchAlgorithmException {                                          
    	// -1 --> incomplete fields 0 --> incorrect 1 --> correct
    	int isValid = 0;
    	
    	String username = usernameFld.getText().toLowerCase();
    	String password = passwordFld.getText();
    	
        frame.mainNav();
        
    	if(!username.isEmpty() && !password.isEmpty()) {
    		ArrayList<User> users = sqlite.getUsers();
            for(int nCtr = 0; nCtr < users.size(); nCtr++){
            	if(users.get(nCtr).getUsername().compareTo(username) == 0) {
            		if(users.get(nCtr).getPassword().compareTo(HashCreator.createMD5Hash(password)) == 0) {
            			isValid = 1;
            			break;
            		} else {
            			isValid = 0;
            			break;
            		}
            	}
            }
            
            if(isValid == 1) {
            	// Creating a Timestamp
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();  
			    System.out.println(dtf.format(now));
			    
			    // Authentication Logs
			    sqlite.addLogs("Login", username, "Successful", dtf.format(now).toString());
					
				// Clears the username and password upon navigating to another page
				usernameFld.setText("");
				passwordFld.setText("");
				
				// Proceeds to main page
				frame.mainNav();
        	} else if(isValid == 0){
        		// Creating a Timestamp
        		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
				LocalDateTime now = LocalDateTime.now();  
			    System.out.println(dtf.format(now));
			    
			    // Authentication Logs
			    sqlite.addLogs("Login", username, "Unsuccessful", dtf.format(now).toString());
        		
        		//Notifies the user that the username or password is incorrect
        		javax.swing.JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Failed", JOptionPane.PLAIN_MESSAGE);
        		
        		// Clears the password field
        		passwordFld.setText("");
        		
        		// Debug
        		System.out.println("Current username: "+username);
        		System.out.println("Current password: "+password);
        	}
            
    	} else {
    		javax.swing.JOptionPane.showMessageDialog(null, "Complete the form", "Login Message", JOptionPane.PLAIN_MESSAGE);
    	}
    }                                        

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed
    	
    	// Clears the username and password upon navigating to another page
    	usernameFld.setText("");
    	passwordFld.setText("");
        
    	// Proceeds to register page
    	frame.registerNav();
    }//GEN-LAST:event_registerBtnActionPerformed
    
    
    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordFld;
    private javax.swing.JButton registerBtn;
    private javax.swing.JTextField usernameFld;
}
