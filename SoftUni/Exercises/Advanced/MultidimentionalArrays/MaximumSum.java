package multyDimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {

	public static void main(String[] args) {
		int[][] matrix = fillMatrix();
		int maxSum = 0, maxI = 0, maxJ = 0;
		for (int i = 0; i < matrix.length-2; i++) {
			for (int j = 0; j < matrix[i].length-2; j++) {
				int sum = getSum(matrix, i,j);
				if(sum > maxSum) {
					maxSum = sum;
					maxI = i;
					maxJ = j;
				}
			}
		}
		System.out.println("Sum = " + maxSum);
		for (int j2 = maxI; j2 < maxI+3; j2++) {
			for (int k = maxJ; k < maxJ+3; k++) {
				System.out.print(matrix[j2][k]+ " ");
			}
			System.out.println();
		}

	}
	private static int getSum(int[][] matrix, int i, int j) {
		int sum = 0;
		for (int j2 = i; j2 < i+3; j2++) {
			for (int k = j; k < j+3; k++) {
				sum += matrix[j2][k];
			}
		}
		return sum;
	}

	private static int[][] fillMatrix() {

		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		sc.nextLine();
		int[][] matrix = new int[n][m];

		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		}
		
	
		sc.close();
		return matrix;
	}
}
