import java.io.*;
import java.util.*;


class operation
{
  public int arr[]=new int[100];
  public int i,j,ss;
  public void singleOp(int a1[])
  {
        for(i=0,ss=0;i<a1.length;i++)
          {
            for(j=(ss-1);j>=0;j--)
               {
                  if(arr[j]==a1[i])
                    break;
               }
               if(j<0)
                 {
                  arr[ss]=a1[i];
                  ss++;
                 }
          }  
          for(i=0;i<ss;i++)
            {
              System.out.println(arr[i]);
            }
  }
  public void doubleOp(int a1[],int a2[])
  {
     for(i=0,ss=0;i<a1.length;i++)
        {
          for(j=(ss-1);j>=0;j--)
            {
              if(arr[j]==a1[i])
                break;
            }
            if(j<0)
            {
             arr[ss]=a1[i];
             ss++;
            }
        }
     for(i=0,ss=0;i<a2.length;i++)
       {
         for(j=(ss-1);j>=0;j--)
           {
             if(arr[j]==a2[i])
               break;
           }
           if(j<0)
           {
            arr[ss]=a2[i];
            ss++;
           }
       }
       for(i=0;i<ss;i++)
       {
       System.out.println(arr[i]);
       }
     }
      public void tripleOp(int arr[],int arr2[],int arr3[]) 
        {
                int ss1,ss2;
                int arr1[]=new int[100];
                for(i=0,ss1=0;i<arr.length;i++)
                {
                  for(j=(ss1-1);j>=0;j--)
                  {
                   if(arr1[j]==arr[i]);
                   break;
                   }
                   if(j<0)
                   {
                     arr1[ss1]=arr[i];
                     ss++;
                   }
                 }
                 for(i=0;i<arr2.length;i++)
                 {
                   for(j=(ss1-1);j>=0;j--)
                   {
                    if(arr1[j]==arr2[i])
                    break;
                   }
                   if(j<0)
                   {
                     arr1[ss1]=arr2[i];
                     ss1++;
                   }
                 }
                  int arr1a[]=new int[50];
                  for(i=0,ss2=0;i<arr3.length;i++)
                  {
                  for(j=(ss2-1);j>=0;j--)
                  {
                   if(arr1a[j]==arr3[i])
                   break;
                  }
                  if(j<0)
                  {
                   arr[ss1]=arr3[i];
                   ss2++;
                  }
                }
                
                for(i=0,ss=0;i<ss1;i++)  
                {
                 for(j=0;j<ss2;j++)
                  {
                    if(arr1[i]==arr1a[j])
                      break;
                  }
                  if(j==ss2)
                    {
                      arr[ss]=arr1[i];
                      ss++;
                    }
                }
                for(i=0;i<ss;i++)
                {System.out.println(arr[i]);}
        
       
  }

}

public class ArrayOp1
{
   public static void main(String ag[])
   {
     int noa,n;
     Scanner s=new Scanner(System.in);
     noa=s.nextInt();
     if(noa==1)
     
     {
       operation op=new operation();
       n=s.nextInt();
       int ar1[]=new int[n];
       for(int i=0;i<n;i++)
       {ar1[i]=s.nextInt();}
       op.singleOp(ar1);
     }
     
     else if(noa==2)
     {
     operation op1=new operation();
     n=s.nextInt();
     int ar1[]=new int[n];
     for(int i=0;i<n;i++)
     {ar1[i]=s.nextInt();}
     n=s.nextInt();
     int ar2[]=new int[n];
     for(int i=0;i<n;i++)
     {ar2[i]=s.nextInt();}
     op1.doubleOp(ar1,ar2);
     }    
     else if(noa==3)
      {
         operation op2=new operation();
         n=s.nextInt();
         int ar1[]=new int[n];
         for(int i=0;i<n;i++)
         {ar1[i]=s.nextInt();}
         n=s.nextInt();
         int ar2[]=new int[n];
         for(int i=0;i<n;i++)
         {ar2[i]=s.nextInt();}
         int ar3[]=new int[n];
         for(int i=0;i<n;i++)
         {ar3[i]=s.nextInt();}
         op2.tripleOp(ar1,ar2,ar3);
            }
            else
            ;
   }
   }
