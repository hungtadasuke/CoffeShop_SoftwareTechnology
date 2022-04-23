package GUI;

import java.awt.*;
import javax.swing.*;

public final class StatisticGUI extends JFrame{
    //attribute
    
    //constructor
    public StatisticGUI() {
        this.init();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    //setter and getter
    
    //method
    public void init() {
        this.setTitle("Statistic Form");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource\\statistics-icon.png"));
        this.setSize(new Dimension(1300, 760));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }
    
    //main
    public static void main(String[] args) {
        StatisticGUI statistic = new StatisticGUI();
    }
}
