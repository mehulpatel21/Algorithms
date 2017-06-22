package experianDataQualityTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CharacterIteratorExecutor implements Callable<Double> {
	private static int pos;
	private static int ch;
	private static String inputString;
	
	public CharacterIteratorExecutor(String inputString, int pos, int ch) {
		this.inputString = inputString;
		this.pos = pos;
		this.ch = ch;
	}

	public CharacterIteratorExecutor() {}

	public double Parse() throws InterruptedException, ExecutionException {
		NextCharacter();
		// FixedThreadPool=1 as threads are not meant to run concurrently given the requirements of the test.
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Callable callable = new CharacterIteratorExecutor();
		Future<Double> value = executor.submit(callable);
		double x = value.get().doubleValue();
		
		executor.shutdown();
		
		if (pos < inputString.length())
			throw new RuntimeException("Unexpected: " + (char) ch);
		return x;
	}

	public void NextCharacter() {
		ch = (++pos < inputString.length()) ? inputString.charAt(pos) : -1;
	}

	public boolean characterToEvaluate(int charToEval) {
		while (ch == ' ')
			NextCharacter();
		if (ch == charToEval) {
			NextCharacter();
			return true;
		}
		return false;
	}

	public double parseExpression() throws InterruptedException, ExecutionException {
		double x = parseTerm();
		for (;;) {
			if (characterToEvaluate('+')) //Addition
				x += parseTerm();
			else if (characterToEvaluate('-')) //Subtraction
				x -= parseTerm();
			else
				return x;
		}
	}

	public double parseTerm() throws InterruptedException, ExecutionException {
		double x = parseFactor();
		for (;;) {
			if (characterToEvaluate('*')) // Multiplication
				x *= parseFactor();
			else if (characterToEvaluate('/')) // Division
				x /= parseFactor();
			else
				return x;
		}
	}

	public double parseFactor() throws InterruptedException, ExecutionException {
		if (characterToEvaluate('+'))
			return parseFactor(); /*Unary Plus*/
		if (characterToEvaluate('-'))
			return -parseFactor(); /*Unary minus*/

		double x;
		int startPos = CharacterIteratorExecutor.pos;
		if (characterToEvaluate('(')) {
			
			ExecutorService executor = Executors.newFixedThreadPool(1);
			Callable callable = new CharacterIteratorExecutor();
			Future<Double> value = executor.submit(callable);
			x = value.get().doubleValue();
			executor.shutdown();
			
			characterToEvaluate(')');
			
		} else if ((ch >= '0' && ch <= '9') || ch == '.') {
			while ((ch >= '0' && ch <= '9') || ch == '.')
				NextCharacter();
			x = Double.parseDouble(inputString.substring(startPos, CharacterIteratorExecutor.pos));
		} else {
			throw new RuntimeException("Unexpected: " + (char) ch);
		}
		
		return x;
	}

	@Override
	public Double call() throws InterruptedException, ExecutionException {
		return parseExpression();
	}
}
