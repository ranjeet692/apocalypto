import java.util.Scanner;
class cartesian_coordinate
{
	private double x,y;
	cartesian_coordinate(double a,double b)
	{
		x=a;
		y=b;
	}
	double distance(cartesian_coordinate o1,cartesian_coordinate o2)
	{
	 	double d= Math.sqrt(((o1.x-o2.x)*(o1.x-o2.x))+((o1.y-o2.y)*(o1.y-o2.y)));
		return d;	
	}
	void midpoint(cartesian_coordinate o)
	{
		x=(o.x+x)/2;
		y=(o.y+y)/2;
		System.out.println(x+" "+y);
	}
	double slope(cartesian_coordinate o)
	{
		double s= (o.y-y)/(o.x-x);
  		if(s==Double.POSITIVE_INFINITY)
			return 0;
		return s;
	}
	void equation(cartesian_coordinate o)
	{
		double m= (o.y-y)/(o.x-x);
                double c=y-(m*x);
		double M=-m,C=-c;
      		System.out.println(M+"x "+"+ y"+C+"=0");	
	}
}
class Cartesian
{
	public static void main(String ag[])
	{
		Scanner sc= new Scanner(System.in);
		double p,q,r,s,d;int t;
		p=sc.nextInt();
		q=sc.nextInt();
		r=sc.nextInt();
		s=sc.nextInt();
		t=sc.nextInt();
		cartesian_coordinate obj1=new cartesian_coordinate(p,q);
		cartesian_coordinate obj2=new cartesian_coordinate(r,s);
		switch(t)
		{
			case 1: d = obj1.distance(obj1,obj2);
				System.out.println(d);
				break;
			case 2:	obj1.midpoint(obj2);
				break;
			case 3: d = obj1.slope(obj2);
				if(d==0)
			        System.out.println("Undefined");
				else
                                System.out.println(d);
				break;
			case 4: obj1.equation(obj2);
				break;
			default:System.out.println("Undefined");
		}
	}
}
