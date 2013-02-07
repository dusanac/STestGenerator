package stestgenerator;

// NAJNOVIJA KLASA 09.10.2012.


import java.io.*;
import javax.swing.*;
/**
 *
 * @author dux
 */
public class dataRead {
    private String data,line;
    private String fileName;
    
    private String [] lines;// data stored in separate lines
    private String [] goodLines;
    private int lineNo;// start index with 0 needed for lines[]
    private int i = 0;//br linija
    
    
    dataRead (String fName){
        
        fileName = fName;
        try {
                //FileReader in = new FileReader(fileName);
                //BufferedReader inStream = new BufferedReader (in);
                
                BufferedReader inStream = new BufferedReader(
                        new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
                
                boolean eof = false;
                
                
                lineNo=0;
                data="";//izbjegava null na pocetku stringa
                
                
                while (!eof){
                        line = inStream.readLine();
                        if (line != null){//citace prazne linije ""
                                //System.out.println("A line has been read!> " + String.valueOf(lineNo));
                                data += (line + "\n");
                                lineNo++;
                        }
                        else {
                                eof = true;
                        }
                }
                lines = data.split("\n");
                
                // REMOVE LAST \n
                lines[lines.length-1] = lines[lines.length-1].replace("\n", "");
                noEmptyLines();
                inStream.close();
                //in.close();


            }catch (IOException e){
                JOptionPane.showMessageDialog(null, "Error (greska)... " + e.toString());
            }
        
        
    }
    
    private void noEmptyLines (){
      String [] lines = this.lines.clone();//VAZNO OVO CLONE
    	
    	int nol = 0;
        for (int i = 0; i<lines.length;i++){
            if (lines[i].contains(":") && !lines[i].startsWith("#") ){
                //String [] tmp = lines[i].split(":",2);
                //if (tmp[1]!=null && !tmp[1].isEmpty()){
                    lines[nol]=lines[i];
                    nol++;
                //}
            }
        }
        goodLines = new String [nol];
        for (int i=0;i<nol;i++){
            goodLines[i]=lines[i];
        }
    }
    
    public String getData (){
        return data;
        
    }
    
    public String getLine (){
        if (i <= lineNo){
            return lines[i++];    
        }
        else {
            return null;  
        }
    }
    public String[] getLines(){
        return lines;
    }
    public String[] getGoodLines(){
        return goodLines;
    }
    
    
}
