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
	
	public void is_equals(Str A)
	{
		if(a.equalsIgnoreCase(A.a))
			System.out.println("Equal");
		else 
			System.out.println("Not Equal");
	}
	
	public String get_concat(Str A, Str B)
	{
		String C=a+" "+A.a+" "+B.a;
		return C;
	}
	
	public void length1()
	{
		System.out.println(a.length());
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
		if(n==2)
		{
			a=input.nextLine();
			Str s1=new Str(a);
			a=input.nextLine();
			Str s2=new Str(a);
			s1.is_equals(s2);
		}
		if(n==3)
		{
			a=input.nextLine();
			Str s1=new Str(a);
			a=input.nextLine();
			Str s2=new Str(a);
			a=input.nextLine();
			Str s3=new Str(a);	
			System.out.println(s1.get_concat(s2,s3));
		}
		if(n==4)
		{
			a=input.nextLine();
			Str s1=new Str(a);
			a=input.nextLine();
			Str s2=new Str(a);
			a=input.nextLine();
			Str s3=new Str(a);	
			a=input.nextLine();
			Str s4=new Str(a);	
			if(s1.a.length()>s2.a.length())
			{
				if(s1.a.length()>s3.a.length())
				{
					if(s1.a.length()>s4.a.length())
					{
						s1.length1();
					}
					else
					{
						s4.length1();
					}
				}
				else
				{
					if(s3.a.length()>s4.a.length())
					{
						s3.length1();
					}
					else
					{
						s4.length1();
					}
				}
			}
			else
			{
				if(s2.a.length()>s3.a.length())
				{
					if(s2.a.length()>s4.a.length())
					{
						s2.length1();
					}
					else
					{
						s4.length1();
					}
				}
				else
				{
					if(s3.a.length()>s4.a.length())
					{
						s3.length1();
					}
					else
					{
						s4.length1();
					}
				}
				
		      }
		}
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
