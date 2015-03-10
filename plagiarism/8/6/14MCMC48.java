import java.util.*;

class Reverse
{
	Reverse()
	{
		
		String rs;
		Scanner in = new Scanner(System.in);
				
		int x = in.nextInt();

		switch(x)
		{
			case 1:
			Scanner n = new Scanner(System.in);
			rs = n.nextLine();
			boolean b = rs.contains(" ");

			if(b)
			{
				String[] words = rs.split(" ");
				for(int i = words.length-1; i >= 0; i--)
				{
					System.out.print(words[i] + " ");
				}
			}
			else
			{
				String[] words = rs.split("");
				for(int i = words.length-1; i >= 0; i--)
				{
					System.out.print(words[i] + "");
				}
			}
			break;
			
			case 2:
			
			Scanner a = new Scanner(System.in);
			String str1 = a.nextLine();
			String str2 = a.nextLine();
			
			
			if(str1.compareTo(str2) == 0)
			{
				System.out.println("Equal");			
			}
			else
			{
				System.out.println("Not Equal");
			}
			
			break;

			case 3:

			Scanner c = new Scanner(System.in);
			String str3 = c.nextLine();
			String str4 = c.nextLine();
			String str5 = c.nextLine();
			String str6 = str3 + " " + str4+ " " + str5;
			System.out.println(str6); 
			

			break;

			case 4:

			Scanner d = new Scanner(System.in);
			String str7 = d.nextLine();
			String str8 = d.nextLine();
			String str9 = d.nextLine();
			String str10 = d.nextLine();
			
			int p = str7.length();
			int q = str8.length();
			int r = str9.length();
			int s = str10.length();
			
			 if(p>q)
		         {
	       		 	if(p>r)
             			 {
                         		if(p>s)
	                 		{  
                   				System.out.println(p);
                  	 		}

                 			else
                  			{
                    			System.out.println(s);
                   			}
               			}
          		}
             		else if(q>r)
                     	{
				if(q>s)
				{
	                                System.out.println(q);
                              	}
                            	else
                                {
	                                System.out.println(s);

                                }


                       }
               	   else if(r>s)
                      {
                             System.out.println(r);
                       }
	              else
	               {
	                    System.out.println(s);

	               }
		}
		
	}
	
	public static void main(String args[])
	{
		Reverse r = new Reverse();
		
	}
}
