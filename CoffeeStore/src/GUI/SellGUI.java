package GUI;

import BUS.SellBUS;
import DTO.ClassifyDTO;
import DTO.ProductDTO;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.*;

public final class SellGUI extends JFrame{
    //attribute
    private JPanel pOrderInfo, pOderHeader, pOrderBody, pOrderFooter,
                   pMenus, pHeaderMenus, pBodyMenus, pScrossBar1, pClassifyMenu, pSrossBar2, pTableMenu, pCoffeeMenu, pTeaMenu, pFruitJuiceMenu, pYogurtMenu, pSmoothieMenu, pSearchMenu;
    
    private JScrollPane sOrderBody, sCoffeMenu, sTeaMenu, sFruitJuiceMenu, sYogurtMenu, sSmoothieMenu, sSearchMenu;
    
    private ArrayList<JButton> buttonList; 
    
    private JButton pNew, pHome, pSearch;
    
    private JLabel lOrder;
    
    private Image icon;
    
    private CardLayout card;
    
    private SellBUS sellBUS;
    
    private JTextField tfSearch;
    
    Color BROWN_COLOR = new Color(145, 91, 54);
    Color BACKGROUND_COLOR = new Color(234, 231, 214);
    Color HOVER_COLOR = new Color(149, 231, 231);
    Color BUTTON_COLOR = new Color(239, 228, 200);
    
    //constructor
    public SellGUI(String title) {
        this.setTitle(title);
        this.init();
        this.setVisible(true);
    }
    
    //setter and getter
    public JPanel getpOrderInfo() {
        return pOrderInfo;
    }

    public void setpOrderInfo(JPanel pOrderInfo) {
        this.pOrderInfo = pOrderInfo;
    }

    public JPanel getpOderHeader() {
        return pOderHeader;
    }

    public void setpOderHeader(JPanel pOderHeader) {
        this.pOderHeader = pOderHeader;
    }

    public JPanel getpOrderBody() {
        return pOrderBody;
    }

    public void setpOrderBody(JPanel pOrderBody) {
        this.pOrderBody = pOrderBody;
    }

    public JPanel getpOrderFooter() {
        return pOrderFooter;
    }

    public void setpOrderFooter(JPanel pOrderFooter) {
        this.pOrderFooter = pOrderFooter;
    }

    public JPanel getpMenus() {
        return pMenus;
    }

    public void setpMenus(JPanel pMenus) {
        this.pMenus = pMenus;
    }

    public JPanel getpHeaderMenus() {
        return pHeaderMenus;
    }

    public void setpHeaderMenus(JPanel pHeaderMenus) {
        this.pHeaderMenus = pHeaderMenus;
    }

    public JPanel getpBodyMenus() {
        return pBodyMenus;
    }

    public void setpBodyMenus(JPanel pBodyMenus) {
        this.pBodyMenus = pBodyMenus;
    }

    public JPanel getpScrossBar1() {
        return pScrossBar1;
    }

    public void setpScrossBar1(JPanel pScrossBar1) {
        this.pScrossBar1 = pScrossBar1;
    }

    public JPanel getpClassifyMenu() {
        return pClassifyMenu;
    }

    public void setpClassifyMenu(JPanel pClassifyMenu) {
        this.pClassifyMenu = pClassifyMenu;
    }

    public JPanel getpScrossBar2() {
        return pSrossBar2;
    }

    public void setpSrossBar2(JPanel pSrossBar2) {
        this.pSrossBar2 = pSrossBar2;
    }

    public JPanel getpTableMenu() {
        return pTableMenu;
    }

    public void setpTableMenu(JPanel pTableMenu) {
        this.pTableMenu = pTableMenu;
    }

    public JPanel getpCoffeeMenu() {
        return pCoffeeMenu;
    }

    public void setpCoffeeMenu(JPanel pCoffeeMenu) {
        this.pCoffeeMenu = pCoffeeMenu;
    }

