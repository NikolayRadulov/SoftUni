package methods;

import java.util.Scanner;

public class NNMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		printMatrix(sc.nextInt());
		sc.close();

	}
	
	private static void printMatrix(int num) {
		for (int i = 0; i < num; i++) {
			for (int j = 1; j <= num; j++) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}

}
