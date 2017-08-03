package common_questions;
import java.util.Scanner;

public class ReverseStringWithFirstLetterCapital {
	public static void main(String[] args) {
		System.out.println("Enter the string: ");
        Scanner cc = new Scanner (System.in);
        
    	while (cc.hasNextLine()) {
    		String originalString = cc.nextLine();
    		StringBuilder resultBuilder = new StringBuilder();
    		
    		for (String string : originalString.split(" ")) {
    			String revStr = new StringBuilder(string).reverse().toString();
    			revStr = revStr.toLowerCase();
    			revStr = Character.toUpperCase(revStr.charAt(0)) + revStr.substring(1);
    			
    			resultBuilder.append(revStr).append(" ");
    		}
            System.out.println("Output is: " + resultBuilder.toString()); 
            
    	}
    	cc.close();
    	
	} 
}