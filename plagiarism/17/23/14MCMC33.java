import java.util.Scanner;

class Quadrilateral
{
	int distance(int a,int b, int c ,int d)
	{
		return (int)Math.sqrt(((a-c)*(a-c))+((b-d)*(b-d)));
	}
}

class Rectangle extends Quadrilateral
{
		void rectangle_area(int x, int y, int x1,int y1,int x2,int y2,int y3,int x3)
	{
			int p;
            int l=distance(x,y,x1,y1);
			int l1=distance(x2,y2,x3,y3);
                        p=2*(l+l1);
                        System.out.println(p);
			int B;
				B=l*l1;
		System.out.println(B);
                		

	}	
}

class Square extends Quadrilateral
{
	void square_area(int x, int y,int x1,int y1)
	{
		int a=distance(x,y,x1,y1);
		int p=4*a;
		System.out.println(p);
		int A;
		 A=a*a;
		System.out.println(A);
			
	}
}

class Parallelogram extends Quadrilateral
{
    void parallelo_area(int x,int y,int x1,int y1,int x2,int y2,int x3,int y3){
    int A;
        A=((x*y1)-(x1*y))/2;
        int B;
        B=((x1*y2)-(x2*y1))/2;
        int C;
        C=((x2*y3)-(x3*y2))/2;
        int D;
        D=((x3*y)-(x*y3))/2;
        int AREA=A+B+C+D;
        System.out.println(AREA);
  			
         }
   void  perimeter(int x,int y,int x1,int y1,int x2,int y2,int x3,int y3){
        int p;
        int a=distance(x,y,x1,y1);
        int b=distance(x1,y1,x2,y2);
        int c=distance(x2,y2,x3,y3);
        int d=distance(x3,y3,x,y);
        
        p=a+b+c+d;
        System.out.println(p);
    }
}
class Trapeziod extends Quadrilateral
{
    void trapeziod_area(int x,int y,int x1,int y1,int x2,int y2,int x3,int y3){
    int A;
        A=((x*y1)-(x1*y))/2;
        int B;
        B=((x1*y2)-(x2*y1))/2;
        int C;
        C=((x2*y3)-(x3*y2))/2;
        int D;
        D=((x3*y)-(x*y3))/2;
        int AREA=A+B+C+D;
        System.out.println(AREA);
    }
  			
  void  perimeter(int x,int y,int x1,int y1,int x2,int y2,int x3,int y3)
  {
        int p;
        int a=distance(x,y,x1,y1);
        int b=distance(x1,y1,x2,y2);
        int c=distance(x2,y2,x3,y3);
        int d=distance(x3,y3,x,y);
        
        p=a+b+c+d;
        System.out.println(p);
    }
}
public class Geometry
{    
    public static void main(String[] args)
	{
        Scanner obj = new Scanner(System.in);
		int x = obj.nextInt();
		int y = obj.nextInt();
		int x1 = obj.nextInt();
		int y1= obj.nextInt();
		int x2 = obj.nextInt();
		int y2= obj.nextInt();
		int x3= obj.nextInt();
		int y3= obj.nextInt();
	
	Quadrilateral obj1 = new Quadrilateral();
	int a=obj1.distance(x,y,x1,y1);
	int b=obj1.distance(x1,y1,x2,y2);
	int c=obj1.distance(x2,y2,x3,y3);
	int d=obj1.distance(x3,y3,x,y);
	int e=obj1.distance(x,y,x2,y2);
		
	int f=obj1.distance(x1,y1,x3,y3);
	int n=obj.nextInt();
	switch(n)
	{
		case 1 :
				if(n==1)
				{
                    Trapeziod obj5 =new Trapeziod();
                    obj5.perimeter(x,y,x1,y1,x2,y2, x3,y3);
                    obj5.trapeziod_area(x,y,x1,y1,x2,y2, x3,y3);
                }
			break;
		
		case 2 :
				if(n==2)
			{
					if(e!=f || e==f)
				{
					Parallelogram obj4 = new Parallelogram();
                    obj4.perimeter(x,y,x1,y1,x2,y2, x3,y3);
					obj4.parallelo_area(x,y,x1,y1,x2,y2, x3,y3);
                }
			}
			break;
			
		case 3 : 
				if(n==3)
				{
					if(a==c && b==d)
					{
					Rectangle obj3 = new  Rectangle();
					obj3.rectangle_area(x,y,x1,y1,x2,y2,x3,y3);					
					}
				}
			break;
			
		case 4 : 
				if(n==4)
		{
			if(a==b && a==d && a==c && b==c && b==d && c==d && e==f)
			{
				Square obj2 =new Square();
				obj2.square_area(x,y,x1,y1);
                                
			
			}		
		}
		}
	}
}