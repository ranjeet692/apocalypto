
import java.util.Scanner;
public class Quad{
	private Point p1,p2,p3,p4;
	float l1,l2,l3,l4;

	public Quad(Point p1,Point p2,Point p3,Point p4){
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
		this.p4=p4;	
		l1=distance(p1,p2);
		l2=distance(p2,p3);
		l3=distance(p3,p4);
		l4=distance(p4,p1);
		
	}
	private float distance(Point first,Point second){
		return (float)Math.sqrt((first.getX()-second.getX())*(first.getX()-second.getX())+
			(first.getY()-second.getY())*(first.getY()-second.getY()));
        }
	
	public float perimeter(){
		return (l1+l2+l3+l4);
	}
	public float area(){
		float area1 = 0.5f*((p2.getX()-p1.getX())*(p3.getY()-p1.getY())-(p3.getX()-p1.getX())*(p2.getY()-p1.getY()));
		float area2 = 0.5f*((p4.getX()-p3.getX())*(p1.getY()-p3.getY())-(p1.getX()-p3.getX())*(p4.getY()-p3.getY()));
                if(area1<0){
                    area1=-area1;
                }
                if(area2<0){
                    area2=-area2;
                }
		return (area1+area2);		
	
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Point[] p = new Point[4];
		float x,y;
		for(int i=0;i<4;i++){
			x=sc.nextFloat();
			y=sc.nextFloat();
			p[i]=new Point(x,y);
		}
		int mode = sc.nextInt();
		Quad test;
		
		switch (mode){
			case 1:
				test= new Tapezoid(p[0],p[1],p[2],p[3]);
				break;
			case 2:
				test = new Parallelogram(p[0],p[1],p[2],p[3]);
				break;
			case 3:
				test= new Rectangle(p[0],p[1],p[2],p[3]);
				break;
			case 4:
				test = new Square(p[0],p[1],p[2],p[3]);
				break;
			default:
				System.out.println("Invalid choice");
                                test = null;
				break;
			}
                if(test!=null){
                    float per=test.perimeter();
                    float are= test.area();  
                    int perim = Math.round(per);
                    int area = Math.round(are);
                    System.out.println(perim);
                    System.out.println(area);
                    
                }
		
	}
			

			
		
		
}

class Tapezoid extends Quad{
    public Tapezoid(Point p1,Point p2,Point p3,Point p4){
        super(p1,p2,p3,p4);
    }
}
    

    


class Parallelogram extends Quad{
    public Parallelogram(Point p1,Point p2,Point p3,Point p4){
        super(p1,p2,p3,p4);
    }
}


class Rectangle extends Quad{
       public Rectangle(Point p1,Point p2,Point p3,Point p4){
          super(p1,p2,p3,p4);
       }

       @Override
	public float perimeter(){
		return (2*(l1+l2));
        }
       @Override
	public float area(){
		return (l1*l2);
	}
}

class Square extends Quad{
        public Square(Point p1,Point p2,Point p3,Point p4){
            super(p1,p2,p3,p4);
        }

        @Override
	public float perimeter(){
		return (4*l1);
	}
        @Override
	public float area(){
		return (l1*l1);
	}
}

class Point{
	private float x;
	private float y;
	public Point(float x,float y){
		this.x=x;
		this.y=y;
	}
	public float getX(){
		return this.x;
	}
	public float getY(){
		return this.y;
	}
}

