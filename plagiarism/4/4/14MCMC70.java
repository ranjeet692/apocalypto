
import java.util.*;
import java.lang.Math;

class Test
{
    private double x;
    private double y;
    Test(){}

    Test(double a,double b)
    {
        x=a;
        y=b;
        }
    void dist(Test c1,  Test c2)
    {
        double s;
        s= Math.sqrt((c2.x-c1.x)*(c2.x-c1.x)+(c2.y-c1.y)*(c2.y-c1.y));
        System.out.printf("%.2f\n",s);
    }

    void mid(Test c1,Test c2)
    {
        double s1,s2;

        s1=((c1.x+c2.x)/2);
        s2=((c1.y+c2.y)/2);
        System.out.printf("%.2f %.2f\n",s1,s2);
     }

     void slop(Test c1,Test c2)
     {

        double d1;
        if((c2.x-c1.x)==0)
        	System.out.println("Undefined");
        else{
        d1=(((c2.y-c1.y)/(c2.x-c1.x)));
        System.out.printf("%.2f\n",d1);
        }
     }

     void equ(Test c1,Test c2)
     {
    	 System.out.printf("%.2fx%.2fy+%.2f=0.00\n",1.00,(c1.x-c2.x)/(c2.y-c1.y),(((c2.y*c1.x)-(c2.x*c1.y))/(c1.y-c2.y)));

     }

}

class Cartesian_coordinater1
{
    public static void main(String args[])
    {

        double p,q,r,s;
        int t;
       Test c1,c2,c3;

        Scanner in=new Scanner(System.in);
        p=in.nextDouble();
        q=in.nextDouble();
        r=in.nextDouble();
        s=in.nextDouble();

        c1=new Test(p,q);
        c2=new Test(r,s);
        c3=new Test();
       // result=new Imaginary();

        t=in.nextInt();

        switch(t)
        {
            case 1:
               c3.dist(c1,c2);
                break;


            case 2: c3.mid(c1,c2);
                    break;

            case 3: c3.slop(c1,c2);
                    break;

            case 4: c3.equ(c1,c2);
                    break;

            default: System.out.println("Wrong Choice");

        }

    }
}
