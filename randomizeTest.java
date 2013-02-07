/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stestgenerator;

/**
 *
 * @author dux
 */
public class randomizeTest {
    
    public static void main(String[] args) {
        int a [] = {2, 2, 2, 2, 2, 5, 5, 5, 5, 5, 5, 10, 10, 10, 10, 10};
        // brPitanjaUBazi >15,  brPitanjaUTestu =15,  brTestova, 4, nizVrednostiBodova
        randomizeMultivalue randNo = new randomizeMultivalue(16,15,5,4,a);
        //randomize r = new randomize(16,15,3,4);
    }
    
}
