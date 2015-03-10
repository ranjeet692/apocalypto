import java.util.Scanner;

class test
{
	int n, i=0;
	String str;

	public void getString()
	{
		System.out.println("Enter number of string(s)");
		Scanner m= new Scanner(System.in);
		n=m.nextInt();
		System.out.println("Enter string(s)");
		while(i<n)
		{
			Scanner in= new Scanner(System.in);
			str= in.nextLine();
			i++;
		}
	}
}
class palindrome
{
	public static void main(String args[])
	{
		test z=new test();
		z.getString();
	}
}
