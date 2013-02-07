/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stestgenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author dux
 */
public class multivalueTestHtml extends multivalueTest{
    
    public multivalueTestHtml (int brPit, int brTes, String fn) {
        doTest(brPit,brTes,fn);
        super.writeOutput(fn);
    }
    
    
    
    public void writeOutput (String outFile){
    //open output folder
    //open output file
    //loop testNo and questionNo
    //close output file
    String folderName = (outFile + "Folder"+ File.separatorChar +"Html");
    String folderRjesenja = (outFile + "Folder"+ File.separatorChar +"Rjesenja");
    new File(folderName).mkdirs();
    new File(folderRjesenja).mkdirs();
    
    for (int i = 0; i<brTestova;i++){
            try {
  	//FileWriter out = new FileWriter(folderName + "/Test" + String.valueOf(i+1) + ".html");
		//BufferedWriter outStream = new BufferedWriter (out);
                
                BufferedWriter outStream = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(folderName + File.separatorChar + outFile + String.valueOf(i+1) + ".html"), "UTF-8"));
                
                
                // uradjeno u roditeljskoj klasi
                //FileWriter outR = new FileWriter(folderRjesenja + "/Rjesenje" + String.valueOf(i+1));
		//BufferedWriter outStreamR = new BufferedWriter (outR);
                
		
                //Tekst.write(out);//upisuje u file
                outStream.write("<!DOCTYPE html>");
                outStream.newLine();
                outStream.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");
                outStream.newLine();
                outStream.write("<html><header></header><body>");
                outStream.newLine();
                outStream.write("<p><strong><center>TESTNI LIST</center></strong><br><br>");
                outStream.newLine();
                outStream.write("<table width=\"100%\"><tr><td align=\"left\">Prezime i ime:___________________________</td>");
                outStream.newLine();
                outStream.write("<td align=\"right\">Br. " + (i+1) + "</td></tr></table>");
                outStream.newLine();
                outStream.write("<hr><hr>");
                outStream.newLine();
                
                for (int j=0;j<brPitanjaUTestu;j++){
                    outStream.write("<p>"+String.valueOf(j+1) +". "+pitanja[(randomData[i][j])-1][0] + "</p>");
                    outStream.newLine();
                    outStream.write("<p>a) "+pitanja[(randomData[i][j])-1][randomData3[i][j][0]] + "<br>");
                    outStream.newLine();
                    outStream.write("b) "+pitanja[(randomData[i][j])-1][randomData3[i][j][1]] + "<br>");
                    outStream.newLine();
                    outStream.write("c) "+pitanja[(randomData[i][j])-1][randomData3[i][j][2]] + "<br>");
                    outStream.newLine();
                    outStream.write("d) "+pitanja[(randomData[i][j])-1][randomData3[i][j][3]] + "</p>");
                    outStream.newLine();
                    outStream.write("<hr>");
                    outStream.newLine();
                    //outStreamR.write(String.valueOf(j+1) + ":" + String.valueOf(tacanOdgovor(randomData3[i][j])) + ":"  + nizVredBodova[(randomData[i][j])-1] + "\n");
                }
                
		
		outStream.close();
		//out.close();
		//outStreamR.close();// uradjeno u roditeljskoj klasi
		//outR.close();
		
            }catch (IOException e){
                
		JOptionPane.showMessageDialog(null, "Error... " + e.toString());
            }
    }
    
}
    
}
