import java.util.*;
import java.lang.*;
class Str
{
	String a=new String();
	
	Str()
	{
		a=null;
	}
	
	Str(String A)
	{
		a=A;
	}
	
	public void is_Palindrome()
	{
		
		int flag=0;
		a=a.replace(" ","");
		a=a.toLowerCase();
		
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i)!=a.charAt(a.length()-1-i))
				{
				
				flag=1;break;}
		}
			
			if(flag==0)
			System.out.println("Palindrome");
		else 
			System.out.println("Not Palindrome");
	}
			
}



class A2
{
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		String a;
		int n;
		n=input.nextInt();
		input.nextLine();
		
		if(n==1)
		{
			a=input.nextLine();
			Str s1=new Str(a);
			s1.is_Palindrome();
		}


}}
