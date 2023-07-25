/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.SQLite;
import Model.HashCreator;
import Model.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beepxD
 */
public class MgmtUser extends javax.swing.JPanel {

    public SQLite sqlite;
    public DefaultTableModel tableModel;
    public Frame frame;
    private HashCreator hashCreator;
    
    public MgmtUser(SQLite sqlite) {
        initComponents();
        this.sqlite = sqlite;
        tableModel = (DefaultTableModel)table.getModel();
        table.getTableHeader().setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
    
//        UNCOMMENT TO DISABLE BUTTONS
//        editBtn.setVisible(false);
//        deleteBtn.setVisible(false);
//        lockBtn.setVisible(false);
//        chgpassBtn.setVisible(false);
    }
    
    public void init(){
        //      CLEAR TABLE
        for(int nCtr = tableModel.getRowCount(); nCtr > 0; nCtr--){
            tableModel.removeRow(0);
        }
        
//      LOAD CONTENTS
        ArrayList<User> users = sqlite.getUsers();
        for(int nCtr = 0; nCtr < users.size(); nCtr++){
            tableModel.addRow(new Object[]{
                users.get(nCtr).getUsername(), 
                users.get(nCtr).getPassword(), 
                users.get(nCtr).getRole(), 
                users.get(nCtr).getLocked()});
        }
    }

