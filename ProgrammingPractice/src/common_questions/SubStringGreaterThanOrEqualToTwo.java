package common_questions;

import java.util.ArrayList;
import java.util.List;

public class SubStringGreaterThanOrEqualToTwo {
	public List<String> substringGreaterThanOrEqualToTwo(String str) { 
		if(str == null || str.length() == 0) return null;
		
		List<String> result = new ArrayList<>();
	
		for(int i=0; i<str.length(); i++){
			StringBuilder sb = new StringBuilder();
			sb.append(str.charAt(i)); 
			
			for(int j=i+1; j<str.length(); j++){ 
				sb.append(str.charAt(j));
				
				if(str.charAt(j-1) < str.charAt(j)) 
					result.add(sb.toString()); 
				else 
					break;
			}
		}
		
		return result;

	}
	
	
	public static void main(String[] args){
		SubStringGreaterThanOrEqualToTwo obj = new SubStringGreaterThanOrEqualToTwo();
		System.out.println(obj.substringGreaterThanOrEqualToTwo("BCCDDEEFG"));
	}
}
