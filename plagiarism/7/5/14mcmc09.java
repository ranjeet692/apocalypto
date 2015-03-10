import java.util.*;
import java.lang.Math.*;
class string
{
	void input(int n)
	{
		String a;
		Scanner input= new Scanner(System.in);
		System.out.println("ENTER A STRING:");
		a=input.nextLine();
		System.out.println("STRING ENTERED IS:"+a);
	}
	void str(String s1,String s2,String s3,String s4)
	{
		double len1=s1.length();
		double len2=s2.length();
		double len3=s3.length();
		double len4=s4.length();
		double len=Math.max(len1,len2);
		double res=Math.max(len,len3);
		double res1=Math.max(res,len4);
		System.out.println("LENGTH OF THE LARGEST STRING IS:-"+res1);
	}
	void str(String s1)
	{
		StringBuffer a= new StringBuffer(s1);
		String s2=a.reverse();
		System.out.println("REVERSE STRING IS:"+s2);
		int comp
			= s2.compareTo(s1);
		if(comp==0)
		{
			System.out.println("STRING IS A PALLINDROME");
		}
		else
		{
			System.out.println("STRING IS NOT A PALLINDROME");
		}
	}
	void str(String s1, String s2)
	{
		int comp=s2.compareTo(s1);
		if(comp==0)
		{
			 System.out.println("EQUAL");
		}
		else
		{
			 System.out.println("NOT EQUAL");
		}
	}
	void str(String s1,String s2, String s3)
	{
		s1=s1.concat(s2);
		s1=s1.concat(s3);
		System.out.println("CONCATENATED STRING IS:"+s1);
	}

}

class string1
{
	public static void main(String args[])
	{
		int n;
		String h[]=new String[5];
		string s=new string();
		Scanner input=new Scanner(System.in);
		System.out.println("ENTER THE NUMBER OF STRINGS YOU WANT TO ENTER:");
		n=input.nextInt();
		for(int i=0;i<n;i++)
		{
			h[i]=input.nextLine();
		}

		if(n==1)
		{
			s.str(h[0]);
		}

	else
		if(n==2)
		{
			s.str(h[0],h[1]);
		}
		else
			if(n==3)
			{
				s.str(h[0],h[1],h[2]);
			}
			else
				if(n==4)
				{
					str(h[0],h[1],h[2],h[3]);
				}

	}
}




