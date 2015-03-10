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
	void strrev(String str)
	{	
		int len=str.length();
		int len2=len;
		int i,j,x,c=0;
		char s1[]=new char[len+1];
        
		x=0;
		int a=0;
		for(j=(len-1); j>=0; j--)
		{
			if(str.charAt(j)==' ' || j==0)
			{
			    a++;
				c=j;
				while(c<len2)
				{
				    if(str.charAt(c)==' ')
				    {    
				        c++;
				        continue;
				    }
				    s1[x]=str.charAt(c);
				    c++;
				    x++;
				}
				s1[x++]=' ';
				len2=j;
			}
			
			

		}
        if(a!=1)
		for(i=0; i<len; i++)
		{
			System.out.print(s1[i]);
		}
		else
		for(i=len-1; i>=0; i--)
		{
			System.out.print(s1[i]);
		}
		    System.out.println();
		
	}
	
	void compare(String s1, String s2)
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
	
	void concatenate(String s1, String s2, String s3)
	{
		System.out.println(s1+" "+s2+" "+s3);
	}
	
	void maxlength(String s1,String s2,String s3,String s4)
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

class stringoperation
{
	public static void main(String args[])
	{
		Scanner ob=new Scanner(System.in);
		int n,i;
		String s1="",s2="",s3="",s4="";
		stropr obj=new stropr();
		n=ob.nextInt();
		if(n==1)
		{
			ob.nextLine();
			s1=ob.nextLine();
			obj.strrev(s1);
		}
		if(n==2)
		{
			ob.nextLine();
			s1=ob.nextLine();
			s2=ob.nextLine();
			obj.compare(s1,s2);
		}
		if(n==3)
		{
			ob.nextLine();
			s1=ob.nextLine();
			s2=ob.nextLine();
			s3=ob.nextLine();
			obj.concatenate(s1,s2,s3);
		}
		if(n==4)
		{
			ob.nextLine();
			s1=ob.nextLine();
			s2=ob.nextLine();
			s3=ob.nextLine();
			s4=ob.nextLine();
			obj.maxlength(s1,s2,s3,s4);
		}
		
		
	}
}
		
