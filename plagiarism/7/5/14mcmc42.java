import java.util.Scanner;
 class Opr
{
		String s1,s2,s3,s4;
		Opr()
		{
		}
		Opr(String str1)
		{
			s1=str1;
		}
		
		Opr(String str1,String str2)
		{
			s1=str1;
			s2=str2;
		}
		
		Opr(String str1,String str2,String str3)
		{
			s1=str1;
			s2=str2;
			s3=str3;
		}
		Opr(String str1,String str2,String str3,String str4)
		{
			s1=str1;
			s2=str2;
			s3=str3;
			s4=str4;
		}

		public void palin(String str1)
		{
 			
			/*int i,j;
			int len=str1.length();
			char temp[]= new  char[len];
			for(i=0,j=len-1;i<len;i++,j--)
			{
				temp[j]=str1.charAt(i);
			}
			for(i=0;i<len;i++)
			{
				if(temp[i]==str1.charAt(i));
				else
				{
					System.out.println("Not palindrom");
					break;
				}
			}
			if(i==len)
			{
				System.out.println("Palindrome");
			}*/
			int len=str1.length();
		int i,j;
		char s[]=new char[len];
		char s1[]=new char[len];
		for(i=0,j=(len-1);j>=0;i++,j--)
		{
			if(str1.charAt(j)==' ')
				i--;
			else
				s[i]=str1.charAt(j);
		}
		for(i=0,j=0;i<len;i++,j++)
		{
			if(str1.charAt(i)==' ')
				j--;
			else
				s1[j]=str1.charAt(i);
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

		public void equal(String str1,String str2)
		{
			if(str1.equals(str2))
		
			System.out.println("Equal");
		
		else
		
			System.out.println("Not Equal");
		
		}

		public void concate(String str1,String str2,String str3)
		{
			System.out.println(str1+" "+str2+" "+str3);
		}
		public void maximum(String str1,String str2,String str3,String str4)
		{
			int l1,l2,l3,l4;
			l1=str1.length();
			l2=str2.length();
			l3=str3.length();
			l4=str4.length();
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

class Stropr
{
	public static void main(String args[])
	{
	Scanner obj=new Scanner(System.in);
	Opr ob=new Opr();
	int in=obj.nextInt();
	if(in==1)
	{
		String a1;
		obj.nextLine();
		a1=obj.nextLine();
	
		ob.palin(a1);
	}
	else if(in==2)
	{
		String a1,a2;
		obj.nextLine();
		a1=obj.nextLine();
		//obj.nextLine();
		a2=obj.nextLine();
		
		ob.equal(a1,a2);
	}
	else if(in==3)
	{
		String a1,a2,a3;
		obj.nextLine();
		a1=obj.nextLine();
		a2=obj.nextLine();
		a3=obj.nextLine();
		
		ob.concate(a1,a2,a3);
	}
	else
	{
		String a1,a2,a3,a4;
		obj.nextLine();
		a1=obj.nextLine();
		a2=obj.nextLine();
		a3=obj.nextLine();
		a4=obj.nextLine();
		
		ob.maximum(a1,a2,a3,a4);
	}
	}
}
		
		
	
				
				
				
				
				
			
			
			
		
        
