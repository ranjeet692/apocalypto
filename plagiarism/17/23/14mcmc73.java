import java.util.*;
import java.lang.*;
class Point
    {
         int x,y;
         Point(int a ,int b)
           {
                 x = a;
                 y = b;
            }
            
      }
class Quardilateral
     {
          int distance(Point a , Point b)
               {
                  int dx,dy;
                  int dis;
                  dx = a.x - b.x;
                  dy = a.y - b.y;
                  dx = dx * dx;
                  dy = dy * dy;
                  dis = (int)Math.sqrt(dx+dy);
                  return dis;
                }
       }
                
class Subclass extends Quardilateral
      {
         
        float area_of_tri(int a, int b , int c)
                 {
                       
                      
                      int s=(a+b+c)/2;
                      float area = (float)Math.sqrt(s*(s-a)*(s-b)*(s-c));
                      return area;
                  }
                    void  area(Point a , Point b , Point c, Point d)
                 {
                        int s1,s2,s3,s4,digo;
                       s1 = distance(a,b);
                       s2 = distance(b,c);
                       s3 = distance(c,d);
                       s4 = distance(d,a);
                       digo = distance(a,c);
                       int are = Math.round( (area_of_tri(s1,s2,digo)) + (area_of_tri(digo,s3,s4)) );
                       System.out.println("area = "+are);
                  }
     /*               void  areaoftre(Point a , Point b , Point c, Point d)
                 {
                       
                      int area = (((a.x*b.y)+(b.x*c.y)+(c.x * d.y)+(d.x *a.y)) - ((a.y*b.x)+(b.y*c.x)+(c.y*d.x)+(d.y*a.x)))/2;
                      System.out.println("area = "+area);
                  }
                    void  areaofpara(Point a , Point b , Point c, Point d)
                 {
                       
                      int area = (((a.x*b.y)+(b.x*c.y)+(c.x * d.y)+(d.x *a.y)) - ((a.y*b.x)+(b.y*c.x)+(c.y*d.x)+(d.y*a.x)))/2;
                      System.out.println("area = "+area);
                  }*/
             void  perimeter(Point a , Point b , Point c, Point d )
                   {
                       int s1,s2,s3,s4;
                       s1 = distance(a,b);
                       s2 = distance(b,c);
                       s3 = distance(c,d);
                       s4 = distance(d,a);
                       s1 = s1+s2+s3+s4;
                       System.out.println("Perimeter = "+ s1);
                   }
        }
  class Inheritance
      {
           public static void main(String args[])
             {
              int cx ,cy ,n;
              Scanner get = new Scanner(System.in) ;
              cx = get.nextInt();
              cy = get.nextInt();
             Point p = new Point(cx,cy);
              cx = get.nextInt();
              cy = get.nextInt();
              Point q = new Point(cx,cy);
              cx = get.nextInt();
              cy = get.nextInt();
              Point r = new Point(cx,cy);
              cx = get.nextInt();
              cy = get.nextInt();
              Point s = new Point(cx,cy);
               n = get.nextInt();
              
             Subclass s1 = new Subclass();
              if(n==1)
              {
              s1.area(p,q,r,s);
              s1.perimeter(p,q,r,s);
              }
              else if(n==2)
                 
              {
              s1.area(p,q,r,s);
              s1.perimeter(p,q,r,s);
              }
               else if(n==3)
                 
              {
              s1.area(p,q,r,s);
              s1.perimeter(p,q,r,s);
              }
               else if(n==4)
                 
              {
              s1.area(p,q,r,s);
              s1.perimeter(p,q,r,s);
              }
              }
         }                       
                             
                         
