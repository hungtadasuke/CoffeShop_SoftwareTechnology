/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mycoffeeteam;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.border.TitledBorder;

/**
 *
 * @author DELL
 */
class Login2 extends JFrame{
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1;
    Login2(){
        setLayout(null);
        setSize(400,400);
        Font f=new Font("Arial",Font.BOLD,24);
        setTitle("Coffee Shop");
        l1=new JLabel("");
        l1.setFont(f);
        l2=new JLabel("UserName:");
        l2.setIcon (new ImageIcon ("C:\\Users\\DELL\\Pictures\\picjava\\Users-Guest-icon (1).png"));
        l2.setForeground(new Color(59,235,226));
        t1=new JTextField();
        l3=new JLabel("Password:");
        l3.setIcon (new ImageIcon ("C:\\Users\\DELL\\Pictures\\picjava\\Very-Basic-Lock-Filled-icon.png"));
        l3.setForeground(new Color(59,235,226));
        t2=new JPasswordField();
        b1=new JButton("Sign");
        b1.setBackground(new Color(59,235,226));
        b1.setForeground(Color.black);
        l1.setBounds(200,40,200,40);
        l2.setBounds(210,100,100,20);//UserName Label
	    t1.setBounds(190,120,200,30);//TextField 
     	l3.setBounds(210,170,100,20);
	    t2.setBounds(190,190,200,30);
    	b1.setBounds(240,240,100,30);
        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\DELL\\Pictures\\picjava\\nenJFrame.png")))));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        JLabel pn1 = new JLabel("");
        pn1.setBounds(0,0,100,100);
        add(pn1);
        //add(Label_Icon());
        add(l1);
        add(l2);
        add(t1);
        add(l3);
        add(t2);
        add(b1);
        pack();
     
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                System.out.println(t1.getText());
                System.out.println(t2.getText());
            }
        });
    }
public static void main(String[] args){
    Login2 login=new Login2();
}
}
