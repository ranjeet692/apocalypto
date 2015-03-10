import java.util.Scanner;
public class test
{
	public static void main(String[] args)
	{
		int noa,n,i,j;
		int[] arry;
		Scanner get = new Scanner( System.in );	
		noa = get.nextInt();		
		//System.out.println(noa)	;	
		for(i=0; i<noa; i++)
		{
			n = get.nextInt();
			arry = new int[n];
			//System.out.println(n);
			for(j=0; j<n; j++)
			{
				arry[j] = get.nextInt();
			}
			
		}
		int[] a = { 8,5,3,87,56,90,4};
		for(j=0; j<7; j++)
			{
				System.out.println(a[j]);
			}
	}
}
