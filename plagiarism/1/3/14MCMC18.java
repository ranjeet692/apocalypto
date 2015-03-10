import java.util.Scanner;
import java.lang.*;



//MAIN CLASS
class imaginary_no
{
	public static void main(String[] args)
	   {
	
		int t;
		System.out.println("PLAY WITH COMPLEX NUMBERS");
		System.out.println("\n1. MODULUS\n2.ADDITION\n3.SUBTRACTION\n4.MULTIPLICATION\n");
		System.out.println("ENTER YOUR CHOICE");
		double p,q,r,s;
		complex c0=new complex();
		Scanner input=new Scanner(System.in);
		p=input.nextDouble();
		q=input.nextDouble();
		r=input.nextDouble();
		s=input.nextDouble();
		complex c1=new complex(p,q);
		complex c2=new complex(r,s);
		t=input.nextInt();
 
		switch(t)
		{
			case 1:
				c0.mod(c1);
				c0.mod(c2);
				break;
			case 2:
				c0.add(c1,c2);
				break;
			case 3:
				c0.subtract(c1,c2);
				break;
			case 4:
				c0.multiply(c1,c2);
				break;
			default:
				System.out.println("\nWRONG INPUT");
				break;
		}//END OF SWITCH
	    }//END OF MAIN FUNCTION
}//END OF MAIN CLASS
	

class complex
{
	private double real,imag;
	complex()
	{	
	}
	complex(double r, double i)
	{
	 real=r;
	 imag=i;
	}
	double trunc(double a)
	{
	 a=a*100;
	 a=Math.floor(a);
	 a=a/100;
	 return a;
	}
	void mod(complex c)
	{
	 double modo;
	 modo=Math.sqrt((c.real*c.real)+(c.imag*c.imag));
	 modo=trunc(modo);
	 System.out.println("\nTHE MODULUS="+modo);
	}
	void add(complex c1, complex c2)
	{
	 double x=c1.real+c2.real;
	 double y=c1.imag+c2.imag;
	 trunc(x);
	 trunc(y);
	 System.out.println("\nTHE COMPLEX NUMBERS AFTER ADDITION WILL GIVE: "+x+"+i"+y);
	 }
	void subtract(complex c1, complex c2)
	{
	 double x=c1.real-c2.real;
	 double y=c1.imag-c2.imag;
	 trunc(x);
	 trunc(y);
	 System.out.println("\nTHE COMPLEX NUMBERS AFTER subtraction WILL GIVE: "+x+"+i"+y);
	 }
	void multiply(complex c1, complex c2)
	{
	 double x=(c1.real*c2.real)-(c1.imag*c2.imag);
	 double y=((c1.imag*c2.real)+(c1.real*c2.imag));
	 trunc(x);
	 trunc(y);
	 System.out.println("\nTHE COMPLEX NUMBERS AFTER MULTIPLICATION WILL GIVE: "+x+"+i"+y);
	}
}