/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author mc14mc01
 */
import java.util.Scanner;
public class StringOps {

    private String st1;
    private String st2;
    private String st3;
    private String st4;
    
    
    
    /**
     * @param args the command line arguments
     */
    public StringOps(String st1){
        this.st1=st1;      
        palindrome1();
    }
    
    public StringOps(String st1,String st2){
        this.st1=st1;
        this.st2=st2; 
        compare2();
       
    }
    
     public StringOps(String st1,String st2,String st3){
        this.st1=st1;
        this.st2=st2;
        this.st3=st3;   
        concate3();
    }
    public StringOps(String st1,String st2,String st3,String st4){
        this.st1=st1;
        this.st2=st2;
        this.st3=st3;
        this.st4=st4;
        max_length4();
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
	sc.nextLine();        
        String[] arrs = new String[4];
        for(int i=0;i<choice;i++){
            arrs[i]=new String(sc.nextLine());            
        }
        StringOps test;
        switch (choice){
            case 1:
                test=new StringOps(arrs[0]);
                break;
            case 2:
                test= new StringOps(arrs[0],arrs[1]);
                break;
            case 3:
                test= new StringOps(arrs[0],arrs[1],arrs[2]);
                break;
            case 4:
                test= new StringOps(arrs[0],arrs[1],arrs[2],arrs[3]);
                break;
            default:
                System.out.println("Choice invalid");
                break;
        }
                       
                
        
    }        
        
    
    
    private void max_length4(){
        int max= st1.length();
        if(st2.length()>max){
            max=st2.length();
        }
        if(st3.length()>max){
            max=st3.length();
        }
        if(st4.length()>max){
            max=st4.length();
        }
        System.out.println(max);
    }
    
    private void concate3(){
        System.out.println(st1+" "+st2+" "+st3);
    }
    
    private void compare2(){
        if(st1.equals(st2)){
            System.out.println("Equal");
        }
        else{
            System.out.println("Not Equal");
        }
    }
    
    private Integer palindrome1(){
        int index;
        String lower = st1.toLowerCase(); 
        //System.out.println(lower);
        String[] parts=lower.split(" ");
        String onlychars="";
        for(int i=0;i<parts.length;i++){
            onlychars=onlychars.concat(parts[i]);
            //System.out.println(onlychars);
        }
        char[] matching = onlychars.toCharArray();
        //System.out.println(onlychars);
        for(int i=0;i<=(matching.length-1)/2;i++){
            if (matching[i]!=matching[matching.length-1-i]){
                System.out.println("Not Palindrome");
                return null;
            }
        }
        System.out.println("Palindrome");
        return 1;
    }
}
