import java.io.*;
import java.util.Scanner;
import java.lang.*;

class oper
{
        int n;
        char data[]={};
        String str="",st2="",st3="",st4="";
        void palin()
        {
          int len=str.length();
           char temp[]=new char[len];
           char orig[]=new char[len];
            for(int i=0;i<len;i++)      //array of chars
            {
              temp[i]=str.charAt(i);
            }
            for(int j=0;j<len;j++)
            {
              orig[j]=temp[len-1-j];
            }
            String rev=new String(orig);
            String orign=new String(temp);
            if(rev.equals(orign))
            System.out.println("Palindrome");
            else
            System.out.println("Not Palindrome");
        }
        void equal()
        {
        
        if (str.compareTo(st2)==0)
          System.out.println("Equal");
          else
          System.out.println("Not Equal");
        }
        void conc()
        {
          String news=str.concat(st2);
          String news1=news.concat(st3);
          System.out.println(news1);
        }
        void comp()
        {
          int l1,l2,l3,l4;
          l1=str.length();
          l2=st2.length();
          l3=st3.length();
          l4=st4.length();
          if(l1>l2&&l1>l3&&l1>l4)
            System.out.println(l1);
            else if(l2>l3&&l2>l4)
              System.out.println(l2);
              else if(l3>l4)
              System.out.println(l3);
              else
              System.out.println(l4);
          
        }
}
class mee
{
        public static void main(String args[])
        {
                int ch,i;
                oper o=new oper();
                Scanner inp=new Scanner(System.in);
                o.n=inp.nextInt();
                inp.nextLine();
                for(i=0;i<o.n;i++)
                {
                  o.str=inp.nextLine();
                }
                switch(o.n)
                {
                        case 1:o.palin();break;
                        case 2:o.equal();break;
                        case 3:o.conc();break;
                        case 4:o.comp();break;

                }

        }


}
                                                                                                

