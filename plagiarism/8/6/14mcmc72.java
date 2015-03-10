import java.util.Scanner;
class San
{
	String s,t,u,v;
	San(String a)
	{
		s=a;
	}
	San(String a,String b)
	{
		s=a;
		t=b;	
	}
	San(String a,String b,String c)
	{
		s=a;
		t=b;
		u=c;	
	}
	San(String a,String b,String c,String d)
	{
		s=a;
		t=b;
		u=c;
		v=d;
	}
	void reverse(San x)
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
	void com(san y)
	{
		if(s.compareTo(t==0)
                     System.out.println("EQUAL");
                else
                   System.out.println("NOT EQUAL");
	}
	void con()
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
class main
{
	public static void main(String arg[])
	{
		Scanner sc= new Scanner(System.in);
                System.out.println("ENTER YOUR CHOICE(1-4)");
		int n=sc.nextInt();
		switch(n)
		{
			case 1: String b=sc.nextLine(); // for clearing buffer
				String a=sc.nextLine();
				San x=new San(a);
				x.reverse(x);
				break;	
			case 2: String c=sc.nextLine(); // for clearing buffer
				String d=sc.nextLine();
				String e=sc.nextLine();
				San y=new San(d,e);
				y.com(y);				
				break;	
			case 3: String f=sc.nextLine(); // for clearing buffer
				String g=sc.nextLine();
				String h=sc.nextLine();
				String i=sc.nextLine();
				San z=new San(g,h,i);
				z.con();
				break;	
			case 4: String j=sc.nextLine(); // for clearing buffer
				String k=sc.nextLine();
				String l=sc.nextLine();
				String m=sc.nextLine();
				String o=sc.nextLine();
				San p=new San(k,l,m,o);
				p.max();
				break;			
		}		
	}
}
