package basicgui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class LeftRightPanel extends JPanel        
{
    private JButton cmdLeft, cmdRight;
    private JLabel lblOutput;
    private JPanel panButtonPanel;
    
    public LeftRightPanel()
    {
        cmdLeft = new JButton("Left");
        cmdRight = new JButton("Right");
        lblOutput = new JLabel("Push a button");
        panButtonPanel = new JPanel();
        
        panButtonPanel.setBackground(Color.BLUE);
        panButtonPanel.setPreferredSize(new Dimension(200, 40));
        ButtonListener listener = new ButtonListener();
        cmdLeft.addActionListener(listener);
        cmdRight.addActionListener(listener);
        
        panButtonPanel.add(cmdLeft);
        panButtonPanel.add(cmdRight);
        
        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(200, 80));
        this.add(lblOutput);
        this.add(panButtonPanel);
    }
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == cmdLeft)
                lblOutput.setText("Left");
            else
                lblOutput.setText("Right");
        }
    }
}
