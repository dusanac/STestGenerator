/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stestgenerator;

//import java.util.Random;

/**
 *
 * @author dux
 */

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.*;
import javax.swing.JOptionPane;

public class blicTest extends testNumerData{  
    
    protected String dataInLine;
    protected String lines[];
    
    //brTestova   brPitanja
    protected int [][] randomData;
    
    protected blicTest (){//potrebno samo radi nasledjivanja
        
    }
    public blicTest (int brPitanjaUTestu, int brTestova, String filename){
        doTest(brPitanjaUTestu, brTestova, filename);
    }
    
    public void doTest (int brPitanjaUTestu, int brTestova, String filename){
        setPitanjaUTestu(brPitanjaUTestu);
        setBrTestova (brTestova);
        
        disectData (filename);
        
        
        
        if (dataTest()){
            
            // brPitanjaUBAzi, brPitanjaUTestu, brTestova
            randomize r = new randomize(super.brPitanjaUBazi, super.brPitanjaUTestu, super.brTestova);
            randomData = r.getNiz2();
            
            writeOutput(filename);
            
        }
        
    }
    
    
public boolean dataTest (){
    if (super.brPitanjaUBazi>=super.brPitanjaUTestu){
        return true;
    }
    else {
        // treba obavjestenje
        return false;
    }
    
}    

public void disectData (String filename){
    dataRead drObject = new dataRead(filename);
    //dataInLine = drObject.getData();
    
    lines = drObject.getGoodLines();
    
    lines = cleanLines(lines);
    
    int nol = 0;//temp var
    
    for (int i=0;i<lines.length;i++){//dismiss empty lines in the file
        if (lines[i]!=null || !lines[i].equals("")){
            nol++;
        }
    }
    
    setPitanjaUBazi(nol);   
}
    
public String[] cleanLines(String[] l){
    int tmp = 0;
    String s [] = new String [l.length];//novi niz obradjenih linija
    String temp [];
    
    
    for (int i = 0;i<l.length; i++){
        
        Pattern pattern = Pattern.compile(":");
        Matcher matcher = pattern.matcher(l[i]);
        
        
        
        if (matcher.find()){
            tmp ++;
            temp = l[i].split(":");
            s[i]=temp[1];
        }
        //matcher.
    }
    if (tmp>5){//find : separator in at least 5 questions (lines)
        return s;
    }
    else {
        return l;
    }
    
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
  	//FileWriter out = new FileWriter(folderName + "/" + outFile + String.valueOf(i+1) + ".txt");
		//BufferedWriter outStream = new BufferedWriter (out);
		
                BufferedWriter outStream = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(folderName + File.separatorChar + outFile + String.valueOf(i+1) + ".txt"), "UTF-8"));
                
                //Tekst.write(out);//upisuje u file
                
                outStream.write ("\t\t\t\tTESTNI LIST\n\n");
                outStream.write("Prezime i Ime:\t\t\t\t\t\t\tBr. " + (i+1) + "\n");
                outStream.write("\n___________________________\n\n");
                outStream.write("=====================================================================\n");
                
                for (int j=0;j<brPitanjaUTestu;j++){
                    outStream.write(String.valueOf(j+1) +": "+lines[(randomData[i][j])-1]);
                    outStream.write("\n\n\n\n\n_____________________________________________________________________\n");
                }
                
		
		outStream.close();
		//out.close();
		
		
            }catch (IOException e){
                
		JOptionPane.showMessageDialog(null, "Error... " + e.toString());
            }
    }
    
}

}
