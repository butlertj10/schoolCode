/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutexampe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author speciosr
 */
public class BorderPanel extends JPanel
{
    public BorderPanel()
    {
        this.setLayout(new BorderLayout());
        
        this.setBackground(Color.green);
        
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        JButton b4 = new JButton("Button 4");
        JButton b5 = new JButton("Button 5");
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1,3));
        northPanel.add(b1);
        northPanel.add(b2);
        this.add(northPanel,BorderLayout.NORTH);        
        //this.add(b2,BorderLayout.NORTH);
        this.add(new GridPanel(),BorderLayout.CENTER);
        this.add(b4,BorderLayout.WEST);
        this.add(b5,BorderLayout.EAST);        
    }
}
