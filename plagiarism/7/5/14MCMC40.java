import java.util.*;
class palindrome
{
	public static void main(String args[])
	{
	String orig,rev="";
Scanner p  = new Scanner(System.in);

System.out.println("enter the string");
orig =p.nextLine();
int lenght=orig.length();
for (int i=lenght-1;i>=0;i--)
	rev=rev+orig.charAt(i);
if(orig.equals(rev))
	System.out.println("npalindrome");
else
	System.out.println("not palindrome");
	}}


