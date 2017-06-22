package experianDataQualityTest;

import java.io.BufferedInputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class EvaluateExpression_myversion{
	 @SuppressWarnings({ "resource" })
	public static void main(String[] args){
		 final String charsetName = "UTF-8";
		 System.out.println("Enter your expression: ");
		 Scanner scan = new Scanner(new BufferedInputStream(System.in), charsetName);
		 String string = scan.nextLine();
		 Iterator<Character> expression = stringIterator(string);
		 System.out.println(evaluate(expression));
	 }
	 
	 public static Iterator<Character> stringIterator(final String string) {
		  if (string == null)
		    throw new NullPointerException();
		  
		  return new Iterator<Character>() {
			  private int index = 0;
			  public boolean hasNext() {
				  return index < string.length();
			  }

			  public Character next() {
				  if (!hasNext())
					  throw new NoSuchElementException();
				  return string.charAt(index++);
			  }

		    public void remove() {
		      throw new UnsupportedOperationException();
		    }
		  };
		}
	 
	 public static double evaluate(Iterator<Character> itr){
		Stack<String> operations = new Stack<String>();
		Stack<Double> values = new Stack<Double>();
		
		while(itr.hasNext()){
			String element = itr.next().toString();
			if	   (element.equals("("))						 ;
			else if(element.equals("+")) operations.push(element);
			else if(element.equals("-")) operations.push(element);
			else if(element.equals("*")) operations.push(element);
			else if(element.equals("/")) operations.push(element);
			else if(element.equals(")")) {
				String operation = operations.pop();
				double value = values.pop();
				if		(operation.equals("+"))	value = values.pop() + value;
				else if (operation.equals("-"))	value = values.pop() - value;
				else if (operation.equals("*"))	value = values.pop() * value;
				else if (operation.equals("/"))	value = values.pop() / value;
				values.push(value);
			}
			else values.push(Double.parseDouble(element));
		}
		return values.pop();
	}

	
}