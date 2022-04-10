package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ThieuHoang
 */
public class FormStaff extends JFrame {
    //khai bao cac bien 
    private JTable staffTable;   //cai bang loai san pham
    private JLabel staffLabel, infoLabel, idLabel, nameLabel, birthdayLabel, addressLabel,
            phoneLabel, positionLabel;   //dung de hien thi cac chu nhu "STAFF", "INFOR",...
    private JTextField searchTextField, idTextField, nameTextField, birthdayTextField,
            addressTextField, phoneTextField, positionTextField; // cac o de nhap "Name", "id",...
    private JButton searchButton, saveButton, addButton, editButton, //cac nut chuc nang
            deleteButton, logoutButton, homeButton;
    DefaultTableModel model = new DefaultTableModel();
    
    // ham nay de viet giao dien 
    public void MainDisplay(){
        this.setName("Coffee Shop");
        staffTable = new JTable();
        staffLabel = new JLabel("STAFF");
        infoLabel = new JLabel("INFO");
        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        birthdayLabel = new JLabel("Birthday:");
        addressLabel = new JLabel("Address:");
        phoneLabel = new JLabel("Phone:");
        positionLabel = new JLabel("Position:");
        searchTextField = new JTextField();
        idTextField = new JTextField();
        nameTextField = new JTextField();
        birthdayTextField = new JTextField();
        addressTextField = new JTextField();
        phoneTextField = new JTextField();
        positionTextField = new JTextField();
        searchButton = new JButton();
        saveButton = new JButton();
        addButton = new JButton();
        editButton = new JButton();
        deleteButton = new JButton();
        logoutButton = new JButton();
        homeButton = new JButton();
        
        staffLabel.setBounds(615, 30,  130, 30);
        staffLabel.setFont(new Font("Serif", Font.BOLD, 25));
        
        homeButton.setBounds(1230,20,50, 50);
        homeButton.setIcon(new ImageIcon("Resource\\home-icon.png"));
        homeButton.setBackground(new Color(190,148,92));
        homeButton.setBorder(null);
        
        saveButton.setBounds(950, 470, 50, 140);
        saveButton.setIcon(new ImageIcon("Resource\\save-icon.png"));
        saveButton.setBackground(new Color(149,231,231));
        
        addButton.setBounds(1030, 470, 50, 50);
        addButton.setIcon(new ImageIcon("Resource\\add-1-icon.png"));
        addButton.setBackground(new Color(149,231,231));
        
        editButton.setBounds(1100, 470, 50, 50);
        editButton.setIcon(new ImageIcon("Resource\\edit-icon.png"));
        editButton.setBackground(new Color(149,231,231));
        
        deleteButton.setBounds(1030, 560, 50, 50);
        deleteButton.setIcon(new ImageIcon("Resource\\trash-icon.png"));
        deleteButton.setBackground(new Color(149,231,231));  
        
        logoutButton.setBounds(1100, 560, 50, 50);
        logoutButton.setIcon(new ImageIcon("Resource\\close-icon.png"));
        logoutButton.setBackground(new Color(149,231,231));
        
        searchButton.setBounds(675, 630, 50, 50);
        searchButton.setIcon(new ImageIcon("Resource\\search-icon.png"));
        searchButton.setBackground(new Color(149,231,231));
        
        staffTable.setBounds(110,95,615,500);
        staffTable.setModel(model);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Birthday");
        model.addColumn("Address");
        model.addColumn("Phone");
        model.addColumn("Position");
        
        infoLabel.setBounds(1020, 120, 120, 25);
        infoLabel.setFont(new Font("Serif", Font.BOLD, 22)); 
        
        idLabel.setBounds(850, 170, 120, 25);
        idLabel.setFont(new Font("Serif", Font.BOLD, 22));  
        
        nameLabel.setBounds(850, 220, 120, 25);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 22)); 
        
        birthdayLabel.setBounds(850, 270, 120, 25);
        birthdayLabel.setFont(new Font("Serif", Font.BOLD, 22));

        addressLabel.setBounds(850, 320, 120, 25);
        addressLabel.setFont(new Font("Serif", Font.BOLD, 22));

        phoneLabel.setBounds(850, 370, 120, 25);
        phoneLabel.setFont(new Font("Serif", Font.BOLD, 22));

        positionLabel.setBounds(850, 420, 120, 25);
        positionLabel.setFont(new Font("Serif", Font.BOLD, 22));
        
        idTextField.setBounds(950, 170, 240, 25);
        nameTextField.setBounds(950, 220, 240, 25);
        birthdayTextField.setBounds(950, 270, 240, 25);
        addressTextField.setBounds(950, 320, 240, 25);
        phoneTextField.setBounds(950, 370, 240, 25);
        positionTextField.setBounds(950, 420, 240, 25);
        
        searchTextField.setBounds(110, 640, 545, 30);
        this.add(staffLabel);
        this.add(homeButton);
        this.add(saveButton);
        this.add(addButton);
        this.add(editButton);
        this.add(deleteButton);
        this.add(logoutButton);
        this.add(searchButton);
        this.add(staffTable);
        this.add(infoLabel);
        this.add(idLabel);
        this.add(nameLabel);
        this.add(idTextField);
        this.add(nameTextField);
        this.add(searchTextField);
        this.add(birthdayLabel);
        this.add(birthdayTextField);
        this.add(addressLabel);
        this.add(addressTextField);
        this.add(phoneLabel);
        this.add(phoneTextField);
        this.add(positionLabel);
        this.add(positionTextField);
        this.setSize(1300,760);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(190,148,92)); //set mau cho JFrame bang bang mau RGB
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    public FormStaff(){
        MainDisplay();
    }
    
    public static void main(String[] args) {
        new FormStaff();
    }
    
}
