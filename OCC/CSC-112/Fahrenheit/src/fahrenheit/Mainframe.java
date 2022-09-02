/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fahrenheit;

/**
 *
 * @author t.j.butler2
 */
import javax.swing.*;

public class Mainframe extends JFrame
{
    public Mainframe()
    {
        super("Fahrenheit");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FahrenheitPanel panel = new FahrenheitPanel();
        
        this.getContentPane().add(panel);
        
        this.pack();
        this.setVisible(true);
    }
}
