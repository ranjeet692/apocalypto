import java.util.Scanner;
import java.lang.Math;
class coordinate
{
    private double x;
    private double y;
       
	coordinate()
	{
	}

        coordinate(double a,double b)
	{
		x=a;
		y=b;
	}

	public void distance(coordinate c1)
        {
                double dst,d1,d2;
                d1=((x-c1.x)*(x-c1.x));
                d2=((y-c1.y)*(y-c1.y));
                dst=Math.sqrt(d1+d2);
                System.out.printf("%.2f\n",dst);
         }
    public void midpoint(coordinate c2)
    {
	    double midx,midy;
        midx=((x+c2.x)/2);
        midy=((y+c2.y)/2);
        System.out.printf("%.2f %.2f\n",midx,midy);
    }
	public void slope(coordinate c3)
	{
		double slp;
		if((c3.x-x)==0)
		    System.out.println("Undefined");
		else
		    {
		    slp=(c3.y-y)/(c3.x-x);
		    System.out.printf("%.2f\n",slp);
		    }
	}
	public void equation(coordinate c5)
	{
		double cx,cy,cc,c,m;

		    m=((c5.y-y)/(c5.x-x));
		   // c=(y-(m*x));
		    cx=1.00;
		    cy=(1/m);
		    cc=(((c5.x*y)-(x*c5.y))/(c5.y-y));
		    System.out.printf("%.2fx+%.2fy+%.2f=0.00\n",cx,cy,cc);
        }
	}

class cartesion_coordinate
{
        public static void main(String args[])
        {
                double p,q,r,s;
		int t;
		
                Scanner c=new Scanner (System.in);
                p=c.nextDouble();
                q=c.nextDouble();
                r=c.nextDouble();
                s=c.nextDouble();
                t=c.nextInt();

		        coordinate point1= new coordinate(p,q);
                coordinate point2= new coordinate(r,s);
		
		switch(t)
		{

			case 1:
				point1.distance(point2);
				break;
			case 2:
		        point1.midpoint(point2);
				break;
			case 3:
				point1.slope(point2);
				break;
			case 4:
			    point1.equation(point2);
			    break;
			default:
				System.out.println("Wrong choice");
				break;
		}

        }
}
