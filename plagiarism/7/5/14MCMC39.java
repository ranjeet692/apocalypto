import java.util.*;
import java.io.*;
import java.lang.*;
//import java.String.*;


class CheckString{

//********************************************************
//data declaration	
//********************************************************


	String s="",str="",rev="",str1="";
	int n,len=0,len1=0,len2=0,len3=0;	

//*******************************************************	
//end
//*******************************************************


//*******************************************************
//start of function
//*******************************************************

	void stringOperation(String a, String b){
		//inputdata(s);
		//inputdata(rev);
		if(a.equals(b))
                        System.out.println("Equal");
                else
                        System.out.println("Not Equal");
}

//********************************************************
//end of function
//********************************************************



//********************************************************
//start of function
//********************************************************


	void stringOperation(String a,String b,String c){
		String str1;
		//inputdata(s);
		//System.out.println(""+str1);		
		//inputdata(rev);
		//System.out.println(""+str2);
		//inputdata(str);
		//str1=s+rev+str;
	
		str1=new StringBuffer().append(a).append(b).append(c).toString();

		//str2=str2.concat(str3);
		//str1=str1.concat(str2);

		System.out.println(str1);

		//return(str1);
}

//***************************************************************	
//end of function
//***************************************************************



//****************************************************************
//start of function
//****************************************************************

	void checkPalindrome(){
               int len= str.length();
               for(int i=len-1;i>=0;i--) 
		
		rev=rev+str.charAt(i);

               
                if(str.equals(rev)){
                        System.out.println("Palindrome");}
                else{
                        System.out.println("Not Palindrome");}
}	


//*******************************************************************
//end of function
//*******************************************************************



//*******************************************************************
//start of function
//*******************************************************************

	void stringLen(){
		len=s.length();
		len1=rev.length();
		len2=str.length();
		len3=str1.length();

		if((len>len1)&&(len>len2)){
			if(len>len3){
				System.out.println(len);
			}
			else
				System.out.println(len3);
		}
		else if((len1>len)&&(len1>len2)){
			if(len1>len3){
				System.out.println(len1);
			}
			else 
				System.out.println(len3);
		}
		if((len2>len)&&(len2>len1)){
			if(len2>len3){
				System.out.println(len2);
			}
			else
				System.out.println(len3);
			
		}
}	     


//******************************************************************
//end of function
//******************************************************************



//******************************************************************
//start of main function
//******************************************************************               


        public static void main(String agru[])throws IOException {
		String a,b,c;
                //Strings obj=new Strings();
		CheckString cs=new CheckString();

                BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
                cs.n=Integer.parseInt(br.readLine());
		if(cs.n==1) {
                
                cs.str=br.readLine();
                cs.checkPalindrome();}
		else if(cs.n==2){
		a=br.readLine();
		b=br.readLine();
		cs.stringOperation(a,b);}
		else if(cs.n==3){
		a=br.readLine();
		b=br.readLine();
		c=br.readLine();
		cs.stringOperation(a,b,c);
		}
		else if(cs.n==4){
		
		cs.s=br.readLine();
		cs.rev=br.readLine();
		cs.str=br.readLine();
		cs.str1=br.readLine();
		cs.stringLen();
		}



}//end

}//end

/*class Strings{
        public int n,len,len1,len2,len3;
        public String s="",rev="",str="",str1="";

      /*  void checkPalindrome(){
               int len= s.length();
               for(int i=len-1;i>=0;i--) 
		
		rev=rev+s.charAt(i);

               
                if(s.equals(rev))
                        System.out.println("Palindrome");
                else
                        System.out.println("Not Palindrome");
}
    
	void inputdata(String str){
               Scanner br =new Scanner(System.in);
		str=br.nextLine();
	
               }

	public String stringOperation(String a, String b){
		//inputdata(s);
		//inputdata(rev);
		if(a.equals(b))
                        System.out.println("Equal");
                else
                        System.out.println("Not Equal");
}

	 void stringOperation1(){
	//	String str1="",str2="",str3="";
		//inputdata(s);
//System.out.println(""+str1);		
		//inputdata(rev);
//System.out.println(""+str2);
		//inputdata(str);
		//str1=s+rev+str;
		str1=new StringBuffer().append(s).append(rev).append(str).toString();
		//str2=str2.concat(str3);
		//str1=str1.concat(str2);
		System.out.println(str1);
		//return(str1);
}*/			     
               
/*		void stringLen(){
		len=s.length();
		len1=rev.length();
		len2=str.length();
		len3=str1.length();

		if((len>len1)&&(len>len2)){
			if(len>len3){
				System.out.println(len);
			}
			else
				System.out.println(len3);
		}
		else if((len1>len)&&(len1>len2)){
			if(len1>len3){
				System.out.println(len1);
			}
			else 
				System.out.println(len3);
		}
		if((len2>len)&&(len2>len1)){
			if(len2>len3){
				System.out.println(len2);
			}
			else
				System.out.println(len3);
			
		}
}
}
*/                                                                                                                        
