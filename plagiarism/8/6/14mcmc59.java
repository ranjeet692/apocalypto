import java.util.Scanner;
public class Stringa {

	Stringa (){
	
	}
	Stringa (String S1, String S2) {
		if(S1.equals(S2))
			System.out.println("Equal");
		else 
			System.out.println("Not Equal");
	}
	        
	Stringa (String S1,String S2,String S3 ){
		System.out.println(S1+" "+S2+" "+S3 );
	}
		    
	Stringa(String S1, String S2, String S3, String s4){
		int l1 = S1.length();
		int l2 = S2.length();
		int l3 = S3.length();
		int l4 = s4.length();

		int lar = (l1 >= l2 ?l1 >= l3 ? l1:l3:l2 >= l3? l2:l3);
		if(l4 >= lar)
			System.out.println(l4);
		else
			System.out.println(lar);
	}

	Stringa(String A){
		int flag = 0;

		for(char c : A.toCharArray()){
			if(c == ' ')
			flag = 1;

		}
			 

		
		if(flag == 0){
			StringBuffer buffer = new StringBuffer(A);
			buffer.reverse();
			System.out.println(buffer);
		}		 
		else{			
			StringBuilder revStr = new StringBuilder("");
    			int end = A.length(); // substring takes the end index -1
    			int counter = A.length()-1;
    			for (int i = A.length()-1; i >= 0; i--) {     
        			if (A.charAt(i) == ' ' || i == 0) {
        			    if (i != 0) {
        			        revStr.append(A.substring(i+1, end));
       				         revStr.append(" ");
            		}
            			else {
               			revStr.append(A.substring(i,end));
       				}
	            end = counter;
	        }
	        counter--;
	    }
	    System.out.println(revStr);
			}
        }
	

	public static void main(String[] args) {
		Stringa S;

		Scanner Sc = new Scanner(System.in);
		int Op = Sc.nextInt();
		Sc.nextLine();
		
		switch(Op){
			case 1:
				String c1s1= Sc.nextLine();
				S =new Stringa(c1s1);
				break;
			case 2:
				String c2s1 = Sc.nextLine();
				String c2s2 = Sc.nextLine();
				S = new Stringa(c2s1,c2s2);
				break;
			case 3:
				String c3s1 = Sc.nextLine();
				String c3s2 = Sc.nextLine();
				String c3s3 = Sc.nextLine();
				S = new Stringa(c3s1,c3s2,c3s3);
				break;
			case 4:
				String c4s1 = Sc.nextLine();
				String c4s2 = Sc.nextLine();
				String c4s3 = Sc.nextLine();
				String c4s4 = Sc.nextLine();
				S = new Stringa(c4s1,c4s2,c4s3,c4s4);
				break;



		}	
			
	}
					         
}