    public void designer(JTextField component, String text){
        component.setSize(70, 600);
        component.setFont(new java.awt.Font("Tahoma", 0, 18));
        component.setBackground(new java.awt.Color(240, 240, 240));
        component.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        component.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), text, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12)));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        editRoleBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        lockBtn = new javax.swing.JButton();
        chgpassBtn = new javax.swing.JButton();

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Password", "Role", "Locked"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(24);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(160);
            table.getColumnModel().getColumn(1).setPreferredWidth(400);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        editRoleBtn.setBackground(new java.awt.Color(255, 255, 255));
        editRoleBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editRoleBtn.setText("EDIT ROLE");
        editRoleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRoleBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        lockBtn.setBackground(new java.awt.Color(255, 255, 255));
        lockBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lockBtn.setText("LOCK/UNLOCK");
        lockBtn.setToolTipText("");
        lockBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lockBtnActionPerformed(evt);
            }
        });

        chgpassBtn.setBackground(new java.awt.Color(255, 255, 255));
        chgpassBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chgpassBtn.setText("CHANGE PASS");
        chgpassBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chgpassBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editRoleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(lockBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(chgpassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chgpassBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editRoleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lockBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editRoleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRoleBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            String[] options = {"1-DISABLED","2-CLIENT","3-STAFF","4-MANAGER","5-ADMIN"};
            JComboBox optionList = new JComboBox(options);
            
            optionList.setSelectedIndex((int)tableModel.getValueAt(table.getSelectedRow(), 2) - 1);
            
            String result = (String) JOptionPane.showInputDialog(null, "USER: " + tableModel.getValueAt(table.getSelectedRow(), 0), 
                "EDIT USER ROLE", JOptionPane.QUESTION_MESSAGE, null, options, options[(int)tableModel.getValueAt(table.getSelectedRow(), 2) - 1]);
            
            if(result != null){
                System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                System.out.println(result.charAt(0));
                
                // Trim the option the user chose
                String NumericPart = result.split("-")[0].trim();
    
                // Parse the numeric part to an integer
                int role = Integer.parseInt(NumericPart);
                System.out.println(role);
                
                // call change role function from sqlite
                sqlite.changeRole( (String)tableModel.getValueAt(table.getSelectedRow(), 0), role);
                
                // Creating a Timestamp
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                System.out.println(dtf.format(now));

                // Authentication Logs
                sqlite.addLogs("RoleEdit", "Admin", "Role Edit Successful", dtf.format(now).toString());
                
                // refreshes table to show update value
                init();
            }
            
        }
    }//GEN-LAST:event_editRoleBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", "DELETE USER", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                
                // calls remove function on selected row of user
                sqlite.removeUser( (String)tableModel.getValueAt(table.getSelectedRow(), 0));
                
                // Creating a Timestamp
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String formattedDate = dtf.format(now);
                System.out.println(dtf.format(now));

                // Authentication Logs
                sqlite.addLogs("DeleteUser", "Admin", "Delete User Successfull", formattedDate);
                
                // refreshes table to show update value
                init();
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void lockBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lockBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            String state = "lock";
            if("1".equals(tableModel.getValueAt(table.getSelectedRow(), 3) + "")){
                state = "unlock";
            }
           
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to " + state + " " + tableModel.getValueAt(table.getSelectedRow(), 0) + "?", "DELETE USER", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                System.out.println(tableModel.getValueAt(table.getSelectedRow(), 0));
                int lock = (int) tableModel.getValueAt(table.getSelectedRow(), 3);
                System.out.println(lock);
                        
                // checks if the state is lock or unlock
                if ("lock".equals(state)) {
                    lock = 1;
                    sqlite.changeLock( (String)tableModel.getValueAt(table.getSelectedRow(), 0), lock);
                } else {
                    lock = 0;
                    sqlite.changeLock( (String)tableModel.getValueAt(table.getSelectedRow(), 0), lock);
                }
                
                // Creating a Timestamp
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                System.out.println(dtf.format(now));

                // Authentication Logs
                sqlite.addLogs("ChangeLock", "Admin", "Change Lock Sucessful", dtf.format(now).toString());
                
                // refreshes table to show update value
                init();
            }
        }
    }//GEN-LAST:event_lockBtnActionPerformed

    private void chgpassBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chgpassBtnActionPerformed
        if(table.getSelectedRow() >= 0){
            JTextField jpassword = new JPasswordField();
            JTextField jconfpass = new JPasswordField();
            designer(jpassword, "PASSWORD");
            designer(jconfpass, "CONFIRM PASSWORD");
            
            Object[] message = {
                "Enter New Password:", jpassword, jconfpass
            };

            int result = JOptionPane.showConfirmDialog(null, message, "CHANGE PASSWORD", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null);
            
            if (result == JOptionPane.OK_OPTION) {
                System.out.println(jpassword.getText());
                System.out.println(jconfpass.getText());
                
                String password = jpassword.getText();
                String confpass = jconfpass.getText();
                boolean isPasswordUnique = true;
                boolean isPasswordValid = true;
                
                // Checks if the password and confirm password is not empty upon clicking confirm
                if(!password.isEmpty() && !confpass.isEmpty()){        
                    ArrayList<User> users = sqlite.getUsers();
                    for (int nCtr = 0; nCtr < users.size(); nCtr++) {
                        // Check the Use is valid and unique from the Database
                        if (password.compareTo(users.get(nCtr).getPassword()) == 0) {
                            javax.swing.JOptionPane.showMessageDialog(null, "Password is already exists", "Password Message", JOptionPane.PLAIN_MESSAGE);
                            isPasswordUnique = false;
                            break;
                        }
                    }

                    // Checks for the password based from the criteria given
                    if(isPasswordUnique) {
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

                        if (!isValid) {
                            isPasswordValid = false;
                            javax.swing.JOptionPane.showMessageDialog(null, validationMessage, "Password Message", JOptionPane.PLAIN_MESSAGE);
                        }    
                    }
                    
                    // Checks if the password is valid
                    if(isPasswordValid = true) {
                        // checks if the passwords match
                        if (password.compareTo(confpass) == 0) {
                            // Creating a Timestamp
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();
                            System.out.println(dtf.format(now));
                            String formattedDate = dtf.format(now);

                            // Authentication Logs
                            sqlite.addLogs("ChangePass", "Admin", "Change Password Successful", formattedDate);

                            // Notifies the user that the password has been changed
                            javax.swing.JOptionPane.showMessageDialog(null, "Password has been changed!", "Password Message", JOptionPane.PLAIN_MESSAGE);

                            // Updates the password in the database
                            sqlite.changePassword( (String)tableModel.getValueAt(table.getSelectedRow(),0), password);
                        } else {
                            // Notifies the user that the password and confirm password does not match
                            javax.swing.JOptionPane.showMessageDialog(null, "Password and Confirm password does not match", "Password Message", JOptionPane.PLAIN_MESSAGE);
                        }
                    }
                }   
            }
            // refreshes table to show update value
                init();
        }
    }//GEN-LAST:event_chgpassBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chgpassBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editRoleBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lockBtn;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}