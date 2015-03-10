import java.util.Scanner;
class comp
{
	public static void main(String arg[])
	{
		int p,q,r,s,t;
		Scanner in =new Scanner (System.in);
		p=in.nextInt();
		q=in.nextInt();
		r=in.nextInt();
		s=in.nextInt();
		t=in.nextInt();
		
		if(t==1)
		{
			System.out.println((int)Math.sqrt(p*p+q*q)+(int)Math.sqrt(r*r+s*s));
		}
		else if(t==2)
		{
		
			System.out.println((p+r)+"+"+(q+s)+"i");
		}
		else if(t==3)
		{
	
			System.out.println((p-r)+""+(q-s)+"i");
		}
		else if(t==4)
		{
			System.out.println(((p*r)-(q*s))+"+"+((p*s)+(r*q))+"i");
		}

	}
}
