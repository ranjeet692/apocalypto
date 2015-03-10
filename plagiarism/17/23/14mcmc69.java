import java.util.*;
import java.lang.*;
class Point{
    int x;
    int y;
    public Point(int a, int b){
        x = a;
        y = b;
    }      
    
}

class Quadrilateral{
    Point point;
    double dis1,dis2,dis3,dis4;
    double area;
    double peri;
    public void distance(Point p1, Point p2, Point p3, Point p4){
        dis1 = Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));
        dis2 = Math.sqrt((p2.x-p3.x)*(p2.x-p3.x) + (p2.y-p3.y)*(p2.y-p3.y));
        dis3 = Math.sqrt((p3.x-p4.x)*(p3.x-p4.x) + (p3.y-p4.y)*(p3.y-p4.y));
        dis4 = Math.sqrt((p4.x-p1.x)*(p4.x-p1.x) + (p4.y-p1.y)*(p4.y-p1.y));
    }
    
}

 class SubClass extends Quadrilateral{
    public void square(Point a, Point b, Point c, Point d){
       distance(a, b, c, d);
        area = dis1*dis1;
        peri = 4*dis1;
        System.out.println(Math.round(peri));
        System.out.println(Math.round(area));
        
    }
}


class Shape{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        SubClass obj = new SubClass();
        int x1 = input.nextInt();
        int y1 = input.nextInt();
        int x2 = input.nextInt();
        int y2 = input.nextInt();
        int x3 = input.nextInt();
        int y3 = input.nextInt();
        int x4 = input.nextInt();
        int y4 = input.nextInt();
        Point p1 = new Point(x1,y1);
        Point p2 = new Point(x2,y2);
        Point p3 = new Point(x3,y3);
        Point p4 = new Point(x4,y4);
        int ch = input.nextInt();
        switch(ch){
            case 1:
                obj.square(p1,p2,p3,p4);
                break;
            
            case 2:
                obj.square(p1,p2,p3,p4);
                break;
            
            case 3:
                obj.square(p1,p2,p3,p4);
                break;
            
            case 4:
                obj.square(p1,p2,p3,p4);
                break;
            
        }
    }
}