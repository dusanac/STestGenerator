/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stestgenerator;

/**
 *
 * @author dux
 */
public class dataReadTest {
    
    public static void main(String[] args) {
       String fname = "biologija";
       String [] l;
       
       dataRead d = new dataRead(fname);
       l = d.getLines();
       
       for (int i =0;i<l.length;i++){
           
                System.out.println(l[i]);
           
       }
       
    }
    
    
}
