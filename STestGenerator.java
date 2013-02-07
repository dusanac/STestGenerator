/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stestgenerator;

/**
 *
 * @author dux
 */
import java.awt.Toolkit;
//import javax.swing.*;
public class STestGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MainFrame Mframe = new MainFrame();// neradi
        /*java.awt.EventQueue.invokeLater(new Runnable() {// RADI
            public void run() {
                new MainFrame().setVisible(true);
            }
        });*/
        //System.setProperty("user.dir", "/home/STestGenerator");
        MainFrame mf = new MainFrame();//new MainFrame().setVisible(true);
        mf.setVisible(true);
        mf.setIconImage(Toolkit.getDefaultToolkit().getImage("stg128x128.png"));
        //System.setProperty("user.home", "/home/STestGenerator");
    }
}
