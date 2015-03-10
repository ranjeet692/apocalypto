import java.util.Scanner;

class Operators
{
	String str1,str2,str3,str4;
	
	Operators()
	{
	}
	Operators(String s)
	{
		str1=s;
	}

	Operators(String s1,String s2)
	{
		str1=s1;
		str2=s2;
	}	

	Operators(String s1,String s2,String s3)
	{
		str1=s1;
		str2=s2;
		str3=s3;
	}

	Operators(String s1,String s2,String s3,String s4)
	{
		str1=s1;
		str2=s2;
		str3=s3;
		str4=s4;
	}

	public void palindrome(String s)
	{
		int i,j,len,sz=0;
		len=s.length();
		for(i=0;i<len;i++)
		{
			if(s.charAt(i)==' ');
			else
				sz++;
		}
		char str[]=new char[sz];
		char temp[]=new char[sz];

		for(i=0,j=0;i<len;j++,i++)
		{
			if(s.charAt(i)!=' ')
				temp[i]=s.charAt(i);
		}
		for(i=0,j=sz-1;i<sz;j--,i++)
		{
			str[j]=temp[i];
		}
		
		
		for(i=0;i<sz;i++)
		{
		
			if(str[i]==temp[i]);
			else
			{
				System.out.println("Not Palindrome");
				break;
			}
		}
		if(i==sz)
			System.out.println("Palindrome");
	}

	public void equal(String s1,String s2)
	{

	    int i,l1,l2;
		l1=s1.length();
		l2=s2.length();
		
		if(l1==l2)
		{
			for(i=0;i<l1;i++)
			{
				if(s1.charAt(i)==s2.charAt(i));
				else
				{
					System.out.println("Not Equal");
					break;
				}
			}
			if(i==l1)
			   System.out.println("Equal");
		}
		else
			System.out.println("Not Equal");
	}

	public void concat(String s1,String s2,String s3)
	{
		System.out.println(s1+" "+s2+" "+s3);
	}

	public void maximum(String s1,String s2,String s3,String s4)
	{
		int l1,l2,l3,l4;
		l1=s1.length();
		l2=s2.length();
		l3=s3.length();
		l4=s4.length();

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


public class Test
{
 public static void main(String args[])
 {
	int input;
	Operators ob=new Operators();
	Scanner in=new Scanner(System.in);
	
	input=in.nextInt();

	if(input==1)
	{
		String a;
		in.nextLine();
		a=in.nextLine();
		ob.palindrome(a);
	}
	else if(input==2)
	{
		String a,b;
		in.nextLine();
		a=in.nextLine();
		b=in.nextLine();
		ob.equal(a,b);
	}
	else if(input==3)
	{
		String a,b,c;
		in.nextLine();
		a=in.nextLine();
		b=in.nextLine();
		c=in.nextLine();
		ob.concat(a,b,c);
	}
	else if(input==4)
	{
		String a,b,c,d;
		in.nextLine();
		a=in.nextLine();
		b=in.nextLine();
		c=in.nextLine();
		d=in.nextLine();
		ob.maximum(a,b,c,d);
	}
 }
}
