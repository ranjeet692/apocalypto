import java.util.*;
import java.lang.*;

class Points
{
	int x,y;
	Points()
	{
		x=y=0;
	}
	Points(int a1,int b1)
	{
		x=a1;
		y=b1;
	}
}
class Quadrilateral
{	
	Points p1=new Points();
	Points p2=new Points();
	Points p3=new Points();
	Points p4=new Points();
	
	Quadrilateral()
	{
	}

	Quadrilateral(Points x1,Points x2,Points x3,Points x4)
	{
		p1.x=x1.x;
		p1.y=x1.y;
		p2.x=x2.x;
		p2.y=x2.y;
		p3.x=x3.y;
		p3.y=x3.y;
		p4.x=x4.x;
		p4.y=x4.y;
	}
	double slen(Points p,Points q)
	{
		double l;
		l=Math.sqrt(((q.x-p.x)*(q.x-p.x))+((q.y-p.y)*(q.y-p.y)));
		return l;
	}
	double trigarea(double a,double b,double c)
	{
		double s;
		s=(a+b+c)/2;
		double arr=Math.sqrt((s*(s-a)*(s-b)*(s-c)));
		return (arr);
	}
}

class Trapezium extends Quadrilateral
{
	double ab,bc,cd,da,db;
	double larr,uarr,arr1;
	Trapezium(Points x1,Points x2,Points x3,Points x4)
	{
		p1.x=x1.x;
		p1.y=x1.y;
		p2.x=x2.x;
		p2.y=x2.y;
		p3.x=x3.x;
		p3.y=x3.y;
		p4.x=x4.x;
		p4.y=x4.y;
	}
	void tlengths()
	{
		ab=slen(p1,p2);
		bc=slen(p2,p3);
		cd=slen(p3,p4);
		da=slen(p4,p1);
		db=slen(p2,p4);
	}
	void tarea()
	{
		uarr=trigarea(ab,db,da);
		larr=trigarea(bc,cd,db);
		arr1=uarr+larr;
		System.out.println(Math.round(arr1));
	}
	void tperimeter()
	{
		double prr1;
		prr1=ab+bc+cd+da;
		System.out.println(Math.round(prr1));
	}
}

class Parallogram extends Quadrilateral
{
	double ab,bc,cd,da,db;

	Parallogram(Points x1,Points x2,Points x3,Points x4)
	{
		p1.x=x1.x;
		p1.y=x1.y;
		p2.x=x2.x;
		p2.y=x2.y;
		p3.x=x3.x;
		p3.y=x3.y;
		p4.x=x4.x;
		p4.y=x4.y;
	}
	void plengths()
	{
		ab=slen(p1,p2);
		bc=slen(p2,p3);
		cd=slen(p3,p4);
		da=slen(p4,p1);
		db=slen(p2,p4);
	}
	void parea()
	{	double arr2;
		arr2=trigarea(ab,db,da);
		System.out.println(Math.round(2*(arr2)));
		
		
	}
	void pperimeter()
	{
		double prr2;
		prr2=2*(ab+bc);
		System.out.println(Math.round(prr2));
	}
}

class Rectangle extends Quadrilateral
{
	double ab,bc,cd,da,db;

	Rectangle(Points x1,Points x2,Points x3,Points x4)
	{
		p1.x=x1.x;
		p1.y=x1.y;
		p2.x=x2.x;
		p2.y=x2.y;
		p3.x=x3.x;
		p3.y=x3.y;
		p4.x=x4.x;
		p4.y=x4.y;
	}
	void rlengths()
	{
		ab=slen(p1,p2);
		bc=slen(p2,p3);
		
	}
	void rarea()
	{	double arr3;
		arr3=ab*bc;
		System.out.println(Math.round(arr3));
		
		
	}
	void rperimeter()
	{
		double prr3;
		prr3=(2*(ab+bc));
		System.out.println(Math.round(prr3));
	}
}

class Square extends Quadrilateral
{
	double ab;
	Square(Points x1,Points x2,Points x3,Points x4)
	{
		p1.x=x1.x;
		p1.y=x1.y;
		p2.x=x2.x;
		p2.y=x2.y;
		p3.x=x3.x;
		p3.y=x3.y;
		p4.x=x4.x;
		p4.y=x4.y;
	}
	void slengths()
	{
		ab=slen(p1,p2);
		
	}
	void sarea()
	{	double arr4;
		arr4=ab*ab;
		System.out.println(Math.round(arr4));
		
		
	}
	void sperimeter()
	{
		double prr4;
		prr4=4*ab;
		System.out.println(Math.round(prr4));
	}
}


class Area
{
	public static void main(String args[])
	{
		int c1,d1,c2,d2,c3,d3,c4,d4,ch;
		Scanner ob=new Scanner(System.in);
		c1=ob.nextInt();
		d1=ob.nextInt();
		c2=ob.nextInt();
		d2=ob.nextInt();
		c3=ob.nextInt();
		d3=ob.nextInt();
		c4=ob.nextInt();
		d4=ob.nextInt();
		Points n1=new Points(c1,d1);
		Points n2=new Points(c2,d2);
		Points n3=new Points(c3,d3);
		Points n4=new Points(c4,d4);
		ch=ob.nextInt();
		if(ch==1)
		{
			Trapezium obj1=new Trapezium(n1,n2,n3,n4);
			obj1.tlengths();
			obj1.tperimeter();
			obj1.tarea();
			
		}
		else if(ch==2)
		{
			Parallogram obj2=new Parallogram(n1,n2,n3,n4);
			
			obj2.plengths();
			obj2.pperimeter();
			obj2.parea();
			
		}
		else if(ch==3)
		{
			Rectangle obj3=new Rectangle(n1,n2,n3,n4);
			obj3.rlengths();
			obj3.rperimeter();
			obj3.rarea();
			
		}
		else
		{
			
			Square obj4=new Square(n1,n2,n3,n4);
			obj4.slengths();
			obj4.sperimeter();
			obj4.sarea();
			
		}
	}
}
			


	
		
	
	


	
		
	
	
	
	
	
		
	
	
	
	

	
	
		
	
	
	
	

	
