import java.io.*;
import java.util.*;

public class AssignmentSetTheory {

        public static void main(String agru[]){
                Scanner si= new Scanner (System.in);
                setFunct f= new setFunct();
                f.noa = si.nextInt();
                

                if (f.noa==1){
                        f.n = si.nextInt();
                        int arr[]=new int[f.n];
                         for(int i=0;i<f.n;i++)
                          {
                                arr[i] = si.nextInt();
                        }
                    f.removeDuplicate(arr);
                               }
               else if(f.noa==2) {
                        f.n = si.nextInt();
                        int arr1[]=new int[f.n];
                        for(int i=0;i<f.n;i++)
                        {
                            arr1[i] = si.nextInt();
                        }

                        f.n1 = si.nextInt();
                        int arr2[]=new int[f.n1];
                        for(int i=0;i<f.n1;i++)
                        {
                                arr2[i] = si.nextInt();
                        }
			
                       f.union(arr1,arr2); }
                else if(f.noa==3) {
			 f.n = si.nextInt();
                        int arr1[]=new int[f.n];
                        for(int i=0;i<f.n;i++)
                        {
                            arr1[i] = si.nextInt();
                        }

                        f.n1 = si.nextInt();
                        int arr2[]=new int[f.n1];
                        for(int i=0;i<f.n1;i++)
                        {
                                arr2[i] = si.nextInt();
                        }

			f.n2 = si.nextInt();
			int arr3[]=new int[f.n2];
			for(int i=0;i<f.n2;i++) {
				arr3[i]=si.nextInt();
			}
                       f.unionSubraction(arr1,arr2,arr3); }


                }
        }




class setFunct {

        public int tem[]=new int[100];
	public int tem1[]=new int[100];
        public int i,j, temp,temp1,temp2;
        public int noa,n,n1,n2;
	
        //setFunct obj= new setFunct(); 
      public void removeDuplicate(int arr1[]){
             
                 int len1=arr1.length;
               
                 for(i=0;i<len1;i++) {
                        for(int j=i+1;j<len1;j++) {

                                if(arr1[i] == arr1[j]) {
                                        int shiftleft =j;
                                                for(int k=j+1;k<len1;k++,shiftleft++){
                                        arr1[shiftleft]=arr1[k];

                                }
                                len1--;
                                j--;
                               }
                }
        }

                displayData(len1,arr1);
		
        }

       

        public void displayData(int n,int arr []){
                for(i=0;i<n;i++)
                {
                       System.out.println(arr[i]);
                }
        }

  

  public void  union(int  arr1[],int  arr2[])
        {	//inti,temp;
                for(i=0, temp=0;i< arr1.length;i++)
                {
                        for(j=( temp-1);j>=0;j--)
                        {
                                if( tem[j]== arr1[i])
                                        break;
                        }
                        if(j<0)
                        {
                                 tem[ temp]= arr1[i];
          temp++;
                        }
                }
                for(i=0;i< arr2.length;i++)
                {
                        for(j=( temp-1);j>=0;j--)
                        {
                                if( tem[j]== arr2[i])
                                        break;
                        }
                        if(j<0)
                        {
                                 tem[ temp]= arr2[i];
                                 temp++;
                        }
                }
                for(i=0;i< temp;i++)
                {
                        System.out.println( tem[i]);
                }
        }

       void unionSubraction(int arr1[],int arr2[],int arr3[]){
                 for(i=0, temp=0;i< arr1.length;i++)
                {
                        for(j=( temp-1);j>=0;j--)
                        {
                                if( tem[j]== arr1[i])
                                        break;
                        }
                        if(j<0)
                        {
                                 tem[ temp]= arr1[i];
          temp++;
                        }
                }
                for(i=0;i< arr2.length;i++)
                {
                        for(j=( temp-1);j>=0;j--)
                        {
                                if( tem[j]== arr2[i])
                                        break;
                        }
                        if(j<0)
                        {
                                 tem[ temp]= arr2[i];
                                 temp++;
                        }
                }
        
      int  tem2[]=new int[100];

                

                for(i=0, temp2=0;i<arr3.length;i++)
                {
                        for(j=( temp2-1);j>=0;j--)
                        {
                                if( tem2[j]==arr3[i])
                                        break;
                        }
                        if(j<0)
                        {
                                 tem[ temp2]=arr3[i];
                                 temp2++;
                        }
                }


               /* for(i=0, temp=0;i< temp1;i++)
                {
                        for(j=0;j< temp2;j++)
                        {
                                if( tem1[i]== tem2[j])
                                        break;
                        }
                        if(j== temp2)
                        {
                                 tem[ temp]= tem1[i];
                                 temp++;
                        }
                }
*/
      
int len=tem2.length;
               
                 for(i=0;i<len;i++) {
                        for(int j=0;j<len;j++) {

                                if(tem2[i] == tem1[j]) {
                                        int shiftleft =j+1;
                                                for(int k=j+1;k<len;k++,shiftleft++){
                                        tem2[shiftleft]=tem2[k];

                                }
                                len--;
                                j--;
                               }
                }
        }

                displayData(len,tem2);
		        

        }

     }
