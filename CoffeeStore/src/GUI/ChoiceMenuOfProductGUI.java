package GUI;

import BUS.SellBUS;
import DTO.Product_SizeDTO;
import DTO.Product_ToppingDTO;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;

public final class ChoiceMenuOfProductGUI extends JFrame{
    //components
    JPanel pHeader, pBody, pFooter, pBodyHeader, pBodySize, pBodyQuantity, pBodyPrice, pBodyStatus, pBodyCenter;
    JLabel lHeader, lSize, lQuantity, lPrice, lStatus;
    JButton btnCheck, bAdd, bSub;
    JTextField tfQuantity, tfPrice;
    SellBUS sellBUS;
    Vector <JRadioButton> sizeRadioButtonList;
    JCheckBox[] statusCheckBoxList;
    Vector <ChoiceMenuOfToppingGUI> toppingPanelList;
    String productId;
    String detailBillId;
    Color BACKGROUND_COLOR = new Color(175, 136, 110);
    
    //constructor
    public ChoiceMenuOfProductGUI(String productId, SellBUS sellBUS, String detailBillId) {
        this.setSellBUS(sellBUS);
        this.setProductId(productId);
        this.setDetailBillId(detailBillId);
        this.setTitle("Choice Menu Of Product");
        this.init();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    //setter and getter
    public JPanel getpHeader() {
        return pHeader;
    }

    public void setpHeader(JPanel pHeader) {
        this.pHeader = pHeader;
    }

    public JPanel getpBody() {
        return pBody;
    }

    public void setpBody(JPanel pBody) {
        this.pBody = pBody;
    }

    public JPanel getpFooter() {
        return pFooter;
    }

    public void setpFooter(JPanel pFooter) {
        this.pFooter = pFooter;
    }

    public JPanel getpBodySize() {
        return pBodySize;
    }

    public void setpBodySize(JPanel pBodySize) {
        this.pBodySize = pBodySize;
    }

    public JPanel getpBodyStatus() {
        return pBodyStatus;
    }

    public void setpBodyStatus(JPanel pBodyStatus) {
        this.pBodyStatus = pBodyStatus;
    }

    public JLabel getlHeader() {
        return lHeader;
    }

    public void setlHeader(JLabel lHeader) {
        this.lHeader = lHeader;
    }

    public JLabel getlSize() {
        return lSize;
    }

    public void setlSize(JLabel lSize) {
        this.lSize = lSize;
    }

    public JLabel getlQuantity() {
        return lQuantity;
    }

    public void setlQuantity(JLabel lQuantity) {
        this.lQuantity = lQuantity;
    }

    public JLabel getlPrice() {
        return lPrice;
    }

    public void setlPrice(JLabel lPrice) {
        this.lPrice = lPrice;
    }

    public JButton getBtnCheck() {
        return btnCheck;
    }

    public void setBtnCheck(JButton btnCheck) {
        this.btnCheck = btnCheck;
    }

    public JTextField getTfQuantity() {
        return tfQuantity;
    }

    public void setTfQuantity(JTextField tfQuantity) {
        this.tfQuantity = tfQuantity;
    }

    public JTextField getTfPrice() {
        return tfPrice;
    }

    public void setTfPrice(JTextField tfPrice) {
        this.tfPrice = tfPrice;
    }

    public SellBUS getSellBUS() {
        return sellBUS;
    }

    public void setSellBUS(SellBUS sellBUS) {
        this.sellBUS = sellBUS;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public JPanel getpBodyQuantity() {
        return pBodyQuantity;
    }

    public void setpBodyQuantity(JPanel pBodyQuantity) {
        this.pBodyQuantity = pBodyQuantity;
    }

    public JPanel getpBodyPrice() {
        return pBodyPrice;
    }

    public void setpBodyPrice(JPanel pBodyPrice) {
        this.pBodyPrice = pBodyPrice;
    }

    public JPanel getpBodyHeader() {
        return pBodyHeader;
    }

    public void setpBodyHeader(JPanel pBodyHeader) {
        this.pBodyHeader = pBodyHeader;
    }

    public JPanel getpBodyCenter() {
        return pBodyCenter;
    }

    public void setpBodyCenter(JPanel pBodyCenter) {
        this.pBodyCenter = pBodyCenter;
    }

    public Vector<JRadioButton> getSizeRadioButtonList() {
        return sizeRadioButtonList;
    }

    public void setSizeRadioButtonList(Vector<JRadioButton> sizeRadioButtonList) {
        this.sizeRadioButtonList = sizeRadioButtonList;
    }

    public JButton getbAdd() {
        return bAdd;
    }

    public void setbAdd(JButton bAdd) {
        this.bAdd = bAdd;
    }

    public JButton getbSub() {
        return bSub;
    }

    public void setbSub(JButton bSub) {
        this.bSub = bSub;
    }

    public JLabel getlStatus() {
        return lStatus;
    }

    public void setlStatus(JLabel lStatus) {
        this.lStatus = lStatus;
    }

    public JCheckBox[] getStatusCheckBoxList() {
        return statusCheckBoxList;
    }

    public void setStatusCheckBoxList(JCheckBox[] statusCheckBoxList) {
        this.statusCheckBoxList = statusCheckBoxList;
    }

    public Vector<ChoiceMenuOfToppingGUI> getToppingPanelList() {
        return toppingPanelList;
    }

    public void setToppingPanelList(Vector<ChoiceMenuOfToppingGUI> toppingPanelList) {
        this.toppingPanelList = toppingPanelList;
    }

    public String getDetailBillId() {
        return detailBillId;
    }

    public void setDetailBillId(String detailBillId) {
        this.detailBillId = detailBillId;
    }
    
    
    
    
    //method
    private void init() {
        this.setSize(450, 600);
        this.setIconImage(Toolkit.getDefaultToolkit().createImage("Resource\\choice-icon.png"));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        
        //Tao phan header
        this.createpHeaderPanel();
        this.add(this.getpHeader(), BorderLayout.NORTH);
        
        //Tao phan body
        this.createpBodyPanel();
        this.add(this.getpBody(), BorderLayout.CENTER);
        
        //Tao phan footer
        this.createpFooterPanel();
        this.add(this.getpFooter(), BorderLayout.SOUTH);
    }
    
    private void createpHeaderPanel() {
        //Tao khung chua chung
        this.setpHeader(new JPanel());
        this.getpHeader().setPreferredSize(new Dimension(450, 60));
        this.getpHeader().setBackground(BACKGROUND_COLOR);
        this.getpHeader().setBorder(new EmptyBorder(15, 0, 0, 0));
        this.getpHeader().setLayout(new FlowLayout());
        
        //Tao cac thanh phan
        this.setlHeader(new JLabel(this.getSellBUS().getProductBUS().getProductFromId(this.getProductId()).getProductName()));
        this.getlHeader().setForeground(Color.WHITE);
        this.getlHeader().setFont(new Font("Arial", Font.BOLD, 19));
        
        //Them cac thanh phan vao pHeader
        this.getpHeader().add(this.getlHeader());
    }
    
    private void createpBodyPanel() {
        //Tao khung chua chung
        this.setpBody(new JPanel());
        this.getpBody().setLayout(new BorderLayout(0, 5));
        this.getpBody().setBackground(BACKGROUND_COLOR);
        this.getpBody().setBorder(BorderFactory.createTitledBorder(new LineBorder(Color.BLACK), "Please Choose Drink Information", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 13), Color.BLACK));
        
        //Tao phan header cua pBodyPanel
        this.setpBodyHeader(new JPanel());
        this.getpBodyHeader().setBackground(BACKGROUND_COLOR);
        this.getpBodyHeader().setLayout(new GridLayout(4, 1, 0, 5));
        this.getpBodyHeader().setPreferredSize(new Dimension(450, 155));
        
        //Tao pBodySize
        this.setpBodySize(new JPanel());
        this.getpBodySize().setBackground(BACKGROUND_COLOR);
        this.getpBodySize().setLayout(new FlowLayout(FlowLayout.LEFT, 15, 0));
        Border matteBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE);
        this.getpBodySize().setBorder(BorderFactory.createCompoundBorder(matteBorder, new EmptyBorder(4, -5, 0, 0)));
        
        this.setlSize(new JLabel("Size          :           "));
        this.getlSize().setFont(new Font("Arial", Font.BOLD, 13));
        this.setSizeRadioButtonList(createSizeRadioButtonList());
        
        this.getpBodySize().add(this.getlSize());
        this.getSizeRadioButtonList().get(this.getSizeRadioButtonList().size() - 1).setSelected(true);
        for(int i = this.getSizeRadioButtonList().size() - 1; i >= 0; i--) {
            this.getpBodySize().add(this.getSizeRadioButtonList().get(i));
        }
        
        //Tao pBodyQuantity
        this.setpBodyQuantity(new JPanel());
        this.getpBodyQuantity().setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        this.getpBodyQuantity().setBackground(BACKGROUND_COLOR);
        this.getpBodyQuantity().setBorder(BorderFactory.createCompoundBorder(matteBorder, new EmptyBorder(4, 1, 0, 0)));
        
        this.setlQuantity(new JLabel("Quantity  :             "));
        this.getlQuantity().setFont(new Font("Arial", Font.BOLD, 13));
        
        this.getSellBUS().getDetailBillBUS().resetList();
        if (this.getSellBUS().getDetailBillBUS().getQuantity(this.getDetailBillId()) == 0)  {
            this.setTfQuantity(new JTextField(1+"", 3));
        } else {
            this.setTfQuantity(new JTextField(this.getSellBUS().getDetailBillBUS().getQuantity(this.getDetailBillId())+"", 3));
        }
        this.getTfQuantity().setEditable(false);
        this.getTfQuantity().setHorizontalAlignment((int) JTextField.CENTER_ALIGNMENT);
        
        this.getpBodyQuantity().add(this.getlQuantity());
        this.getpBodyQuantity().add(this.createButtonAddOrSub(new ImageIcon("Resource\\tp_minus.png"), "quantitySub"));
        this.getpBodyQuantity().add(this.getTfQuantity());
        this.getpBodyQuantity().add(this.createButtonAddOrSub(new ImageIcon("Resource\\tp_add.png"), "quantityAdd"));
        
        
        //Tao pBodyPrice
        this.setpBodyPrice(new JPanel());
        this.getpBodyPrice().setBackground(BACKGROUND_COLOR);
        this.getpBodyPrice().setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        this.getpBodyPrice().setBorder(BorderFactory.createCompoundBorder(matteBorder, new EmptyBorder(4, 1, 0, 0)));
        
        this.setlPrice(new JLabel("Price        :              "));
        this.getlPrice().setFont(new Font("Arial", Font.BOLD, 13));
        this.setTfPrice(new JTextField(12));
        this.setToppingPanelList(this.createToppingPanelList());
        this.getTfPrice().setText((this.getSellBUS().getProductSizeBUS().getPrice(this.getProductId(), this.getSizeSelected()) + this.getToTalFromDetailToppingList()) * Integer.parseInt(getTfQuantity().getText())  + "");
        this.getTfPrice().setEditable(false);
        
        this.getpBodyPrice().add(this.getlPrice());
        this.getpBodyPrice().add(this.getTfPrice());
        
        //TaopBodyStatus
        this.setpBodyStatus(new JPanel());
        this.getpBodyStatus().setBackground(BACKGROUND_COLOR);
        this.getpBodyStatus().setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        this.getpBodyStatus().setBorder(BorderFactory.createCompoundBorder(matteBorder, new EmptyBorder(4, -1, 0, 0)));
        
        this.setlStatus(new JLabel("Status      :            "));
        this.getlStatus().setFont(new Font("Arial", Font.BOLD, 13));
        
        this.setStatusCheckBoxList(this.createStatusCheckBoxList());
        
        this.getpBodyStatus().add(this.getlStatus());
        for (JCheckBox statusCheckBox: this.getStatusCheckBoxList()) {
            statusCheckBox.setCursor(new Cursor(HAND_CURSOR));
            this.getpBodyStatus().add(statusCheckBox);
        }
        
        //Dang ki su kien cho hai nut checkBox
        if(this.getStatusCheckBoxList().length == 2) {
            this.getStatusCheckBoxList()[0].addActionListener((ActionEvent e) -> {
                getStatusCheckBoxList()[1].setSelected(false);         
            });
            this.getStatusCheckBoxList()[1].addActionListener((ActionEvent e) -> {
                getStatusCheckBoxList()[0].setSelected(false);         
            });
        }
        
        //Them cac thanh phan vao khung chua chung nay
        this.getpBodyHeader().add(this.getpBodySize());
        this.getpBodyHeader().add(this.getpBodyQuantity());
        this.getpBodyHeader().add(this.getpBodyPrice());
        this.getpBodyHeader().add(this.getpBodyStatus());
        
        //Tao phan pBodyCenter
        this.setpBodyCenter(new JPanel());
        this.getpBodyCenter().setBackground(BACKGROUND_COLOR);
        this.getpBodyCenter().setLayout(new BoxLayout(this.getpBodyCenter(), BoxLayout.Y_AXIS));
        Border lineBorder = new LineBorder(Color.WHITE);
        this.getpBodyCenter().setBorder(BorderFactory.createTitledBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 50, 0, 50), lineBorder), "Topping", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 15), Color.BLACK));
        
        if(this.getToppingPanelList().size() < 3) {
            this.setSize(450, 400);
            for(ChoiceMenuOfToppingGUI toppingPanel: this.getToppingPanelList()) {
                this.getpBodyCenter().add(toppingPanel);
            }               
        } else if (this.getToppingPanelList().size() < 5) {
            this.setSize(450, 500);
            for(ChoiceMenuOfToppingGUI toppingPanel: this.getToppingPanelList()) {
                this.getpBodyCenter().add(toppingPanel);
            }
        } else {
            for(ChoiceMenuOfToppingGUI toppingPanel: this.getToppingPanelList()) {
                this.getpBodyCenter().add(toppingPanel);
            }
        }
        
    
        this.getpBody().add(this.getpBodyHeader(), BorderLayout.NORTH);
        this.getpBody().add(this.getpBodyCenter(), BorderLayout.CENTER);
    }
    
    private void createpFooterPanel() {
        //Tao khung chua chung
        this.setpFooter(new JPanel());
        this.getpFooter().setPreferredSize(new Dimension(450, 50));
        this.getpFooter().setLayout(new FlowLayout());
        this.getpFooter().setBackground(BACKGROUND_COLOR);
        
        //Tao button "check"
        this.setBtnCheck(new JButton("OK"));
        this.getBtnCheck().setPreferredSize(new Dimension(50, 40));
        this.getBtnCheck().setFont(new Font("Arial", Font.BOLD, 19));
        this.getBtnCheck().setBackground(BACKGROUND_COLOR);
        this.getBtnCheck().setFocusPainted(false);
        this.getBtnCheck().setBorder(null);
        this.getBtnCheck().setCursor(new Cursor(HAND_CURSOR));
        this.getBtnCheck().setForeground(Color.WHITE);
        this.getBtnCheck().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
               getBtnCheck().setBackground(new Color(149, 231, 231));
               getBtnCheck().setForeground(Color.BLACK);
               getBtnCheck().setBorder(BorderFactory.createRaisedBevelBorder());
               getBtnCheck().setFont(new Font("Arial", Font.BOLD, 22));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
               getBtnCheck().setBackground(BACKGROUND_COLOR);
               getBtnCheck().setForeground(Color.WHITE);
               getBtnCheck().setBorder(null);
               getBtnCheck().setFont(new Font("Arial", Font.BOLD, 19));
            }
        });
        
        //Them cac thanh phan vao pFooterPanel
        this.getpFooter().add(this.getBtnCheck());
    }
    
    private JCheckBox[] createStatusCheckBoxList() {
        JCheckBox[] checkBoxList = null;
        if(this.getSellBUS().getProductBUS().getProductFromId(this.getProductId()).getProductStatus().contains("BOTH")) {
            checkBoxList = new JCheckBox[2];
            checkBoxList[0] = this.createStatusCheckBox("Hot", "Hot");
            checkBoxList[1] = this.createStatusCheckBox("Cold", "Cold");
        } else if (this.getSellBUS().getProductBUS().getProductFromId(this.getProductId()).getProductStatus().contains("HOT")) {
            checkBoxList = new JCheckBox[1];
            checkBoxList[0] = this.createStatusCheckBox("Hot", "Hot");
            checkBoxList[0].setSelected(true);
        } else {
            checkBoxList = new JCheckBox[1];
            checkBoxList[0] = this.createStatusCheckBox("Cold", "Cold");
            checkBoxList[0].setSelected(true);
        }
        return checkBoxList;
    }
    
    private JCheckBox createStatusCheckBox(String text, String actionCommand) {
        JCheckBox checkBox = new JCheckBox(text);
        checkBox.setBackground(BACKGROUND_COLOR);
        checkBox.setFocusPainted(false);
        checkBox.setActionCommand(actionCommand);
        return checkBox;
    }
    
    private Vector<JRadioButton> createSizeRadioButtonList() {
        Vector<JRadioButton> listTemp = new Vector<>();
        ButtonGroup bg = new ButtonGroup();
        for(Product_SizeDTO o: this.getSellBUS().getProductSizeBUS().getProductSizeList()) {
            if(o.getProductId().equalsIgnoreCase(this.getProductId())) {
                JRadioButton rBtn = createSizeRadioButton(o.getSize(), o.getSize());
                bg.add(rBtn);
                listTemp.add(rBtn);
            }
        }
        return listTemp;
    }
    
    private JRadioButton createSizeRadioButton(String name, String actionCommand) {
        JRadioButton rBtn = new JRadioButton(name);
        rBtn.setActionCommand(actionCommand);
        rBtn.setBackground(BACKGROUND_COLOR);
        rBtn.setFocusPainted(false);
        rBtn.setCursor(new Cursor(HAND_CURSOR));
        rBtn.addActionListener((ActionEvent e) -> {
            getTfPrice().setText((this.getSellBUS().getProductSizeBUS().getPrice(this.getProductId(), getSizeSelected()) + this.getToTalFromDetailToppingList()) * Integer.parseInt(getTfQuantity().getText()) + "");
        });
        return rBtn;
    }
    
    private JButton createButtonAddOrSub(Icon icon, String actionCommand) {
        JButton button = new JButton(icon);
        button.setActionCommand(actionCommand);
        button.setBackground(BACKGROUND_COLOR);
        button.setBorder(null);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(HAND_CURSOR));
        button.addActionListener((ActionEvent e) -> {
            if(e.getActionCommand().equalsIgnoreCase("quantityAdd")) {
                getTfQuantity().setText((Integer.parseInt(getTfQuantity().getText()) + 1) + "");
            } else if(Integer.parseInt(getTfQuantity().getText()) <= 1) {
                getTfQuantity().setText(1 + "");
            } else {
                getTfQuantity().setText((Integer.parseInt(getTfQuantity().getText()) - 1) + "");
            }
            getTfPrice().setText((ChoiceMenuOfProductGUI.this.getSellBUS().getProductSizeBUS().getPrice(getProductId(), getSizeSelected()) + this.getToTalFromDetailToppingList()) * Integer.parseInt(getTfQuantity().getText())  + "");
        });
        return button;
    }
        
    private Vector<ChoiceMenuOfToppingGUI> createToppingPanelList() {
       Vector<ChoiceMenuOfToppingGUI> list = new Vector<>();
       for(Product_ToppingDTO o: this.getSellBUS().getProductToppingBUS().getProductToppingList()) {
           if(o.getProductId().equalsIgnoreCase(this.getProductId())) {
               list.add(new ChoiceMenuOfToppingGUI(o.getToppingId(), o.getToppingId() + "Add", o.getToppingId() + "Sub", this.getSellBUS(), this.getDetailBillId(), this.getTfPrice(), this.getTfQuantity()));
           }
       }
       return list;
    }
    
    private String getSizeSelected() {
        for(JRadioButton button: this.getSizeRadioButtonList()) {
            if(button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }
    
    private Double getToTalFromDetailToppingList() {
        Double total = 0.0;
        for(ChoiceMenuOfToppingGUI o: this.getToppingPanelList()) {
            total += Double.parseDouble(o.tfQuantity.getText()) * this.getSellBUS().getToppingBUS().getToppingFromId(o.toppingId).getToppingPrice();
        }
        return total;
    }
    
    //main
    public static void main(String[] args) {
        SellBUS s = new SellBUS();
        ChoiceMenuOfProductGUI o = new ChoiceMenuOfProductGUI("TE001", s, "BL0011");
    }
}
