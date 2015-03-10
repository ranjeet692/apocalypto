import java.util.*;
import java.lang.*;
class Quadrilateral
{
	float area(Points a,Points b,points c)
	{
		return((a.x*(b.y-c.y)+b.x*(c.y-a.y)+(a.y-b.y))/2;
	}
}
class points
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
			float a2=areaT(c,b,a);
			System.out.println(a1+a2);
		}
}
	void perimeter(float a,float b,float c,float d)
	{
		System.out.println(a+b+c+d);
	}
}
class paraGm extends Quadrilateral
{
	void perimeter(float a,float b)
	{
		System.out.println(2*(a+b));
	}
	void area(Points a,points b,Points c)
	{
		System.out.println(2*areaT(a,b,c));
	}
}
class Ract extends Quadrilateral
{
	void perimeter(float a,float b)
		{
			System.out.println(2*(a+b));
		}
	void area(float a,float b)
		{
			System.out.println(a*b);
		}

}
class Square extends Quadrilateral
{
	void perimeter(float d)
		{
			System.out.println(4*d);
		}
	void area(float d)
		{
			System.out.println(d*d);
		}
}
class Area_of_figure
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
			Points =new Points(x1,y1);
			n=in.nextInt();
			float d1,d2,d3,d4;
			d1=Math.sqrt(Math.pow((p1.x-p2.x),2)+Math.pow((p1.y-p2.y),2));
			d2=Math.sqrt(Math.pow((p2.x-p3.x),2)+Math.pow((p2.y-p3.y),2));
			d3=Math.sqrt(Math.pow((p3.x-p4.x),2)+Math.pow((p3.y-p4.y),2));
			d4=Math.sqrt(Math.pow((p4.x-p1.x),2)+Math.pow((p4.y-p1.y),2));
			switch(n)
			{
				case 1:Trapezium ob=new Trapezium();
				       ob.perimeter(d1,d2,d3,d4);
				       ob.area(p1,p2,p3,p4);
				     	break;
				case 2:ParaGm ob2=new ParaGm();
				       ob.perimeter(d1,d2);
				       ob.area(p1,p2,p3);
				       break;
				case 3:Rect ob=new Rect();
				       ob.perimeter(d1,d2);
				       ob.area(d1,d2);
				       break;
				case 4:Square ob=new Square();
				       ob.perimeter(d1);
				       ob.area(d1);
				       break;
			}
		}
}

																										
