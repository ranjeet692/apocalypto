import java.util.*;
@SuppressWarnings("unchecked")


public class ArrAnurag {
	public ArrayList<Integer> removeDuplicate(int[] arr){
		
		ArrayList<Integer> r = new ArrayList<>();

		HashSet<Integer> s = new HashSet<>();

		for (Integer item : arr) {
			if (!s.contains(item)) {
			r.add(item);
			s.add(item);
		    }
		}
		return r;
	} 
	
	
	
	public static void main (String arg[]){
		ArrAnurag An = new ArrAnurag();
		Scanner S = new Scanner(System.in);
		int n = S.nextInt();

		
		
		
		switch(n){
		case 1:{
			int len1 = S.nextInt();
			int[] arr;
			arr = new int[len1];
			for(int i = 0; i < arr.length; i++)
				arr[i] = S.nextInt();
			ArrayList<Integer> l =  An.removeDuplicate(arr);
			for(int i = 0; i < l.size(); i++)
				System.out.println(l.get(i));}
		break;
		
	}

}
}
