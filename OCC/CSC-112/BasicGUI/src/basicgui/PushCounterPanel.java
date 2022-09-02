package basicgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PushCounterPanel extends JPanel
{
    private JButton push;
    private JLabel label;  
    private int count = 0;
        
    public PushCounterPanel()
    {
        push = new JButton("Push Me");
        label = new JLabel("Pushes: " + count);
        push.addActionListener(new ButtonListener());
        add(push);
        add(label);
    }
    
    private class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            count++;
            label.setText("Pushes: " + count);
        }
        
    }
}
