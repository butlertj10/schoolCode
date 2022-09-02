package fahrenheit;

import javax.swing.*;
        
public class MainFrame extends JFrame
{
    
    public MainFrame()
    {
        super("Fahrenheit");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FahrenheitPanel panel = new FahrenheitPanel();
        
        this.getContentPane().add(panel);
        
        this.pack();
        this.setVisible(true);
    }
}
