package wordLadder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
		
		Ladder result = getShortestTransformationIterative("CAT", "COG", dictionary);
		if(result != null){
			System.out.println("Path is: " + result.getPath() + " and length is: " + result.getLength());
		}
		else {
			System.out.println("No path found!!");
		}
	}
	
	private static Ladder getShortestTransformationIterative(String startWord, String endWord, Set<String> dictionary) {
	  if(dictionary.contains(startWord) && dictionary.contains(endWord)){
		  List<String> path = new LinkedList<String>();
		  path.add(startWord);
	 
		  Queue<Ladder> queue = new LinkedList<Ladder>(); 
		  queue.add(new Ladder(path, 1, startWord));
	   
		  dictionary.remove(startWord);
	
		  while(!queue.isEmpty() && !queue.peek().equals(endWord)) {
			  Ladder ladder = queue.remove();
			  if(endWord.equals(ladder.getEndWord())) {
				  return ladder;
			  }
	 
			  Iterator<String> i = dictionary.iterator();
			  while (i.hasNext()) {
				  String string = i.next(); 
				  if(differByOne(string, ladder.getEndWord())) {
					  List<String> list = new LinkedList<String>(ladder.getPath());
					  list.add(string);
					  queue.add(new Ladder(list, ladder.getLength()+1, string));
					  i.remove();
				  }
			  }
		  }
	    
		  if(!queue.isEmpty()){
			  return queue.peek();
		  }
	  	}
	  return null;
	 }
	
	private static boolean differByOne(String word1, String word2){
		if(word1.length() != word2.length()){
			return false;
		}
		int diffCount = 0;
		for(int i=0; i<word1.length(); i++) {
			if(word1.charAt(i) != word2.charAt(i)){
				diffCount++;
			}
		}
		return (diffCount == 1);
	}
}
