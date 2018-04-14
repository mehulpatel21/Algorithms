package bloomberg;

public class PowerXtoN {
	public double myPow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if(x == 0) {
            return 0;
        }
        if( n < 0) {
            if( n == Integer.MIN_VALUE) {
                n++; // Make -2147483648 to -2147483647
                if(x < 0) {
                    x = -x; //we made n odd so need to update sign
                }
            }
            n = -n;
            x = 1/x;
        }
        if(n % 2 == 0) {
            return myPow(x*x, n/2);
        }
        else {
            return x * myPow(x*x, n/2);
        }
    }
}
