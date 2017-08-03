package common_questions;

public class SquareRootWithoutMathLibrary {
	public double square_root(int num){
		double x1 = (num * 1.0) / 2;
		double x2 = (x1 + (num/x1)) / 2;
		while(Math.abs(x1-x2) >= 0.0000001){
			x1=x2;
			x2=(x1+(num/x1)) / 2;
		}
		return x2;
	}
	
	public static void findSquareRoot(double number) {
 
        boolean isPositiveNumber = true;
        double g1;
 
        //if the number given is a 0
        if(number==0)
        {
            System.out.println("Square root of "+number+" = "+0);
        }
 
        //If the number given is a -ve number
        else if(number<0)
        {
            number=-number;
            isPositiveNumber = false;
        }
 
        //Proceeding to find out square root of the number
        double squareRoot = number/2;
        do
        {
            g1=squareRoot;
            squareRoot = (g1 + (number/g1))/2;
        }
        while((g1-squareRoot)!=0);
 
        //Displays square root in the case of a positive number
        if(isPositiveNumber)
        {
            System.out.println("Square roots of "+number+" are ");
            System.out.println("+"+squareRoot);
            System.out.println("-"+squareRoot);
        }
        //Displays square root in the case of a -ve number
        else
        {
            System.out.println("Square roots of -"+number+" are ");
            System.out.println("+"+squareRoot+" i");
            System.out.println("-"+squareRoot+" i");
        }
 
    }
}
