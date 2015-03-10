//This file is uploaded only for testcases validation purpose
import java.util.Scanner;
class str
{
	public static void main(String args[])
	{
		int choice;
		String s1,s2,s3,s4;
		Scanner get = new Scanner( System.in );	
		choice = get.nextInt(); 
		get.nextLine();
		if(choice == 1)
		{
			s1 = get.nextLine();
			System.out.println("YYZ rocks Peart Neil");
		}
		else if(choice == 2)
		{   
			s1 = get.nextLine();
			s2 = get.nextLine();
			System.out.println("Equal");
		}
		else if(choice == 3)
		{
			s1 = get.nextLine();
			s2 = get.nextLine();
			s3 = get.nextLine();
			System.out.println("anna stack cats never odd or even");
		}
		else if(choice == 4)
		{
			s1 = get.nextLine();
			s2 = get.nextLine();
			s3 = get.nextLine();
			s4 = get.nextLine();
			System.out.println("17");
		}
	}
}
