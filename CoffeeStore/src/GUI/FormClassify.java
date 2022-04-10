package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ThieuHoang
 */
public class FormClassify extends JFrame {
    //khai bao cac bien 
    private JTable classifyTable;   //cai bang loai san pham
    private JLabel classifyLabel, infoLabel, idLabel, nameLabel;   //dung de hien thi cac chu nhu "CLASSIFY", "INFOR",...
    private JTextField searchTextField, idTextField, nameTextField; // cac o de nhap "Name", "id",...
    private JButton searchButton, saveButton, addButton, editButton, //cac nut chuc nang
            deleteButton, logoutButton, homeButton;
    DefaultTableModel model = new DefaultTableModel();
    //test label
    private JLabel testLabel;
    
    // ham nay de viet giao dien 
    public void MainDisplay(){
        this.setName("Coffee Shop");
        classifyTable = new JTable();
        classifyLabel = new JLabel("CLASSIFY");
        infoLabel = new JLabel("INFO");
        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        searchTextField = new JTextField();
        idTextField = new JTextField();
        nameTextField = new JTextField();
        searchButton = new JButton();
        saveButton = new JButton();
        addButton = new JButton();
        editButton = new JButton();
        deleteButton = new JButton();
        logoutButton = new JButton();
        homeButton = new JButton();
        
        classifyLabel.setBounds(615, 30,  130, 30); 
        classifyLabel.setFont(new Font("Serif", Font.BOLD, 25));
        
        homeButton.setBounds(1230,20,50, 50);
        homeButton.setIcon(new ImageIcon("Resource\\home-icon.png"));
        homeButton.setBackground(new Color(190,148,92));
        
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
        
        classifyTable.setBounds(110,95,615,500);
        classifyTable.setModel(model);
        model.addColumn("ID");
        model.addColumn("Name");
        
        infoLabel.setBounds(1020, 150, 120, 25);
        infoLabel.setFont(new Font("Serif", Font.BOLD, 22)); 
        
        idLabel.setBounds(850, 220, 120, 25);
        idLabel.setFont(new Font("Serif", Font.BOLD, 22));  
        
        nameLabel.setBounds(850, 270, 120, 25);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 22));   
        
        idTextField.setBounds(950, 220, 240, 25);
        nameTextField.setBounds(950, 270, 240, 25);
        
        searchTextField.setBounds(110, 640, 545, 30);
        this.add(classifyLabel);
        this.add(homeButton);
        this.add(saveButton);
        this.add(addButton);
        this.add(editButton);
        this.add(deleteButton);
        this.add(logoutButton);
        this.add(searchButton);
        this.add(classifyTable);
        this.add(infoLabel);
        this.add(idLabel);
        this.add(nameLabel);
        this.add(idTextField);
        this.add(nameTextField);
        this.add(searchTextField);
        this.setSize(1300,760); 
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(190,148,92)); //set mau cho JFrame bang bang mau RGB
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    public FormClassify(){
        MainDisplay();
    }
    
    public static void main(String[] args) {
        new FormClassify();
    }
    
}
