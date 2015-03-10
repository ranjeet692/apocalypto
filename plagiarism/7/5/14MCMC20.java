import java.util.*;
class stropr
{
	String str1,str2,str3,str4;
	stropr()
	{
	}	
	stropr(String s1)
	{
		str1=s1;
	}
	stropr(String s1,String s2)
	{
		str1=s1;
		str2=s2;
	}
	stropr(String s1,String s2,String s3)
	{
		str1=s1;
		str2=s2;
		str3=s3;
	}
	stropr(String s1,String s2,String s3,String s4)
	{
		str1=s1;
		str2=s2;
		str3=s3;
		str4=s4;
	}	
	public void palindrome(String str)
	{	
		int len=str.length();
		int i,j;
		char s[]=new char[len];
		char s1[]=new char[len];
		for(i=0,j=(len-1);j>=0;i++,j--)
		{
			if(str.charAt(j)==' ')
				i--;
			else
				s[i]=str.charAt(j);
		}
		for(i=0,j=0;i<len;i++,j++)
		{
			if(str.charAt(i)==' ')
				j--;
			else
				s1[j]=str.charAt(i);
		}
		len=j;
		for(i=0;i<len;i++)
		{
			if(s1[i]!=s[i])
			{
				System.out.println("Not Palindrome");
				break;
			}
		}
		if(i==len)
			System.out.println("Palindrome");
	}
	
	public void compare(String s1, String s2)
	{
		if(s1.equals(s2))
		{
			System.out.println("Equal");
		}
		else
		{
			System.out.println("Not Equal");
		}
	}
	
	public void concatenate(String s1, String s2, String s3)
	{
		System.out.println(s1+" "+s2+" "+s3);
	}
	
	public void maxlength(String s1,String s2,String s3,String s4)
	{
		int l1=s1.length();
		int l2=s2.length();
		int l3=s3.length();
		int l4=s4.length();
		if((l1>l2)&&(l1>l3)&&(l1>l4))
			System.out.println(l1);
		else if((l2>l1)&&(l2>l3)&&(l2>l4))
			System.out.println(l2);
		else if((l3>l1)&&(l3>l2)&&(l3>l4))
			System.out.println(l3);
		else
			System.out.println(l4);
	}	
}

class stroperation
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n,i;
		String s1="",s2="",s3="",s4="";
		stropr obj=new stropr();
		n=in.nextInt();
		if(n==1)
		{
			in.nextLine();
			s1=in.nextLine();
			obj.palindrome(s1);
		}
		if(n==2)
		{
			in.nextLine();
			s1=in.nextLine();
			s2=in.nextLine();
			obj.compare(s1,s2);
		}
		if(n==3)
		{
			in.nextLine();
			s1=in.nextLine();
			s2=in.nextLine();
			s3=in.nextLine();
			obj.concatenate(s1,s2,s3);
		}
		if(n==4)
		{
			in.nextLine();
			s1=in.nextLine();
			s2=in.nextLine();
			s3=in.nextLine();
			s4=in.nextLine();
			obj.maxlength(s1,s2,s3,s4);
		}
		
		
	}
}
		
