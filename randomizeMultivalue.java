/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stestgenerator;

/**
 *
 * @author dux
 */
public class randomizeMultivalue extends randomize {
    
    private boolean satisfied;
    private int bod2, bod5, bod10;
    int [] temp = new int [4];
    
    // brPitanjaUBazi,  brPitanjaUTestu,  brTestova, 4, nizVrednostiBodova
    public randomizeMultivalue (int b, int t, int nt, int abc, String bvn){
        calcRandoms (b,t,nt,abc,bvn);
        
    }
    public randomizeMultivalue (int b, int t, int nt, int abc, int[] bvn){
        calcRandoms (b,t,nt,abc,bvn);
        
    }
    
    public void calcRandoms (int B,int T, int noT,int Abcd, String bodValueNo){
        String [] tmp = bodValueNo.split(" ");
        int param [] = new int[tmp.length];
        
        for (int i = 0; i<tmp.length; i++){
            param[i] = Integer.valueOf(tmp[i]);
            //System.out.print(String.valueOf(param[i]));
        }
        calcRandoms(B,T,noT,Abcd,param);
    }

     public void calcRandoms (int B,int T, int noT,int Abcd, int[] bodValNo){
        /*String [] tmp = bodValueNo.split(" ");
        
        
        for (int i = 0; i<tmp.length; i++){
            param[i] = Integer.valueOf(tmp[i]);
        }*/
        
        int [] param = bodValNo;
        satisfied = false;
        
        setPitanjaUBazi (B);
        setPitanjaUTestu (T);
        setBrTestova (noT);
        setAbcd(4);
        niz1=new int [brPitanjaUTestu];//mora se zadati velicina niza
        niz2=new int [brTestova][brPitanjaUTestu];
        niz3 = new int [brTestova][brPitanjaUTestu][abcd];
        
        for (int tc = 0; tc<brTestova; tc++){
            bod2=0;
            bod5=0;
            bod10=0;
            
            for (int i = 0; i<brPitanjaUTestu;i++){
                boolean repetNum = false;
                satisfied = false;
                no=-1; // in case of exeption
                while (!satisfied){
                    repetNum = false;
                    no=rnum.nextInt(brPitanjaUBazi)+1;
                    
                    if (i==0){
                        satisfied = Satisfied(param[no-1]);  
                        //System.out.print(">");
                    }
                    else {
                        for (int j=0;j<i;j++){
                           if (no==niz1[j]){
                                repetNum=true;
                           }
                           //else {repetNum=false;}
                        }
                        if (repetNum == false){
                           satisfied = Satisfied(param[no-1]);
                        }
                        else {satisfied = false;}
                        
                    }
                    
                }
                niz1[i]=no;
                bodPluss(param[no-1]);
                //System.out.print(no);
                
                niz1[i]=no;
                niz2[tc][i]=niz1[i];
                temp = rand4();
                niz3[tc][i][0] = temp[0];
                niz3[tc][i][1] = temp[1];
                niz3[tc][i][2] = temp[2];
                niz3[tc][i][3] = temp[3];
                
                //System.out.print ("\t");
                
                /*
                satisfied = false;
                    //while(!satisfied){
                    OUTER:
                        
                        if (i==0){
                            no=rnum.nextInt(brPitanjaUBazi)+1;
                            niz1[0]=no;
                            System.out.print("prvi>");
                            Satisfied(param[no-1]);
                        }
                        else{
                            boolean goodBr=false;
                            while (!goodBr){
                                CHANGE:{
                                    no=rnum.nextInt(brPitanjaUBazi)+1;
                                    for (int j=0;j<i;j++){
                                        if (no==niz1[j]){
                                            goodBr=false;
                                            break CHANGE;

                                        }
                                    }
                                    if (!Satisfied(param [no-1])){
                                        goodBr=false;
                                        break OUTER;
                                    }
                                    goodBr=true;
                                   
                                }
                            }
                        }
                   // }//end of while
                //OUT:
                niz1[i]=no;
                temp = rand4();
                niz3[tc][i][0] = temp[0];
                niz3[tc][i][1] = temp[1];
                niz3[tc][i][2] = temp[2];
                niz3[tc][i][3] = temp[3];
                //System.out.print (String.valueOf(niz3[tc][i][0]));
                //System.out.print (String.valueOf(niz3[tc][i][1]));
                //System.out.print (String.valueOf(niz3[tc][i][2]));
                //System.out.print (String.valueOf(niz3[tc][i][3]));
                //System.out.print (" ");
                niz2[tc][i]=niz1[i];
                //System.out.print (String.valueOf(niz2[tc][i]) + "-" + String.valueOf(param[(niz1[i])-1]) +" ");
                //System.out.print(niz1[i]);
                
                */
                //System.out.print ("("+i+")");
            }   
            
        //System.out.println (" ");    
            
        }
        
    }
    
     
    private boolean Satisfied (int bodValue){
        if (bodValue ==2 && bod2<5){
            //bod2++;  
            //System.out.print(2);
            //satisfied=true; 
            return true;
        } 
  else if (bodValue == 5 && bod5<6){
            //bod5++;  
            //System.out.print(5);
            //satisfied=true; 
            return true;
        } 
	else if (bodValue==10 && bod10<4){
            //bod10++;  
            //System.out.print(10);
            //satisfied=true; 
            return true;
        } 
	else {return false;}	
    }
    
    private boolean bodPluss (int bodValue){
        if (bodValue ==2 && bod2<5){
            bod2++;  
            return true;
        } 
	else if (bodValue == 5 && bod5<6){
            bod5++;  
            return true;
        } 
	else if (bodValue==10 && bod10<4){
            bod10++;  
            return true;
        } 
	else {return false;}	
    }
    
    
}
