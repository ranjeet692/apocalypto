import java.util.*;
import java.lang.*;

class Input
{
	public int temp[]=new int[100];
	public int i,j,t;
	public void rem(int x[])
	{
		for(i=0,t=0;i<x.length;i++)
		{	
			for(j=(t-1);j>=0;j--)
			{
				if(temp[j]==x[i])
					break;
			}
			if(j<0)
			{	
				temp[t]=x[i];
				t++;
			}
		}
		for(i=0;i<t;i++)
		{
			System.out.println(temp[i]);
		}
	}

	public void uni(int x[],int y[])
	{
		for(i=0,t=0;i<x.length;i++)
		{
			for(j=(t-1);j>=0;j--)
			{
				if(temp[j]==x[i])
					break;
			}
			if(j<0)
			{
				temp[t]=x[i];
				t++;
			}
		}
		for(i=0;i<y.length;i++)
		{
			for(j=(t-1);j>=0;j--)
			{
				if(temp[j]==y[i])
					break;
			}
			if(j<0)
			{
				temp[t]=y[i];
				t++;
			}
		}
		for(i=0;i<t;i++)
		{
			System.out.println(temp[i]);
		}
	}
	
	public void subtract(int x[],int y[],int z[])
	{
		int t1,t2;
		int temp1[]=new int[100];


		//union of first two arrays


		for(i=0,t1=0;i<x.length;i++)
		{
			for(j=(t1-1);j>=0;j--)
			{
				if(temp1[j]==x[i])
					break;
			}
			if(j<0)
			{
				temp1[t1]=x[i];
				t1++;
			}
		}
		for(i=0;i<y.length;i++)
		{
			for(j=(t1-1);j>=0;j--)
			{
				if(temp1[j]==y[i])
					break;
			}
			if(j<0)
			{
				temp1[t1]=y[i];
				t1++;
			}
		}

		int temp2[]=new int[50];

		//remove duplicates from third array

		for(i=0,t2=0;i<z.length;i++)
		{	
			for(j=(t2-1);j>=0;j--)
			{
				if(temp2[j]==z[i])
					break;
			}
			if(j<0)
			{	
				temp2[t2]=z[i];
				t2++;
			}
		}
		
		//subtraction
		
		for(i=0,t=0;i<t1;i++)
		{
			for(j=(t2-1);j>=0;j--)
			{
				if(temp1[i]==temp2[j])
					break;
			}
			if(j<0)
			{
				temp[t]=temp1[i];
				t++;
			}
		}

		for(i=0;i<t;i++)
		{
			System.out.println(temp[i]);
		}
		
	}

}

public class Array
{
	public static void main(String args[])
	{
		int noa,n;
		
		Scanner in=new Scanner(System.in);
		
		noa=in.nextInt();
		if(noa==1)
		{
			Input X=new Input();
			n=in.nextInt();
			int arr1[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr1[i]=in.nextInt();
			}
			X.rem(arr1);
		}
		else if(noa==2)
		{
			Input Y=new Input();
			n=in.nextInt();
			int arr1[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr1[i]=in.nextInt();
			}
			n=in.nextInt();
			int arr2[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr2[i]=in.nextInt();
			}
			Y.uni(arr1,arr2);
		}
		else if(noa==3)
		{
			Input Z=new Input();
			n=in.nextInt();
			int arr1[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr1[i]=in.nextInt();
			}
			n=in.nextInt();
			int arr2[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr2[i]=in.nextInt();
			}
			n=in.nextInt();
			int arr3[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr3[i]=in.nextInt();
			}
			Z.subtract(arr1,arr2,arr3);
		}
		else
			;
	}
}
