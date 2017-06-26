package interview_questions;

public class ConvertStringToNumberAndSumIt {
	public static int convertStringToNumAndSumIt(String inputString){
		int i=0,sum=0;
		String currentString = "";
		inputString = inputString.replace("one", "1");
		inputString = inputString.replace("two", "2");
		inputString = inputString.replace("three", "3");
		inputString = inputString.replace("four", "4");
		inputString = inputString.replace("five", "5");
		inputString = inputString.replace("six", "6");
		inputString = inputString.replace("seven", "7");
		inputString = inputString.replace("eight", "8");
		inputString = inputString.replace("nine", "9");
		inputString = inputString.replace("minus", "-");
		inputString = inputString.replace("plus", "+");
		
		while(i<inputString.length()){
			if(inputString.charAt(i) >= '0' && inputString.charAt(i) <=9){
				currentString = currentString + inputString.charAt(i);
				i++;
			} else {
				if(currentString != ""){
					sum = sum + Integer.parseInt(currentString);
					currentString = "";
				}
				i++;
			}
		}
		if(currentString != ""){
			sum = sum + Integer.parseInt(currentString);
		}
		return sum;
	}
	
	public static void main(String[] args){
		System.out.println(convertStringToNumAndSumIt("xyzonetwothreefourfiveplustwozys"));
	}
}
