// Program to do basic operations on imaginary numbers

import java.util.Scanner;
import java.lang.*;

class imag
{
	public static void main(String args[])
	{
		complex c1=new complex();
		complex c2=new complex();
		Scanner inp=new Scanner(System.in);
		c1.real=inp.nextDouble();
		c1.imag=inp.nextDouble();
		c2.real=inp.nextDouble();
		c2.imag=inp.nextDouble();
		int t=inp.nextInt();
		switch(t)
		{
			case 1: c1.modulus(c2);
				break;
			case 2: c1.addition(c2);
				break;
			case 3: c1.subtraction(c2);
				break;
			case 4: c1.multiplication(c2);
				break;
		}
	}
}


class complex
{
	public double real;
	public double imag;

	public complex()
	{
		real=0;
		imag=0;
	}

	public void modulus(complex ob2)
	{
		double r1,r2,s;
		r1=Math.sqrt((real*real)+(imag*imag));
		r2=Math.sqrt((ob2.real()*ob2.real())+(ob2.imag()*ob2.imag()));
		s=r1+r2;
		System.out.println(s);
	}

	public void addition(complex ob2)
	{
		complex ob3=new complex();

		ob3.real=real+ob2.real();
		ob3.imag=imag+ob2.imag();
		System.out.println((int)ob3.real()+"+"+(int)ob3.imag()+"i");
	}

	public void subtraction(complex ob2)
	{
		complex ob3=new complex();
		ob3.real=real-ob2.real();
		ob3.imag=imag-ob2.imag();
		System.out.println((int)ob3.real()+"+"+(int)ob3.imag()+"i");
	}

	public void multiplication(complex ob2)
	{
		complex ob3=new complex();
		ob3.real=real*ob2.real()-imag*ob2.imag();
		ob3.imag=real*ob2.imag()+imag*ob2.imag();
		System.out.println((int)ob3.real()+"+"+(int)ob3.imag()+"i");
	}

	public double real()
	{
		return real;
	}

	public double imag()
	{
		return imag;
	}
}

