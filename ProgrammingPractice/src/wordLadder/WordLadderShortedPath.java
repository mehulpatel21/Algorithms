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
		 
		String startWord = "CAT";
		String endWord = "DOG";
		
		Ladder result = getShortestTransformationIterative(startWord, endWord, dictionary);
		if(result != null){
			System.out.println("Path is: " + result.getPath() + " and length is: " + result.getLength());
		}
		else {
			System.out.println("No path found!!");
		}
	}
	

	 private static Ladder getShortestTransformationIterative(String startWord, String endWord, Set<String> dictionary){
	  if(dictionary.contains(startWord) && dictionary.contains(endWord)){
	 
	   List<String> path = new LinkedList<String>();
	   path.add(startWord);
	 
	   //All intermediate paths are stored in queue.
	   Queue<Ladder> queue = new LinkedList<Ladder>(); 
	   queue.add(new Ladder(path, 1, startWord));
	 
	   //We took the startWord in consideration, So remove it from dictionary, otherwise we might pick it again.
	   dictionary.remove(startWord);
	 
	   //Iterate till queue is not empty or endWord is found in Path.
	   while(!queue.isEmpty() && !queue.peek().equals(endWord)){
	    Ladder ladder = queue.remove();
	 
	    if(endWord.equals(ladder.getEndWord())){
	     return ladder;
	    }
	 
	    Iterator<String> i = dictionary.iterator();
	    while (i.hasNext()) {
	     String string = i.next(); 
	      
	     if(differByOne(string, ladder.getEndWord())){
	 
	      List<String> list = new LinkedList<String>(ladder.getPath());
	      list.add(string);
	 
	      //If the words differ by one then dump it in Queue for later processing.
	      queue.add(new Ladder(list, ladder.getLength()+1, string));
	       
	      //Once the word is picked in path, we don't need that word again, So remove it from dictionary.
	      i.remove();
	     }
	    }
	   }
	    
	   //Check is done to see, on what condition above loop break, 
	   //if break because of Queue is empty then we didn't got any path till endWord.
	   //If break because of endWord matched, then we got the Path and return the path from head of Queue.
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
