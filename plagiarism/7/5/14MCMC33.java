import java.util.*;

public class RevNumString
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a string: ");
        String str = scanner.next();
		RevNumString rns = new RevNumString();
        String revStr = rns.reverse(str);
        System.out.printf("\n The reverse of string '%s' is '%s' ", str, revStr);
    }
    
    // Method to return the reverse of a string
    public String reverse(String str) {
        StringBuilder revStr = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--)
          {
            revStr.append(str.charAt(i));
        }
        return revStr.toString();
    }
 
}