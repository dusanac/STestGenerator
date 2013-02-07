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
public class gapQuestionTest extends blicTest{
    
    public gapQuestionTest (int brPitanjaUTestu, int brTestova, String filename){
        super.doTest(brPitanjaUTestu, brTestova, filename);
    }
    
    public void writeOutput (String outFile){
    //open output folder
    //open output file
    //loop testNo and questionNo
    //close output file
    String folderName = (outFile + "Folder"+ File.separatorChar +"Txt");
    new File(folderName).mkdirs();
    
    for (int i = 0; i<brTestova;i++){
            try {
  	//FileWriter out = new FileWriter(folderName + "/" + outFile + String.valueOf(i+1));
		//BufferedWriter outStream = new BufferedWriter (out);
                
                BufferedWriter outStream = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(folderName + File.separatorChar + outFile + String.valueOf(i+1) + ".txt"), "UTF-8"));
                
		
                //Tekst.write(out);//upisuje u file
                
                outStream.write ("\t\t\t\tTESTNI LIST\n\n");
                outStream.write("Prezime i Ime:\t\t\t\t\t\t\tBr. " + (i+1) + "\n");
                outStream.write("\n___________________________\n\n");
                outStream.write("=====================================================================\n\n");
                
                for (int j=0;j<brPitanjaUTestu;j++){
                    outStream.write(String.valueOf(j+1) +": "+lines[(randomData[i][j])-1]);
                    outStream.write("\n\n_____________________________________________________________________\n\n");
                }
                
		
		outStream.close();
		//out.close();
		
		
            }catch (IOException e){
                
		JOptionPane.showMessageDialog(null, "Error... " + e.toString());
            }
    }
    
}
}
