import java.util.*;
class imag_no
{
	private double R;
	private double I;
	
	imag_no(int x,int y)
	{
		R=x;
		I=y;
	}
	
	imag_no(double x,double y)
	{
		R=x;
		I=y;
	}
	
	imag_no()
	{
		R=0;
		I=0;
	}
	public double mod()
	{
		double mod=Math.sqrt(R*R+I*I);
		return mod;
	}
	public void display()
	{
		System.out.println(R+"+"+I+"i");
	}
	public double get_re()
	{
		return R;
	}
	public double get_im()
	{
		return I;
	}
}

class A1
{
public static void main(String args[])
{
	int p,q,r,s,t;
	Scanner input=new Scanner(System.in);
	p=input.nextInt();
	q=input.nextInt();
	r=input.nextInt();
	s=input.nextInt();
	t=input.nextInt();
	imag_no a=new imag_no(p,q);
	imag_no b=new imag_no(r,s);
	imag_no z=new imag_no(r,s);
	switch(t)
	{
		case 1:	
			double mod1=a.mod()+b.mod();
			System.out.printf("%.2f",mod1);
			break;
		case 2:
			z=add(a,b);
			z.display();
			break;
		case 3:
			z=sub(a,b);
			z.display();
			break;
		case 4:
			z=prod(a,b);
			z.display();
			break;
		
	}
	
	
}
	public static imag_no add(imag_no a,imag_no b)
	{ 
		imag_no sum=new imag_no(a.get_re()+b.get_re(),a.get_im()+b.get_im());
		//sum.R=a.get_re()+b.get_re();
		//sum.I=a.get_im()+b.get_im();
		return sum;
	}
	public static imag_no sub(imag_no a,imag_no b)
	{
		imag_no diff=new imag_no(a.get_re()-b.get_re(),a.get_im()-b.get_im());
		//diff.R=a.get_re()-b.get_re();
		//diff.I=a.get_im()-b.get_im();
		return diff;
	}
	public static imag_no prod(imag_no a,imag_no b)
	{
		imag_no mul=new imag_no((a.get_re()*b.get_re())-(a.get_im()*b.get_im()),(a.get_re()*b.get_im())+(a.get_im()*b.get_re()));
		/*mul.R=(a.get_re()*b.get_re())-(a.get_im()*b.get_im());
		mul.I=(a.get_re()*b.get_im())+(a.get_im()*b.get_re());*/
		return mul;
	}
}
		
		
		
		
		
		