    public JPanel getpTeaMenu() {
        return pTeaMenu;
    }

    public void setpTeaMenu(JPanel pTeaMenu) {
        this.pTeaMenu = pTeaMenu;
    }

    public JPanel getpFruitJuiceMenu() {
        return pFruitJuiceMenu;
    }

    public void setpFruitJuiceMenu(JPanel pFruitJuiceMenu) {
        this.pFruitJuiceMenu = pFruitJuiceMenu;
    }

    public JPanel getpYogurtMenu() {
        return pYogurtMenu;
    }

    public void setpYogurtMenu(JPanel pYogurtMenu) {
        this.pYogurtMenu = pYogurtMenu;
    }

    public JPanel getpSmoothieMenu() {
        return pSmoothieMenu;
    }

    public void setpSmoothieMenu(JPanel pSmoothieMenu) {
        this.pSmoothieMenu = pSmoothieMenu;
    }

    public JScrollPane getsOrderBody() {
        return sOrderBody;
    }

    public void setsOrderBody(JScrollPane sOrderBody) {
        this.sOrderBody = sOrderBody;
    }

    public JScrollPane getsCoffeMenu() {
        return sCoffeMenu;
    }

    public void setsCoffeMenu(JScrollPane sCoffeMenu) {
        this.sCoffeMenu = sCoffeMenu;
    }

    public JScrollPane getsTeaMenu() {
        return sTeaMenu;
    }

    public void setsTeaMenu(JScrollPane sTeaMenu) {
        this.sTeaMenu = sTeaMenu;
    }

    public JScrollPane getsFruitJuiceMenu() {
        return sFruitJuiceMenu;
    }

    public void setsFruitJuiceMenu(JScrollPane sFruitJuiceMenu) {
        this.sFruitJuiceMenu = sFruitJuiceMenu;
    }

    public JScrollPane getsYogurtMenu() {
        return sYogurtMenu;
    }

    public void setsYogurtMenu(JScrollPane sYogurtMenu) {
        this.sYogurtMenu = sYogurtMenu;
    }

    public JScrollPane getsSmoothieMenu() {
        return sSmoothieMenu;
    }

    public void setsSmoothieMenu(JScrollPane sSmoothieMenu) {
        this.sSmoothieMenu = sSmoothieMenu;
    }

    public ArrayList<JButton> getButtonList() {
        return buttonList;
    }

    public void setButtonList(ArrayList<JButton> buttonList) {
        this.buttonList = buttonList;
    }

    public JButton getpNew() {
        return pNew;
    }

    public void setpNew(JButton pNew) {
        this.pNew = pNew;
    }

    public JButton getpHome() {
        return pHome;
    }

    public void setpHome(JButton pHome) {
        this.pHome = pHome;
    }

    public JLabel getlOrder() {
        return lOrder;
    }

