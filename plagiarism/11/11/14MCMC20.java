import java.util.*;
class ArrayMethods
{
			
	public void removeDuplicate(int[] array,int len)
	{
		
		int a[]=new int[len];
		int i,j,t=0;
		for(i=0;i<len;i++)
		{
			for(j=t;j>=0;j--)
			{
				if(a[j]==array[i])
				{
					break;	
				}
			}
			if(j<0)
			{
				a[t]=array[i];
				t++;
			}
		}
		for(i=0;i<t;i++)
			System.out.println(a[i]);
	}
	
	public void setUnion(int[] array1, int[] array2, int len1,int len2)
	{
		int a[]=new int[50];
		int c=0,i,j;
		for(i=0;i<len1;i++)
		{
			for(j=c-1;j>=0;j--)
			{
				if(a[j]==array1[i])
				{
					break;
				}
			}
			if(j<0)
			{
				a[c]=array1[i];
				c++;
			}

		}
	
		
		for(i=0;i<len2;i++)
		{
			for(j=c-1;j>=0;j--)
				{
					if(a[j]==array2[i])
					{
						break;
					}
				}
			if(j<0)
			{
				a[c]=array2[i];
				c++;
				
			}
		}
		for(i=0;i<c;i++)
		{
			System.out.println(a[i]);
		}
	}
	
	public void setDifference(int[] array1, int[] array2, int[] array3,int len1,int len2,int len3)
	{
		int t1,t2,c=0;
		int i,j;
		int temp1[]=new int[100];
		int a[]=new int[50];

	


		for(i=0,t1=0;i<len1;i++)
		{
			for(j=(t1-1);j>=0;j--)
			{
				if(temp1[j]==array1[i])
					break;
			}
			if(j<0)
			{
				temp1[t1]=array1[i];
				t1++;
			}
		}
		for(i=0;i<len2;i++)
		{
			for(j=(t1-1);j>=0;j--)
			{
				if(temp1[j]==array2[i])
					break;
			}
			if(j<0)
			{
				temp1[t1]=array2[i];
				t1++;
			}
		}

		int temp2[]=new int[50];

		//remove duplicates from third array

		for(i=0,t2=0;i<len3;i++)
		{	
			for(j=(t2-1);j>=0;j--)
			{
				if(temp2[j]==array3[i])
					break;
			}
			if(j<0)
			{	
				temp2[t2]=array3[i];
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

public class ArrayOperation
{
	public static void main( String[] args)
	{
		Scanner in=new Scanner(System.in);
		int noa,n1,n2,n3;
		int i;
		noa=in.nextInt();
		ArrayMethods obj=new ArrayMethods();
		if(noa==1)
		{
			n1=in.nextInt();
			int a1[]=new int[n1];
			for(i=0;i<n1;i++)
				a1[i]=in.nextInt();
			obj.removeDuplicate(a1,n1);
		}
		if(noa==2)
		{
			n1=in.nextInt();
			int a1[]=new int[n1];
			for(i=0;i<n1;i++)
				a1[i]=in.nextInt();
			n2=in.nextInt();
			int a2[]=new int[n2];
			for(i=0;i<n2;i++)
				a2[i]=in.nextInt();
			obj.setUnion(a1,a2,n1,n2);
		}
		if(noa==3)
		{
			n1=in.nextInt();
			int a1[]=new int[n1];
			for(i=0;i<n1;i++)
				a1[i]=in.nextInt();
			n2=in.nextInt();
			int a2[]=new int[n2];
			for(i=0;i<n2;i++)
				a2[i]=in.nextInt();
			n3=in.nextInt();
			int a3[]=new int[n3];
			for(i=0;i<n3;i++)
				a3[i]=in.nextInt();
			obj.setDifference(a1,a2,a3,n1,n2,n3);
		}
			
	}
}	
		
