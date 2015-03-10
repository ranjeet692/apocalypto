import java.util.*;
import java.text.DecimalFormat;
class Cartesian_coordinate
{
   private double x,y;
   DecimalFormat df = new DecimalFormat("0.00");
    public void get()
       {    
           Scanner g = new Scanner(System.in);
           x = g.nextDouble();
           y = g.nextDouble();
      }
         
    public  void t (Cartesian_coordinate o,int n)
     {
       if(n==1)
           {
              x = x-o.x;
              y = y-o.y;
              x = x*x;
              y = y*y;
              x = Math.sqrt(x+y);
              System.out.println(df.format(x));
            }
        else if(n==2)
            {
              x = (x+o.x)/2;
              y = (y+o.y)/2;
              System.out.println(df.format(x)+" "+df.format(y));
            }
       else if (n==3)
           {
              if(x==o.x)
             System.out.println("Undefind");
              else
             {
               x = (y-o.y)/(x-o.x);
               System.out.println(df.format(x));
             }
           }
       else if(n==4)
           {
              if(x==o.x)
             System.out.println("Undefind");
             else 
               {
              double cons,yterm;
              cons = ((x*(o.y-y))+(y*(o.x-x)))/(o.y-y);
              yterm = (o.x-x)/(o.y-y);
              System.out.println("x"+df.format(-yterm) +"y"+ df.format(-cons) +"=0.00");
               }

            }
      }
}
        class Man 
 {
         public static void main(String[] args)
             {
             Cartesian_coordinate o  = new  Cartesian_coordinate();
             Cartesian_coordinate a  = new  Cartesian_coordinate();
             int n;
             Scanner g = new Scanner(System.in);
             a.get();
             o.get();
             n = g.nextInt();
             a.t(o,n);
            }
     }      


