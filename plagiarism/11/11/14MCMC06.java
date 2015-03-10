import java.util.*;

class Array
{
	ArrayList<Integer> b;
	
	void set(ArrayList<Integer> a)
	{
		b=a;
	}
	
	public void removeDuplicate()
	  {
	  	ArrayList<Integer> result=new ArrayList<>();
	  	ArrayList<Integer> hash=new ArrayList<>();
	  	
		for(int i=0;i<b.size();i++)
		{
			if(!hash.contains(b.get(i)))
			{
				result.add(b.get(i));
				hash.add(b.get(i));
			}
		}
		b=result;
			
	  }
	
	//create method to find union of two array.
	public void setUnion(Array a)
	   {
	   	
		for(int i=0;i<a.b.size();i++)
			if(!b.contains(a.b.get(i)))
				b.add(a.b.get(i));
			
	   	removeDuplicate();
	   
	   }
	   
	
	
	
	 public void setDifference(Array a)
	   {

	        for(int i=0;i<a.b.size();i++)
			{
			if(b.contains(a.b.get(i)))
				b.remove(a.b.get(i));
			
			}
		
		
	  }
	
	
	
}
class ArrayOperation
{
	public static void main( String[] args)
    {
    	Scanner in= new Scanner(System.in);
    	int n=in.nextInt();
    	int length;
    	switch(n)
    	{
    	case 1:
	    	Array ab=new Array();
	    	length=in.nextInt();
	    	ArrayList<Integer> a=new ArrayList<Integer>(length);
	    	for(int i=0;i<length;i++)
	    	{
	    		a.add(in.nextInt());
	    	}
	    	ab.set(a);
	    	ab.removeDuplicate();
	    	
		for(int x=0;x<ab.b.size();x++)
			System.out.println(ab.b.get(x));	
	    	break;
    	case 2:
	    	Array ab1=new Array();
	    	Array ab2=new Array();
	    	
	    	length=in.nextInt();
	    	ArrayList<Integer> a1=new ArrayList<Integer>(length);
	    	for(int i=0;i<length;i++)
	    	{
	    		a1.add(in.nextInt());
	    	}
	    	ab1.set(a1);
	    	
	    	length=in.nextInt();
	    	ArrayList<Integer> a2=new ArrayList<Integer>(length);
	    	for(int i=0;i<length;i++)
	    	{
	    		a2.add(in.nextInt());
	    	}
	    	ab2.set(a2);
	    	ab1.setUnion(ab2);
	    	 for(int x=0;x<ab1.b.size();x++)
			System.out.println(ab1.b.get(x));	
	    	break;
	case 3:
		Array abi=new Array();
	    	Array abii=new Array();
	    	Array abiii=new Array();
		length=in.nextInt();
	    	ArrayList<Integer> ai=new ArrayList<Integer>(length);
	    	for(int i=0;i<length;i++)
	    	{
	    		ai.add(in.nextInt());
	    	}
	    	abi.set(ai);
	    	length=in.nextInt();
	    	ArrayList<Integer> aii=new ArrayList<Integer>(length);
	    	for(int i=0;i<length;i++)
	    	{
	    		aii.add(in.nextInt());
	    	}
	    	abii.set(aii);
	    	length=in.nextInt();
	    	ArrayList<Integer> aiii=new ArrayList<Integer>(length);
	    	for(int i=0;i<length;i++)
	    	{
	    		aiii.add(in.nextInt());
	    	}
	    	abiii.set(aiii);
	    	abi.setUnion(abii);
	    	abi.setDifference(abiii);
	    	for(int x=0;x<abi.b.size();x++)
			System.out.println(abi.b.get(x));	
	   }
    	    	
    }
}    
