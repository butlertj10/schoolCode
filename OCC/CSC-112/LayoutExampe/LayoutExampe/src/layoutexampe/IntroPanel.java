/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutexampe;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author speciosr
 */
public class IntroPanel extends JPanel
{
    public IntroPanel()
    {
        this.setBackground(Color.red);
        
        JLabel l1 = new JLabel("Lay manager demonstraction");
        JLabel l2 = new JLabel("Choose a tab to see an example of a layout manager");
        
        this.add(l1);
        this.add(l2);
    }
}
