/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutexampe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author speciosr
 */
public class BoxPanel extends JPanel
{
    public BoxPanel()
    {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        
        this.setBackground(Color.green);
        
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        JButton b4 = new JButton("Button 4");
        JButton b5 = new JButton("Button 5");
        
        this.add(b1);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(b2);
        this.add(Box.createVerticalGlue());
        this.add(b3);
        this.add(b4);
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(b5);        
    }
}

