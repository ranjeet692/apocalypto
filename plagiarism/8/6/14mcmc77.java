import java.util.Scanner;
import java.io.InputStream;
class Fun1
{
                String[] s = new String[4];
                 int  n1;
               Fun1()
                 {
                  Scanner in = new Scanner(System.in);
                   n1=in.nextInt();
                  int i;
                  s[0] = in.nextLine();
                  for(i=0;i<n1;i++)
                  {
                      s[i] = in.nextLine();
                  } 
                  }
                  
                 
                  void strfunction(String s1)
                {
                      String palindrome, reverse="";
                    palindrome = s1;
                        int length=palindrome.length();
                        for(int i = length - 1;i>=0;i--)
                                reverse = reverse + palindrome.charAt(i);
                        if(palindrome.equals(reverse))
                                System.out.println("palindrome");
                        else
                                System.out.println("not palindrome");
                }
                    void strfunction (String s1 ,String s2)
                {
                    String n1,n2;
                  n1=s1;
                  n2= s2;
                if(n1.compareTo(n2)>0||n1.compareTo(n2)<0)

                        System.out.println("Equal");
                else
                        System.out.println("Not Equal");


                 } 
                 void  strfunction (String s1 ,  String s2, String s3)
                 {
                    System.out.println(s1+s2+s3);
                 }
                  void  strfunction (String s1 ,String s2, String s3,  String s4)
                 {
                        String[] arr=new String[4];
                         arr[0] = s1;
                          arr[1] = s2;
                           arr[2] = s3;
                            arr[3] = s4;
                      String n="";   
                  for(int i=0;i<3;i++)
		{
			
			if(arr[i].length()>arr[i+1].length() )
			{
				n=arr[i];
			}
		}
	System.out.println("Max string is : - "+n);
	}
}

class Assignment2
{
     public static void main(String[] args)
	{
           Fun1  obj =new Fun1();
             if(obj.n1==1)
          obj.strfunction (obj.s[0]);
             else if  (obj.n1==2)
          obj.strfunction (obj.s[0],obj.s[1]);
              else if  (obj.n1==3)
          obj.strfunction (obj.s[0],obj.s[1],obj.s[2]);
              else if  (obj.n1==4)
           obj.strfunction (obj.s[0],obj.s[1],obj.s[2],obj.s[3]);
     }    
              }       
