import java.util.*;
class Str
     
{
      String s1,s2,s3,s4;
    
       Str(String p)
       {
            s1 = p;
          
         }
         Str(String p,String q)
       {
            s1 = p;
           s2 = q;
          
         }
       Str(String p,String q,String r)
       {
           s1 = p;
           s2 = q;
            s3 = r;
         }
         Str(String p ,String q,String r,String s )
       {
           s1 = p;
            s2 = q;
            s3 = r;
           s4 = s;
         }
 void stro4()
       {
          String   sb = new String();
          String   mb = new String();
	  sb="";
          mb="";
           
          for(int i = s1.length()-1; i>= 0; i--) 
           {
             if(s1.charAt(i)!=' ')
                   mb =  mb + s1.charAt(i);
                else
                {
                    sb="";
                    mb="";
                   for(int k = 0;k< s1.length(); k++)
                     if(s1.charAt(k)!=' ')
                      sb =   sb + s1.charAt(k) ;
                     else
                     {
                      mb = sb +" "+ mb;
                      sb = "";
                      }
                 mb = sb +" "+ mb;
                 break;         
                 } 
                      
            }         
 
                  
            
 
             System.out.println(mb);
         }      
              
       void stro1()
           {
             if(s1.equals(s2))
             System.out.println("Equal");
          else
             System.out.println("Not Equal");
            }
       void stro2()
           {
              System.out.println(s1+" "+s2+" "+s3);
            }
       void stro3()
         {
             String s[] = new String[4];
             int i,lar = s1.length();
             s[0]=s1;
             s[1]=s2;
             s[2]=s3;
             s[3]=s4;
             for(i=1;i<4;i++)
                     if((s[i].length())>lar)
                      lar = s[i].length();
              System.out.println(lar);
           }
}
public class S {
    public static void main(String[] args)
  {
       Scanner get = new Scanner(System.in);
           String s1[] = new String[4] ;
       
           
       
      int i,n;
     n = get.nextInt();
     switch(n){
		case 1: get.nextLine();
                          for(i=0;i<n;i++)
              
                s1[i] = get.nextLine();
                  Str o = new Str(s1[0]);
                  o.stro4();
               
			 
			break;
		case 2: get.nextLine();
			 for(i=0;i<n;i++)
              
                s1[i] = get.nextLine();
                 Str o2 = new Str(s1[0],s1[1]);
                 o2.stro1();
               
			break;

		case 3:get.nextLine();
			 for(i=0;i<n;i++)
             
                s1[i] = get.nextLine();
                 Str o3 = new Str(s1[0],s1[1],s1[2]);
                o3.stro2();
			break;
		case 4:get.nextLine();
			 for(i=0;i<n;i++)
              
                  s1[i] = get.nextLine();
                  Str o4 = new Str(s1[0],s1[1],s1[2],s1[3]);
                  o4.stro3();
			break;
	 }
   }
 }
     
     
                        
