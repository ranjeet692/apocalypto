import java.util.*;
import java.io.*;
import java.lang.*;


class AreaOfFigure extends Quadrilateral {

	 

       /* public void areaParallelogram () {

                area = base1*height;
                //perimeter =
                System.out.println(area);
		//System.out.println(perimeter);
        

    
*/
       
        public static void main (String args[]) {

        AreaOfFigure obj=new AreaOfFigure();
        Scanner s= new Scanner (System.in);
                obj.FposX=s.nextDouble();
                obj.FposY=s.nextDouble();  //1st quad

                obj.FrposX=s.nextDouble();
                obj.FrposY=s.nextDouble(); //4th quad

                obj.TposX=s.nextDouble();
                obj.TposY=s.nextDouble(); //3rd quad

                obj.SposX=s.nextDouble();
                obj.SposY=s.nextDouble(); //2nd quad

                obj.ch=s.nextInt();     //value for method call

                switch(obj.ch)
                {
                        case 1: obj.areaTrapezium();
                                break;
                        case 2: obj.areaParallelogram();
                                break;
                        case 3: obj.areaRectrangle();
                                break;
                        case 4: obj.areaSquare();
                                break;
                }

        }
}

class Quadrilateral {

//      private int x_axis = 0,y_axis = 0;              // axis point
        public int area = 0,perimeter = 0;           //main working
        public double FposY,FrposY,SposY,TposY;        //y_axis
        public double FposX,SposX,TposX,FrposX;       //x_axis
        public double base1,base2,height;
        public double base4,base3;
	public int ch;

        public void areaTrapezium () {
                base1 = Math.sqrt(Math.pow((FposX-FrposX),2)+Math.pow((FposY-FrposY),2));
                base2 = Math.sqrt(Math.pow((SposX-TposX),2)+Math.pow((SposY-TposY),2));
		base3 = Math.sqrt(Math.pow((FposX-SposX),2)+Math.pow((FposY-SposY),2));
		base4 = Math.sqrt(Math.pow((TposX-FrposX),2)+Math.pow((TposY-FrposY),2));
                height = FrposY+TposY;
		area = (int)(((base1+base2)/2)*height);
		perimeter = (int)(base1+base2+base3+base4);
System.out.println(perimeter);
                System.out.println(area);                }


        public void areaParallelogram () {
                base1 = Math.sqrt(Math.pow((FposX-FrposX),2)+Math.pow((FposY-FrposY),2));
		base3 = Math.sqrt(Math.pow((FposX-SposX),2)+Math.pow((FposY-SposY),2));
                //base2 = RniveY,LniveY;
                height = FrposY-TposY;
		area = (int)(base1*height);
		
		perimeter = (int)(2*(base1+base3));
		System.out.println(perimeter);
                System.out.println(area);

        }

        public void areaRectrangle () {
                base1 = Math.sqrt(Math.pow((FposX-FrposX),2)+Math.pow((FposY-FrposY),2));
		base3 = Math.sqrt(Math.pow((FposX-SposX),2)+Math.pow((FposY-SposY),2));
                //height = base1;
		 area = (int)(base1*base3);
                 perimeter = (int)(2*(base1+base3));
           System.out.println(perimeter);
                System.out.println(area);

        }

        public void areaSquare () {
               
                base1 = Math.sqrt(Math.pow((FposX-FrposX),2)+Math.pow((FposY-FrposY),2));
		
		area = (int)(base1*base1);
                perimeter = (int)(4*base1);
                System.out.println(perimeter);
                System.out.println(area);
        }
}





