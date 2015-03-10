import java.util.*;
import java.lang.*;

class DataInput
{
	public int temp[]=new int[100];
	public int i,j,t;
	public void rem(int x[]){
		for(i=0,t=0;i<x.length;i++){	
			for(j=(t-1);j>=0;j--){
				if(temp[j]==x[i])
					break;
			}
			if(j<0){	
				temp[t]=x[i];
				t++;
			}
		}
		for(i=0;i<t;i++){
			System.out.println(temp[i]);
		}
	}

	public void Union(int x[],int y[]){
		for(i=0,t=0;i<x.length;i++){
			for(j=(t-1);j>=0;j--){
				if(temp[j]==x[i])
					break;
			}
			if(j<0){
				temp[t]=x[i];
				t++;
			}
		}
		for(i=0;i<y.length;i++){
			for(j=(t-1);j>=0;j--){
				if(temp[j]==y[i])
					break;
			}
			if(j<0){
				temp[t]=y[i];
				t++;
			}
		}
		for(i=0;i<t;i++){
			System.out.println(temp[i]);
		}
	}
	
	public void Subs(int x[],int y[],int obj[]){
		int t1,t2;
		int temp1[]=new int[100];
		for(i=0,t1=0;i<x.length;i++){
			for(j=(t1-1);j>=0;j--){
				if(temp1[j]==x[i])
					break;
			}
			if(j<0){
				temp1[t1]=x[i];
				t1++;
			}
		}
		for(i=0;i<y.length;i++){
			for(j=(t1-1);j>=0;j--)
			{
				if(temp1[j]==y[i])
					break;
			}
			if(j<0){
				temp1[t1]=y[i];
				t1++;
			}
		}

		int temp2[]=new int[50];
		for(i=0,t2=0;i<obj.length;i++){	
			for(j=(t2-1);j>=0;j--){
				if(temp2[j]==obj[i])
					break;
			}
			if(j<0){	
				temp2[t2]=obj[i];
				t2++;
			}
		}
		for(i=0,t=0;i<t1;i++){
			for(j=(t2-1);j>=0;j--){
				if(temp1[i]==temp2[j])
					break;
			}
			if(j<0){
				temp[t]=temp1[i];
				t++;
			}
		}

		for(i=0;i<t;i++){
			System.out.println(temp[i]);
		}
		
	}

}

public class ArrayClass{
	public static void main(String args[]){
		int noa,n;
		
		Scanner get=new Scanner(System.in);
		
		noa=get.nextInt();
		if(noa==1){
			DataInput X=new DataInput();
			n=get.nextInt();
			int arr1[]=new int[n];
			for(int i=0;i<n;i++){
				arr1[i]=get.nextInt();
			}
			X.rem(arr1);
		}
		else if(noa==2){
			DataInput Y=new DataInput();
			n=get.nextInt();
			int arr1[]=new int[n];
			for(int i=0;i<n;i++){
				arr1[i]=get.nextInt();
			}
			n=get.nextInt();
			int arr2[]=new int[n];
			for(int i=0;i<n;i++){
				arr2[i]=get.nextInt();
			}
			Y.Union(arr1,arr2);
		}
		else if(noa==3){
			DataInput obj=new DataInput();
			n=get.nextInt();
			int arr1[]=new int[n];
			for(int i=0;i<n;i++){
				arr1[i]=get.nextInt();
			}
			n=get.nextInt();
			int arr2[]=new int[n];
			for(int i=0;i<n;i++){
				arr2[i]=get.nextInt();
			}
			n=get.nextInt();
			int arr3[]=new int[n];
			for(int i=0;i<n;i++){
				arr3[i]=get.nextInt();
			}
			obj.Subs(arr1,arr2,arr3);
		}
		else
			;
	}
}
