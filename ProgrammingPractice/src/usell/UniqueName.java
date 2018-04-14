package usell;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

/**
 * 
 * @author Mehul Patel
 * @Date 09/19/2017
 * @Description Write a method that finds the first name in an array that occurs only once in that array.
 * 				If there are no unique names in that array, null should be returned.
 *
 */

public class UniqueName {
	public static String firstUniqueName(String[] names) {
    	Map<String, Integer> countStrings = new LinkedHashMap<String, Integer>();
    	
    	for(int i=0; i<names.length; i++){
    		String str = names[i];
    		if(!countStrings.containsKey(str)){
    			countStrings.put(str, 1);
    		} else {
    			countStrings.put(str, countStrings.get(str) + 1);
    		}
    	}
    	
    	for(Entry<String, Integer> e : countStrings.entrySet()){
    		if(e.getValue() == 1){
    			return e.getKey();
    		}
    	}
		return null;
    	
    }
	
	@Test
    public void testFirstUniqueName(){
    	assertNotEquals("Mehul", UniqueName.firstUniqueName(new String[] 
    			{ "Addeline", "Abbi", "Abbi", "Abbi","Abbie","Mehul","Mehul","Callie","Callie","Addeline" }));
    	assertEquals("0", UniqueName.firstUniqueName(new String[] 
    			{ "0", "Abbi", "Abbi", "Abbi","Abbie","Mehul","Mehul","Callie","Callie","Addeline" }));
    	assertEquals("Addeline", UniqueName.firstUniqueName(new String[] 
    			{ "Addeline", "Abbi", "Amy","Abbie","Mehul","Marty","Callie","Comet","Andre" }));
    	assertEquals("a", UniqueName.firstUniqueName(new String[] 
    			{ "a", "b", "c","d","e","f","g","h","i" }));
    	assertEquals(null, UniqueName.firstUniqueName(new String[] 
    			{ "a", "a", "a","a"}));
    }
}
    