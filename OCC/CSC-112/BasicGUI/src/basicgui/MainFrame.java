package basicgui;

import javax.swing.*;

public class MainFrame extends JFrame
{
    private PushCounterPanel panel1;
    private LeftRightPanel panel2;
    private JPanel mainPanel;
    private TextBoxPanel panel3;
    
    public MainFrame(String caption)
    {        
        super(caption);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        
        panel1 = new PushCounterPanel();
        panel2 = new LeftRightPanel();
        panel3 = new TextBoxPanel();
        
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        
        this.getContentPane().add(mainPanel);        
        
        this.pack();
        this.setVisible(true);
    }
}
