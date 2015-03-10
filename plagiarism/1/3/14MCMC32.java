import java.util.Scanner;

class imaginaryNumbers
{
	public static void main(String args[])
	{
		int p, q, r, s, t;
		Scanner in= new Scanner(System.in);
		p=in.nextInt();
		q=in.nextInt();
		r=in.nextInt();
		s=in.nextInt();
		t=in.nextInt();
		switch(t)
		{
			case 1:
				System.out.print(""+(p+r));
				System.out.print("+"+(q+s));
				System.out.println("i");
				break;
			case 2:
				System.out.print(""+(p-r));
				System.out.print("-"+(q-s));
				System.out.print("i");		
				break;
			case 3:
				System.out.print(""+(p*r));
				System.out.print("+"+(q*s));
				System.out.print("i");
				break;
		}
	}
}
