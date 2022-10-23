package methods;

import java.util.Scanner;

public class FactorialDivision {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%.2f", ((double)findFactoriel(sc.nextLong())/ (double)findFactoriel(sc.nextLong())));
		sc.close();
	}

	private static long findFactoriel(long num) {
		if(num == 1) return 1;
		
		return num*findFactoriel(num-1);
	}
}
