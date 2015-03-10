import java.util.Scanner;
class arraymethod
{
	public static void main(String args[])
	{
		//int arr[];
		int a;
	int i;
	int j;
	int n;
	//arraymethod obj = new arraymethod();
	Scanner obj = new Scanner(System.in);
	//System.out.println("enter a number");
//	n = in.nextInt();
	System.out.println("enter number of arr");
	int noa=obj.nextInt();
	for(i=1;i<=noa;i++)
	{
          System.out.println("enter a elements");
		        n = obj.nextInt();
	int arr[]=new int[n];
		for(j=0;j<n;j++)
	{
		arr[j]=obj.nextInt();
	}
	//System.out.println(j);
	//System.out.println(i);
	}
	
}
}

