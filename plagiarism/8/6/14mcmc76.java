import java.util.*;
class compare_string
{ 
	compare_string(String s1)
	{
	String rev = "";	
	String str[] = s1.split(" ");
	String tmp = "";
	if(str.length==1)
	{
		
		for(int i = s1.length()-1; i>=0; i--)
			rev = rev+s1.charAt(i);
	System.out.println(rev);
	}	
	else
	{	
		for(int i = str.length-1;i>=0;i--)	
		tmp = tmp+str[i]+" ";
		System.out.println(tmp);
	}	 
	}
	compare_string(String s2,String s3)
	{	
			if(s2.compareTo(s3)==0)
				System.out.println("Equal");
			else
				System.out.println("Not Equal");
	}
		
	compare_string(String s4,String s5,String s6)
	{
	System.out.println(s4+" "+s5+" "+s6);
	}
	compare_string(String s7,String s8,String s9,String s0)
	{
	int l1 = s7.length();
	int l2 = s8.length();
	int l3 = s9.length();
	int l4 = s0.length(); 
	if((l1>l2)&&(l1>l3)&&(l1>l4))
		System.out.println( l1);
	else 
		if((l2>l1)&&(l2>l3)&&(l2>l4))
		System.out.println(l2);
		else
			if((l3>l1)&&(l3>l2)&&(l3>l4))
			System.out.println(l3);
			else
				System.out.println(l4);
	}
	
	
}
 class String_name
{
	public static void main(String args[])
	{
		Scanner input = new Scanner (System.in);
		int choice = input.nextInt();
		input.nextLine();		
		switch(choice)
		{
			case 1 :			       			       	
			       String s1 = input.nextLine();
			       compare_string obj1 = new compare_string(s1);
			       break;
			case 2 :			       
			       String s2 = input.nextLine();
			       String s3 = input.nextLine();
			       compare_string obj2 = new compare_string(s2,s3);
			       break;
			case 3 :			       
			       String s4 = input.nextLine();
			       String s5 = input.nextLine();
			       String s6 = input.nextLine();
			       compare_string obj3 = new compare_string(s4,s5,s6);
			       break;
			case 4 :			      
			       String s7 = input.nextLine();
			       String s8 = input.nextLine();
			       String s9 = input.nextLine();
			       String s0 = input.nextLine();
			       compare_string obj4 = new compare_string(s7,s8,s9,s0);
			       break;
			default:			
		}
	}
}
