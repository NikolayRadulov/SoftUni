package methods;

import java.util.Scanner;

public class AddAndSubtract {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(subtract(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		sc.close();
	}

	private static int subtract(int a, int b, int c) {
		return sum(a, b)-c;
	}
	private static int sum(int a, int b) {
		return a+b;
	}
}
