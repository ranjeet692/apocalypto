import java.util.Scanner;

class array
{
	public static void main(String args[])
	{
		int i, j, n1, n2, n;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of array");
		n=sc.nextInt();
		while(n==2)
		{
			System.out.println("Enter the number of elements of first array");
			n1=sc.nextInt();
			System.out.println("Enter the number of elements of second array");
			n2=sc.nextInt();
			int a1[]=new int[n1];
			int a2[]=new int[n2];
			System.out.println("\nEnter the elements of the first array");
			for(i=0;i<n1;i++)
			a1[i]=sc.nextInt();
			System.out.println("\nEnter the elements of the second array");
			for(i=0;i<n2;i++)
			a2[i]=sc.nextInt();
			i=j=0;
			System.out.println("\nUnion of arrays");
			while(i<n1 &&j<n2)
			{
				if(a1[i]<a2[j])
				{
					System.out.println(a1[i]+"");
					i++;
				}
				else if(a2[j]<a1[i])
				{
					System.out.println(a2[j]+"");
					j++;
				}
				else
				{
					System.out.println(a1[i]+"");
					i++;
					j++;
				}
			}
			if(i<n1)
				while(i<n1)
				{
					System.out.println(a1[i]+"");
					i++;
				}
			if(j<n2)
				while(j<n2)
				{
					System.out.println(a2[j]+"");
					j++;
				}
		}
	}
}
