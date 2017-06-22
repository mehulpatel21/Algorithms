package experianDataQualityTest;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class EvaluateExpression {
	
	public static void main(String[] args) {
		final String charsetName = "UTF-8";
		System.out.print("Enter your expression: ");
		
		Scanner scan = new Scanner(new BufferedInputStream(System.in), charsetName);
		String expression = scan.nextLine();
		 
		CharacterIteratorExecutor characterExecutor = new CharacterIteratorExecutor(expression, -1, 0);
		try {
			System.out.println(characterExecutor.Parse());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} finally{
			scan.close();
		}
	}

}