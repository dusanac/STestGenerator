/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stestgenerator;

import java.util.Random;
/**
 *
 * @author dux
 */
public class randomize extends testNumerData {
    
    Random rnum = new Random();
    //brTestova = 30;//defoult value
    //abcd = 4;//defoult value
    protected int [] niz1;
    protected int [][] niz2;
    protected int [][][] niz3;
    
    

    protected int no;//temp variable
    
    // PARAMETRI:
    // brPitanjaUBazi,  brPitanjaUTestu,  brTestova, 4, nizVrednostiBodova
    public randomize(){
        
    }
    public randomize (int brB, int brT){
        calcRandoms(brB,brT);
    }
    
    // primjenjiva za simple test (miksa samo pitanja)
    // brPitanjaUBAzi, brPitanjaUTestu, brTestova
    public randomize (int b, int t, int test){
        calcRandoms (b,t,test);
    }
    public randomize (int b, int t, int test,int Abcd){
        calcRandoms (b,t,test,Abcd);
    }
    
    
    
    public void calcRandoms (){
        niz1=new int [brPitanjaUTestu];//mora se zadati velicina niza
        niz2=new int [brTestova][brPitanjaUTestu];
        niz3 = new int [brTestova][brPitanjaUTestu][abcd];
        
        for (int tc = 0; tc<brTestova; tc++){
            for (int i = 0; i<brPitanjaUTestu;i++){
                if (i==0){
                    niz1[0]=rnum.nextInt(brPitanjaUBazi)+1;
                }
                else{
                    boolean goodBr=false;
                    while (!goodBr){
                        change:{

                            no = rnum.nextInt(brPitanjaUBazi)+1;
                            for (int j=0;j<i;j++){
                                if (no==niz1[j]){
                                    goodBr=false;
                                    break change;

                                }
                            }
                            goodBr=true;
                            niz1[i]=no;
                        }
                    }
                }
                int [] temp = new int [4];
                temp = rand4();
                niz3[tc][i] = temp;
                niz2[tc][i]=niz1[i];
                //System.out.print (String.valueOf(niz2[tc][i]) + "-"+String.valueOf(niz3[tc][i][0])+" ");
            }   
            //System.out.println ("");
           
        }
    }//end of fungction
    
    public void calcRandoms (int brPitUBazi,int brPitUTestu){
        
        setPitanjaUBazi (brPitUBazi);
        setPitanjaUTestu (brPitUTestu);
        calcRandoms();
        
    }
    public void calcRandoms(int B,int T,int noTests){
        setBrTestova (noTests);
        calcRandoms (B,T);
        //abcd = noChoice;//for future inplementation
        
        
    }
    public void calcRandoms (int B,int T, int noT,int Abcd){
        //upotrebljivo ako su sva abcd pritanja isto rangirana
        
        setAbcd(Abcd);
        calcRandoms(B,T,noT);
        
    }
   
    public int[] rand4() {
         int [] tmp = new int[4];
         int sl;
         
         for (int i =0; i<4; i++){
           
                if (i==0){
                    tmp[i]=rnum.nextInt(4)+1;
                   
                }
                else {
                    boolean dobBr = false;
                    while (!dobBr){
                        OUT:{
                            sl = rnum.nextInt(4)+1;
                            for (int j=0; j<i;j++){
                                if (tmp[j] == sl){
                                    dobBr=false;
                                    break OUT;
                                }
                            }

                            dobBr = true;
                            tmp[i] = sl;
                            
                        }

                }

              
            }
         //System.out.print(String.valueOf(tmp[i]));
         
         }
         //System.out.print(" ");
         return tmp;
    }
    
    
    public int [] getNiz1(){
        return niz1;
    }
    public int [][] getNiz2(){//brTesta  brPitanjUTestu
        return niz2;
    }
    public int [][][] getNiz3(){//brTesta  brPitanjUTestu  ABCD
        return niz3;
    }
}
