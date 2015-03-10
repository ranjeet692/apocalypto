import java.util.Scanner;

class Point
{
	private double x;
	private double y;

	Point()
	{
		x=0.0;
		y=0.0;
	}

	Point(double a, double b )
	{
		x = a;
		y = b;
	}

	public double get_x()
        {
                return x;
        }
        
        public double get_y()
        {
                return y;
        }

	public void display()
        {
                System.out.printf("%.2f %.2f\n",x,y);
        }
        
	void distance(Point c2)
	{
		double d;
		d =  Math.sqrt(Math.pow((c2.get_x()-this.x),2.0)+Math.pow((c2.get_y()-this.y),2.0));
	        System.out.printf("%.2f\n",d);	
	}

	void  midPoint(Point c1, Point c2)
	{
		this.x = ((c1.get_x()+c2.get_x())/2.0);
		this.y = ((c1.get_y()+c2.get_y())/2.0);
	}

	void lineSlope(Point c2)
	{
		if((c2.get_x()-this.x)==0)
		{
			System.out.println("Undefined");
		}
		else
		{
			System.out.printf("%.2f\n",((c2.get_y()-this.y)/(c2.get_x()-this.x)));
		}	
	}

	void print_equation(Point c2)
	{

		System.out.printf("%.2fx%.2fy+%.2f=0.00\n",1.00,(this.x-c2.get_x())/(c2.get_y()-this.y),((c2.get_x())*(this.y)-(this.x)*(c2.get_y()))/(c2.get_y()-this.y));
	}

	public static void main(String args[])
	{
		int t;
		double p,q,r,s;
		
		Scanner in = new Scanner(System.in);
		p = in.nextDouble();
		q = in.nextDouble();
		r = in.nextDouble();
		s = in.nextDouble();
		t = in.nextInt();
		
		Point c1 = new Point(p,q);
		Point c2 = new Point(r,s);
		Point mid = new Point();
		

		switch(t)
		{
			case 1:	c1.distance(c2);
				break;
				
			case 2:	mid.midPoint(c1,c2);
				mid.display();
				break;
				
			case 3:
				c1.lineSlope(c2);
				break;
				
			case 4:	c1.print_equation(c2);
		}
	}
} 
