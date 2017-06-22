package interview_questions;


public class FizzBuzz {
	
	public static String fizzBuzz(int number){
		if(number % 15 == 0){
			return "fizzbuzz";
		} else if(number % 3 == 0){
			return "fizz";
		} else if(number % 5 == 0){
			return "buzz";
		}
		return String.valueOf(number);
		
	}
	
	public static void main(String[] args){
		System.out.println(fizzBuzz(3));
	}
	
}
