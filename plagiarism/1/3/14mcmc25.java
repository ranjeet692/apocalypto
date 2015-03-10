
import java.util.Scanner;

 public class ComplexTest
{
    public static void main(String args[])
    {
	Scanner input = new Scanner(System.in);
	Double R1 = input.nextDouble();
	Double I1 = input.nextDouble();
	Complex a = new Complex(R1, I1);
	R1 = input.nextDouble();	
	I1 = input.nextDouble();
	int t = input.nextInt();
	Complex b = new Complex(R1,I1);
	Complex temp;
	if(t==1)
		{
			double moda = a.mod();
			double modb = b.mod();
			System.out.println((int)(moda+modb));
		}
	if(t==2)
		{
			temp = a.add(b);							
			System.out.println(temp);
			
		}
	if(t==3)
		{
			
			System.out.println(a.sub(b));
		}
	 if(t==4)
		{
			temp = a.mul(b);
			System.out.println(temp);
		}
	}
}

class Complex
{
    private double real;
    private double imag;

    public Complex(double real, double imag)
    {
	this.real = real;
	this.imag = imag;
    }

    public Complex add(Complex a)
    {
	double tReal =  this.real + a.real;
	double tImag =  this.imag + a.imag;
	Complex sum = new Complex(tReal, tImag );
	return sum;
    }
    
    public String sub(Complex a)
    {
	double tReal =  this.real - a.real;
	double tImag =  this.imag - a.imag;
	//Complex sub = new Complex(tReal, tImag );
	String s="";
	s+=(int)tReal;
	s+=(int)tImag+"i";
	return s;
    }
    
    public Complex mul(Complex a)
    {
	double tReal =  (this.real * a.real) - (this.imag * a.imag);
	double tImag =  (this.real * a.imag) + (this.imag * a.real);
	Complex mul = new Complex(tReal, tImag );
	return mul;
    }
   
    public double mod()
    {
	double tReal = (real * real) + (imag * imag);
	return Math.sqrt(tReal);
    }

    public String toString()
    {
		String s = (int)this.real + "+"+ (int)this.imag + "i";
		return s;
    }
}
