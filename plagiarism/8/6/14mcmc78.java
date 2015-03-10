class reversarr
{
	public static void main(String [] args)
	{
		comp2 c=new comp2("java","c++","c","c#");
		c.display();
		comlen com=new comlen();
		com.compare();
		com.concat();
           String [] str = {"Rise","to","vote","sir"};
	   /*int len = str.length();
	   char [] temparray=new char[len];
	   char [] chararray =new char[len];
	   for(int i=0 ;i<len;i++)
	   {
		   temparray[i]=str.charAt(i);
	   }
           
	   for(int j=0 ;j<len;j++)
	   {
		   chararray[j]=temparray[j];
	   }*/
	   for(int i=3;i>0;i--)
	   {palindrome
		   System.out.print(str[i]);
	   }
	   System.out.println();
	}
}
class comlen
{
	public static void compare()
	{
	  String str1 = " Rise to vote sir";
	  String str2 = "Code mafia Teame";
	  int len1=str1.length();
	  int len2=str2.length();
	  if(len1==len2)
          {
		  System.out.println("Equal");
	  }
	  else 
		  System.out.println("Not Equal");
	}
	void concat()
	{
		String concats="java" +" "+
			      "string" + " "+
			      "class";
		System.out.println(concats);
	}
	
}
class comp2
{
  String a;
  String b;
  String c;
  String d;
  comp2(String x,String y,String z,String w)
  {
    a=x;
    b=y;
    c=z;
    d=w;
  }
      void display()
      {
        int n1=a.length();
        int n2 =b.length();
        int n3=c.length();
        int n4 =d.length();
	if(n1>n2 &&n1>n3&&n1>n4)
          {
          System.out.println("Big one is "+ n1);
          }
	else if (n2>n1&&n2>n3&&n2>n4)
	{
	   System.out.println("Big one is "+ n2);
	}
	else if (n3>n1&&n3>n2&&n3>n4)
	{
	   System.out.println("Big one is "+ n3);
	}
        else 
	System.out.println("Big one is "+ n4);
      }    
}
