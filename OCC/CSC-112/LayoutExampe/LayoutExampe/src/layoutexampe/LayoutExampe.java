/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layoutexampe;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author speciosr
 */
public class LayoutExampe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        JFrame frame = new JFrame("Layout Manager Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Intro", new IntroPanel());
        tp.addTab("Flow", new FlowPanel());
        tp.addTab("Border", new BorderPanel()); 
        tp.addTab("Grid", new GridPanel());
        tp.addTab("Box", new BoxPanel());   
        
        frame.getContentPane().add(tp);
        frame.pack();
        frame.setVisible(true);
    }
    
}
