import java.util.*;
class myString{
	String s1,s2,s3,s4;
	myString(String ptr){
	s1 = ptr;
	}
	myString(String spr, String spr1){
	s1 = spr;
	s2 = spr1;
	}		
	 myString(String spr2, String spr3, String spr4){
	s1 = spr2;
	s2 = spr3;
	s3 = spr4;
	}
	myString(String spr8, String spr7, String spr6, String spr5){
	s1 = spr5;
	s2 = spr6;
	s3 = spr7;
	s4 = spr8;
	}
	
	void equ(){
		if(s1.equals(s2))
		System.out.println("Equal");
		else System.out.println("Unequal");
		
	}
	
	void concatinate(){
	System.out.println(s1+" "+s2+" "+s3);
	}

	void lenth(){
	int a = s1.length();
	int b = s2.length();
	int c = s3.length();
	int d = s4.length();
		if((a>b)&&(a>c)&&(a>d))
			System.out.println(a);
		else if((b>a)&&(b>c)&&(b>d))
			System.out.println(b);
		else if((c>a)&&(c>b)&&(c>d))
			System.out.println(c);
		else if((d>a)&&(d>b)&&(d>c))
			System.out.println(d);
	}

	void reverse(){
		String   sb = new String();
          String   mb = new String();
	  sb="";
          mb="";
           
          for(int i = s1.length()-1; i>= 0; i--){
             if(s1.charAt(i)!=' ')
                   mb =  mb + s1.charAt(i);
                else{
                    sb="";
                    mb="";
                   for(int k = 0;k< s1.length(); k++)
                     if(s1.charAt(k)!=' ')
                      sb =   sb + s1.charAt(k) ;
                     else{
                      mb = sb +" "+ mb;
                      sb = "";
                      }
                 mb = sb +" "+ mb;
                 break;         
                 } 
                      
            }     
 
             System.out.println(mb);
	}

}


class newString{
	public static void main(String args[]){
	Scanner input = new Scanner(System.in);
	int n = input.nextInt();
		switch(n){
		case 1: 
			input.nextLine();
			String str0 = input.nextLine();
			myString obj0 = new myString(str0);
			obj0.reverse();
			break;
		case 2: 
			input.nextLine();
			String str1 = input.nextLine();
			String str2 = input.nextLine();
			myString obj = new myString(str1, str2);
			obj.equ();
			break;

		case 3:
			input.nextLine();
			String str3 = input.nextLine();
			String str4 = input.nextLine();
			String str5 = input.nextLine();
			myString obj1 = new myString(str3, str4, str5); 
			obj1.concatinate();
			break;
		case 4:
			input.nextLine();
			String str6 = input.nextLine();
			String str7 = input.nextLine();
			String str8 = input.nextLine();
			String str9 = input.nextLine();
			myString obj2 = new myString(str6, str7, str8, str9);
			obj2.lenth();
			break;
		}
	}
}
