import java.util.Scanner;
import java.lang.Math;
class Cartisian{
	private double x;
	private double y;

	Cartisian(){}

	Cartisian(double a, double b ){
		x = a;
		y = b;
	}


	void Dis(Cartisian c1, Cartisian c2){
		double d = Math.sqrt(((c2.x-c1.x)*(c2.x-c1.x))+((c2.y-c1.y)*(c2.y-c1.y)));
	        System.out.printf("%.2f\n",d);	
	}

	void  Mid(Cartisian c1, Cartisian c2){
		Cartisian CMid = new Cartisian();
		CMid.x = (c1.x+c2.x)/2;
		CMid.y = (c1.y+c2.y)/2;
		System.out.printf("%.2f %.2f\n",CMid.x,CMid.y);
	}

	void Slo(Cartisian c1, Cartisian c2){
		if((c2.x-c1.x)==0)
			System.out.println("Undefined");
		else{
		double s = ((c2.y-c1.y)/(c2.x-c1.x));
		System.out.printf("%.2f\n",s);
		}	
	}

	void Equ(Cartisian c1, Cartisian c2){

		System.out.printf("%.2fx%.2fy+%.2f=0.00\n",1.00,(c1.x-c2.x)/(c2.y-c1.y),((c2.x)*(c1.y)-(c1.x)*(c2.y))/(c2.y-c1.y));
	}


	

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		double p,q,r,s;
		int t;
		p = sc.nextDouble();
		q = sc.nextDouble();
		r = sc.nextDouble();
		s = sc.nextDouble();
		t = sc.nextInt();
		
		Cartisian c1 = new Cartisian(p,q);
		Cartisian c2 = new Cartisian(r,s);
		Cartisian c3 = new Cartisian();

		switch(t){
			case 1:
				c3.Dis(c1,c2);
				break;
			case 2:
				c3.Mid(c1,c2);
				break;
			case 3:
				c3.Slo(c1,c2);
				break;
			case 4:
				c3.Equ(c1,c2);
		}
	}
} 
