package common_questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StringRearrangePalindrome {
	
	public static void main(String[] args) {

		StringRearrangePalindrome testObj = new StringRearrangePalindrome();
		System.out.println(testObj.canPermutePalindromeUsingArray("geeksogeeks"));
		System.out.println(testObj.canPermutePalindromeUsingHashMap("geeksogeeks"));
		System.out.println(testObj.canPermutePalindromeUsingSet("geeksogeeks"));

	}

	public void checkForPalindrome(String word) {

		if (word == null || word.isEmpty()) {
			System.out.println("Data Error");
			return;
		}
		// Remove spaces
		word = word.replaceAll(" ", "");
		word = word.trim();
		
		char[] tempWord = word.toUpperCase().toCharArray();
		int matchCount = tempWord.length / 2;

		for (int i = 0; i < tempWord.length; i++) {
		  for (int j = 0; j < tempWord.length; j++) {
		    if (i != j && tempWord[i] != '_' && tempWord[j] != '_'
							&& tempWord[i] == tempWord[j]) {
						tempWord[i] = '_';
						tempWord[j] = '_';
						matchCount--;
					}
				}
			}

		if (matchCount == 0) {
		   System.out.println(word + " can be formed as palindrome !");
		} else {
			System.out.println(word + " cannot be formed as palindrome !");
		}
	}
	
	//Time and Space both O(n)
	public boolean canPermutePalindromeUsingHashMap(String s) {
	     HashMap < Character, Integer > map = new HashMap < > ();
	     for (int i = 0; i < s.length(); i++) {
	         map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
	     }
	     int count = 0;
	     for (char key: map.keySet()) {
	         count += map.get(key) % 2;
	     }
	     return count <= 1;
	 }
	
	// Time complexity is O(n), space complexity O(1)
	public boolean canPermutePalindromeUsingArray(String s) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        int count = 0;
        for (int key = 0; key < map.length && count <= 1; key++) {
            count += map[key] % 2;
        }
        return count <= 1;
    }
	
	// Time and space complexity O(n)
	public boolean canPermutePalindromeUsingSet(String s) {
        Set < Character > set = new HashSet < > ();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }
}
