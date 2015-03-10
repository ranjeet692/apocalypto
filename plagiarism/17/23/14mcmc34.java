import java.lang.Math.*;
import java.util.*;
class point
{
 int x,y;
    point()
    {
    	x=0;y=0;
    }    
    point(int j,int k)
    {
        x=j;
        y=k;
    }
    double length(point p1,point p2)
    {
       double side = Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));         
       return side;
    }
}
class quadrilateral
{
    double ab,bc,cd,da,ac;
    quadrilateral(double a,double b,double c,double d,double e)
    {
        ab = a;
        bc = b;
        cd = c;
        da = d;
        ac = e;
    }
     void perimeter()
    {
       double peri = ab+bc+cd+da;
       System.out.println((int)peri);
    }
    void area()
    {
        double s1 = (ab+bc+ac)/2;
        double t1 = Math.sqrt(s1*(s1-ab)*(s1-bc)*(s1-ac));
        double s2 = (cd+da+ac)/2;
	double t2 = Math.sqrt(s2*(s2-cd)*(s2-da)*(s2-ac));
        double quad_area = t1+t2;
        System.out.println(Math.round(quad_area));
    }
   
}
class inheritence
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int p = input.nextInt();
        int q = input.nextInt();
	point o1 = new point(p,q);
        int r = input.nextInt();
        int s = input.nextInt();
	point o2 = new point(r,s);
        int t = input.nextInt();
        int u = input.nextInt();
	point o3 = new point(t,u);
        int v = input.nextInt();
        int x = input.nextInt();
	point o4 = new point(v,x);
        int ch = input.nextInt();
	point o5 = new point();               
        double e1 = o5.length(o1,o2);
        double e2 = o5.length(o2,o3);
        double e3 = o5.length(o3,o4);
        double e4 = o5.length(o4,o1);
        double e5 = o5.length(o1,o3);
        quadrilateral quad = new quadrilateral(e1,e2,e3,e4,e5);                    
        quad.perimeter();
	quad.area();
     }	
}
