import java.util.*;
import java.lang.*;

class Arraymth
{
	public int nrs[]=new int[100];
	public int p,q,l;
	public void rmv(int u[])
	{
		for(p=0,l=0;p<u.length;p++)
		{	
			for(q=(l-1);q>=0;q--)
			{
				if(nrs[q]==u[p])
					break;
			}
			if(q<0)
			{	
				nrs[l]=u[p];
				l++;
			}
		}
		for(p=0;p<l;p++)
		{
			System.out.println(nrs[p]);
		}
	}

	public void union(int u[],int v[])
	{
		for(p=0,l=0;p<u.length;p++)
		{
			for(q=(l-1);q>=0;q--)
			{
				if(nrs[q]==u[p])
					break;
			}
			if(q<0)
			{
				nrs[l]=u[p];
				l++;
			}
		}
		for(p=0;p<v.length;p++)
		{
			for(q=(l-1);q>=0;q--)
			{
				if(nrs[q]==v[p])
					break;
			}
			if(q<0)
			{
				nrs[l]=v[p];
				l++;
			}
		}
		for(p=0;p<l;p++)
		{
			System.out.println(nrs[p]);
		}
	}
	
	public void subtrt(int u[],int v[],int w[])
	{
		int l1,l2;
		int nrs1[]=new int[100];


		//union of 1st 2nd arrays


		for(p=0,l1=0;p<u.length;p++)
		{
			for(q=(l1-1);q>=0;q--)
			{
				if(nrs1[q]==u[p])
					break;
			}
			if(q<0)
			{
				nrs1[l1]=u[p];
				l1++;
			}
		}
		for(p=0;p<v.length;p++)
		{
			for(q=(l1-1);q>=0;q--)
			{
				if(nrs1[q]==v[p])
					break;
			}
			if(q<0)
			{
				nrs1[l1]=v[p];
				l1++;
			}
		}

		int nrs2[]=new int[50];

		//remove duplicates from 3rd array

		for(p=0,l2=0;p<w.length;p++)
		{	
			for(q=(l2-1);q>=0;q--)
			{
				if(nrs2[q]==w[p])
					break;
			}
			if(q<0)
			{	
				nrs[l2]=w[p];
				l2++;
			}
		}


		//Subtraction

		for(p=0,l=0;p<l1;p++)
		{
			for(q=0;q<l2;q++)
			{
				if(nrs1[p]==nrs2[q])
					break;
			}
			if(q==l2)
			{
				nrs[l]=nrs1[p];
				l++;
			}
		}

		for(p=0;p<l;p++)
		{
			System.out.println(nrs[p]);
		}
		
	}

}

public class Settheory
{
	public static void main(String args[])
	{
		int nofa,m;
		
		Scanner in=new Scanner(System.in);
		
		nofa=in.nextInt();
		if(nofa==1)
		{
			Arraymth M=new Arraymth();
			m=in.nextInt();
			int arr1[]=new int[m];
			for(int p=0;p<m;p++)
			{
				arr1[p]=in.nextInt();
			}
			M.rmv(arr1);
		}
		else if(nofa==2)
		{
			Arraymth Y=new Arraymth();
			m=in.nextInt();
			int arr1[]=new int[m];
			for(int p=0;p<m;p++)
			{
				arr1[p]=in.nextInt();
			}
			m=in.nextInt();
			int arr2[]=new int[m];
			for(int p=0;p<m;p++)
			{
				arr2[p]=in.nextInt();
			}
			Y.union(arr1,arr2);
		}
		else if(nofa==3)
		{
			Arraymth Z=new Arraymth();
			m=in.nextInt();
			int arr1[]=new int[m];
			for(int p=0;p<m;p++)
			{
				arr1[p]=in.nextInt();
			}
			m=in.nextInt();
			int arr2[]=new int[m];
			for(int p=0;p<m;p++)
			{
				arr2[p]=in.nextInt();
			}
			m=in.nextInt();
			int arr3[]=new int[m];
			for(int p=0;p<m;p++)
			{
				arr3[p]=in.nextInt();
			}
			Z.subtrt(arr1,arr2,arr3);
		}
		else
			;
	}
}