    public void setlOrder(JLabel lOrder) {
        this.lOrder = lOrder;
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public void setCard(CardLayout card) {
        this.card = card;
    }

    public CardLayout getCard() {
        return card;
    }

    public SellBUS getSellBUS() {
        return sellBUS;
    }

    public void setSellBUS(SellBUS sellBUS) {
        this.sellBUS = sellBUS;
    }

    public JPanel getpSearchMenu() {
        return pSearchMenu;
    }

    public void setpSearchMenu(JPanel pSearchMenu) {
        this.pSearchMenu = pSearchMenu;
    }

    public JScrollPane getsSearchMenu() {
        return sSearchMenu;
    }

    public void setsSearchMenu(JScrollPane sSearchMenu) {
        this.sSearchMenu = sSearchMenu;
    }

    public JButton getpSearch() {
        return pSearch;
    }

    public void setpSearch(JButton pSearch) {
        this.pSearch = pSearch;
    }

    public JTextField getTfSearch() {
        return tfSearch;
    }

    public void setTfSearch(JTextField tfSearch) {
        this.tfSearch = tfSearch;
    }
    
    //method
    private void init() {
        //Tao cua so ung dung
        this.createJFrame();
        
        //Tao khung chua thong tin don hang ben trai (pOrderInfo)
        this.createpOrderInfo();
        
        //Tao khung chua cac menu ben phai (pMenus)
        this.createpMenus();
        
        //Them cac thanh phan vao JFrame
        this.add(this.getpOrderInfo(), BorderLayout.WEST);
        this.add(this.getpMenus(), BorderLayout.CENTER);   
    }
    
    //Tao cua so ung dung (JFrame Container)
    private void createJFrame() {
        this.setTitle("Sell Form");
        icon = Toolkit.getDefaultToolkit().createImage("Resource\\iconJFrame.png");
        this.setIconImage(icon);
        this.setSize(1300, 760);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        //Su dung thay cho this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
        });
        this.setLayout(new BorderLayout());
    }
    
    //Tao khung chua thong tin don hang ben trai
    private void createpOrderInfo() {
        //Tao khung chua chung
        this.setpOrderInfo(new JPanel());
        this.getpOrderInfo().setPreferredSize(new Dimension(420, JFrame.MAXIMIZED_VERT));
        this.getpOrderInfo().setLayout(new BorderLayout());
        
        //Header
        this.setpOderHeader(new JPanel());
        this.getpOderHeader().setPreferredSize(new Dimension(400, 80));
        this.getpOderHeader().setBackground(new Color(229, 167, 123));
        this.getpOderHeader().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        //Body
        this.setpOrderBody(new JPanel());
        this.getpOrderBody().setPreferredSize(new Dimension(400, 5000));
        this.getpOrderBody().setBackground(BACKGROUND_COLOR);
        this.getpOrderBody().setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setsOrderBody(new JScrollPane(this.getpOrderBody(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
       
        //Footer
        this.setpOrderFooter(new JPanel());
        this.getpOrderFooter().setPreferredSize(new Dimension(400, 220));
        this.getpOrderFooter().setBackground(BROWN_COLOR);
        this.getpOrderFooter().setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        //Them cac thanh phan vao panel pOderInfo
        this.getpOrderInfo().add(this.getpOderHeader(), BorderLayout.NORTH);
        this.getpOrderInfo().add(this.getsOrderBody(), BorderLayout.CENTER);
        this.getpOrderInfo().add(this.getpOrderFooter(), BorderLayout.SOUTH);
    }
    
    //Tao khung chua cac menu ben phai
    private void createpMenus() {
        //Tao khung chua chung
        this.setpMenus(new JPanel());
        this.getpMenus().setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));
        this.getpMenus().setLayout(new BorderLayout());

        //North
        this.setpHeaderMenus(new JPanel());
        this.getpHeaderMenus().setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, 300));
        this.getpHeaderMenus().setLayout(new BorderLayout());
        
        //pSrossBar1
        this.setpScrossBar1(new JPanel());
        this.getpScrossBar1().setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, 40));
        this.getpScrossBar1().setBackground(BROWN_COLOR);
        this.getpScrossBar1().setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.BLACK));
        this.getpScrossBar1().setLayout(new BorderLayout());
        
        //Set button "New"
        this.setpNew(new JButton("New"));
        this.getpNew().setActionCommand("New");
        this.getpNew().setPreferredSize(new Dimension(70, 20));
        this.getpNew().setBackground(BROWN_COLOR);
        this.getpNew().setForeground(Color.WHITE);
        this.getpNew().setFont(new Font("Arial", Font.BOLD, 22));
        this.getpNew().setBorder(null);
        //delete khung bao jbutton moi khi nhap vao (mac dinh)
        this.getpNew().setFocusPainted(false);
        //Di chuot vao doi tuong va doi thanh hinh ban tay
        this.getpNew().setCursor(new Cursor(HAND_CURSOR));
        //Su ly su kien chuot cho "New" JButton
        this.getpNew().addMouseListener(new MouseAdapter() {
           @Override
           public void mouseEntered(MouseEvent e) {
               getpNew().setBackground(HOVER_COLOR);
               getpNew().setForeground(Color.BLACK);
               getpNew().setBorder(BorderFactory.createRaisedBevelBorder());
           }
           
           @Override
           public void mouseExited(MouseEvent e) {
               getpNew().setBackground(BROWN_COLOR);
               getpNew().setForeground(Color.WHITE);
               getpNew().setBorder(null);
           }
        });
        
        //set button has home icon
        this.setpHome(new JButton(new ImageIcon("Resource\\iconHome.png")));
        this.getpHome().setActionCommand("Home");
        this.getpHome().setPreferredSize(new Dimension(50, 40));
        this.getpHome().setBackground(BROWN_COLOR);
        this.getpHome().setBorder(null);
        this.getpHome().setContentAreaFilled(false);
        this.getpHome().setCursor(new Cursor(HAND_CURSOR));
        this.getpHome().setFocusPainted(false);
        //su ly su kien chuot cho nut icon "Home" JButton
        this.getpHome().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                getpHome().setIcon(new ImageIcon("Resource\\iconHomeHover.png"));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                getpHome().setIcon(new ImageIcon("Resource\\iconHome.png"));
            }
        });
        
        
        //add button "New" and button has home icon to pScrossBar1
        this.getpScrossBar1().add(this.getpHome(), BorderLayout.WEST);
        this.getpScrossBar1().add(this.getpNew(), BorderLayout.EAST);
        
        
        //pClassifyMenu
        this.setpClassifyMenu(new JPanel());
        this.getpClassifyMenu().setBackground(BACKGROUND_COLOR);
        this.getpClassifyMenu().setLayout(new GridLayout(2, 6, 10, 10));
        this.getpClassifyMenu().setBorder(new EmptyBorder(10, 10, 10, 10));
        
        //hien thi menu classify
        this.setButtonList(new ArrayList<>());
        this.setSellBUS(new SellBUS());
        this.createClassifyButtonList();
        this.addComponentsInListToJPanel(this.getButtonList(), this.getpClassifyMenu());

        //pScrossBar2
        this.setpSrossBar2(new JPanel());
        this.getpScrossBar2().setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, 40));
        this.getpScrossBar2().setBackground(BROWN_COLOR);
        Border matteBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
        Border emptyBorder = BorderFactory.createEmptyBorder(0, 180, 0, 0);
        this.getpScrossBar2().setBorder(BorderFactory.createCompoundBorder(matteBorder, emptyBorder));
        this.getpScrossBar2().setLayout(new BorderLayout());
        
        //set label "Order"
        this.setlOrder(new JLabel("Order"));
        this.getlOrder().setFont(new Font("Arial", Font.ITALIC, 24));
        this.getlOrder().setForeground(Color.BLACK);
        this.getlOrder().setPreferredSize(new Dimension(200, 40));
        
        //set jtextfield search
        this.setTfSearch(new JTextField("Search product here"));
        this.getTfSearch().setFont(new Font("Arial", Font.ITALIC, 16));
        this.getTfSearch().setBackground(new Color(235, 238, 236));
        this.getTfSearch().setBorder(BorderFactory.createRaisedBevelBorder());
        
        //set button search
        this.setpSearch(new JButton("Search"));
        this.getpSearch().setFocusPainted(false);
        this.getpSearch().setFont(new Font("Arial", Font.BOLD, 20));
        this.getpSearch().setBackground(Color.LIGHT_GRAY);
        this.getpSearch().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getpSearchMenu().removeAll();
                createProductButtonSearchList(getTfSearch().getText());
                addComponentsInListToJPanel(getButtonList(), getpSearchMenu());
                getCard().show(getpBodyMenus(), "Search");
            }
            
        });
        
        //add label "Order" to pScrossBar2
        this.getpScrossBar2().add(this.getlOrder(), BorderLayout.WEST);
        this.getpScrossBar2().add(this.getTfSearch(), BorderLayout.CENTER);
        this.getpScrossBar2().add(this.getpSearch(), BorderLayout.EAST);
        
        
        //Center
        this.setpBodyMenus(new JPanel());
        this.setCard(new CardLayout());
        this.getpBodyMenus().setLayout(this.getCard());
        
        
        this.setpTableMenu(this.createJPanel());
        this.getpTableMenu().setBackground(Color.LIGHT_GRAY);
        this.getpTableMenu().setLayout(new GridLayout(3, 4, 5, 5));
        
        this.setpCoffeeMenu(this.createJPanel());
        this.createProductButtonList("CL001");
        this.addComponentsInListToJPanel(this.getButtonList(), this.getpCoffeeMenu());
        
        this.setpTeaMenu(this.createJPanel());
        this.createProductButtonList("CL002");
        this.addComponentsInListToJPanel(this.getButtonList(), this.getpTeaMenu());
        
        this.setpFruitJuiceMenu(this.createJPanel());
        this.createProductButtonList("CL003");
        this.addComponentsInListToJPanel(this.getButtonList(), this.getpFruitJuiceMenu());
        
        this.setpYogurtMenu(this.createJPanel());
        this.createProductButtonList("CL004");
        this.addComponentsInListToJPanel(this.getButtonList(), this.getpYogurtMenu());
        
        this.setpSmoothieMenu(this.createJPanel());
        this.createProductButtonList("CL005");
        this.addComponentsInListToJPanel(this.getButtonList(), this.getpSmoothieMenu());
        
        this.setpSearchMenu(this.createJPanel());
        
        this.setsCoffeMenu(new JScrollPane(this.getpCoffeeMenu(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        this.setsTeaMenu(new JScrollPane(this.getpTeaMenu(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        this.setsFruitJuiceMenu(new JScrollPane(this.getpFruitJuiceMenu(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        this.setsYogurtMenu(new JScrollPane(this.getpYogurtMenu(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        this.setsSmoothieMenu(new JScrollPane(this.getpSmoothieMenu(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        this.setsSearchMenu(new JScrollPane(this.getpSearchMenu(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        
        this.getpBodyMenus().add(this.getpTableMenu(), "Table");
        this.getpBodyMenus().add(this.getsCoffeMenu(), "Coffee");
        this.getpBodyMenus().add(this.getsTeaMenu(), "Tea");
        this.getpBodyMenus().add(this.getsFruitJuiceMenu(), "Fruit Juice");
        this.getpBodyMenus().add(this.getsYogurtMenu(), "Yogurt");
        this.getpBodyMenus().add(this.getsSmoothieMenu(), "Smoothie");
        this.getpBodyMenus().add(this.getsSearchMenu(), "Search");
        
        //Them cac thanh phan vao panel pMenus
        this.getpHeaderMenus().add(this.getpScrossBar1(), BorderLayout.NORTH);
        this.getpHeaderMenus().add(this.getpClassifyMenu(), BorderLayout.CENTER);
        this.getpHeaderMenus().add(this.getpScrossBar2(), BorderLayout.SOUTH);
        
                
        this.getpMenus().add(this.getpHeaderMenus(), BorderLayout.NORTH);
        this.getpMenus().add(this.getpBodyMenus(), BorderLayout.CENTER);
        
        //End: pMenus
    }
    
    public JButton createChooseDrinkJButton(String text, String actioncommand) {
        JButton o = new JButton();
        o.setText(text);
        o.setActionCommand(actioncommand);
        o.setBackground(BUTTON_COLOR);
        o.setFocusPainted(false);
        o.setBorder(null);
        o.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 17));
        o.setPreferredSize(new Dimension(158, 90));
        o.setBorder(BorderFactory.createRaisedBevelBorder());
        o.setCursor(new Cursor(HAND_CURSOR) {
        });
        o.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                o.setBackground(HOVER_COLOR);
                o.setFont(new Font("Arial", Font.BOLD, 19));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                o.setBackground(BUTTON_COLOR);
                o.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 17));
            }
        });
        o.addActionListener((ActionEvent e) -> {
            if(e.getActionCommand().equalsIgnoreCase("Table")) {
                getCard().show(getpBodyMenus(), "Table");
            } else if (e.getActionCommand().equalsIgnoreCase("Coffee")) {
                getCard().show(getpBodyMenus(), "Coffee");
            } else if (e.getActionCommand().equalsIgnoreCase("Tea")) {
                getCard().show(getpBodyMenus(), "Tea");
            } else if (e.getActionCommand().equalsIgnoreCase("Fruit Juice")) {
                getCard().show(getpBodyMenus(), "Fruit Juice");
            } else if (e.getActionCommand().equalsIgnoreCase("Yogurt")) {
                getCard().show(getpBodyMenus(), "Yogurt");
            } else if (e.getActionCommand().equalsIgnoreCase("Smoothie")) {
                getCard().show(getpBodyMenus(), "Smoothie");
            }
        });
        return o;
    }
    
    public JButton createPaymentJButton() {
        JButton o = new JButton("Payment");
        o.setBackground(new Color(18, 247, 51));
        o.setBorder(BorderFactory.createRaisedBevelBorder());
        o.setFocusPainted(false);
        o.setCursor(new Cursor(HAND_CURSOR) {
        });
        o.setForeground(Color.WHITE);
        o.setFont(new Font("Arial", Font.BOLD, 17));
        o.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                o.setFont(new Font("Arial", Font.BOLD, 21));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                o.setFont(new Font("Arial", Font.BOLD, 17));
            }
        });
        return o;
    }
    
    public void addComponentsInListToJPanel(ArrayList<JButton> list, JPanel jpanel) {
        for(JButton o: list) {
            jpanel.add(o);
        }
    }
    
    public void createClassifyButtonList() {
        this.getButtonList().add(this.createChooseDrinkJButton("Table", "Table"));
        this.getSellBUS().getClassifyBUS().getClassifyListFromDAO();
        for(ClassifyDTO classify: this.getSellBUS().getClassifyBUS().getClassifyList()) {
            this.getButtonList().add(this.createChooseDrinkJButton(classify.getClassifyName(), classify.getClassifyName()));
        }
        if(this.getButtonList().size() != 11) {
            for(int i = this.getButtonList().size(); i < 11; i++) {
                this.getButtonList().add(this.createChooseDrinkJButton("", ""));
            }
        }
        this.getButtonList().add(this.createPaymentJButton());
    }
    
    public void createProductButtonList(String classifyId) {
        this.getButtonList().clear();
        this.getSellBUS().getProductBUS().getProductListFromClassifyId(classifyId);
        for(ProductDTO product: this.getSellBUS().getProductBUS().getProductList()) {
            if(product.isProductBusiness()) {      
                this.getButtonList().add(this.createChooseDrinkJButton(product.getProductNickName(), product.getProductId()));
            }
        }
    }
    
    public void createProductButtonSearchList(String search) {
        this.getButtonList().clear();
        this.getSellBUS().getProductBUS().getProductListFromProductDAO();
        for(ProductDTO product: this.getSellBUS().getProductBUS().getProductList()) {
            if(product.isProductBusiness() && ((product.getProductName().contains(search)))) {
                this.getButtonList().add(this.createChooseDrinkJButton(product.getProductNickName(), product.getProductId()));
            }
        }
    }
    
    private JPanel createJPanel() {
        JPanel o = new JPanel();
        o.setBackground(BACKGROUND_COLOR);
        o.setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, 1000));
        o.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        return o;
    }
    
    public void addJPanelTopBodyMenus(JPanel jpanel, String name) {
        this.getpBodyMenus().add(jpanel, name);
    }
        
    //main
    public static void main (String[] args) {
        SellGUI o = new SellGUI("Sell Form");
    }
    
}
