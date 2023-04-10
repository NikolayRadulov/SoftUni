package multyDimentionalArrays;

import java.util.Scanner;

public class MatrixShuffiling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] matrix = fillMatrix(sc);
		
		String input = sc.nextLine();
		
		while (!input.equals("END")) {
			String[] tokens = input.split(" ");
			if(!tokens[0].equals("swap") || tokens.length != 5) {
				System.out.println("Invalid input!");
				input = sc.nextLine();
				continue;
			}
			int i1 = 0, i2 = 0, i3 = 0, i4 = 0;
			try {
				i1 = Integer.parseInt(tokens[1]);
				i2 = Integer.parseInt(tokens[2]);
				i3 = Integer.parseInt(tokens[3]);
				i4 = Integer.parseInt(tokens[4]);
				
				String buff = matrix[i1][i2];
				matrix[i1][i2] = matrix[i3][i4];
				matrix[i3][i4] = buff;
			} catch (Exception e) {
				System.out.println("Invalid input!");
				input = sc.nextLine();
				continue;
			}
			printMatrix(matrix);
			
			input = sc.nextLine();
		}

	}
	
	private static void printMatrix(String[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static String[][] fillMatrix(Scanner sc) {

		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		sc.nextLine();
		String[][] matrix = new String[n][m];

		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = sc.nextLine().split("\\s+");
		}
		
		return matrix;
	}

}
