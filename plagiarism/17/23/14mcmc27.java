import java.util.*;
import java.lang.*;
class Quadrilateral
{
	int x1,y1;
	int x2,y2;
	int x3,y3;
	int x4,y4;


	void Getparameter(int a1,int b1,int a2,int b2,int a3,int b3,int a4,int b4)
	{
		x1=a1;
		x2=a2;
		x3=a3;
		x4=a4;
		y1=b1;
		y2=b2;
		y3=b3;
		y4=b4;

	}
	
	void Perimeter()
	{
		double p1=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
		double p2=Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
		double p3=Math.sqrt((x4-x3)*(x4-x3)+(y4-y3)*(y4-y3));
		double p4=Math.sqrt((x1-x4)*(x1-x4)+(y1-y4)*(y1-y4));
		double p=p1+p2+p3+p4;
		
		System.out.println(Math.round(p));
	}


	void Area()
	{
		double p1=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
		double p2=Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
		double p3=Math.sqrt((x4-x3)*(x4-x3)+(y4-y3)*(y4-y3));
		double p4=Math.sqrt((x1-x4)*(x1-x4)+(y1-y4)*(y1-y4));
		
		double diagonal =Math.sqrt((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1));
		double s1=(p1+p2+diagonal)/2;
		double Triangle1=Math.sqrt(s1*(s1-p1)*(s1-p2)*(s1-diagonal));
		
		double s2=(p3+p4+diagonal)/2;
		double Triangle2=Math.sqrt(s2*(s2-p3)*(s2-p4)*(s2-diagonal));

		double s=Triangle1+Triangle2;

		System.out.println(Math.round(s));
	}	
}

class Trapezoid extends Quadrilateral
{

}
class Parallelogram extends Quadrilateral
{

}

class Rectangle extends Quadrilateral
{

}

class Square extends Quadrilateral
{

}

class Area_Figure
{
	public static void main(String args[])
	{
		Scanner in =new Scanner(System.in);
		int x1=in.nextInt();
		 int y1=in.nextInt();

		int x2=in.nextInt();
		int y2=in.nextInt();

		int x3=in.nextInt();
		 int y3=in.nextInt();

		int x4=in.nextInt();
		 int y4=in.nextInt();
		 
		
		 int n=in.nextInt();
		 
		switch(n)
		{
		case 1:
		Trapezoid S1 =new Trapezoid();
		S1.Getparameter(x1,y1,x2,y2,x3,y3,x4,y4);
		S1.Perimeter();
		S1.Area();
		break;
		
		case 2:
		
		Parallelogram S2 =new Parallelogram();
		S2.Getparameter(x1,y1,x2,y2,x3,y3,x4,y4);
		S2.Perimeter();
		S2.Area();
		break;
		
		case 3:
		
		Rectangle  S3 =new Rectangle ();
		S3.Getparameter(x1,y1,x2,y2,x3,y3,x4,y4);
		S3.Perimeter();
		S3.Area();
		break;
		
		case 4:

		Square S4 =new Square ();
		S4.Getparameter(x1,y1,x2,y2,x3,y3,x4,y4);
		S4.Perimeter();
		S4.Area();
		break;
		}
	}

}


