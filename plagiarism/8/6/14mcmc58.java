import java.util.Scanner;
class DUString
{	
	DUString()
	{
	
	}
	
	DUString(String S1)
	{
		int l;
		l=S1.length();
		if(S1.indexOf(' ')==-1)
		{
			char [] temp = new char[l];
			for(int i=0;i<l;i++)
				temp[i]=S1.charAt(l-i-1);
			System.out.println(temp);
		}
		else
		{
			char c;
			char [] temp = new char[l];
			int i,k,ti=0;
			int count=0;
			for(i=l-1;i>=0;i--)
			{
				c=S1.charAt(i);
				if(c==' ')
				{
					k=1;
					while(count!=0)
					{
						temp[ti++]=S1.charAt(i+k);
						k++;
						count--;
					}
					temp[ti++]=c;
				}
				else 
				{
					count++;
				}
			}
			while(count!=0)
			{
				temp[ti++]=S1.charAt(++i);
				count--;
			}
			System.out.println(temp);
		}	
	}

	DUString(String S1,String S2)
	{
		if(S1.equals(S2))
			System.out.println("Equal");
		else 
			System.out.println("Not Equal");
	}
	
	DUString(String S1,String S2,String S3)
	{
		System.out.println(S1+" "+S2+" "+S3);
	}

	DUString(String S1, String S2, String S3, String s4)
	{
		int l[]=new int[4];		
		l[0] = S1.length();
		l[1] = S2.length();
		l[2] = S3.length();
		l[3] = s4.length();

		int max=0;
		for(int i=1;i<4;i++)
		{
			if(l[max]<l[i])
				max=i;
		}
		System.out.println(l[max]);
	}
       

	
	public static void main(String args[])
	{	
		DUString str;
		int ch;
		Scanner in=new Scanner(System.in);
		
		ch=in.nextInt();
		in.nextLine();
		String S1,S2,S3,S4;
		S1=new String();
		S2=new String();
		S3=new String();
		S4=new String();
		switch(ch)
		{
			case 1:
				S1=in.nextLine();
				str=new DUString(S1);
				break;

			case 2:
				S1=in.nextLine();
				S2=in.nextLine();
				str=new DUString(S1,S2);
				break;

			case 3:
				S1=in.nextLine();
				S2=in.nextLine();
				S3=in.nextLine();
				
				str=new DUString(S1,S2,S3);
				break;

			case 4:
				
				S1=in.nextLine();
				S2=in.nextLine();
				S3=in.nextLine();
				S4=in.nextLine();
				str=new DUString(S1,S2,S3,S4);
				break;

		}
	}
}

