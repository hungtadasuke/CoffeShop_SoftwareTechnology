package GUI;

import BUS.SellBUS;
import DTO.ClassifyDTO;
import DTO.ProductDTO;
import DTO.TableDTO;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.border.*;

public final class SellGUI extends JFrame{
    //attribute
    private JPanel pOrderInfo, pOderHeader, pOrderBody, pOrderFooter,
                   pMenus, pHeaderMenus, pBodyMenus, pScrossBar1, pWestSrcossBar1, pClassifyMenu, pSrossBar2, pTable, pItemMenu, pTemp;
    
    private JScrollPane sOrderBody, sItemMenu, sTemp;
    
    private ArrayList<JButton> buttonList;
    
    private ArrayList<JPanel> panelList;
    
    private JButton bNew, bHome, bReset, bSearch;
    
    private JLabel lOrder;
    
    private CardLayout card;
    
    private JTextField tfSearch;
    
    private SellBUS sellBUS;
    
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

    public JScrollPane getsOrderBody() {
        return sOrderBody;
    }

    public void setsOrderBody(JScrollPane sOrderBody) {
        this.sOrderBody = sOrderBody;
    }

    public ArrayList<JButton> getButtonList() {
        return buttonList;
    }

    public void setButtonList(ArrayList<JButton> buttonList) {
        this.buttonList = buttonList;
    }

    public JButton getbNew() {
        return bNew;
    }

    public void setbNew(JButton bNew) {
        this.bNew = bNew;
    }

    public JButton getbHome() {
        return bHome;
    }

    public void setbHome(JButton bHome) {
        this.bHome = bHome;
    }

    public JLabel getlOrder() {
        return lOrder;
    }

    public void setlOrder(JLabel lOrder) {
        this.lOrder = lOrder;
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

    public JButton getbSearch() {
        return bSearch;
    }

    public void setbSearch(JButton bSearch) {
        this.bSearch = bSearch;
    }

    public JTextField getTfSearch() {
        return tfSearch;
    }

    public void setTfSearch(JTextField tfSearch) {
        this.tfSearch = tfSearch;
    }

    public JPanel getpTemp() {
        return pTemp;
    }

    public void setpTemp(JPanel pTemp) {
        this.pTemp = pTemp;
    }
    
    public JScrollPane getsTemp() {
        return sTemp;
    }

    public void setsTemp(JScrollPane sTemp) {
        this.sTemp = sTemp;
    }

    public JPanel getpWestSrcossBar1() {
        return pWestSrcossBar1;
    }

    public void setpWestSrcossBar1(JPanel pWestSrcossBar1) {
        this.pWestSrcossBar1 = pWestSrcossBar1;
    }

    public JButton getbReset() {
        return bReset;
    }

    public void setbReset(JButton bReset) {
        this.bReset = bReset;
    }

    public JPanel getpTable() {
        return pTable;
    }

    public void setpTable(JPanel pTable) {
        this.pTable = pTable;
    }

    public JScrollPane getsItemMenu() {
        return sItemMenu;
    }

    public void setsItemMenu(JScrollPane sItemMenu) {
        this.sItemMenu = sItemMenu;
    }

    public JPanel getpItemMenu() {
        return pItemMenu;
    }

    public void setpItemMenu(JPanel pItemMenu) {
        this.pItemMenu = pItemMenu;
    }

    public ArrayList<JPanel> getPanelList() {
        return panelList;
    }

    public void setPanelList(ArrayList<JPanel> panelList) {
        this.panelList = panelList;
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
        this.setIconImage(Toolkit.getDefaultToolkit().createImage("Resource\\iconJFrame.png"));
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
        this.getpOderHeader().setPreferredSize(new Dimension(420, 80));
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

        //Khung chua chung cho thanh phan phia North
        this.setpHeaderMenus(new JPanel());
        this.getpHeaderMenus().setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, 300));
        this.getpHeaderMenus().setLayout(new BorderLayout());
        
