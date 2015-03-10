import java.util.*;
import java.lang.*;

class Quadrilateral
{
	float areaT(Points a,Points b,Points c)
	{
		return (Math.abs((a.x*(b.y-c.y)+b.x*(c.y-a.y)+c.x*(a.y-b.y))/2));
	}
}

class Points
{
	int x,y;
	Points(int a,int b)
	{
		x=a;
		y=b;
	}
}

class Trapezium extends Quadrilateral
{

	void area(Points a,Points b,Points c,Points d)
	{
		float a1=areaT(a,b,c);
		float a2=areaT(c,d,a);
		
		System.out.println(Math.round(a1+a2));
	}
	
	void perimeter(double a,double b,double c,double d)
	{
		System.out.println(Math.round(a+b+c+d));
	}
}

class ParaGm extends Quadrilateral
{
	
	void perimeter(double a,double b)
	{
		System.out.println(Math.round(2*(a+b)));
	}
	
	void area(Points a,Points b,Points c)
	{
		System.out.println(Math.round(2*areaT(a,b,c)));
	}
}

class Rect extends Quadrilateral
{
	
	void perimeter(double a,double b)
	{
		System.out.println(Math.round(2*(a+b)));
	}
	
	void area(double a,double b)
	{
		System.out.println(Math.round(a*b));
	}

}

class Square extends Quadrilateral
{
	
	void perimeter(double d)
	{
		System.out.println(Math.round(4*d));
	}
	
	void area(double d)
	{
		System.out.println(Math.round(d*d));
	}
}

class Test
{
	public static void main(String args[])
	{

		int x1,y1,n;
		Scanner in=new Scanner(System.in);
		
		x1=in.nextInt();
		y1=in.nextInt();
		Points p1=new Points(x1,y1);
		
		x1=in.nextInt();
		y1=in.nextInt();
		Points p2=new Points(x1,y1);

		x1=in.nextInt();
		y1=in.nextInt();
		Points p3=new Points(x1,y1);
		
		x1=in.nextInt();
		y1=in.nextInt();
		Points p4=new Points(x1,y1);

		n=in.nextInt();
		
		double d1,d2,d3,d4;
		d1=Math.sqrt(Math.pow((p1.x-p2.x),2)+Math.pow((p1.y-p2.y),2));
		d2=Math.sqrt(Math.pow((p2.x-p3.x),2)+Math.pow((p2.y-p3.y),2));
		d3=Math.sqrt(Math.pow((p3.x-p4.x),2)+Math.pow((p3.y-p4.y),2));
		d4=Math.sqrt(Math.pow((p4.x-p1.x),2)+Math.pow((p4.y-p1.y),2));
		
		switch(n)
		{
			case 1:Trapezium ob1=new Trapezium();
					ob1.perimeter(d1,d2,d3,d4);
					ob1.area(p1,p2,p3,p4);
					break;
					
			case 2:ParaGm ob2=new ParaGm();
					ob2.perimeter(d1,d2);
					ob2.area(p1,p2,p3);
					break;
					
			case 3:Rect ob3=new Rect();
					ob3.perimeter(d1,d2);
					ob3.area(d1,d2);
					break;
					
			case 4:Square ob4=new Square();
					ob4.perimeter(d1);
					ob4.area(d1);
					break;
					
		}
	}
}
