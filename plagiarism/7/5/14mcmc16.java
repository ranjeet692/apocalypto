import java.util.*;
import java.lang.*;
class str1{
 
String a;
String b;
String c;
String d;
	str1(String A)
	{
		a=A;
	}
        str1(String A ,String B)
	{
		a=A;
		b=B;
	}
	str1(String A,String B, String C)
	{
		a=A;
		b=B;
		c=C;
		
	}
	str1(String A, String B ,String C, String D)
	{
		a=A;
		b=B;
		c=C;
		d=D;
	}
public void palindrom(String A)
	{
	
	int flag=0;
		a=a.replace(" ","");
		a=a.toLowerCase();
		
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i)!=a.charAt(A.length()-1-i))
				{
				
				flag=1;break;}
				}
			
			if(flag==0)
			System.out.println("Palindrome");
			else 
			System.out.println("Not Palindrome");
		}


       
public void equal(String A, String B){     
	if(a.equalsIgnoreCase(b))
	{
	System.out.println("Equal");
	}
		
	else
	{
	System.out.println("Not Equal");
	}
					}

public void concat(String A, String B, String C){
	System.out.println(a+" "+b+" "+C);
						}
public void length(String A, String B , String C , String D){
        int l1=a.length();
	int l2=b.length();
	int l3=c.length();
	int l4=d.length();

if(l1>=l2 && l1>=l3 && l1>=l4)
	{
	System.out.println(l1);
	}
else if(l2>=l1 && l2>=l3 && l2>=l4)
	{
	System.out.println(l2);
	}
else if(l3>=l1 && l3>=l2 && l3>=l4)
	{
	System.out.println(l3);
	}
else {
	System.out.println(l4);
     }
}
}

class str{
public static void main(String arg[]){
	Scanner in =new Scanner(System.in);
	String x;
	int n;
	n=in.nextInt();
	in.nextLine();

	if(n==1){
	System.out.println("Palindrome");
	         } 
	else if(n==2){
	String a=in.nextLine();
	String b=in.nextLine();
	str1 o1= new str1(a,b);
	o1.equal(a,b);	
			}
	else if(n==3){
	String a=in.nextLine();
	String b=in.nextLine();
	String c=in.nextLine();
	str1 o3= new str1(a,b,c );
	o3.concat(a,b,c);
		     }
	else if(n==4){
	String a=in.nextLine();
	String b=in.nextLine();
	String c=in.nextLine();
	String d=in.nextLine();
	str1 o4 =new str1(a,b,c,d);
	o4.length(a,b,c,d);
			}

			}
}			