        //pSrossBar1
        this.setpScrossBar1(new JPanel());
        this.getpScrossBar1().setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, 40));
        this.getpScrossBar1().setBackground(BROWN_COLOR);
        this.getpScrossBar1().setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.BLACK));
        this.getpScrossBar1().setLayout(new BorderLayout());
        
        //set pWestScrossBar1
        this.setpWestSrcossBar1(new JPanel());
        this.getpWestSrcossBar1().setPreferredSize(new Dimension(100, 40));
        this.getpWestSrcossBar1().setLayout(new BorderLayout());
        this.getpWestSrcossBar1().setBorder(new EmptyBorder(0, 5, 0, 0));
        this.getpWestSrcossBar1().setBackground(BROWN_COLOR);
        
        //Set button "New"
        this.setbNew(new JButton("New"));
        this.getbNew().setActionCommand("New");
        this.getbNew().setPreferredSize(new Dimension(70, 20));
        this.getbNew().setBackground(BROWN_COLOR);
        this.getbNew().setForeground(Color.WHITE);
        this.getbNew().setFont(new Font("Arial", Font.BOLD, 22));
        this.getbNew().setBorder(null);
        //delete khung bao jbutton moi khi nhap vao (mac dinh)
        this.getbNew().setFocusPainted(false);
        //Di chuot vao doi tuong va doi thanh hinh ban tay
        this.getbNew().setCursor(new Cursor(HAND_CURSOR));
        //Su ly su kien chuot cho "New" JButton
        this.getbNew().addMouseListener(new MouseAdapter() {
           @Override
           public void mouseEntered(MouseEvent e) {
               getbNew().setBackground(HOVER_COLOR);
               getbNew().setForeground(Color.BLACK);
               getbNew().setBorder(BorderFactory.createRaisedBevelBorder());
           }
           
           @Override
           public void mouseExited(MouseEvent e) {
               getbNew().setBackground(BROWN_COLOR);
               getbNew().setForeground(Color.WHITE);
               getbNew().setBorder(null);
           }
        });
        
        //set button has home icon
        this.setbHome(new JButton(new ImageIcon("Resource\\iconHome.png")));
        this.getbHome().setActionCommand("Home");
        this.getbHome().setPreferredSize(new Dimension(50, 40));
        this.getbHome().setBorder(null);
        this.getbHome().setContentAreaFilled(false);
        this.getbHome().setCursor(new Cursor(HAND_CURSOR));
        this.getbHome().setFocusPainted(false);
        //su ly su kien chuot cho nut icon "Home" JButton
        this.getbHome().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                getbHome().setIcon(new ImageIcon("Resource\\iconHomeHover.png"));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                getbHome().setIcon(new ImageIcon("Resource\\iconHome.png"));
            }
        });
        
        //set reset button
        this.setbReset(new JButton(new ImageIcon("Resource\\reset-icon.png")));
        this.getbReset().setActionCommand("Reset");
        this.getbReset().setPreferredSize(new Dimension(50, 40));
        this.getbReset().setFocusPainted(false);
        this.getbReset().setContentAreaFilled(false);
        this.getbReset().setBorder(null);
        this.getbReset().setCursor(new Cursor(HAND_CURSOR));
        //xu ly su kien chuot cho "Reset" JButton
        this.getbReset().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                getbReset().setIcon(new ImageIcon("Resource\\reset-icon-hover.png"));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                getbReset().setIcon(new ImageIcon("Resource\\reset-icon.png"));
            }
        });
        
        //add button home icon, button reset icon to pWestScrossBar1
        this.getpWestSrcossBar1().add(this.getbHome(), BorderLayout.WEST);
        this.getpWestSrcossBar1().add(this.getbReset(), BorderLayout.CENTER);
        
        //add components to pScrossBar1
        this.getpScrossBar1().add(this.getpWestSrcossBar1(), BorderLayout.WEST);
        this.getpScrossBar1().add(this.getbNew(), BorderLayout.EAST);
        
        
        //pClassifyMenu
        this.setpClassifyMenu(new JPanel());
        this.getpClassifyMenu().setBackground(BACKGROUND_COLOR);
        this.getpClassifyMenu().setLayout(new GridLayout(2, 6, 10, 10));
        this.getpClassifyMenu().setBorder(new EmptyBorder(10, 10, 10, 10));
        
        //hien thi menu classify
        this.setButtonList(new ArrayList<>());
        this.setPanelList(new ArrayList<>());
        this.setSellBUS(new SellBUS());
        this.createClassifyButtonList();
        this.addComponentsInButtonListToJPanel(this.getButtonList(), this.getpClassifyMenu());

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
        this.setTfSearch(new JTextField("search product here"));
        this.getTfSearch().setFont(new Font("Arial", Font.ITALIC, 16));
        this.getTfSearch().setBackground(new Color(235, 238, 236));
        this.getTfSearch().setBorder(BorderFactory.createRaisedBevelBorder());
        
        //set button search
        this.setbSearch(new JButton("Search"));
        this.getbSearch().setPreferredSize(new Dimension(100, 40));
        this.getbSearch().setFocusPainted(false);
        this.getbSearch().setFont(new Font("Arial", Font.BOLD, 18));
        this.getbSearch().setBackground(Color.LIGHT_GRAY);
        this.getbSearch().setCursor(new Cursor(HAND_CURSOR));
        this.getbSearch().setBorder(BorderFactory.createRaisedBevelBorder());
        this.getbSearch().addMouseListener(new MouseAdapter() {      
            @Override
            public void mouseEntered(MouseEvent e) {
                getbSearch().setBackground(HOVER_COLOR);
                getbSearch().setFont(new Font("Arial", Font.BOLD, 20));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                getbSearch().setBackground(Color.LIGHT_GRAY);
                getbSearch().setFont(new Font("Arial", Font.BOLD, 18));
            }
        });
        this.getbSearch().addActionListener((ActionEvent e) -> {
            createProductButtonSearchList(getTfSearch().getText());
            getpItemMenu().removeAll();
            addComponentsInButtonListToJPanel(getButtonList(), getpItemMenu());
            getCard().show(getpBodyMenus(), "Item");
        });
        
        this.getTfSearch().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                getCard().show(getpBodyMenus(), "Temp");
            }
        });
        
        //add label "Order" to pScrossBar2
        this.getpScrossBar2().add(this.getlOrder(), BorderLayout.WEST);
        this.getpScrossBar2().add(this.getTfSearch(), BorderLayout.CENTER);
        this.getpScrossBar2().add(this.getbSearch(), BorderLayout.EAST);
        
        
        //Center
        this.setpBodyMenus(new JPanel());
        this.setCard(new CardLayout());
        this.getpBodyMenus().setLayout(this.getCard());
        
        
        this.setpTable(this.createItemMenuJPanel());
        this.getpTable().setBackground(new Color(194, 179, 152, 76));
        this.getpTable().setLayout(new FlowLayout(FlowLayout.LEFT, 12, 12));
        this.getpTable().setBorder(new EmptyBorder(4, 0, 0, 0));
        
        //create table panel list
        this.getpTable().removeAll();
        this.createTablePanelList();
        this.addComponentsInPanelListToJPanel(getPanelList(), getpTable());
        
        this.setpItemMenu(this.createItemMenuJPanel());

        this.setpTemp(this.createItemMenuJPanel());
        
        //create JScollPane contains JPanel contains Products
        this.setsItemMenu(new JScrollPane(this.getpItemMenu(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        this.setsTemp(new JScrollPane(this.getpTemp(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        
        this.getpBodyMenus().add(this.getpTable(), "Table");
        this.getpBodyMenus().add(this.getsItemMenu(), "Item");
        this.getpBodyMenus().add(this.getsTemp(), "Temp");
        
        //Them cac thanh phan vao panel pMenus
        this.getpHeaderMenus().add(this.getpScrossBar1(), BorderLayout.NORTH);
        this.getpHeaderMenus().add(this.getpClassifyMenu(), BorderLayout.CENTER);
        this.getpHeaderMenus().add(this.getpScrossBar2(), BorderLayout.SOUTH);
        
                
        this.getpMenus().add(this.getpHeaderMenus(), BorderLayout.NORTH);
        this.getpMenus().add(this.getpBodyMenus(), BorderLayout.CENTER);
        
        //End: pMenus
    }
    
    private JButton createChooseDrinkJButton(String text, String actioncommand) {
        JButton o = new JButton();
        o.setText(text);
        o.setActionCommand(actioncommand);
        o.setBackground(BUTTON_COLOR);
        o.setFocusPainted(false);
        o.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 17));
        o.setPreferredSize(new Dimension(158, 90));
        o.setBorder(BorderFactory.createRaisedBevelBorder());
        o.setCursor(new Cursor(HAND_CURSOR));
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
           } else if (e.getActionCommand().contains("CL0")){
               getpItemMenu().removeAll();
               createProductButtonList(e.getActionCommand());
               addComponentsInButtonListToJPanel(getButtonList(), getpItemMenu());
               getCard().show(getpBodyMenus(), "Temp");
               getCard().show(getpBodyMenus(), "Item");
           } else if (!e.getActionCommand().equals("")) {
               ChoiceMenuOfProductGUI choiceMenu = new ChoiceMenuOfProductGUI(e.getActionCommand(), this.getSellBUS());
           }
        });
        return o;
    }
    
    private JButton createPaymentJButton() {
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
    
    private void addComponentsInButtonListToJPanel(ArrayList<JButton> list, JPanel jpanel) {
        for(JButton o: list) {
            jpanel.add(o);
        }
    }
    
    private void createClassifyButtonList() {
        this.getButtonList().clear();
        this.getButtonList().add(this.createChooseDrinkJButton("Table", "Table"));
        for(ClassifyDTO classify: this.getSellBUS().getClassifyBUS().getClassifyList()) {
            if(classify.isClassifyBusiness()) {
                this.getButtonList().add(this.createChooseDrinkJButton(classify.getClassifyName(), classify.getClassifyId()));
            }
        }
        if(this.getButtonList().size() < 11) {
            for(int i = this.getButtonList().size(); i < 11; i++) {
                this.getButtonList().add(this.createChooseDrinkJButton("", ""));
            }
        }
        this.getButtonList().add(this.createPaymentJButton());
    }
    
    private void createProductButtonList(String classifyId) {
        this.getButtonList().clear();
        for(ProductDTO product: this.getSellBUS().getProductBUS().getProductList()) {
            if(product.isProductBusiness() && product.getClassifyId().equalsIgnoreCase(classifyId)) {      
                this.getButtonList().add(this.createChooseDrinkJButton(product.getProductNickName(), product.getProductId()));
            }
        }
    }
    
    private void createProductButtonSearchList(String search) {
        this.getButtonList().clear();
        for(ProductDTO product: this.getSellBUS().getProductBUS().getProductList()) {
            if(!search.equals("") && (product.isProductBusiness() && (product.getProductName().toLowerCase().contains(search) || product.getProductName().toUpperCase().contains(search) || product.getProductName().contains(search)))
                && this.getSellBUS().getClassifyBUS().getClassifyFromId(product.getClassifyId()).isClassifyBusiness()) {
                    this.getButtonList().add(this.createChooseDrinkJButton(product.getProductNickName(), product.getProductId()));
            }
        }
    }
    
    private JPanel createItemMenuJPanel() {
        JPanel o = new JPanel();
        o.setBackground(BACKGROUND_COLOR);
        o.setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, 1000));
        o.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        return o;
    }
    
    private JPanel createTablePanel(String title, int numbetSeat, boolean avaliable) {
        
        //tao khung chua
        JPanel table = new JPanel();
        table.setPreferredSize(new Dimension(130, 190));
        table.setLayout(new BorderLayout());
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border compound = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), raisedBevel);
        table.setBorder(BorderFactory.createTitledBorder(compound, title, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 15), Color.BLACK));
        
        //tao cac thanh phan ben trong panel table
        //header
        JEditorPane header = new JEditorPane();
        header.setContentType("text/html");
        header.setBackground(new Color(238, 238, 238));
        header.setPreferredSize(new Dimension(130, 20));
        if(avaliable) {
            header.setText("<html><font size = 3><b>" + "Seat: " + numbetSeat + "--" + "Status: " + "<font color=blue>" + avaliable + "</font>" + "</b></font></html>");
        } else {
            header.setText("<html><font size = 3><b>" + "Seat: " + numbetSeat + "--" + "Status: " + "<font color=red>" + avaliable + "</font>" + "</b></font></html>");
        }
        
        //center
        JLabel center = new JLabel(new ImageIcon("Resource\\table-icon.png"));
        
        //footer
        JButton pFooter = new JButton("Choose");
        pFooter.setActionCommand(title);
        pFooter.setPreferredSize(new Dimension(130, 30));
        pFooter.setBackground(Color.LIGHT_GRAY);
        pFooter.setFocusPainted(false);
        pFooter.setBorder(BorderFactory.createRaisedBevelBorder());
        pFooter.setCursor(new Cursor(HAND_CURSOR));
        pFooter.setFont(new Font("Arial", Font.BOLD, 15));
        pFooter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                pFooter.setBackground(HOVER_COLOR);
                pFooter.setFont(new Font("Arial", Font.BOLD, 18));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                pFooter.setBackground(Color.LIGHT_GRAY);
                pFooter.setFont(new Font("Arial", Font.BOLD, 15));
            }
        });
        
        //add cac thanh phan vao panel table
        table.add(header, BorderLayout.NORTH);
        table.add(center, BorderLayout.CENTER);
        table.add(pFooter, BorderLayout.SOUTH);
        
        
        return table;
    }
    
    private void createTablePanelList() {
        this.getPanelList().clear();
        for(TableDTO table: this.getSellBUS().getTableBUS().getTableList()) {
            this.getPanelList().add(this.createTablePanel(table.getTableId(), table.getTableType(), table.isTableStatus()));
        }
    }
    
    private void addComponentsInPanelListToJPanel(ArrayList<JPanel> panelList, JPanel panel) {
        for(JPanel o: panelList) {
            panel.add(o);
        }
    }
        
    //main
    public static void main (String[] args) {
        SellGUI gui = new SellGUI("Sell Form");
    }
    
}
