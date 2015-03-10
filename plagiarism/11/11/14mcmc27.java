import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
@SuppressWarnings("unchecked")


public class Array_List {
	public ArrayList<Integer> remove(int[] array1){
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i : array1){
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
	
	public ArrayList<Integer> Union(int[] array1, int[] array2){

		ArrayList<Integer> first = new ArrayList<Integer>();
		for(int i : array1)
			first.add(i);
		
		for(int i : array2)
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

	public static void main (String args[]){
		Array_List Al = new Array_List();
		Scanner in = new Scanner(System.in);
		int noa = in.nextInt();

		
		
		
		switch(noa){
		case 1:{
			int len1 = in.nextInt();
			int[] array1;
			array1 = new int[len1];
			for(int i = 0; i < array1.length; i++)
				array1[i] = in.nextInt();
			ArrayList<Integer> list =  Al.remove(array1);
			for(int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));}
		break;
		case 2:
		{
			
			int[] array2;
			int[] array1;
			
			int len1 = in.nextInt();
			array1 = new int[len1];
			for(int i = 0; i < array1.length; i++)
				array1[i] = in.nextInt();
			
			int len2 = in.nextInt();
			array2 = new int[len2];
			for(int i = 0; i < array2.length; i++)
				array2[i] = in.nextInt();
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.addAll(Al.Union(array1,array2));
			for(int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		}
		
		
	}

}
}
