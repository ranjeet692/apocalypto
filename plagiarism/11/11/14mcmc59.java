import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
@SuppressWarnings("unchecked")


public class ArrayAss {
	public ArrayList<Integer> removeDuplicate(int[] arr1){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : arr1){
			list.add(i);
		}
		ArrayList<Integer> result = new ArrayList<>();

		HashSet<Integer> set = new HashSet<>();

		for (Integer item : list) {
			if (!set.contains(item)) {
			result.add(item);
			set.add(item);
		    }
		}
		return result;
	} 
	
	public ArrayList<Integer> setUnion(int[] arr1, int[] arr2){

		ArrayList<Integer> first = new ArrayList<Integer>();
		for(int i : arr1)
			first.add(i);
		
		for(int i : arr2)
			first.add(i);
		
		
		ArrayList<Integer> result = new ArrayList<>();

		HashSet<Integer> set = new HashSet<>();

		for (Integer item : first) {
			if (!set.contains(item)) {
			result.add(item);
			set.add(item);
		    }
		}
		return result;
		
	}
	
	public ArrayList<Integer> setDifference(int[] arr1, int[] arr2, int[] arr3){
		ArrayList<Integer> list = new ArrayList<Integer>();  
		list.addAll(setUnion(arr1,arr2));
		
		ArrayList<Integer> first = new ArrayList<Integer>();
		for(int i : arr3)
			first.add(i);

		ArrayList<Integer> result = new ArrayList<>();

		HashSet<Integer> set = new HashSet<>();

		for (Integer item : list) {
			if (!set.contains(item)&& !(first.contains(item))) {
					result.add(item);
					set.add(item);
		    }
		}
		return result;
	}
	
	public static void main (String arg[]){
		ArrayAss Al = new ArrayAss();
		Scanner Sc = new Scanner(System.in);
		int noa = Sc.nextInt();

		
		
		
		switch(noa){
		case 1:{
			int len1 = Sc.nextInt();
			int[] arr1;
			arr1 = new int[len1];
			for(int i = 0; i < arr1.length; i++)
				arr1[i] = Sc.nextInt();
			ArrayList<Integer> list =  Al.removeDuplicate(arr1);
			for(int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));}
		break;
		case 2:
		{
			
			int[] arr2;
			int[] arr1;
			
			int len1 = Sc.nextInt();
			arr1 = new int[len1];
			for(int i = 0; i < arr1.length; i++)
				arr1[i] = Sc.nextInt();
			
			int len2 = Sc.nextInt();
			arr2 = new int[len2];
			for(int i = 0; i < arr2.length; i++)
				arr2[i] = Sc.nextInt();
			
			ArrayList<Integer> list = new ArrayList<Integer>();  
			list.addAll(Al.setUnion(arr1,arr2));
			for(int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		}
		case 3:
			int[] arr2;
			int[] arr1;
			int[] arr3;
			
			int len1 = Sc.nextInt();
			arr1 = new int[len1];
			for(int i = 0; i < arr1.length; i++)
				arr1[i] = Sc.nextInt();
			
			int len2 = Sc.nextInt();
			arr2 = new int[len2];
			for(int i = 0; i < arr2.length; i++)
				arr2[i] = Sc.nextInt();
			
			int len3 = Sc.nextInt();
			arr3 = new int[len3];
			for(int i = 0; i < arr3.length; i++)
				arr3[i] = Sc.nextInt();
			
			ArrayList<Integer> list = new ArrayList<Integer>();  
			list.addAll(Al.setDifference(arr1,arr2,arr3));
			
			for(int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		}
	}

}
