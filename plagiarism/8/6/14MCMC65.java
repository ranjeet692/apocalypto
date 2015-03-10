import java.lang.Math;
import java.util.Scanner;
class s
{  	 s(String s1)
	{int i=0;
		for( char c :s1.toCharArray())
			{ if(c==' ')
                   		 i++;
                	}
   		if(i==0)
    		{        String reverse="";
			int length = s1.length();

    			for ( int j = length - 1 ; j >= 0 ; j-- )
      			 	reverse = reverse + s1.charAt(j);

   			System.out.println(reverse.toString());
   		}
               else
		{
			StringBuilder str = new StringBuilder("");
			int end= s1.length();
			int counter = s1.length()-1;
			for( i = s1.length()-1; i >=0 ;i--)
			{
					if (s1.charAt(i) == ' '|| i == 0)
						{
							if(i != 0)
								{
									str.append(s1.substring(i+1,end));
									str.append(" ");}
					else
						str.append(s1.substring(i,end));
						end = counter;

						}
					counter--;
			}	
			System.out.println(str);		
			}
                 
		
			
	}
	s(String s1,String s2)
	{ if(s1.equals(s2))

		System.out.println("Equal");
          else
		System.out.println("Not Equal");

	}

	s(String s1, String s2, String s3)
	{  s1=s1.concat(" "+s2);
           s1=s1.concat(" "+s3);
           System.out.println(s1);

	}
	s(String s1, String s2, String s3,String s4)
	{int a=s1.length();
         int b=s2.length();
         int c=s3.length();
         int d=s4.length();
         System.out.println(Math.max(d,Math.max(c,Math.max(a,b))));
 
	}


}

class ss
{
    public static void main(String args[])
    {
  
        int t;
        Scanner in=new Scanner(System.in);
       	t=in.nextInt();
	String s1,s2,s3,s4,s5;
        in.nextLine();
        switch(t)
        {
            case 1: s1=in.nextLine();
		     s obj=new s(s1);
                    break;
                    
            case 2: s1=in.nextLine();
		    s2=in.nextLine();
		    s obj1=new s(s1,s2);
                    break;
                    
            case 3: s1=in.nextLine();
		    s2=in.nextLine();
                    s3=in.nextLine();
		    s obj2=new s(s1,s2,s3);
                    break;
                    
            case 4: s1=in.nextLine();
		    s2=in.nextLine();
		    s3=in.nextLine();
		    s4=in.nextLine();
   		    s obj3=new s(s1,s2,s3,s4);
                    break;
                    
            
            
        }
        
    }
}

