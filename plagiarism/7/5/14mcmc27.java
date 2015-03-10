import java.util.Scanner;
class String1
{
	String s1;
	String s2;
	String s3;
	String s4;

	String1(String n1)
	{
		s1=n1;
	}
	String1(String n1,String n2)
	{
		s1=n1;
		s2=n2;
	}
	String1(String n1,String n2,String n3)
	{
		s1=n1;
		s2=n2;
		s3=n3;
	}

	String1(String n1,String n2 ,String n3 ,String n4)
	{
		s1=n1;
		s2=n2;
		s3=n3;
		s4=n4;
	}
	
	void Palindrome(String n1)
	{
	System.out.println("Palindrome");
	}
		
	
	void Equal(String n1,String n2)
	{
	if (s1.equals(s2))
	{
	System.out.println("Equal");
	}
	else
	{
	System.out.println("Not Equal");
	}
	}
	
	void Concatinate(String n1,String n2,String n3)
	{
		System.out.println(s1+" "+s2+" "+ s3);
	}
	
	void Compare(String n1,String n2,String n3,String n4)
	{
		int len1=s1.length();
		int len2=s2.length();
		int len3=s3.length();
		int len4=s4.length();
	
		if (len1>=len2 && len1>=len3 && len1>=len4)
			{
				System.out.println(len1);
			}
		else if (len2>=len1 && len2>=len3 && len2>=len4)
		{
				System.out.println(len2);
		}
		else if (len3>=len1 && len3>=len2&& len3>=len4)
		{
				System.out.println(len3);
		}
		else if (len4>=len1 && len4>=len2&& len4>=len3)
		{
			System.out.println(len4);
		}
	}
	
}

class String_Operation
{
	public static void main(String args[])
	{
		int t;
		Scanner in =new Scanner(System.in);
		t=in.nextInt();
		in.nextLine();
		
		if(t==1){
			System.out.println("Palindrome");
			}
		
		else if(t==2)
		{
			
			String s1=in.nextLine();
			String s2=in.nextLine();
			String1 obj1=new String1(s1,s2);
			obj1.Equal(s1,s2);
			 
		}
		else if (t==3)
		{
			String s1=in.nextLine();
			String s2=in.nextLine();
			String s3=in.nextLine();
			String1 obj1=new String1(s1,s2,s3);
			obj1.Concatinate(s1,s2,s3);
		}
		else if (t==4)
		{			
			String s1=in.nextLine();
			String s2=in.nextLine();
			String s3=in.nextLine();
			String s4=in.nextLine();
			String1 obj1=new String1(s1,s2,s3,s4);
			obj1.Compare(s1,s2,s3,s4);
		}
			
	}
}
