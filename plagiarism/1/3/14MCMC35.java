
import java.util.Scanner;
import java.lang.Math;
class assign1
{
        public static void main(String []args)
        {
                int n;
                
                Scanner rec=new Scanner(System.in);
                calc c=new calc();
                c.p=rec.nextDouble();
                c.q=rec.nextDouble();
                c.r=rec.nextDouble();
                c.s=rec.nextDouble();
                n=rec.nextInt();
                switch(n)
                {
                 case 1:c.mod();break;
                 case 2:c.add();break;
                 case 3:c.sub();break;
                 case 4:c.mul();break;
                }

        }
}
class calc
{
    double p,q,r,s;
    double sqrt1,sqrt2;
    void mod()
{

  sqrt1=Math.sqrt((p*p)+(q*q)); 
  sqrt2=Math.sqrt((r*r)+(s*s));
  System.out.println(Math.round(sqrt1+sqrt2));
}
    void add()
    {
    System.out.println(Math.round(p+r)+ "+" +Math.round(q+s) + "i");
    }
    void sub()
    {
    if((p>r)&&(q>s))
    System.out.println(Math.round(p-r)+ "+" +Math.round(q-s) + "i");
    else
    System.out.println(Math.round(p-r)+ "" +Math.round(q-s) + "i");
    }
    void mul()
    {
    System.out.println(Math.round((p*r)-(s*q)) + "+" +Math.round((s*p)+(r*q)) + "i");
    }
}

