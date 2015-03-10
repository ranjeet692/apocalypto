import java.util.*;
import java.lang.*;

class Qlateral
{
	double areaT(Pts a,Pts b,Pts c)
	{
		double a_o_t=Math.abs((a.x*(b.y-c.y)+b.x*(c.y-a.y)+c.x*(a.y-b.y))/2);
		return a_o_t;
	}
}

class Pts
{
	int x,y;
	Pts(int a,int b)
	{
		x=a;
		y=b;
	}
}

class Trapezoide extends Qlateral
{

	void area(Pts a,Pts b,Pts c,Pts d)
	{	
		System.out.println(Math.round(areaT(a,b,c)+areaT(c,d,a)));
	}
	
	void perimeter(double a,double b,double c,double d)
	{
		System.out.println(Math.round(a+b+c+d));
	}
}

class ParaGm extends Qlateral
{
	
	void perimeter(double a,double b)
	{
		System.out.println(Math.round(2*(a+b)));
	}
	
	void area(Pts a,Pts b,Pts c)
	{
		System.out.println(Math.round(2*areaT(a,b,c)));
	}
}

class Rect extends Qlateral
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

class Square extends Qlateral
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

class Inherit
{
	public static void main(String args[])
	{

		int X,Y,fig;
		Scanner in=new Scanner(System.in);
		
		X=in.nextInt();
		Y=in.nextInt();
		Pts P1=new Pts(X,Y);
		
		X=in.nextInt();
		Y=in.nextInt();
		Pts P2=new Pts(X,Y);

		X=in.nextInt();
		Y=in.nextInt();
		Pts P3=new Pts(X,Y);
				
		X=in.nextInt();
		Y=in.nextInt();
		Pts P4=new Pts(X,Y);
		
		fig=in.nextInt();

		double D1,D2,D3,D4;
		D1=Math.sqrt(Math.pow((P1.x-P2.x),2)+Math.pow((P1.y-P2.y),2));
		D2=Math.sqrt(Math.pow((P2.x-P3.x),2)+Math.pow((P2.y-P3.y),2));
		D3=Math.sqrt(Math.pow((P3.x-P4.x),2)+Math.pow((P3.y-P4.y),2));
		D4=Math.sqrt(Math.pow((P4.x-P1.x),2)+Math.pow((P4.y-P1.y),2));

        switch(fig)
		{
			case 1:Trapezoide ob1=new Trapezoide();
					ob1.perimeter(D1,D2,D3,D4);
					ob1.area(P1,P2,P3,P4);
					break;
					
			case 2:ParaGm ob2=new ParaGm();
					ob2.perimeter(D1,D2);
					ob2.area(P1,P2,P3);
					break;
					
			case 3:Rect ob3=new Rect();
					ob3.perimeter(D1,D2);
					ob3.area(D1,D2);
					break;
					
			case 4:Square ob4=new Square();
					ob4.perimeter(D1);
					ob4.area(D1);
					break;
					
		}
	}
}
