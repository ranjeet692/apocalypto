import java.util.Scanner;
	class Assing
	{
		String a;
		String b;
		String c;
		String d;
		test(String n1)
		{
			w=a;
		}
		test(String n1,String n2)
		{
		 	w=a;
	 		x=b;
		}
		 test(String n1,String n2,String n3)
		{
		 	w=a;
		 	x=b;
		 	y=c;
		}
		 test(String n1,String n2,String n3,String n4)
		{
		 	w=a;
		 	x=b;
		 	y=c;
		 	z=d;
        	}
	void compare(String a,String b)
	{
		if(a.equals(b))
		{
            		System.out.println("equal.");
		} 
		else 
		{
            		System.out.println("not equal.");
		}
	}
	void concat(String a,String b,String c)
	{
 		 System.out.println(a+" "+b+" "+c);
	}
	void len(String a,String b,String c,String d)
	{
		 System.out.println(a.lenth+b.lenth+c.lenth+d.lenth);
	}
	void rev(String a)
	{
	}
	class str
	{
		public static void main(String args[])
	{
	int no;
	test A = new test;
	Scanner in = new Scanner(System.in);
	a = input.nextInt();
	switch(a)
	{
	case 1:
		String w = in.nextLine()
		break;
	case 2:
		String x = in.nextLine();
		String y = in.nextLine();
		A.compare(w,x);
		break;
	case 3:
		String w = in.nextLine();
		String x = in.nextLine();
		String y = in.nextLine();
		A.concat(w,x,y);
		break;
	case 4:
		String w = in.nextLine();
		String x = in.nextLine();
		String y = in.nextLine();
		String z = in.nextLine();
		A.len(w,x,y,z);
		break;
	default:
            System.out.println("invalid entry");
}
}
}
