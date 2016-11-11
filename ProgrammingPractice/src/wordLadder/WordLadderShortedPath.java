package wordLadder;

import java.util.HashSet;
import java.util.Set;

public class WordLadderShortedPath {

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("CAT");
		dictionary.add("BAT");
		dictionary.add("COT");
		dictionary.add("COG");
		dictionary.add("COW");
		dictionary.add("RAT");
		dictionary.add("BUT");
		dictionary.add("CUT");
		dictionary.add("DOG");
		dictionary.add("WEB");
		
		String startWord ="WEB";
		String endWord = "CAT";
		
		Ladder result = getShortestTransformationIterative(startWord, endWord, dictionary);
		
		if(result != null){
			System.out.println("Length is: " + result.getLength() + " and path is: "+ result.getPath());
		} else {
			System.out.println("No path found");
		}
	}
	
	private static Ladder getShortestTransformationIterative(String startWord, String endWord, Set<String> dictionary){
		
		return null;
	}

}
