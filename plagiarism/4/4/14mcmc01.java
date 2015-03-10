import java.util.Scanner;
import java.lang.Math;

public class Cartesian{
	public static void main(String args[]){
		double p,q,r,s;
		int t;
		Scanner sc = new Scanner(System.in);
		p = sc.nextDouble();
		q=sc.nextDouble();
		r=sc.nextDouble();
		s=sc.nextDouble();
		t=sc.nextInt();
		Point p1= new Point(p,q);
		Point p2=new Point(r,s);
		switch(t){
			case(1): p1.distance(p2);
				 break;
			case(2): p1.midpoint(p2);
				 break;
			case(3): p1.slope(p2);
				 break;
			case(4): p1.equation(p2);
				 break;
			default: System.out.println("Invalid option");
				 break;
		}
	}
	
}


class Point{
	private double x,y;
	public Point(double a,double b){
		this.x=a;
		this.y=b;
	}
	public double getx(){
		return this.x;
	}
	public double gety(){
		return this.y;
	}

	public void distance(Point b){
		System.out.printf("%.2f\n",Math.sqrt((this.x-b.x)*(this.x-b.x)+(this.y-b.y)*(this.y-b.y)));
	}

	public void midpoint(Point b){
		System.out.printf("%.2f %.2f\n",(this.x+b.x)/2,(this.y+b.y)/2);
	}

	public void slope(Point b){
		if (this.x-b.x==0){
			System.out.println("Undefined");
		}
		else{
			System.out.printf("%.2f\n",(this.y-b.y)/(this.x-b.x));
		}
	}
		
	public void equation(Point b){
		double slope = (b.y-this.y)/(b.x-this.x);
		double intercept= (this.y*b.x-this.x*b.y)/(b.x-this.x);
			System.out.printf("%.2fx%.2fy+%.2f=0.00\n",1.00,(b.x-this.x)/(this.y-b.y),(b.x*this.y-b.y*this.x)/(b.y-this.y));
		
	}


}



