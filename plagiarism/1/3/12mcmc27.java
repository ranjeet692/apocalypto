import java.util.Scanner;
public class ComplexScan
{	
	public static void main(String[] args)
	{
		double r, i;		
		int choice;
		Scanner get = new Scanner( System.in );	
		Complex obj1 = new Complex();
		Complex obj2 = new Complex();
		r = get.nextDouble();
		i = get.nextDouble();
		obj1.setReal( r );
		obj1.setImaginary( i );
		r = get.nextDouble();
		i = get.nextDouble();
		obj2.setReal( r );
		obj2.setImaginary( i );
		choice = get.nextInt(); 
		if(choice == 1)
		{
			System.out.println( (int)(obj1.magnitude() + obj2.magnitude()) );
		}
		else if(choice == 2)
		{
			Complex obj3 = obj1.addComplexNumbers( obj2 );
			obj3.display();	
		}
		else if(choice == 3)
		{
			Complex obj4 = obj1.subtractComplexNumbers( obj2 );
			obj4.display();
		}
		else if(choice == 4)
		{
			Complex obj5 = obj1.multiplyComplexNumbers( obj2 );
			obj5.display();	
		}
	}
}
class Complex
{
	private double real;
	private double imaginary;
	
	public Complex()
	{
		real = 0.0;
		imaginary = 0.0;
	}
	public Complex( double r, double img )
	{
		real = r;
		imaginary = img;
	}
	public double getReal()
	{
		return real;
	}
	public  double getImaginary()
	{
		return imaginary;
	}
	public void setReal( double r )
	{
		real = r;
	}
	public void setImaginary( double img )
	{
		imaginary = img;
	}
	public void display(  )
	{
		if( imaginary < 0 )
		{
			System.out.println( (int)real +"" + (int)imaginary + "i" );
		}
		else if( imaginary >= 0 )
		{
			System.out.println( (int)real + "+" + (int)imaginary + "i" );
		}
		else
		{
			System.out.println( (int)real );
		}		
	}
	public Complex addComplexNumbers( Complex obj )
	{
		Complex result = new Complex();
		result.real = real + obj.real;
		result.imaginary = imaginary + obj.imaginary;
		return result;
	}
	public Complex subtractComplexNumbers( Complex obj )
	{
		Complex result = new Complex();
		result.real = real - obj.real;
		result.imaginary = imaginary - obj.imaginary;
		return result;
	}
	public Complex multiplyComplexNumbers( Complex obj )   //(a+bi) (c+di) = (ac-bd) + (bc+ad)i
	{
		Complex result = new Complex();
		result.real = real * obj.real - imaginary * obj.imaginary;
		result.imaginary = imaginary * obj.real + real * obj.imaginary;
		return result;
	}
	public double magnitude()
	{
		return Math.sqrt((real*real) + (imaginary*imaginary));
	}
}	
