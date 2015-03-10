import java.util.Scanner;
class Quadrilateral{

	

	int distance(int a,int b, int c ,int d){
		 int D;
			D=(int)Math.sqrt(((a-c)*(a-c))+((b-d)*(b-d)));
				return D;
}
}

	class Square extends Quadrilateral{
			void sarea(int x, int y,int x1,int y1)
		{
                    int a=distance(x,y,x1,y1);
			int p=4*a;
			System.out.println(p);
			int A;
				 A=a*a;
		System.out.println(A);
			
		}
}
class Rectangle extends Quadrilateral{
		void rarea(int x, int y, int x1,int y1,int x2,int y2,int y3,int x3){
			

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
class Parallelogram extends Quadrilateral
{
    void parea(int x,int y,int x1,int y1,int x2,int y2,int x3,int y3){
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
class Tropozido extends Quadrilateral
{
    void tarea(int x,int y,int x1,int y1,int x2,int y2,int x3,int y3){
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
public class Try {

    
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);		int x = obj.nextInt();
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
	//System.out.println(e);
	
	int f=obj1.distance(x1,y1,x3,y3);
	//System.out.println(f);
		//System.out.println(a+b+c+d);
		int n=obj.nextInt();
		if(n==4)
		{
			if(a==b && a==d && a==c && b==c && b==d && c==d && e==f)
			{
				Square obj2 =new Square();
				obj2.sarea(x,y,x1,y1);
                                
			
			}
		
		}
                if(n==3)
				{
					if(a==c && b==d)
					{
					Rectangle obj3 = new  Rectangle();
					obj3.rarea(x,y,x1,y1,x2,y2,x3,y3);					
				}
				
   				}
                 if(n==2){
					if(e!=f || e==f)
					{
						Parallelogram obj4 = new Parallelogram();
                                                obj4.perimeter(x,y,x1,y1,x2,y2, x3,y3);
						obj4.parea(x,y,x1,y1,x2,y2, x3,y3);
                                                
					}
				}
                 if(n==1){
                             Tropozido obj5 =new Tropozido();
                             obj5.perimeter(x,y,x1,y1,x2,y2, x3,y3);
                             obj5.tarea(x,y,x1,y1,x2,y2, x3,y3);
                             
                         }

    }
    
}
