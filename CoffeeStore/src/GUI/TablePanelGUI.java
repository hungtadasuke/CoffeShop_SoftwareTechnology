package GUI;

import ApplicationHelper.ID;
import DTO.BillDTO;
import DTO.Detail_BillDTO;
import DTO.TableDTO;
import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public final class TablePanelGUI extends JPanel {
    //attribute
    SellGUI sellGUI;
    TableDTO table;
    JEditorPane header;
    JLabel center;
    JButton footer;
    
    //constructor
    public TablePanelGUI(String tableId, SellGUI sellGUI) {
        //Set cac gia tri
        this.sellGUI = sellGUI;
        this.table = this.getSellGUI().getSellBUS().getTableBUS().getTableFromId(tableId);
        this.header = new JEditorPane();
        this.center = new JLabel(new ImageIcon("Resource\\table-icon.png"));
        this.footer = new JButton("Choose");
        
        //Tao khung chua chung
        this.setPreferredSize(new Dimension(130, 190));
        this.setLayout(new BorderLayout());
        Border compound = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY), BorderFactory.createRaisedBevelBorder());
        this.setBorder(BorderFactory.createTitledBorder(compound, tableId, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.BOLD, 15), Color.BLACK));
        
        //tao cac thanh phan ben trong panel this
        
        //header
        this.getHeader().setContentType("text/html");
        this.getHeader().setBackground(new Color(238, 238, 238));
        this.getHeader().setPreferredSize(new Dimension(130, 20));
        String titleTrue = "<html><font size = 3><b>" + "Seat: " + this.getTable().getTableType() + "--" + "Status: " + "<font color=blue>" + this.getTable().isTableStatus() + "</font>" + "</b></font></html>";
        String titleFalse = "<html><font size = 3><b>" + "Seat: " + this.getTable().getTableType() + "--" + "Status: " + "<font color=red>" + this.getTable().isTableStatus() + "</font>" + "</b></font></html>";
        if(this.getTable().isTableStatus()) {
            this.getHeader().setText(titleTrue);
            this.getFooter().setBackground(Color.LIGHT_GRAY);
        } else {
            this.getHeader().setText(titleFalse);
            this.getCenter().setEnabled(false);
            this.getFooter().setText("Full");
            this.getFooter().setBackground(Color.ORANGE);
            this.getFooter().setEnabled(false);
        }
        
        //center
        this.getCenter().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //reset
                getSellGUI().getDetailPanelList().clear();
                getSellGUI().getpOrderBody().removeAll();
                
                //set
                BillDTO billNow = getSellGUI().getSellBUS().getBillDoesNotPaymentOfATable(tableId);
                for(Detail_BillDTO detail: getSellGUI().getSellBUS().getDetailBillBUS().getDetailBillListFromBillId(billNow.getBillId())) {
                    getSellGUI().getDetailPanelList().add(getSellGUI().createDetailBillPanel(detail.getDetailBillId().trim()));
                }
                getSellGUI().addDetailPanelListToPOrderBody();
                getSellGUI().nextCardOrder();
                
                //set lai cac thong tin
                getSellGUI().getlResultBillId().setText(billNow.getBillId());
                getSellGUI().getlTableId().setText("Table  : ");
                getSellGUI().getlResultTableId().setText(tableId);
                getSellGUI().getlToTalResult().setText(billNow.getTotal() + "");
                
            }
        });
        
        
        //footer
        this.getFooter().setActionCommand(tableId);
        this.getFooter().setPreferredSize(new Dimension(130, 30));
        this.getFooter().setFocusPainted(false);
        this.getFooter().setBorder(BorderFactory.createRaisedBevelBorder());
        this.getFooter().setCursor(new Cursor(HAND_CURSOR));
        this.getFooter().setFont(new Font("Arial", Font.BOLD, 15));
        this.getFooter().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                if(button.getText().equalsIgnoreCase("Choose")) {
                    getFooter().setBackground(getSellGUI().HOVER_COLOR);
                    getFooter().setFont(new Font("Arial", Font.BOLD, 18));
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                if(button.getText().equalsIgnoreCase("Choose")) {
                    getFooter().setBackground(Color.LIGHT_GRAY);
                    getFooter().setFont(new Font("Arial", Font.BOLD, 15));
                }
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                if(button.getText().equalsIgnoreCase("Choose")) {
                    getCenter().setIcon(new ImageIcon("Resource\\table-choosed-icon.png"));
                    getFooter().setText("Choosed");
                    getFooter().setBackground(getSellGUI().HOVER_COLOR);
                    getSellGUI().getlTableId().setText("Table  : ");
                    getSellGUI().getlResultTableId().setText(button.getActionCommand());
                    getSellGUI().getlResultBillId().setText(ID.createBillId());
                    
                    //Tai mot thoi diem chi duoc chon 1 table
                    for(TablePanelGUI tableGUI: getSellGUI().getPanelList()) {
                        if(tableGUI.getFooter().getText().equalsIgnoreCase("Choosed") && !tableGUI.getFooter().getActionCommand().equalsIgnoreCase(button.getActionCommand())) {
                            tableGUI.getCenter().setIcon(new ImageIcon("Resource\\table-icon.png"));
                            tableGUI.getFooter().setText("Choose");
                            tableGUI.getFooter().setBackground(Color.LIGHT_GRAY);
                        }
                    }
                    getSellGUI().getpOrderBody().removeAll();
                    getSellGUI().getDetailPanelList().clear();
                    getSellGUI().nextCardOrder();
                } else if(button.getText().equalsIgnoreCase("Choosed")){
                    getCenter().setIcon(new ImageIcon("Resource\\table-icon.png"));
                    getFooter().setText("Choose");
                    getFooter().setBackground(Color.LIGHT_GRAY);
                    getSellGUI().getlTableId().setText("");
                    getSellGUI().getlResultTableId().setText("");
                }
            }
        });
        //add cac thanh phan vao panel this
        this.add(this.getHeader(), BorderLayout.NORTH);
        this.add(this.getCenter(), BorderLayout.CENTER);
        this.add(this.getFooter(), BorderLayout.SOUTH);
        
        //Truong hop khac
        if(!this.getSellGUI().getlResultTableId().getText().equalsIgnoreCase("")) {
            for(TablePanelGUI tableGUI: this.getSellGUI().getPanelList()) {
                if(tableGUI.getTable().getTableId().equalsIgnoreCase(this.getSellGUI().getlResultTableId().getText()) && this.getSellGUI().getSellBUS().getTableBUS().getTableFromId(this.getSellGUI().getlResultTableId().getText()).isTableStatus()) {
                    tableGUI.getCenter().setIcon(new ImageIcon("Resource\\table-choosed-icon.png"));
                    tableGUI.getFooter().setText("Choosed");
                    tableGUI.getFooter().setBackground(getSellGUI().HOVER_COLOR);
                }
            }
        }
    }
    
    //setter and getter
    public SellGUI getSellGUI() {
        return sellGUI;
        
    }

    public void setSellGUI(SellGUI sellGUI) {
        this.sellGUI = sellGUI;
    }

    public TableDTO getTable() {
        return table;
    }
    
    public void setTable(TableDTO table) {    
        this.table = table;
    }

    public JEditorPane getHeader() {
        return header;
    }

    public void setHeader(JEditorPane header) {
        this.header = header;
    }

    public JLabel getCenter() {
        return center;
    }

    public void setCenter(JLabel center) {
        this.center = center;
    }

    public JButton getFooter() {
        return footer;
    }

    public void setFooter(JButton footer) {
        this.footer = footer;
    }
}
