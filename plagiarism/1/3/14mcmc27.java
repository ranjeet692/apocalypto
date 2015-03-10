import java.lang.Math;
import java.util.Scanner;
public class ImaginaryNumber {
	private double realPart;
	private double ImaginaryPart;
	
	ImaginaryNumber(){
		
	}
	ImaginaryNumber(int Real1,int Imag1)
	{
	realPart=Real1;
	ImaginaryPart=Imag1;
	}
	
	ImaginaryNumber AddComplex(ImaginaryNumber C1,ImaginaryNumber C2)
	{
	ImaginaryNumber CSum=new ImaginaryNumber();
	CSum.realPart=C1.realPart+C2.realPart;
	CSum.ImaginaryPart=C1.ImaginaryPart+C2.ImaginaryPart;
	return CSum;
	}
	
	ImaginaryNumber SubComplex(ImaginaryNumber C1,ImaginaryNumber C2)
	{
	ImaginaryNumber CSub=new ImaginaryNumber();
	CSub.realPart=C1.realPart-C2.realPart;
	CSub.ImaginaryPart=C1.ImaginaryPart-C2.ImaginaryPart;
	return CSub;
	}
	ImaginaryNumber MulComplex(ImaginaryNumber C1,ImaginaryNumber C2)
	{
	ImaginaryNumber CMul=new ImaginaryNumber();
	CMul.realPart = C1.realPart * C2.realPart - C1.ImaginaryPart * C2.ImaginaryPart;
	CMul.ImaginaryPart = C1.realPart * C2.ImaginaryPart + C1.ImaginaryPart * C2.realPart;
	return CMul;
	}
	
	ImaginaryNumber ModComplex(ImaginaryNumber C1,ImaginaryNumber C2)
	{
	ImaginaryNumber CMod=new ImaginaryNumber();
	CMod.realPart = Math.sqrt((C1.realPart * C1.realPart)+(C1.ImaginaryPart * C1.ImaginaryPart))+ Math.sqrt((C2.realPart * C2.realPart)+(C2.ImaginaryPart * C2.ImaginaryPart));
	return CMod;
	}
	
	public static void main(String[] a){
	
	Scanner sc = new Scanner(System.in);
	int p,q,r,s,t;
		
	p = sc.nextInt();
	q = sc.nextInt();
	r = sc.nextInt();
	s = sc.nextInt();
	t = sc.nextInt();
	
		
	ImaginaryNumber C1=new ImaginaryNumber(p,q);
	ImaginaryNumber C2=new ImaginaryNumber(r,s);
	ImaginaryNumber C3=new ImaginaryNumber();
	
	
	switch(t){
		case 1:
			C3 = C3.ModComplex(C1, C2);
			System.out.printf("%.2f", C3.realPart);
			break;
		case 2:
			C3 = C3.AddComplex(C1, C2);
			System.out.println(Math.round(C3.realPart) +"+" +Math.round(C3.ImaginaryPart)+"i");
			break;
		case 3:
			C3 = C3.SubComplex(C1, C2);
			System.out.println(Math.round(C3.realPart) +"+" +Math.round(C3.ImaginaryPart)+"i");
			break;
		case 4:
			C3 = C3.MulComplex(C1, C2);
			System.out.println(Math.round(C3.realPart) +"+" +Math.round(C3.ImaginaryPart)+"i");
			break;
		
		}
	}
}
