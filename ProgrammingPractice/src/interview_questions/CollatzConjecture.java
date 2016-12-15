package interview_questions;

import java.util.Scanner;

public class CollatzConjecture {
	public static void collatzConjecture(int num, int limit){
		int count = 0;
		while(num != 1){
			if(count == limit){
				break;
			}
			if(num % 2 == 0){
				num = num/2;
				System.out.println(num);
				count++;
			} else {
				num = (3*num) + 1;
				System.out.println(num);
				count++;
			}
		}
		System.out.println("Number of steps it took: " + count);
	}

	public static void main(String[] args) {
		System.out.println("Enter the number: ");
		@SuppressWarnings("resource")
		int number = new Scanner(System.in).nextInt();
		collatzConjecture(number, 16);

	}

}
