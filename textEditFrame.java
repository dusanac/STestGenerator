// OVO JE KALUP ZA IZRADU JEDNOSTAVNIH TEKST EDITORA KOJI KOMUNICIRAJU SA FAJLOVIMA
// this (imeFajla, upustvoLabel)

package stestgenerator;

import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.*;
//import java.awt.*;
import java.io.*;
//import java.util.Scanner;
//import java.io.File;

        
public class textEditFrame extends JFrame implements ActionListener{
     
    JButton Ok = new JButton ("OK");
    JTextArea Tekst = new JTextArea(20,50);
    
    private String fileName;
    JLabel l1 = new JLabel("Edit text and press OK to store it!");
    
    
    
        public textEditFrame(String filename){
            
            
            super ("Simple words editor");
            setBounds (400,200,580,420);
            this.setResizable (false);
            //System.setProperty("user.dir", "/home/STestGenerator");
            //System.setProperty("user.home", "/home/STestGenerator");
            //this.setIconImage(Toolkit.getDefaultToolkit().getImage("images\\mylogo.png"));
            //System.setProperty("user.dir", System.getProperty("user.home")+"/STestGenerator");
            //System.out.println(System.getProperty("user.dir"));
            //System.out.println(System.getProperty("user.home"));
            
            fileName = System.getProperty("user.dir")+File.separatorChar+filename;
            getFileText(this.fileName);
            JPanel panel = new JPanel ();
            Ok.addActionListener(this);
            
            panel.add(l1);
            panel.add(Tekst);
            
            Tekst.setLineWrap(true);
            Tekst.setWrapStyleWord(true);
            
            //ubacivanje skrol bara
            JScrollPane scrollPane = new JScrollPane(Tekst);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            panel.add(scrollPane);
            
            panel.add(Ok);
            
            
            setContentPane(panel);
            setIconImage(Toolkit.getDefaultToolkit().getImage("stg128x128.png"));
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setVisible(true);
        }
        
        public textEditFrame(String fnm, String labelText){   
            this (fnm);
            l1.setText(labelText);
            
        }
        public void actionPerformed(ActionEvent evt){
             setFileText(fileName);
             this.setVisible(false);
             
        }
        
        public void setFileText(String fileName){
            try {
  	//FileWriter out = new FileWriter(fileName);
		//BufferedWriter outStream = new BufferedWriter (out);
                
                BufferedWriter outStream = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
		
                
                
                Tekst.write(outStream);//upisuje u file
		
		outStream.close();
		//out.close();
		
		
            }catch (IOException e){
                
		JOptionPane.showMessageDialog(null, "Error... " + e.toString());
            }
        }
        public void getFileText(String fileName){
            try {
		//Scanner in = new Scanner(new FileInputStream(fileName), "UTF-8");
                //FileReader in = new FileReader(fileName);
		//BufferedReader inStream = new BufferedReader (in);
		BufferedReader inStream = new BufferedReader(
                     new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

                
		boolean eof = false;
		String line;
		while (!eof){
			line = inStream.readLine();
			if (line != null){
				Tekst.append(line + "\n");
                                
			}
			else {
				eof = true;
			}
		}
		
		inStream.close();
		//in.close();
		
		
            }catch (IOException e){
		//JOptionPane.showMessageDialog(null, "Error (greska)... " + e.toString());
                if (e.getMessage().equals("fileNotFound")){
                    JOptionPane.showMessageDialog(null, "Would you like to open the file !!!" + e.toString());
                }//should be finnished
		JOptionPane.showMessageDialog(null, "Would you like to create the file ?");
            }
            
        }
  

}
