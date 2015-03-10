import java.util.*;

class Operation
{
	public int tem[]=new int[100];
	public int i,j,t;
	public void rem(int[] a)
	{
		for(i=0,t=0;i<a.length;i++)
		{	
			for(j=t-1;j>=0;j--)
				if(tem[j]==a[i])
					break;
			if(j<0)
			{	
				tem[t]=a[i];
				t++;
			}
		}
		for(i=0;i<t;i++)
		{
			System.out.println(tem[i]);
		}
	}

	public void uni(int[] a,int[] b)
	{
		for(i=0,t=0;i<a.length;i++)
		{
			for(j=t-1;j>=0;j--)
				if(tem[j]==a[i])
					break;
			if(j<0)
			{
				tem[t]=a[i];
				t++;
			}
		}
		for(i=0;i<b.length;i++)
		{
			for(j=t-1;j>=0;j--)
				if(tem[j]==b[i])
					break;
			if(j<0)
			{
				tem[t]=b[i];
				t++;
			}
		}
		for(i=0;i<t;i++)
		{
			System.out.println(tem[i]);
		}
	}
	
	public void sub(int[] a,int[] b,int[] c)
	{
		int t1,t2;
		int tem1[]=new int[100];

		for(i=0,t1=0;i<a.length;i++)
		{
			for(j=t1-1;j>=0;j--)
				if(tem1[j]==a[i])
					break;
			if(j<0)
			{
				tem1[t1]=a[i];
				t1++;
			}
		}
		for(i=0;i<b.length;i++)
		{
			for(j=t1-1;j>=0;j--)
				if(tem1[j]==b[i])
					break;
			if(j<0)
			{
				tem1[t1]=b[i];
				t1++;
			}
		}

		int tem2[]=new int[50];

		for(i=0,t2=0;i<c.length;i++)
		{	
			for(j=t2-1;j>=0;j--)
				if(tem2[j]==c[i])
					break;
			if(j<0)
			{	
				tem2[t2]=c[i];
				t2++;
			}
		}
		for(i=0,t=0;i<t1;i++)
		{
			for(j=0;j<t2;j++)
				if(tem1[i]==tem2[j])
					break;
			if(j==t2)
			{
				tem[t]=tem1[i];
				t++;
			}
		}

		for(i=0;i<t;i++)
		{
			System.out.println(tem[i]);
		}
		
	}

}

class ArrayList
{
	public static void main(String args[])
	{
		int noa,n;
		
		Scanner obj=new Scanner(System.in);
		Operation Obj=new Operation();
		noa=obj.nextInt();
		if(noa==1)
		{
			n=obj.nextInt();
			int arr1[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr1[i]=obj.nextInt();
			}
			Obj.rem(arr1);
		}
		else if(noa==2)
		{
			n=obj.nextInt();
			int arr1[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr1[i]=obj.nextInt();
			}
			n=obj.nextInt();
			int arr2[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr2[i]=obj.nextInt();
			}
			Obj.uni(arr1,arr2);
		}
		else if(noa==3)
		{
			n=obj.nextInt();
			int arr1[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr1[i]=obj.nextInt();
			}
			n=obj.nextInt();
			int arr2[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr2[i]=obj.nextInt();
			}
			n=obj.nextInt();
			int arr3[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr3[i]=obj.nextInt();
			}
			Obj.sub(arr1,arr2,arr3);
		}
		else;
	}
}
