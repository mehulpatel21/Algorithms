package cleverDevices;
import java.util.Scanner;

/**
 * @author: Mehul Patel
 * @Date: 07/27/2017
 * @Company: Clever Devices
 * @Description A Java program to reverse the order of words in a sentence i.e. "code is good" will be "good is code"
 */

class ReverseWordsInSentence {
	/*
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println("Write the sentence to be reversed: ");
		Scanner scanner = new Scanner(System.in);
		System.out.println(reverseWordsInSentence(scanner.nextLine()));
		scanner.close();
	}
	/*
	 * @param: String (Sentence to be reversed)
	 * @Return: String (Reversed sentence)
	 */
	public static String reverseWordsInSentence(String sentence){
		/* Trimming the sentence into array of words, removing leading and trailing spaces */
		String[] words = sentence.trim().split("\\s+");
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(words[words.length - 1]);
		/* Iterating over array of words and appending each word into StringBuilder, starting at length-2*/
		for(int i=words.length-2; i>=0; --i){
			stringBuilder.append(" ").append(words[i]);
		}
		return stringBuilder.toString();
	}
}
