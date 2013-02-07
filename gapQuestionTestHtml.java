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
public class gapQuestionTestHtml extends blicTest{
    public gapQuestionTestHtml (int brPitanjaUTestu, int brTestova, String filename){
        doTest(brPitanjaUTestu, brTestova, filename);
        super.writeOutput(filename);//da upise i u txt formatu
    }
    
    public void writeOutput (String outFile){
    //open output folder
    //open output file
    //loop testNo and questionNo
    //close output file
    String folderName = (outFile + "Folder"+ File.separatorChar +"Html");
    new File(folderName).mkdirs();
    
    for (int i = 0; i<brTestova;i++){
            try {
  	//FileWriter out = new FileWriter(folderName + "/" + outFile + String.valueOf(i+1) + ".html");
		//BufferedWriter outStream = new BufferedWriter (out);
                
                BufferedWriter outStream = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(folderName + File.separatorChar + outFile + String.valueOf(i+1) + ".html"), "UTF-8"));
                
		
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
                //outStream.write("");
                
                for (int j=0;j<brPitanjaUTestu;j++){
                    outStream.write("<p>");
                    outStream.write(String.valueOf(j+1) +": "+lines[(randomData[i][j])-1]);
                    outStream.write("</p>");
                    outStream.newLine();
                    outStream.write("<br><hr>");
                    outStream.newLine();
                }
                
                outStream.write("</body></htmm>");
		
		outStream.close();
		//out.close();
		
		
            }catch (IOException e){
                
		JOptionPane.showMessageDialog(null, "Error... " + e.toString());
            }
    }
    
}
}
