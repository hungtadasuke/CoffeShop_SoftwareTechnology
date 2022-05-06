package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ThieuHoang
 */
public class FormBill extends JFrame {
    //khai bao cac bien 
    private JTable billTable;   //bang hien thi bill
    private JLabel billLabel, searchLabel, idLabel, dateLabel;   //dung de hien thi cac chu nhu "BILL", "Sreach",...
    private JTextField idTextField, dateTextField; // cac o de nhap "id",...
    private JButton noteButton, searchButton, saveButton, deleteButton, backButton, homeButton;
    DefaultTableModel model = new DefaultTableModel();
    
    // ham nay de viet giao dien 
    public void MainDisplay(){
        this.setTitle("Coffee Shop");
        billTable = new JTable();
        billLabel = new JLabel("BILL");
        searchLabel = new JLabel("SEARCH");
        idLabel = new JLabel("ID:");
        dateLabel = new JLabel("Date:");
        idTextField = new JTextField();
        dateTextField = new JTextField();
        searchButton = new JButton();
        saveButton = new JButton();
        noteButton = new JButton();
        deleteButton = new JButton();
        backButton = new JButton();
        homeButton = new JButton();
        
        billLabel.setBounds(615, 30,  130, 30);
        billLabel.setFont(new Font("Serif", Font.BOLD, 25));
        
        homeButton.setBounds(1230,20,50, 50);
        homeButton.setIcon(new ImageIcon("Resource\\home-icon.png"));
        homeButton.setBackground(new Color(149,231,231));
        
        saveButton.setBounds(970, 550, 50, 50);
        saveButton.setIcon(new ImageIcon("Resource\\save-icon.png"));
        saveButton.setBackground(new Color(149,231,231));
        
        deleteButton.setBounds(1040, 550, 50, 50);
        deleteButton.setIcon(new ImageIcon("Resource\\trash-icon.png"));
        deleteButton.setBackground(new Color(149,231,231));  
        
        backButton.setBounds(1110, 550, 50, 50);
        backButton.setIcon(new ImageIcon("Resource\\Go-back-icon.png"));
        backButton.setBackground(new Color(149,231,231));
        
        searchButton.setBounds(1080, 270, 50, 50);
        searchButton.setIcon(new ImageIcon("Resource\\search-icon.png"));
        searchButton.setBackground(new Color(149,231,231));
        
        noteButton.setBounds(1010, 270, 50, 50);
        noteButton.setIcon(new ImageIcon("Resource\\information-icon.png"));
        noteButton.setBackground(new Color(149,231,231));
        
        
        billTable.setBounds(110,95,620,550);
        billTable.setModel(model);
        model.addColumn("ID");
        model.addColumn("Date");
        model.addColumn("Total");
        model.addColumn("Type");
        model.addColumn("Table");
        
        searchLabel.setBounds(1020, 120, 120, 25);
        searchLabel.setFont(new Font("Serif", Font.BOLD, 22)); 
        
        idLabel.setBounds(850, 170, 120, 25);
        idLabel.setFont(new Font("Serif", Font.BOLD, 22));  
        
        dateLabel.setBounds(850, 220, 120, 25);
        dateLabel.setFont(new Font("Serif", Font.BOLD, 22)); 
        
        
        idTextField.setBounds(950, 170, 240, 25);
        dateTextField.setBounds(950, 220, 240, 25);
        
        this.add(billLabel);
        this.add(searchLabel);
        this.add(idLabel);
        this.add(dateLabel);
        this.add(homeButton);
        this.add(noteButton);
//        this.add(logoutButton);
        this.add(searchButton);
        this.add(saveButton);
        this.add(deleteButton);
        this.add(backButton);
        this.add(billTable);
        this.add(idTextField);
        this.add(dateTextField);
        this.setSize(1300,760);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(202, 135, 96)); //set mau cho JFrame bang bang mau RGB
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    public FormBill(){
        MainDisplay();
    }
    
}
