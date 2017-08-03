package cleverDevices;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Mehul Patel
 * @Date 07/27/2017
 * @Company Clever Devices
 * @Description A Simple java function that takes two string arguments and returns common characters between them in a string format
 */

public class CommonCharactersBetweenStrings {
	public static void main(String[] args){
		String string1 = "Mehul";
		String string2 = "CleverDevices";
		System.out.println(f(string1, string2));
	}
	/**
	 * @param a (String)
	 * @param b (String)
	 * @return String (Common characters between a and b)
	 */
	public static String f(String a, String b){
	    StringBuilder resultBuilder = new StringBuilder();
	    /* HashSet to avoid duplicate characters*/
	    Set<Character> charMap = new HashSet<Character>();
	    
	    for (int i = 0; i < a.length(); i++) {
	        char ch = a.charAt(i); //a and b are the two words given by the user
	         if (b.indexOf(ch) != -1){
	             charMap.add(Character.valueOf(ch));
	         }
	    }
	    /* Iterator that iterates over charMap hashset*/
	    Iterator<Character> charsIterator = charMap.iterator();
	    while(charsIterator.hasNext()) {
	        resultBuilder.append(charsIterator.next().charValue());
	    }
	    return resultBuilder.toString();
	}
}
