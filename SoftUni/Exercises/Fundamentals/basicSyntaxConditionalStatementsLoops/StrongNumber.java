package basicSyntaxConditionalStatementsLoops;

import java.util.Scanner;

public class StrongNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int orgNum = number;
		int sum = 0;
		while(number > 0) {
			int digit = number%10;
			int currSum = 1;
			for(int i = 1; i <= digit; i++) {
				currSum *= i; 
			}
			sum += currSum;
			number /= 10;
		}
		if(sum == orgNum) System.out.println("yes");
		else System.out.println("no");
		sc.close();
	}

}
