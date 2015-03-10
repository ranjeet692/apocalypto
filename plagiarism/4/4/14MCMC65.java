import java.util.Scanner;
import java.lang.Math.*;
class cartesian_coordinate
{
     double x;
     double y;
    cartesian_coordinate()
    {
    }
    cartesian_coordinate(double a,double b)
    {
        x=a;
        y=b;
    }
    
    double distance(cartesian_coordinate m1,cartesian_coordinate m2)
    {
        return (Math.sqrt(((m2.y-m1.y)*(m2.y-m1.y))+((m2.x-m1.x)*(m2.x-m1.x))));
    }
    
    void midpoint(cartesian_coordinate m1,cartesian_coordinate m2)
    {
        System.out.printf("%1.2f %1.2f\n",(m1.x+m2.x)/2 , (m1.y+m2.y)/2);
     }
     
    double slope(cartesian_coordinate m1,cartesian_coordinate m2)
    { 
       return ((m2.y-m1.y)/(m2.x-m1.x));
     }
      
     
    void equation(cartesian_coordinate m1,cartesian_coordinate m2,double m)
    { double c;
       c = ((m1.x*m2.y)-(m1.y*m2.x))/(m1.x-m2.x);
       System.out.printf("1.00x%.2fy+%.2f=0.00\n" ,(-1/m),(c/m)) ;    
     }
    
     
     
}

class Test
{
    public static void main(String args[])
    {
    
        double p,q,r,s;
        double ans;
        int t;
        
        cartesian_coordinate point1,point2,point;
        Scanner in=new Scanner(System.in);
       
    	p=in.nextDouble();
        q=in.nextDouble();
        r=in.nextDouble();
        s=in.nextDouble();
        
        point1=new cartesian_coordinate(p,q);
        point2=new cartesian_coordinate(r,s);
        point=new cartesian_coordinate();
        t=in.nextInt();
        
        switch(t)
        {
            case 1: ans =point.distance(point1,point2);
                    System.out.printf("%.2f\n",ans);
                    break;
                    
            case 2: point.midpoint(point1,point2);
                    break;
                    
            case 3: if(point1.x==point2.x)
                      {
                      System.out.printf("Undefined\n");
                      break;
                      }
                    else
                    {ans = point.slope(point1,point2);
                    System.out.printf("%1.2f\n",ans);
                    break;}
                    
            case 4: ans = point.slope(point1,point2);
                    point.equation(point1,point2,ans);
                    break;
                    
            
            
        }
        
    }
}
