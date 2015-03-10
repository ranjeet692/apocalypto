import java.util.*;
class strg
{
	
	String name;
	static String newStr="";
	static int strlength[]=new int[4]; 
	String str[] =new String[4];
	strg(){
	}
	strg (String n)
	{
		
		this.name=n;
		palindrome(removeSpeces(this.name));
		
	}
	
	strg (String str1, String str2){
	
	comp(str1,str2);
		
	}
	
	strg (String str1,String str2,String str3){
	
		cate(str1,str2,str3);	
	}
	strg (String str1,String str2,String str3,String str4){
		getMaxLength();
	}
	
	
	
	String removeSpeces(String str){
		int i=0;
		String s="";
		for(;i<str.length();i++){
			if(str.charAt(i)!=' '){
			s=s+str.toLowerCase().charAt(i);				
			}
		}
		return s;
		
	}
	
	void palindrome(String tempstr)
	{
		
			int l=tempstr.length();
			int i,begin,middle,end;
			begin=0;
			end=l-1;
			middle=(begin+end)/2;
			for (i=begin;i<=middle;i++)
			{
				if(tempstr.charAt(begin)==tempstr.charAt(end))
				{
					begin++;
					end--;
				}
				else
				{
					break;
				}
			}
		
			if(i==middle+1)
			{
				System.out.println("Palindrome");
			}
			else
			{
				System.out.println("Not Palindrome");
			}
			
	}
	void comp(String str1,String str2)
	{
		if(str1.compareToIgnoreCase(str2)==0)
		{
			System.out.println("Equal");
		}
		else
		{
		System.out.println("Not Equal");
		}	
	}
	
	static String cate(String str1,String str2,String str3)
	{
		strg.newStr=str1.trim()+" "+str2.trim()+" "+str3.trim();
		System.out.println(strg.newStr);
		return strg.newStr;
			
		
		
	}
	static int getMaxLength(){
		int max=0;
		for(int i=0;i<strlength.length;i++){
		

			if(strlength[i]>max){
				max=strlength[i];
			}
		}
		
		
		System.out.println(max);
		return max;
	}
	
	
	void display ()
	{
		System.out.println(name);
		
	}
}
class sttr
{
	public static void main(String args[])
	{
		int i,n;
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		in.nextLine();
		
		
		strg s1=new strg();
		for(i=0;i<n;i++)
		{
		
		
			
			String n1=in.nextLine();
			s1.str[i]=n1;
			strg.strlength[i]=n1.length();
			
		}
		
		
		
		
		if(n==1)
	{
		new strg(s1.str[n-1]);
	}
	else if(n==2){
	
		new strg(s1.str[n-2],s1.str[n-1]);
	}
	else if(n==3){
	
		new strg(s1.str[n-3],s1.str[n-2],s1.str[n-1]);
	}
	else if(n==4){
	
		new strg(s1.str[n-4],s1.str[n-3],s1.str[n-2],s1.str[n-1]);
	}

		
	}
	
	
}
