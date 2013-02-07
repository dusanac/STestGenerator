/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stestgenerator;

import javax.swing.JOptionPane;

/**
 *
 * @author dux
 */
public class rjesenja {
    
    private int sumBodova;
    private int sumBodovaLow;
    private int ukupnoBodova;
    private String [] lines;
    private String [] odgovori;
    private String [] tmp;
    
    
    public rjesenja (){
        
    }
    
    public rjesenja (String DB, String odgovori, int testNo, boolean oduzimanje){
        calculate (DB,odgovori,testNo,oduzimanje);
        
    }
    public void calculate (String DB, String Odgovori, int testNo, boolean oduzimanje){
        sumBodova = 0;
        ukupnoBodova = 0;
        sumBodovaLow = 0;
         dataRead db = new dataRead(DB + "Folder/Rjesenja/Rjesenje" + testNo);
         lines = db.getLines();
         if (Odgovori.length()==lines.length){
             odgovori = Odgovori.split("",lines.length+1);//cjepa na 16 djelova (prvi prazan)
             
             //char[]temp=Odgovori.toCharArray();
             //odgovori

             //System.out.println(odgovori[0]);

             for (int i =0 ; i<odgovori.length;i++){
                 
                 if (odgovori[i].equals("1") || odgovori[i].equals("A")|| odgovori[i].equals("a")){
                     odgovori[i] = "1";
                 }
                 else if (odgovori[i].equals("2") || odgovori[i].equals("B")|| odgovori[i].equals("b")){
                     odgovori[i] = "2";
                 }
                 else if (odgovori[i].equals("3") || odgovori[i].equals("C")|| odgovori[i].equals("c")){
                     odgovori[i] = "3";
                 }
                 else if (odgovori[i].equals("4") || odgovori[i].equals("D")|| odgovori[i].equals("d")){
                     odgovori[i] = "4";
                 }
                 //System.out.println(odgovori[i]);
             }

             if (odgovori.length-1 == lines.length){//-1 zbog cjepanja

                 for (int i = 0; i<lines.length; i++){
                     tmp = lines[i].split(":",3);// 0-rb ; 1-tacan odgovor ; 2-br bodova
                     ukupnoBodova += Integer.valueOf(tmp[2]);
                     if (odgovori[i+1].equals(tmp[1])){
                         sumBodova += Integer.valueOf(tmp[2]);
                         sumBodovaLow += Integer.valueOf(tmp[2]);
                         
                     }
                     else if(odgovori[i+1].equals("") || odgovori[i+1].equals("0")){
                         //do nothing
                     }
                     else if (tmp[2].equals("2")){
                         sumBodovaLow -= 2;
                         
                     }
                 }


             }
             else {
                 JOptionPane.showMessageDialog(null, "Odgovori nisu unešeni ispravno!");
             }
             
            if (oduzimanje == true){
            JOptionPane.showMessageDialog(null, "Rezultat: " + 
                    String.valueOf(sumBodovaLow) + 
                    " od ukupno " + String.valueOf(ukupnoBodova));
            }
            else if (oduzimanje == false){
            JOptionPane.showMessageDialog(null, "Rezultat: " + 
                    String.valueOf(sumBodova) + 
                    " od ukupno " + String.valueOf(ukupnoBodova));
            }
            
         }
         else {
                 JOptionPane.showMessageDialog(null, "Odgovori nisu unešeni ispravno!");
             }
    }
    
}
