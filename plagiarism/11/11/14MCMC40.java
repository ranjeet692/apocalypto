import java.util.*;
import java.lang.*;

class  ArrayMethods
{
	public int tem[]=new int[100];
	public int i,j, temp;
	public void del(int  a[])
	{
		for(i=0, temp=0;i< a.length;i++)
		{	
			for(j=( temp-1);j>=0;j--)
			{
				if( tem[j]== a[i])
					break;
			}
			if(j<0)
			{	
				 tem[ temp]= a[i];
				 temp++;
			}
		}
		for(i=0;i< temp;i++)
		{
			System.out.println( tem[i]);
		}
	}

	public void  union(int  a[],int  b[])
	{
		for(i=0, temp=0;i< a.length;i++)
		{
			for(j=( temp-1);j>=0;j--)
			{
				if( tem[j]== a[i])
					break;
			}
			if(j<0)
			{
				 tem[ temp]= a[i];
				 temp++;
			}
		}
		for(i=0;i< b.length;i++)
		{
			for(j=( temp-1);j>=0;j--)
			{
				if( tem[j]== b[i])
					break;
			}
			if(j<0)
			{
				 tem[ temp]= b[i];
				 temp++;
			}
		}
		for(i=0;i< temp;i++)
		{
			System.out.println( tem[i]);
		}
	}
	
	public void sub(int  A[],int  B[],int Z[])
	{
		int  temp1, temp2;
		int  tem1[]=new int[100];


		//union of first two arrays


		for(i=0, temp1=0;i< A.length;i++)
		{
			for(j=( temp1-1);j>=0;j--)
			{
				if( tem1[j]== A[i])
					break;
			}
			if(j<0)
			{
				 tem1[ temp1]= A[i];
				 temp++;
			}
		}
		for(i=0;i< B.length;i++)
		{
			for(j=( temp1-1);j>=0;j--)
			{
				if( tem1[j]== B[i])
					break;
			}
			if(j<0)
			{
				 tem1[ temp1]= B[i];
				 temp1++;
			}
		}

		int  tem2[]=new int[50];

		//delete duplicates from third array

		for(i=0, temp2=0;i<Z.length;i++)
		{	
			for(j=( temp2-1);j>=0;j--)
			{
				if( tem2[j]==Z[i])
					break;
			}
			if(j<0)
			{	
				 tem[ temp2]=Z[i];
				 temp2++;
			}
		}


		//subtraction

		for(i=0, temp=0;i< temp1;i++)
		{
			for(j=0;j< temp2;j++)
			{
				if( tem1[i]== tem2[j])
					break;
			}
			if(j== temp2)
			{
				 tem[ temp]= tem1[i];
				 temp++;
			}
		}

		for(i=0;i< temp;i++)
		{
			System.out.println( tem[i]);
		}
		
	}

}

public class Arrayset
{
	public static void main(String args[])
	{
		int noa,n;
		
		Scanner in=new Scanner(System.in);
		
		noa=in.nextInt();
		if(noa==1)
		{
			 ArrayMethods X=new  ArrayMethods();
			n=in.nextInt();
			int arr1[]=new int[n];
			for(int i=0;i<n;i++)
			{
				arr1[i]=in.nextInt();
			}
			X.del(arr1);
		}
		else if(noa==2)
		{
			 ArrayMethods Y=new  ArrayMethods();
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
			Y. union(arr1,arr2);
		}
		else if(noa==3)
		{
			 ArrayMethods Z=new  ArrayMethods();
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
			Z.sub(arr1,arr2,arr3);
		}
		else
			;
	}
}
