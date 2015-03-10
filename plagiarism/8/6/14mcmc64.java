import java.util.*;
import java.lang.*;
class test
{
String a;
String b;
String c;
String d;
test(String n1)//constructer1
{
a=n1;
}//close cosed constructer1
test(String n1,String n2)//constructer2
{
a=n1;
b=n2;
}
test(String n1,String n2,String n3)//constructer3
{
a=n1;
b=n2;
c=n3;
}
test(String n1,String n2,String n3,String n4)//constructer1
{
a=n1;
b=n2;
c=n3;
d=n4;
}
void compare()//method1
{
	if(a.equalsIgnoreCase(b))
	{
		    System.out.println("Equal");
	} 
	else 
	{
		    System.out.println("Not Equal");
	}
}

void concat()//method2
{
  	System.out.println(a+" "+b+" "+c);
}

void len()//method3
{
int w,x,y,z;
w=a.length();
x=b.length();
y=c.length();
z=d.length();

if(w>x)
{
	if(w>y)
	{
		if(w>z)
		{
			System.out.println(w);
		}
		else
		{
			System.out.println(z);
		}
	}
	else
	{
		if(y>z)
		{
			System.out.println(y);;
		}
		else
		{
			System.out.println(z);
		}
	}
}
else
{
	if(x>y)
	{
		if(x>z)
		{
			System.out.println(x);
		}
		else
		{
			System.out.println(z);
		}
	}
	else
	{
		if(y>z)
		{
			System.out.println(y);
		}
		else
		{
			System.out.println(z);
		}
	}
				
}
}

void rev()//method4
	{

	
	int j=1;
	int size[]=new int[a.length()-1];
	size[0]=0;
	for(int i=0;i<a.length();i++)
	{
		if(a.charAt(i)==' ')
		{
			size[j++]=i+1;
		}
	}
	j--;
if(j==0)
{
StringBuffer r=new StringBuffer(a);
System.out.println(r.reverse());
}
	else{
	int end=a.length();
	
	
	while(j>=0)
{
	for(int i=size[j];i<end;i++)
{
	
	System.out.print(a.charAt(i));
}
	if(j!=0)
	System.out.print(" ");
	end=size[j--]-1;
	
}
}
}
}	
//end test class
class str
{

public static void main(String arg[]){
	Scanner in =new Scanner(System.in);
	int n;
	n=in.nextInt();
	in.nextLine();

	if(n==1)
{
	String p =in.nextLine();
	test o=new test(p);
	o.rev();
	         } 
	if(n==2){
	String p=in.nextLine();
	String q=in.nextLine();
	test o1= new test(p,q);
	o1.compare();	
			}
	else if(n==3){
	String p=in.nextLine();
	String q=in.nextLine();
	String r=in.nextLine();
	test o3= new test(p,q,r );
	o3.concat();
		     }
	else if(n==4){
	String p=in.nextLine();
	String q=in.nextLine();
	String r=in.nextLine();
	String s=in.nextLine();
	test o4 =new test(p,q,r,s);
	o4.len();
			}

			}
}			

