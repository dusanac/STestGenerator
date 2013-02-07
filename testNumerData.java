/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stestgenerator;

/**
 *
 * @author dux
 */
// the class conteins basic data used in inheritance
public class testNumerData {
    protected int brPitanjaUBazi;
    protected int brPitanjaUTestu;
    protected int brTestova;
    protected int abcd;
    
    public void setPitanjaUBazi (int br){
        brPitanjaUBazi = br;
    }
    public void setPitanjaUTestu (int br){
        brPitanjaUTestu = br;
    }
    public void setBrTestova(int bt){
        brTestova = bt;
    }
    public void setAbcd (int a){
        abcd=a;
        abcd=4;//for the first relise of programa
                // meening that you will have A B C D choise!
    }
    
}
