import java.util.*;
import java.lang.*;

class operation
{
	public int i,j;
	public int a[]=new int[50];
	public void removedup(int a1[])
	{
		int c=0;
		for(i=0;i<a1.length;i++)
		{
			for(j=c-1;j>=0;j--)
			{
				if(a[j]==a1[i])
				{
					break;
				}
			}
				if(j<0)
			
				{
				a[c]=a1[i];
				c++;
				}
		}
		for(i=0;i<c;i++)
		{
			System.out.println(a[i]);
		}
				
	}
	
	public void unionset(int a1[],int a2[])
	{
		int c=0;
		for(i=0;i<a1.length;i++)
		{
			for(j=c-1;j>=0;j--)
			{
				if(a[j]==a1[i])
				{
					break;
				}
			}
			if(j<0)
			{
				a[c]=a1[i];
				c++;
			}

		}
	
		
		for(i=0;i<a2.length;i++)
		{
			for(j=c-1;j>=0;j--)
				{
					if(a[j]==a2[i])
					{
						break;
					}
				}
			if(j<0)
			{
				a[c]=a2[i];
				c++;
				
			}
		}
		for(i=0;i<c;i++)
		{
			System.out.println(a[i]);
		}


	}
	
	public void subtraction(int a1[],int a2[],int a3[])
	{
		int t1,t2,c=0;
		int temp1[]=new int[100];


	


		for(i=0,t1=0;i<a1.length;i++)
		{
			for(j=(t1-1);j>=0;j--)
			{
				if(temp1[j]==a1[i])
					break;
			}
			if(j<0)
			{
				temp1[t1]=a1[i];
				t1++;
			}
		}
		for(i=0;i<a2.length;i++)
		{
			for(j=(t1-1);j>=0;j--)
			{
				if(temp1[j]==a2[i])
					break;
			}
			if(j<0)
			{
				temp1[t1]=a2[i];
				t1++;
			}
		}

		int temp2[]=new int[50];

		//remove duplicates from third array

		for(i=0,t2=0;i<a3.length;i++)
		{	
			for(j=(t2-1);j>=0;j--)
			{
				if(temp2[j]==a3[i])
					break;
			}
			if(j<0)
			{	
				temp2[t2]=a3[i];
				t2++;
			}
		}


		//subtraction
		
		for(i=0,c=0;i<t1;i++)
		{
			for(j=(t2-1);j>=0;j--)
			{
				if(temp1[i]==temp2[j])
					break;
			}
			if(j<0)
			{
				a[c]=temp1[i];
				c++;
			}
		}

		for(i=0;i<c;i++)
		{
			System.out.println(a[i]);
		}
	
	}
}

class Setopr
{
	public static void main(String args[])
	{
		Scanner ob=new Scanner(System.in);
		int noa=ob.nextInt();
		int n;
		operation obj=new operation();
		int i;
		if(noa==1)
		{
			n=ob.nextInt();
		int a1[]=new int[n];
		
			for(i=0;i<n;i++)
			{
			a1[i]=ob.nextInt();
			}
			obj.removedup(a1);
		}
		else if(noa==2)
		{n=ob.nextInt();
		int a1[]=new int[n];
			for(i=0;i<n;i++)
			{
			a1[i]=ob.nextInt();
			}
		n=ob.nextInt();
		int a2[]=new int[n];
			for(i=0;i<n;i++)
			{
			a2[i]=ob.nextInt();
			}
		obj.unionset(a1,a2);
		}
		else
		{n=ob.nextInt();
			int a1[]=new int[n];
			for(i=0;i<n;i++)
			{
			a1[i]=ob.nextInt();
			}
		n=ob.nextInt();
		int a2[]=new int[n];
			for(i=0;i<n;i++)
			{
			a2[i]=ob.nextInt();
			}
		n=ob.nextInt();
		int a3[]=new int[n];
			for(i=0;i<n;i++)
			{
				a3[i]=ob.nextInt();
			}
		obj.subtraction(a1,a2,a3);
		}
			
	}
}
		
		 
