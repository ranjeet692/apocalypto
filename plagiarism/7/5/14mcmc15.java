import java.util.*;
class Strings
{

	String s1,s2,s3,s4;
	Strings()
	{
	  this.s1="";
	  this.s2="";
	  this.s3="";
	  this.s4="";
	}

	Strings(String s)
	{
	 s1=s;
	}
	Strings(String s,String st)
	{
	 s1=s;
	 s2=st;
	}
	Strings(String s,String st,String str)
	{
	 s1=s;
	 s2=st;
	 s3=str;
	}
	Strings(String s,String st,String str,String sr)
	{
	 s1=s;
	 s2=st;
	 s3=str;
	 s4=sr;
	}
	public void palin(String s)
	{
	 String reverse = "";
 	     
	     int  len=s.length();
 	     for ( int i = len - 1; i >= 0; i-- )
 	        reverse = reverse + s.charAt(i);

 	     if (s.equals(reverse))
	         System.out.println("Entered string is a palindrome.");
	     else
         	System.out.println("Entered string is not a palindrome.");
	}

	public void equality(String s,String st)
	{
		if(s1.equals(s2))
		System.out.println("String Equal");
		else
		System.out.println("String Not Equal");
	}

	public void concatinate(String s,String st,String str)
	{
		System.out.println(s+" "+st+" "+str);
	}

	public void maxlen(String s,String st,String str,String sr)
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


public class StringFun
{
 public static void main(String args[])
  {
	int input;
	
	Scanner in=new Scanner(System.in);
	
	input=in.nextInt();

	if(input==1)
	{
		String a;
		a=in.nextLine();
		Strings ob1=new Strings(a);
		ob1.palin(a);
	}
	else if(input==2)
	{
		String a,b;
		a=in.nextLine();
		b=in.nextLine();
		Strings ob2=new Strings(a,b);
		ob2.equality(a,b);
	}
	else if(input==3)
	{
		String a,b,c;
		a=in.nextLine();
		b=in.nextLine();
		c=in.nextLine();
		Strings ob3=new Strings(a,b,c);
		ob3.concatinate(a,b,c);
	}
	else if(input==4)
	{
		String a,b,c,d;
		a=in.nextLine();
		b=in.nextLine();
		c=in.nextLine();
		d=in.nextLine();
		Strings ob4=new Strings(a,b,c,d);
		ob4.maxlen(a,b,c,d);
	}
  }
}
