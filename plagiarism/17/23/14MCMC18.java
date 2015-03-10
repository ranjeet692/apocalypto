import java.util.*;

class point
{
	int x,y;
	void point(int a,int b)
	{
		x=a;
		y=b;
	}
}

class quadrilateral
{

	abstract float area();
	abstract float perimeter();
}

class trapezoid extends quadrilateral
{
	
	float area()
	{
		float area=0;
	       area=((a+b)*h)/2;
		System.out.println("AREA OF TRAPEZOID IS="+area);
	}
	float perimeter()
	{
		float p=0;
		p=a+b+c+d;
		System.out.println("PERIMETER OF TRAPEZOID IS="+p);

	}
}
class parallelogram extends quadrilateral
{

	float area()
	{
		float area=0;
		area=b*h;
		System.out.println("AREA OF PARALLELOGRAM IS="+area);
	}
	float perimeter()
	{
		float p=0;
		p=2*(b+h);
		System.out.println("PERIMETER OF TRAPEZOID IS="+p);
	}
}

class rectangle extends quadrilateral
{
	float area()
	{
		float area=0;
		area=l*b;
		 System.out.println("AREA OF RECTANGLE IS="+area);
	}
	float perimeter()
	{
		float p=0;
		p=2*(b+l);
		System.out.println("PERIMETER OF RECTANGLE IS="+p);
	}
}

class square extends quadrilateral
{
	float area()
		        {
				                float area=0;
						                area=l*b;
								                 System.out.println("AREA OF RECTANGLE IS="+area);
										         }
										        }










class inherit
{
	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		int a,b,c,d,e,f,g,h,n;
		a=input.nextInt();
		b=input.nextInt();
		point p1=new point(a,b);
		c=input.nextInt();
		d=input.nextInt();
		point p2=new point(c,d);
		e=input.nextInt();
		f=input.nextInt();
		point p3=new point(e,f);
		g=input.nextInt();
		h=input.nextInt();
		point p4=new point(g,h);
		System.out.printl("ENTER THE TYPE OF QUADRILATERAL");
		System.out.printl("1.TRAPEZOID\n2.PARALLELOGRAM\n3.RECTANGLE\n4.SQUARE");
		n=input.nextInt();
		switch(n)
		{
			case 1:
				trapezoid t=new trapezoid();
				break;
			case 2:
				parallelogram p=new parallelogram();
				break;
			case 3:
				rectangle r=new rectangle();
				break;
			case 4:
				square s=new square();
				break;
			default:
				System.out.printl("INVALID CHOICE");
		}
	}
}
