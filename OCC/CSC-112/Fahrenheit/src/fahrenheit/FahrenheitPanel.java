package fahrenheit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author t.j.butler2
 */
public class FahrenheitPanel extends JPanel 
{
    private JLabel lblOutput, lblInput, lblResult;
    private JTextField txtFahrenheit;
    
    public FahrenheitPanel()
    {
        lblInput = new JLabel("Enter Fahrenheit Temperature: ");
        lblOutput = new JLabel("Temperature in Celius: ");
        lblResult = new JLabel("---");
        
        //txtFahrenheit = add.ActionListener()
        txtFahrenheit = new JTextField(5);
                
                this.add(lblInput);
                this.add(txtFahrenheit);
                this.add(lblOutput);
                this.add(lblResult);
                
                this.setPreferredSize(new Dimension(30, 75));
                this.setBackground(Color.YELLOW);
    }
    
    private class TempListener implements ActionListener
    {
         public void actionPerformed(ActionEvent event)
         {
             int fTemp, cTemp;
             String text;
             
             text = txtFahrenheit.getText();
             
             fTemp = Integer.parseInt(text);
             cTemp = ((fTemp - 32) * 5/9);
             
             lblResult.setText(Integer.toString(cTemp));
         }

    }
}
