import java.io.*;
import java.util.*;

class SetTheory {
	
        public static void main(String agru[]){
                Scanner si= new Scanner (System.in);
                setFunct f= new setFunct();
              	f.noa = si.nextInt();
		
                
           	if (f.noa==1){
                    f.removeDuplicate();
                               }

                       // case 2: f.union();
                               // break;
                        //case 3: f.unionSubraction();
        		       //  break;
                        
                }
        }




class setFunct {Scanner si= new Scanner (System.in);
	public int noa,n;
  //private double ImaginaryPart,sum;
  //public double p,q,r,s;
  public int i=0,j=0;
	
	Scanner br= new Scanner (System.in);
	
	void removeDuplicate(){
		//noa=br.nextInt();
		n = br.nextInt();
		int arr1[]=new int[n];
		for(i=0;i<n;i++)
		{
			arr1[i] = br.nextInt();
		}
	

		//arr2 = inputData();
		 int len1=arr1.length;
		//int len2=arr2.length();
		displayData(len1,arr1);
		System.out.print("\n");
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

	//void dataToBeFeed(){
		//noa = Integer.parseInt(br.readLine());
		
	//}

	void displayData(int n,int arr []){
		for(i=0;i<n;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

	/*void inputData(){
		n = Integer.parseInt(br.readLine());
		arr[]=new int[5];
		for(i=0;i<n;i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
	}*/

	/*void union(){
	}

	void unionSubtraction(){
	}*/

}
