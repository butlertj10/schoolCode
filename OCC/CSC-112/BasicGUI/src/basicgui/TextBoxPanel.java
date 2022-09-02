 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicgui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author speciosr
 */
public class TextBoxPanel extends JPanel
{
    private JLabel lblFirst, lblLast, lblFullName;
    private JTextField txtFirst, txtLast;
    private JButton cmdGo;
    private JCheckBox chkBold, chkItalic;
    private JRadioButton optSize12, optSize24;
    private ButtonGroup group;
    
    public TextBoxPanel()
    {
        lblFirst = new JLabel("First name");
        lblLast = new JLabel("Last name");
        lblFullName = new JLabel("");
        
        txtFirst = new JTextField(10);
        txtLast = new JTextField(10);
        txtFirst.setText("Hello");
        
        cmdGo = new JButton("Go");
        cmdGo.addActionListener(new ButtonListener());
        
        chkBold = new JCheckBox("Bold");
        chkItalic = new JCheckBox("Italic");
        chkBold.setBackground(Color.YELLOW);
        chkItalic.setBackground(Color.YELLOW);

        chkBold.addItemListener(new StyleListener());
        chkItalic.addItemListener(new StyleListener());
        
        optSize12 = new JRadioButton("Font Size 12", true);
        optSize24 = new JRadioButton("Font Size 24");    
        optSize12.setBackground(Color.YELLOW);
        optSize24.setBackground(Color.YELLOW);
        //optSize12.addActionListener(new ButtonListener());
        //optSize24.addActionListener(new ButtonListener());        
        
        group = new ButtonGroup();
        group.add(optSize12);
        group.add(optSize24);
        
        this.add(lblFirst);
        this.add(txtFirst);
        this.add(lblLast);
        this.add(txtLast);
        this.add(cmdGo);
        this.add(lblFullName);
        this.add(chkBold);
        this.add(chkItalic);
        this.add(optSize12);
        this.add(optSize24);

        
        this.setBackground(Color.YELLOW);
        this.setPreferredSize(new Dimension(300, 120));
        
    }
    
    private class StyleListener implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent e) 
        {
            int style = Font.PLAIN;
                        
            if(chkBold.isSelected())
                style = Font.BOLD;
            
            if(chkItalic.isSelected())
                style += Font.ITALIC;
            
            lblFullName.setFont(new Font("Helvetica", style, 24));
        }
        
    }
    private class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            int style = Font.PLAIN;
            

            
            if(chkBold.isSelected())
                style = Font.BOLD;
            
            if(chkItalic.isSelected())
                style += Font.ITALIC;
            
            if(optSize12.isSelected())
                lblFullName.setFont(new Font("Helvetica", style, 12));
            else if(optSize24.isSelected())
                lblFullName.setFont(new Font("Helvetica", style, 24));
            
            /*if(e.getSource() == optSize12)
                lblFullName.setFont(new Font("Helvetica", style, 12));
            if(e.getSource() == optSize24)
                lblFullName.setFont(new Font("Helvetica", style, 24));*/
            
            lblFullName.setText(txtFirst.getText() + " " +
                    txtLast.getText());            
        }
        
    }
            
}
