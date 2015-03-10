import java.util.*;
import java.lang.math.*;
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
		int len1=s1.length();
		int len2=s2.length();
		int len3=s3.length();
		int len4=s4.length();
		int len=math.max(len1,len2);
		int res=math.max(len,len3);
		int res1=math.max(res,len4);
		System.out.println("LENGTH OF THE LARGEST STRING IS:-"+res1);
	}
	void str(String s1)
	{
		StringBuffer a= new StringBuffer(s1);
		String s2=s1.reverse();
		System.out.println("REVERSE STRING IS:"+s2);
		int compString Operations
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
		string s=new string();
		Scanner input=new Scanner(System.in);
		System.out.println("ENTER THE NUMBER OF STRINGS YOU WANT TO ENTER:");
		n=input.nextInt();
		for(int i=0;i<n;i++)
		{
			s.input();
