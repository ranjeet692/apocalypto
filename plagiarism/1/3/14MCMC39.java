import java.util.*;
import java.io.*;
import java.lang.*;

//public int  p,q,r,s;
class ImaginaryNumber{
        public static void main(String agru[]){
                Scanner si= new Scanner (System.in);
                funct f= new funct();
                f.p= si.nextInt();
                f.q=si.nextInt();
                f.r=si.nextInt();
                f.s=si.nextInt();
                f.t=si.nextInt();

                switch(f.t)
                {
                        case 1:f.Modulous();
                                break;
                        case 2: f.Addition();
                                break;
                        case 3: f.Subtraction();
        		         break;
                        case 4:f.Multiplication();
                                break;
                }
        }

}


class funct {
  private double realPart;
  private double ImaginaryPart,sum;
  public double p,q,r,s;
  public int t;

void Addition(){
        realPart=(p+r);
        ImaginaryPart=(q+s);
	
        System.out.println(StrictMath.round(realPart)+"+"+StrictMath.round(ImaginaryPart)+"i");
                }
void Modulous(){
        realPart=Math.sqrt((p*p)+(q*q));
        ImaginaryPart=Math.sqrt((r*r)+(s*s));
	sum=realPart+ImaginaryPart;
        System.out.println(StrictMath.round(sum));
}

void Subtraction(){
       
                realPart=(p-r);
                ImaginaryPart=(q-s);
		if((p>r)&&(q>s))
                System.out.println(StrictMath.round(realPart)+"+"+StrictMath.round(ImaginaryPart)+"i");
                else 
        
                 System.out.println(StrictMath.round(realPart)+""+StrictMath.round(ImaginaryPart)+"i");

}

void Multiplication(){
     realPart=((p*r)+((-1)*(q*s)));
     ImaginaryPart=((q*r)+(p*s));
        System.out.println(StrictMath.round(realPart)+"+"+StrictMath.round(ImaginaryPart)+"i");
}
}


