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
//import java.util.Stack;
import javax.swing.JOptionPane;
/**
 *
 * @author dux
 */
public class multivalueTest extends blicTest{
    //brTestova   brPitanja   ABCiliD
    protected int randomData3[][][];
    protected int [] nizVredBodova;
    //protected int [] tacniOdgovori;
    protected String pitanja [][];//rbPitanj X pitanje/4odgovora
    
    public multivalueTest(){}
    
    public multivalueTest (int brPit, int brTes, String fn) {
        doTest(brPit,brTes,fn);
    }
    
    public void doTest (int brPitanjaUTestu, int brTestova, String filename){
        setPitanjaUTestu(brPitanjaUTestu);
        setBrTestova (brTestova);
        
        disectData (filename);
        
        
        
        if (dataTest()){
            
            // brPitanjaUBAzi, brPitanjaUTestu, brTestova
            randomize r = new randomizeMultivalue(super.brPitanjaUBazi, super.brPitanjaUTestu, super.brTestova, 4 , nizVredBodova);
            randomData = r.getNiz2();
            randomData3 = r.getNiz3();
            writeOutput(filename);
            
        }
        
    }
    
    public void disectData (String filename){
        dataRead drObject = new dataRead(filename);
        //dataInLine = drObject.getData();
        lines = drObject.getGoodLines();//izmjeno od getLines();
        String temp[];
        //Stack no = new Stack();
        
        //lines = cleanLines(lines);//nepotrebno jer ima : kao separator

        int nol = 0;//temp var

        for (int i=0;i<lines.length;i++){//dismiss empty lines in the file
            if (lines[i]!=null || !lines[i].equals("")){
                nol++;//samo broji linije tj broj pitanja
            }
        }
        setPitanjaUBazi(nol); 
        
        nizVredBodova = new int [nol];
        //tacniOdgovori = new int [nol];
        pitanja = new String [nol][5];
        int brojac =0;
        for (int i=0;i<lines.length;i++){//ili nol
            if (lines[i]!=null || !lines[i].equals("")){
                temp = lines[i].split(":",7);
                
                //nizVredBodova [] [brojac] = Integer.valueOf(temp[1]);
                nizVredBodova [brojac] = Integer.valueOf(temp[1].toString());
                //tacniOdgovori [brojac] = temp[]
                //System.out.print (String.valueOf(nizVredBodova[brojac]) +" ");
                pitanja[brojac][0] = temp[2].toString();//pitnje
                pitanja[brojac][1] = temp[3].toString();//tacan odgovor
                pitanja[brojac][2] = temp[4].toString();//netacni odgovori X 3
                pitanja[brojac][3] = temp[5].toString();
                pitanja[brojac][4] = temp[6].toString();
                //System.out.println (pitanja[brojac][1]);
                brojac++;
            }
                
            
        }
          
    }
    
    public void writeOutput (String outFile){
    //open output folder
    //open output file
    //loop testNo and questionNo
    //close output file
    String folderName = (outFile + "Folder"+ File.separatorChar +"Txt");
    String folderRjesenja = (outFile + "Folder"+ File.separatorChar +"Rjesenja");
    new File(folderName).mkdirs();
    new File(folderRjesenja).mkdirs();
    
    for (int i = 0; i<brTestova;i++){
            try {
  	//FileWriter out = new FileWriter(folderName + "/Test" + String.valueOf(i+1)+".txt");
		//BufferedWriter outStream = new BufferedWriter (out);
                
                BufferedWriter outStream = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(folderName + File.separatorChar + outFile + String.valueOf(i+1) + ".txt"), "UTF-8"));
                
                
                FileWriter outR = new FileWriter(folderRjesenja + File.separatorChar+ "Rjesenje" + String.valueOf(i+1));
		BufferedWriter outStreamR = new BufferedWriter (outR);
                
		
                //Tekst.write(out);//upisuje u file
                
                outStream.write ("\t\t\t\tTESTNI LIST\n\n");
                outStream.write("Prezime i Ime:\t\t\t\t\t\t\tBr. " + (i+1) + "\n");
                outStream.write("\n___________________________\n\n");
                outStream.write("=====================================================================\n");
                
                for (int j=0;j<brPitanjaUTestu;j++){
                    outStream.write(String.valueOf(j+1) +". "+pitanja[(randomData[i][j])-1][0] + "\n\n");
                    outStream.write("a) "+pitanja[(randomData[i][j])-1][randomData3[i][j][0]] + "\n");
                    outStream.write("b) "+pitanja[(randomData[i][j])-1][randomData3[i][j][1]] + "\n");
                    outStream.write("c) "+pitanja[(randomData[i][j])-1][randomData3[i][j][2]] + "\n");
                    outStream.write("d) "+pitanja[(randomData[i][j])-1][randomData3[i][j][3]] + "\n");
                    outStream.write("\n_____________________________________________________________________\n");
                    
                    outStreamR.write(String.valueOf(j+1) + ":" + String.valueOf(tacanOdgovor(randomData3[i][j])) + ":"  + nizVredBodova[(randomData[i][j])-1] + "\n");
                }
                
		
		outStream.close();
		//out.close();
		outStreamR.close();
		outR.close();
		
            }catch (IOException e){
                
		JOptionPane.showMessageDialog(null, "Error... " + e.toString());
            }
    }
    
}
    public int tacanOdgovor (int a []){
        if (a[0]==1){
            return 1;
        }
        else if (a[1]==1){
            return 2;
        }
        else if (a[2]==1){
            return 3;
        }
        else if (a[3]==1){
            return 4;
        }
        else {
            return 0;
        }
    }
}
