package cleverDevices;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ReverseWordsInSentenceTest {

	/* JUnit test cases
	 * 1) Empty String
	 * 2) Single word
	 * 3) Two words
	 * 4) A Sentence
	*/
	@Test
	public void testEmptyString(){
		assertEquals("", ReverseWordsInSentence.reverseWordsInSentence(""));
	}
	@Test
	public void testSingleWord(){
		assertEquals("Machine", ReverseWordsInSentence.reverseWordsInSentence("Machine"));
	}
	@Test
	public void testTwoWords(){
		assertEquals("Learning Machine", ReverseWordsInSentence.reverseWordsInSentence("Machine Learning"));
	}
	@Test
	public void testSentence(){
		assertEquals("great is Learning Machine", ReverseWordsInSentence.reverseWordsInSentence("Machine Learning is great"));
	}
}
