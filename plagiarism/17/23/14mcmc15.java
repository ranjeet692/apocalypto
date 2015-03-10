import java.util.*;
import java.math.*;
class Point
{
	int x;
	int y;
	Point(int a,int b)
	{
		x=a;
		y=b;
	}
	double length(Point a,Point b)
	{
		return Math.sqrt(((a.x-b.x)*(a.x-b.x))+((a.y-b.y)*(a.y-b.y)));
	}
}
class Quadrilateral
{
	Point p1,p2,p3,p4;
	double d12,d23,d34,d41;
	
	Quadrilateral(Point a,Point b,Point c,Point d)
	{
		p1=a;
		p2=b;
		p3=c;
		p4=d;
		d12=p1.length(p1,p2);
		d23=p2.length(p2,p3);
		d34=p3.length(p3,p4);
		d41=p4.length(p4,p1);
		
	}
	
	void perimeter()
	{
		System.out.println(Math.round(d12+d23+d34+d41));
	}
	
}
class Trapezoid extends Quadrilateral
{
	double uarea,larea,area,d13,s1,s2;
	
	Trapezoid(Point a,Point b,Point c,Point d)
	{
		super(a,b,c,d);
	}
	
	void area()
	{
    	d13=p1.length(p1,p3);
	    s1=(d12+d23+d13)/2;
	    uarea=Math.sqrt(s1*(s1-d12)*(s1-d23)*(s1-d13));
	
	    s2=(d41+d34+d13)/2;
        larea=Math.sqrt(s2*(s2-d41)*(s2-d34)*(s2-d13));
	
	
	    System.out.println(Math.round(uarea+larea));
	}
}
class Parallelogram extends Trapezoid
{
	
	Parallelogram(Point a,Point b,Point c,Point d)
	{
		super(a,b,c,d);
	}
}
class Rectangle extends Parallelogram 
{
	
	Rectangle(Point a,Point b,Point c,Point d)
	{
		super(a,b,c,d);
	}
}
class Square extends Rectangle
{
	Square(Point a,Point b,Point c,Point d)
	{
		super(a,b,c,d);
	}
}

class Inheritence
{
	public static void main(String args[])
	{	
		Scanner in=new Scanner(System.in);
		int x,y;
		x=in.nextInt();
		y=in.nextInt();
		Point a=new Point(x,y);
		x=in.nextInt();
		y=in.nextInt();
		Point b=new Point(x,y);
		x=in.nextInt();
		y=in.nextInt();
		Point c=new Point(x,y);
		x=in.nextInt();
		y=in.nextInt();
		Point d=new Point(x,y);
		
		int choice =in.nextInt();
		switch(choice)
		{
			case 1:
			Trapezoid ob1=new Trapezoid(a,b,c,d);
			
			ob1.perimeter();
			ob1.area();
			break;
			case 2:
			Parallelogram ob2=new Parallelogram(a,b,c,d);
			
			ob2.perimeter();
			ob2.area();
			break;
			case 3:
			Rectangle ob3=new Rectangle(a,b,c,d);
			
			ob3.perimeter();
			ob3.area();
			break;
			case 4:
			Square ob4=new Square(a,b,c,d);
			
			ob4.perimeter();
			ob4.area();
			break;
		}
	}
}
