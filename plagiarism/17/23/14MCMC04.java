import java.awt.*;
  
 abstract class Quadrilateral
{
public Point topleft = new Point(0,0);
public Point topright = new Point(0,0);
public Point bottomleft = new Point(0,0);
public Point bottomright = new Point(0,0);
 
public abstract int calculateArea();
}//end of class Quadrilateral

   class MyRect extends Quadrilateral
{
public MyRect()
{
super();
}//end of constructor
 
public MyRect(int x, int y, int width, int height)
{
//super();
topleft = new Point(x,y);
topright = new Point(x+width,y);
bottomleft = new Point(x, y+height);
bottomright = new Point(x+width, y+height);
}//end of constructor
 
public int calculateArea()
{
/*
 * The area of a Rectangle is calculated as follows:
 * (length  *  breadth)
 */
 int area = (bottomright.x - topleft.x) * (bottomright.y - topleft.y);
 return area;
}//end of method calculateArea()
}//end of class MyRect

class Square extends Quadrilateral
{
public Square()
{
super();
}//end of constructor
 
public Square(int x, int y, int side)
{
super();
topleft = new Point(x,y);
topright = new Point(x+side,y);
bottomleft = new Point(x, y+side);
bottomright = new Point(x+side, y+side);
}//end of constructor
 
public int calculateArea()
{
/*
 * The area of a Parallelogram is calculated as follows:
 * (side*side)
 */
 int area = (bottomright.x - topleft.x) * (bottomright.y - topleft.y);
 return area;
}//end of method calculateArea()
}//end of class Square

class Parallelogram extends Quadrilateral
{
public Parallelogram()
{
super();
}//end of constructor
 
public Parallelogram(int x, int y, int width, int height)
{
super();
topleft = new Point(x,y);
topright = new Point(x+width,y);
bottomleft = new Point(x, y+height);
bottomright = new Point(x+width, y+height);
}//end of constructor
 
public int calculateArea()
{
/*
 * The area of a Parallelogram is calculated as follows:
 * (base * height)
 */
 int area = (bottomright.x - topleft.x) * (bottomright.y - topleft.y);
 return area;
}//end of method calculateArea()
}//end of class Parallelogram

public class ShapeGenerator
{
public static void main(String args[])
{
Quadrilateral shapes[] = {
new MyRect(0,0,10,20),
new Parallelogram(0,0,10,20),
new Square(0,0,10)
};
int area=0;
for(int i=0;i<shapes.length;i++)
{
area = shapes[i].calculateArea();
System.out.println("Area of " + shapes[i].getClass() + " : " + area);
}//end of for loop
}//end of method main()
}//end of class ShapeGenerator
