package multyDimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		int[][] matrix = fillMatrix();
		printDiagonalDifference(matrix);

	}
	private static int[][] fillMatrix() {
		Scanner sc = new Scanner(System.in);
		String[] tokens = sc.nextLine().split(", ");
		int dimention = Integer.parseInt(tokens[0]);
		int[][] matrix = new int[dimention][];

		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		}
		
	
		sc.close();
		return matrix;
	}

	private static void printDiagonalDifference(int[][] matrix) {
		int sumP = 0;
		int sumS = 0;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(i == j) sumP+=matrix[i][j];
				if(i+j == matrix.length-1) sumS+= matrix[i][j];
			}
		}
		System.out.println(Math.abs((sumP-sumS)));
	}
}
