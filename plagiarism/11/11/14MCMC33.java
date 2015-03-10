import java.util.Scanner;

class demo
{
 public static void main(String...s)
 {
  int i,j,n1,n2;
  Scanner sc=new Scanner(System.in);

   System.out.print("Enter number of elements of first array:");
  n1=sc.nextInt();
  System.out.print("Enter number of elements of second array:");
  n2=sc.nextInt();

   int a1[]=new int[n1];
  int a2[]=new int[n2];

   System.out.print("\nEnter elements of first array in ascending order:");
  for(i=0;i<n1;++i)
   a1[i]=sc.nextInt();

   System.out.print("\nEnter elements of second array in ascending order:");
  for(i=0;i<n2;++i)
   a2[i]=sc.nextInt();


   i=j=0;
  System.out.print("\nUnion of Arrays: ");
  while(i<n1&&j<n2)
  {
   if(a1[i]<a2[j])
   {
    System.out.print(a1[i]+" ");
    i++;
   }
   else
    if(a2[j]<a1[i])
    {
     System.out.print(a2[j]+" ");
     j++;
    }
    else
    {
     System.out.print(a1[i]+" ");
     i++;
     j++;
    }
  }

   if(i<n1)
   while(i<n1)
   {
    System.out.print(a1[i]+" ");
    i++;
   }

   if(j<n2)
   while(j<n2)
   {
    System.out.print(a2[j]+" ");
    j++;
   }
  
 }
}
