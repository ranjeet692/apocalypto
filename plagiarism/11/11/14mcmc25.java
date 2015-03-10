import java.util.*;
import java.lang.*;
class ArrayMethod
{
        public int temp[]=new int[100];
        public int i,j,t;
        public int[] remove(int x[])
        {
        	      int size=x.length;
                for (i=0;i<size;i++)
                {
                        for(j=(size-1); j>i; j--)
                        {
                                if(x[j]==x[i])
                                {
                                
                                      	for(t=j;t<size-1;t++)
                                      		x[t] = x[t+1];
                                      	size--;	
                                }
                        }
                }
                int arr[] = new int[size];
                for(i=0;i<size;i++)
                {
                        arr[i]=x[i];
                }
                return arr;
        }
        
        public int[] uni(int x[], int y[])
        {
                int X=0,arr[] = new int[x.length+y.length];
                for(int i=0;i<x.length;i++)
                	arr[X++]=x[i];
                for(int i=0;i<y.length;i++)
                	arr[X++]=y[i];
                int ar[] = remove(arr);
        	      return ar;
        }
        public boolean exist(int n, int arr[])
        {
        		for(int i=0;i<arr.length;i++)
        		{
        			if(n==arr[i])
        			    return true;
        		}
        		return false;
        }
        public int[] subtract(int x[],int y[],int z[])
        {
                int arr[] = remove(z);
                int union[] = uni(x,y);
                int size = union.length;
                for(int i = 0; i<size; i++)
                {
                	if(exist(union[i], arr))
                	{
                		for(int k=i;k<size-1;k++)
                			union[k]=union[k+1];
                		i--;
                		size--;
                	}
                }
                int tmp[] = new int[size];
                for(int i = 0; i<size; i++)
                	tmp[i] = union[i];
                return tmp;
        }
}

public class Arr
{
        public static void main( String args[])
        {
                int n,noa;
                Scanner in = new Scanner(System.in);
                noa=in.nextInt();
                if(noa==1)
                {
                        ArrayMethod X=new ArrayMethod();
                        n=in.nextInt();
                        int arr1[]=new int[n];
                        for(int i=0;i<n;i++)
                        {
                                arr1[i]=in.nextInt();
                        }
                        int tmp[] = X.remove(arr1);
                        printArray(tmp);
                }
                else if(noa==2)
                {
                        ArrayMethod Y=new ArrayMethod();
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
                        int tmp[]=Y.uni(arr1,arr2);
                	    printArray(tmp);
                }
                else if(noa==3)
                {
                        ArrayMethod Z=new ArrayMethod();
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
                        int tmp[]=Z.subtract(arr1,arr2,arr3);
                	    printArray(tmp);
                }
                else
                        ;
        }

	public static void printArray(int arr[])
	{
		for(int x:arr)
		{
			System.out.println(x);
		}
	}
}



                                                     

