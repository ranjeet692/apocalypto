import java.util.*;
class assingment
{
void assingment(String B)
{int flag=0;
        for (char c: B.toCharArray())
       {
       if(c==' ')
       flag=1;
        }

        if(flag==0){

                StringBuffer buffer =new StringBuffer(B);
                buffer.reverse();
                System.out.println(buffer);

        }
        else
        {
                StringBuilder rev=new StringBuilder("");
                int end=B.length();
                int cntr=B.length()-1;
                for(int i=B.length()-1;i>=0;i--)
                {
                        if(B.charAt(i)==' ' || i==0)
                        {
                                if(i !=0)
                                {	//rev.append(" ");
                                        rev.append(B.substring(i,end));
                                        rev.append(" ");

                                }
                                else
                                {rev.append(B.substring(i,end));}
                                end=cntr;
                        }
                        cntr--;
                }
                System.out.println(rev);
        }

}

void assingment(String s1, String s2)
{
if (s1.equalsIgnoreCase(s2))
                             {
                              // this line WILL print
                                     System.out.println("Equal");
                                        }
                                         else
                             System.out.println("Not Equal");

}
void  assingment(String s3, String s4, String s5)
{
//System.out.println(s3+s4+s5);
System.out.println(s3+" "+s4+" "+s5);

}

void assingment(String s6,String s7,String s8,String s9)
{

        int e,b,c,d;
        e=s6.length();
        b=s7.length();
        c=s8.length();
        d=s9.length();
	//int l1,l2,l3,l4;
	//l1=s6.compareTo(s7);
	

        if (e>b && e>c && e>d)
                        System.out.println(e);
        else if(b>c && b>d)
                        System.out.println(b);
        else if (c>d)
                        System.out.println(c);
        else System.out.println(d);


}

public static void main(String args[])
{

assingment ob=new assingment();
        Scanner in=new Scanner(System.in);
int a=in.nextInt();
in.nextLine();
switch(a)
{
        case 1 : String a1=in.nextLine();
                ob.assingment(a1);
                 break;


        case 2 :  a1=in.nextLine();
                 String b1=in.nextLine();
                  ob.assingment(a1,b1);
                   break;

        case 3: a1=in.nextLine();
                b1=in.nextLine();
                String c1=in.nextLine();
                ob.assingment(a1,b1,c1);
                break;


        case 4:  a1=in.nextLine();
                 b1=in.nextLine();
                c1=in.nextLine();
                String d1=in.nextLine();
                ob.assingment(a1,b1,c1,d1);
break;
}


}


}

