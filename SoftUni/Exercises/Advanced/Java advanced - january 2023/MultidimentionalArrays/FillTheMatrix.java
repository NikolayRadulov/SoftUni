package multyDimentionalArrays;

import java.util.Scanner;

public class FillTheMatrix {

	public static void main(String[] args) {
		int[][] matrix = fillMatrix();
		printMatrix(matrix);
	}
	
	private static int[][] fillMatrix() {
		Scanner sc = new Scanner(System.in);
		String[] tokens = sc.nextLine().split(", ");
		int dimention = Integer.parseInt(tokens[0]);
		String type = tokens[1];
		int[][] matrix = new int[dimention][dimention];
		int startNum = 1;
		if(type.equals("A")) {
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix.length; j++) {
					matrix[j][i] = startNum++;
				}
			}
		}
		else {
			for (int i = 0; i < matrix.length; i++) {
				if(i % 2 == 0) {
					for (int j = 0; j < matrix.length; j++) {
						matrix[j][i] = startNum++;
					}
				}
				else {
					for (int j = matrix.length-1; j >= 0; j--) {
						matrix[j][i] = startNum++;
					}
				}
			}		
		}
		sc.close();
		return matrix;
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
