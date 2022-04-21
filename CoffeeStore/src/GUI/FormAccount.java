package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ThieuHoang
 */
public class FormAccount extends JFrame {
    //khai bao cac bien 
    private JTable accountTable;   //bang account
    private JLabel accountLabel, infoLabel, usernameLabel, passwordLabel, staffidLabel, permissionLabel;   //dung de hien thi cac chu nhu "ACCOUNT", "INFOR",...
    private JTextField searchTextField, usernameTextField, passwordTextField, staffidTextField, permissionTextField; // cac o de nhap "username", "password",...
    private JButton searchButton, saveButton, addButton, editButton, //cac nut chuc nang
            deleteButton, logoutButton, homeButton;
    DefaultTableModel model = new DefaultTableModel();
    
     // ham nay de viet giao dien 
    public void MainDisplay(){
        this.setTitle("Coffee Shop");
        accountTable = new JTable();
        accountLabel = new JLabel("ACCOUNT");
        infoLabel = new JLabel("INFO");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        staffidLabel = new JLabel("StaffID:");
        permissionLabel = new JLabel("Permission:");
        searchTextField = new JTextField();
        usernameTextField = new JTextField();
        passwordTextField = new JTextField();
        permissionTextField = new JTextField();
        staffidTextField = new JTextField();
        searchButton = new JButton();
        saveButton = new JButton();
        addButton = new JButton();
        editButton = new JButton();
        deleteButton = new JButton();
        logoutButton = new JButton();
        homeButton = new JButton();
        
        accountLabel.setBounds(615, 30,  130, 30); 
        accountLabel.setFont(new Font("Serif", Font.BOLD, 25));
        
        homeButton.setBounds(1230,20,50, 50);
        homeButton.setIcon(new ImageIcon("Resource\\home-icon.png"));
        homeButton.setBackground(new Color(149,231,231));
        
        saveButton.setBounds(1030, 560, 50, 50);
        saveButton.setIcon(new ImageIcon("Resource\\save-icon.png"));
        saveButton.setBackground(new Color(149,231,231));
        
        addButton.setBounds(960, 630, 50, 50);
        addButton.setIcon(new ImageIcon("Resource\\add-1-icon.png"));
        addButton.setBackground(new Color(149,231,231));
        
        editButton.setBounds(1030, 630, 50, 50);
        editButton.setIcon(new ImageIcon("Resource\\edit-icon.png"));
        editButton.setBackground(new Color(149,231,231));
        
        deleteButton.setBounds(1100, 630, 50, 50);
        deleteButton.setIcon(new ImageIcon("Resource\\trash-icon.png"));
        deleteButton.setBackground(new Color(149,231,231));
        
        logoutButton.setBounds(1100, 560, 50, 50);
        logoutButton.setIcon(new ImageIcon("Resource\\close-icon.png"));
        logoutButton.setBackground(new Color(149,231,231));
        
        searchButton.setBounds(675, 630, 50, 50);
        searchButton.setIcon(new ImageIcon("Resource\\search-icon.png"));
        searchButton.setBackground(new Color(149,231,231));
        
        accountTable.setBounds(110,95,615,500);
        accountTable.setModel(model);
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("StaffID");
        model.addColumn("Permission");
        
        infoLabel.setBounds(1010, 150, 120, 25);
        infoLabel.setFont(new Font("Serif", Font.BOLD, 22)); 
        
        usernameLabel.setBounds(840, 220, 120, 25);
        usernameLabel.setFont(new Font("Serif", Font.BOLD, 22));  
        
        passwordLabel.setBounds(840, 270, 120, 25);
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 22));  
        
        staffidLabel.setBounds(840, 320, 120, 25);
        staffidLabel.setFont(new Font("Serif", Font.BOLD, 22));
        
        permissionLabel.setBounds(840, 370, 150, 25);
        permissionLabel.setFont(new Font("Serif", Font.BOLD, 22));
        
        usernameTextField.setBounds(960, 220, 240, 25);
        passwordTextField.setBounds(960, 270, 240, 25);
        staffidTextField.setBounds(960, 320, 240, 25);
        permissionTextField.setBounds(960, 370, 240, 25);
        searchTextField.setBounds(110, 640, 545, 30);
        
        this.add(accountLabel);
        this.add(homeButton);
        this.add(saveButton);
        this.add(addButton);
        this.add(editButton);
        this.add(deleteButton);
//        this.add(logoutButton);
        this.add(searchButton);
        this.add(accountTable);
        this.add(infoLabel);
        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(usernameTextField);
        this.add(passwordTextField);
        this.add(searchTextField);
        this.add(staffidLabel);
        this.add(staffidTextField);
        this.add(permissionLabel);
        this.add(permissionTextField);
        this.setSize(1300,760); 
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(202, 135, 96)); //set mau cho JFrame bang bang mau RGB
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
     public FormAccount(){
        MainDisplay();
    }
    
    public static void main(String[] args) {
        new FormAccount();
    }
}
