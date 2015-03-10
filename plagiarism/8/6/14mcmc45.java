import java.util.Scanner;
class subclass{

	String st;
	Scanner s= new Scanner(System.in);
	void Rfun(){
	System.out.println("Enter String");
        st=s.nextLine();
        StringBuffer b=new StringBuffer(st);
	b.reverse();
	System.out.println(b);
	}

}
class Sprogram{
public static void main(String args[]){
  subclass obj=new subclass();
    obj.Rfun();
}
}
