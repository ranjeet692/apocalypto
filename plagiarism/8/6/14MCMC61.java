import java.util.Scanner;
class MyString
{
	int n;
	String [] str;
	MyString()
	{
		
	}
	MyString(int t)
	{
		n=t;
		str=new String[n];
	}
	void perform_operation()
	{
		switch(n)
		{
			case 1:
				int l;
				l=str[0].length();
				if(str[0].indexOf(' ')==-1)
				{
					
					char [] temp = new char[l];
					for(int i=0;i<l;i++)
						temp[i]=str[0].charAt(l-i-1);
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
						c=str[0].charAt(i);
						if(c==' ')
						{
							k=1;
							while(count!=0)
							{
								temp[ti++]=str[0].charAt(i+k);
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
						temp[ti++]=str[0].charAt(++i);
						count--;
					}
					System.out.println(temp);
					
				}
				break;
			case 2:
				if(str[0].equals(str[1]))
					System.out.println("Equal");
				else
					System.out.println("Not Equal");
				break;
			case 3:
				System.out.println(str[0]+" "+str[1]+" "+str[2]);
				break;
			case 4:
				int ls[];
				ls=new int[4];
				int i;
				for(i=0;i<n;i++)
					ls[i]=str[i].length();
				int max=0;
				for(i=1;i<4;i++)
				{
					if(ls[max]<ls[i])
						max=i;
				}
				System.out.println(ls[max]);
				break;
		}
	}
	public static void main(String arg[])
	{
		Scanner in = new Scanner(System.in);
		
		int t=in.nextInt();
		in.nextLine();
		MyString strings=new MyString(t);
		for(int i=0;i<t;i++)
			strings.str[i]=in.nextLine();
		strings.perform_operation();
		
	}
}
