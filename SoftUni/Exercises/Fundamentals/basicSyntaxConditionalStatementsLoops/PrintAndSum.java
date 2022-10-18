package basicSyntaxConditionalStatementsLoops;

import java.util.Scanner;

public class PrintAndSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int sum = 0;
		for(int i = start; i <= end; i++) {
			System.out.print(i+" ");
			sum+=i;
		}
		System.out.println();
		System.out.print("Sum: " + sum);
		sc.close();
	}

}
