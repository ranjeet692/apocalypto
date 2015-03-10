import java.util.*;


class Options
{
	public int temp[]=new int[100];
	public int i,j,t;
	public void remov(int arr[])
	{
		for(i=0,t=0;i<arr.length;i++)
		{	
			for(j=t-1;j>=0;j--)
			{
				if(temp[j]==arr[i])
					break;
			}
			if(j<0)
			{	
				temp[t]=arr[i];
				t++;
			}
		}
		for(i=0;i<t;i++)
		{
			System.out.println(temp[i]);
		}
	}

	public void unions(int arr[],int arr1[])
	{
		for(i=0,t=0;i<arr.length;i++)
		{
			for(j=t-1;j>=0;j--)
			{
				if(temp[j]==arr[i])
					break;
			}
			if(j<0)
			{
				temp[t]=arr[i];
				t++;
			}
		}
		for(i=0;i<arr1.length;i++)
		{
			for(j=t-1;j>=0;j--)
			{
		
				if(temp[j]==arr1[i])
					break;
			}
			if(j<0)
			{
				temp[t]=arr1[i];
				t++;
			}
		}
		for(i=0;i<t;i++)
		{
			System.out.println(temp[i]);
		}
	}
	
	public void subtraction(int arr[],int arr1[],int arr2[])
	{
		int tem1,tem2;
		int temp1[]=new int[100];

		for(i=0,tem1=0;i<arr.length;i++)
		{
			for(j=tem1-1;j>=0;j--)
			{
				if(temp1[j]==arr[i])
					break;
			}
			if(j<0)
			{
				temp1[tem1]=arr[i];
				tem1++;
			}
		}
		for(i=0;i<arr1.length;i++)
		{
			for(j=tem1-1;j>=0;j--)
			{
				if(temp1[j]==arr1[i])
					break;
			}
			if(j<0)
			{
				temp1[tem1]=arr1[i];
				tem1++;
			}
		}


		int temp2[]=new int[50];

		for(i=0,tem2=0;i<arr2.length;i++)
		{	
			for(j=tem2-1;j>=0;j--)
			{
				if(temp2[j]==arr2[i])
					break;
			}
			if(j<0)
			{	
				temp[tem2]=arr2[i];
				tem2++;
			}
		}

		for(i=0,t=0;i<tem1;i++)
		{
			for(j=0;j<tem2;j++)
			{
				if(temp1[i]==temp2[j])
					break;
			}
			if(j==tem2)
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
		
		Scanner ob=new Scanner(System.in);
		Options Obj=new Options(); 

		noa=ob.nextInt();
		if(noa==1)
		{
		
			n=ob.nextInt();
			int arr1[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr1[i]=ob.nextInt();
			}
			Obj.remov(arr1);
		}
		else if(noa==2)
		{
			n=ob.nextInt();
			int arr1[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr1[i]=ob.nextInt();
			}
			n=ob.nextInt();
			int arr2[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr2[i]=ob.nextInt();
			}
			Obj.unions(arr1,arr2);
		}
		else if(noa==3)
		{
			n=ob.nextInt();
			int arr1[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr1[i]=ob.nextInt();
			}
			n=ob.nextInt();
			int arr2[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr2[i]=ob.nextInt();
			}
			n=ob.nextInt();
			int arr3[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr3[i]=ob.nextInt();
			}
			Obj.subtraction(arr1,arr2,arr3);
		}
		else;
	}
}
