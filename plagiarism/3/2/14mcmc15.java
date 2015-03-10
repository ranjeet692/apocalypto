// Program to print a string n number of times

import java.util.*;
class StringPrint
{
	public static void main(String args[])
	{
		
		Scanner a=new Scanner(System.in);
		
		int n=a.nextInt();
		if(n>0 && n<100)
			for(int i=0;i<n;i++)
				System.out.println("HELLO CODEMAFIA");
		else	
			System.out.println("!!! SORRY OUT OF LIMIT");
			
	}
}
