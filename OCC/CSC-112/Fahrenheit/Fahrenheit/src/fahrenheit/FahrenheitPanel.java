
package fahrenheit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

public class FahrenheitPanel extends JPanel
{
    private JLabel lblInput, lblOutput, lblResult;
    private JTextField txtFahrenheit;
    
    public FahrenheitPanel()
    {
        lblInput = new JLabel("Enter Fahrenheit temperature");
        lblOutput = new JLabel("Temperture in Celsius");
        lblResult = new JLabel("---");
        
        txtFahrenheit = new JTextField(5);
        txtFahrenheit.addActionListener(new TempListener());
        
        this.add(lblInput);
        this.add(txtFahrenheit);
        this.add(lblOutput);
        this.add(lblResult);
        
        this.setPreferredSize(new Dimension(300, 75));
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
            cTemp = (fTemp - 32)* 5/9;
            
            lblResult.setText(Integer.toString(cTemp));
        }
    }
}
