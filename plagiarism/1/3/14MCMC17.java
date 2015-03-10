import java.util.Scanner;
import java.lang.Math;

class Imaginary
{
    private double realPart;
    private double imaginaryPart;
    
    
    Imaginary(double x,double y)
    {
        realPart=x;
        imaginaryPart=y;
    }
    
    double modulus(Imaginary m)
    {
        double mod;
        mod=Math.sqrt((m.realPart*m.realPart)+(m.imaginaryPart*m.imaginaryPart));
        return mod;
    }
    
    void addition(Imaginary a1,Imaginary a2)
    {
        double s1,s2;
        
        s1=a1.realPart+a2.realPart;
        s2=a1.imaginaryPart+a2.imaginaryPart;
        
        Imaginary sum=new Imaginary(s1,s2);
        putdata(sum);
     }
     
     void subtraction(Imaginary b1,Imaginary b2)
     {
     
        double d1,d2;
        
        d1=b1.realPart-b2.realPart;
        d2=b1.imaginaryPart-b2.imaginaryPart;
        
        Imaginary diff=new Imaginary(d1,d2);
        putdata(diff);
        
     }
     
     void multiplication(Imaginary p1,Imaginary p2)
     {
        double m1,m2;
        
        m1=((p1.realPart*p2.realPart)-(p1.imaginaryPart*p2.imaginaryPart));
        m2=((p1.realPart*p2.imaginaryPart)+(p1.imaginaryPart*p2.realPart));
        
        Imaginary pro=new Imaginary(m1,m2);
        putdata(pro);
        
     }
     
     void putdata(Imaginary data)
     {
        System.out.println(Math.round(data.realPart)+"+"+Math.round(data.imaginaryPart)+"i");
     }
     
}

class Test
{
    public static void main(String args[])
    {
    
        double p,q,r,s;
        int t;
        double mod;
        Imaginary complex1,complex2;
        
        Scanner in=new Scanner(System.in);
        p=in.nextDouble();
        q=in.nextDouble();
        r=in.nextDouble();
        s=in.nextDouble();
        
        complex1=new Imaginary(p,q);
        complex2=new Imaginary(r,s);
       
        
        t=in.nextInt();
        
        switch(t)
        {
            case 1: 
                {
                    mod=complex1.modulus(complex1);
                    System.out.printf("%.2f",mod);
                    mod=complex2.modulus(complex2);
                    System.out.printf("%.2f",mod);
                    break;
                 }
                    
            case 2: complex1.addition(complex1,complex2);
                    break;
                    
            case 3: complex1.subtraction(complex1,complex2);
                    break;
                    
            case 4: complex1.multiplication(complex1,complex2);
                    break;
                    
            default: System.out.println("Wrong Choice");
            
        };
        
    }
}
