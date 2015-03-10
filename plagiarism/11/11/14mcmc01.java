import java.util.Scanner;
public class ArrayOps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int noa=sc.nextInt();
        int arr1[],arr2[],arr3[],arr4[],arr5[];
        
        switch (noa) {
            case 1:
                arr1 = read_arr(sc);
                arr1 = rem_dup(arr1);
                display_arr(arr1);
                break;
            
            case 2:
                arr1 = read_arr(sc);
                arr1 = rem_dup(arr1);
                arr2 = read_arr(sc);
                arr2= rem_dup(arr2);
                arr3 = union(arr1,arr2);
                display_arr(arr3);
                break;
             
            case 3:
                arr1 = read_arr(sc);
                arr1 = rem_dup(arr1);
                arr2 = read_arr(sc);
                arr2= rem_dup(arr2);
                arr3 = union(arr1,arr2);
                arr4=read_arr(sc);
                arr4 = rem_dup(arr4);
                arr5 = subtract(arr3,arr4);
                display_arr(arr5);                
            
        }
        
        
        
    }
    
    public static int[] read_arr(Scanner sc){
        int length=sc.nextInt();
        int[] arr = new int[length];
        for(int i=0;i<length;i++){
            arr[i]=sc.nextInt();            
        }
        return arr;
    }
    public static int[] rem_dup(int[] arr){
        int[] arr1 = new int[arr.length];
        arr1[0]=arr[0];
        int non_dups=1;
        
        for(int i=1;i<arr.length;i++){
            if (!found_elem(arr1,arr[i],non_dups)){
                arr1[non_dups]=arr[i];
                non_dups++;      
                
            }
            
        }
        //display_arr(arr);
        //display_arr(arr1);
        int[] arr2 = new int[non_dups];
        for(int i=0;i<non_dups;i++){
            arr2[i]=arr1[i];
        }
        return arr2;
    }
    
    public static boolean found_elem(int[] arr,int ele,int non_dups){
        for(int i=0;i<non_dups;i++){
            if(arr[i]==ele){
                return true;
            }            
        }
        return false;        
    }  
    
    public static int[] union(int[] arr1,int[] arr2){
        int[] arr3= new int[arr1.length+arr2.length];
        for(int i=0;i<arr1.length;i++){
            arr3[i]=arr1[i];            
        }
        for(int j=0;j<arr2.length;j++){
            arr3[arr1.length+j]=arr2[j];
        }
        return rem_dup(arr3);    
    }
    
    public static int[] subtract(int[] arr1,int[] arr2){
               int[] arr3 = new int[arr1.length];
               int final_length=0;
               boolean flag;
               for(int i=0;i<arr1.length;i++){
                   flag=false;
                   for(int j=0;j<arr2.length;j++){
                       if(arr2[j]==arr1[i]){
                           flag=true;
                           break;
                       }
                           
                   }
                   if(!flag){
                       arr3[final_length++]=arr1[i];
                   }
                   
               }
               int[] arr4 = new int[final_length];
               for(int k=0;k<final_length;k++){
                   arr4[k]=arr3[k];
               }
               return arr4;
               
    }
    
    public static void display_arr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
