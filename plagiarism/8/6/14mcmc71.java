import java.util.Scanner;
class String_op
{
	String s,t,u,v;
	String_op(String a)
	{
		s=a;
	}
	String_op(String a,String b)
	{
		s=a;
		t=b;	
	}
	String_op(String a,String b,String c)
	{
		s=a;
		t=b;
		u=c;	
	}
	String_op(String a,String b,String c,String d)
	{
		s=a;
		t=b;
		u=c;
		v=d;
	}
	void reverse(String_op x)
	{
		CharSequence a=" ";
		boolean f=x.s.contains(a);
		if(f)
		{
				 			
		} 
		else
		{
			int len = x.s.length();
       			char[] tempCharArray = new char[len];
        		char[] charArray = new char[len];
		        for (int i = 0; i < len; i++) 
			{
			        tempCharArray[i] = 
		                x.s.charAt(i);
        		} 
        		for (int j = 0; j < len; j++)
			{
            			charArray[j] =
                		tempCharArray[len - 1 - j];
        		}
        
        		String rev =new String(charArray);
        		System.out.println(rev);			
		}
	}
	void compare(String_op x)
	{
		boolean b= x.s.equals(x.t);
		if(b)
			System.out.println("Equal");
		else
			System.out.println("Not Equal");
	}
	void concat()
	{
		String x=s+" "+t+" "+u;	
		System.out.println(x);
	}
	void max()
	{
		int l=s.length();
		int m=t.length();
		int n=u.length();
		int o=v.length();	
		if(l>=m&&l>=n&&l>=o)
			System.out.println(l);
		else if(m>=n&&m>=o&&m>=l)
			System.out.println(m);	
		else if(n>=o&&n>=m&&n>=l)
			System.out.println(n);	
		else
			System.out.println(o);	
	}
}
class test3
{
	public static void main(String arg[])
	{
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		switch(n)
		{
			case 1: String b=sc.nextLine(); // for clearing buffer
				String a=sc.nextLine();
				String_op x=new String_op(a);
				x.reverse(x);
				break;	
			case 2: String c=sc.nextLine(); // for clearing buffer
				String d=sc.nextLine();
				String e=sc.nextLine();
				String_op y=new String_op(d,e);
				y.compare(y);				
				break;	
			case 3: String f=sc.nextLine(); // for clearing buffer
				String g=sc.nextLine();
				String h=sc.nextLine();
				String i=sc.nextLine();
				String_op z=new String_op(g,h,i);
				z.concat();
				break;	
			case 4: String j=sc.nextLine(); // for clearing buffer
				String k=sc.nextLine();
				String l=sc.nextLine();
				String m=sc.nextLine();
				String o=sc.nextLine();
				String_op p=new String_op(k,l,m,o);
				p.max();
				break;			
		}		
	}
}
