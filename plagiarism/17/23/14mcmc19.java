import java.lang.*;
import java.util.*;

class points
{
	int x;
	int y;
	
	points()
	{
		x=0;
		y=0;
	}
	points( int a,int b)
	{
		x=a;
		y=b;
	}
}

class quadrilateral
{
	points p1= new points();
	points p2= new points();
	points p3= new points();
	points p4= new points();
	
	quadrilateral()
	{
		p1.x=p1.y=0;
		p2.x=p2.y=0;
		p3.x=p3.y=0;
		p4.x=p4.y=0;
	}
		
	quadrilateral(points a,points b,points c,points d)
	{
		p1.x=a.x;
		p1.y=a.y;
		p2.x=b.x;
		p2.y=b.y;
		p3.x=c.x;
		p3.y=c.y;
		p4.x=d.x;
		p4.y=d.y;
	}
	
	int length(points p,points q)
	{
		double l;
		int l1;
		l=Math.sqrt(((q.x-p.x)*(q.x-p.x))+((q.y-p.y)*(q.y-p.y)));
		l1=Math.round(l);
		return l1;
	}
	
	int triarea(int l1,int l2,int l3)
	{
		double s=(l1+l2+l3)/2;
		double ar;
		int ar1;
		ar=Math.sqrt(s*(s-l1)*(s-l2)*(s-l3));
		ar1=Math.round(ar);
		return ar1;
	}
}

class trapezium extends quadrilateral
{
	int ab,bc,cd,da,ac;
	int uarea,larea,area;
	
	trapezium(points a,points b,points c,points d)
	{
		p1.x=a.x;
		p1.y=a.y;
		p2.x=b.x;
		p2.y=b.y;
		p3.x=c.x;
		p3.y=c.y;
		p4.x=d.x;
		p4.y=d.y;
	}
	
	void tlengths()
	{	
		ab=length(p1,p2);
		bc=length(p2,p3);
		cd=length(p3,p4);
		da=length(p4,p1);
		ac=length(p1,p3);
	}
	
	void tarea()
	{
		uarea=triarea(ab,bc,ac);
		larea=triarea(cd,da,ac);
		area=uarea+larea;
		System.out.println(area);
	}
	
	void tperimeter()
	{
		int peri;
		peri=ab+bc+cd+da;
		System.out.println(peri);
	}
}

class parallelogram extends quadrilateral
{
	int ab,bc,cd,da,ac;
	int uarea,larea,area;
	
	parallelogram(points a,points b,points c,points d)
	{
		p1.x=a.x;
		p1.y=a.y;
		p2.x=b.x;
		p2.y=b.y;
		p3.x=c.x;
		p3.y=c.y;
		p4.x=d.x;
		p4.y=d.y;
	}
	
	void plengths()
	{	
		ab=length(p1,p2);
		bc=length(p2,p3);
		cd=length(p3,p4);
		da=length(p4,p1);
		ac=length(p1,p3);
	}
	
	void parea()
	{
		uarea=triarea(ab,bc,ac);
		larea=triarea(cd,da,ac);
		area=uarea+larea;
		System.out.println(area);
	}
	
	void pperimeter()
	{
		int peri;
		peri=ab+bc+cd+da;
		System.out.println(peri);
	}
}

class rectangle extends quadrilateral
{
	int ab,bc;
	
	rectangle(points a,points b,points c,points d)
	{
		p1.x=a.x;
		p1.y=a.y;
		p2.x=b.x;
		p2.y=b.y;
		p3.x=c.x;
		p3.y=c.y;
		p4.x=d.x;
		p4.y=d.y;
	}
	
	void rlengths()
	{	
		ab=length(p1,p2);
		bc=length(p2,p3);
	}
	
	void rarea()
	{
		int area=ab*bc;
		System.out.println(area);
	}
	
	void rperimeter()
	{
		int peri=2*(ab+bc);
		System.out.println(peri);
	}
}

class square extends quadrilateral
{
	int ab;
	
	square(points a,points b,points c,points d)
	{
		p1.x=a.x;
		p1.y=a.y;
		p2.x=b.x;
		p2.y=b.y;
		p3.x=c.x;
		p3.y=c.y;
		p4.x=d.x;
		p4.y=d.y;
	}
	
	void slengths()
	{	
		ab=length(p1,p2);
	}
	
	void sarea()
	{
		int area=ab*ab;
		System.out.println(area);
	}
	
	void rperimeter()
	{
		int peri=4*ab;
		System.out.println(peri);
	}
}

class inheritance
{
	public static void main(String args[])
	{
		int x1,x2,x3,x4,y1,y2,y3,y4,ch;
		Scanner inp=new Scanner(System.in);	
		x1=inp.nextInt();
		y1=inp.nextInt();
		x2=inp.nextInt();
		y2=inp.nextInt();
		x3=inp.nextInt();
		y3=inp.nextInt();
		x4=inp.nextInt();
		y4=inp.nextInt();
		ch=inp.nextInt();
		
		points p1=new points(x1,y1);
		points p2=new points(x2,y2);
		points p3=new points(x3,y3);
		points p4=new points(x4,y4);
		
		switch(ch)
		{
			case 1: trapezium t=new trapezium(p1,p2,p3,p4);
				t.tlengths();
				t.tperimeter();
				t.tarea();
				break;
			case 2: parallelogram p=new parallelogram(p1,p2,p3,p4);
				p.plengths();
				p.pperimeter();
				p.parea();
				break;
			case 4: rectangle r=new rectangle(p1,p2,p3,p4);
				r.rlengths();
				r.rperimeter();
				r.rarea();
				break;
			case 4: square s=new square(p1,p2,p3,p4);
				s.slengths();
				s.sperimeter();
				s.sarea();
				break;
		}
	}
}
				
