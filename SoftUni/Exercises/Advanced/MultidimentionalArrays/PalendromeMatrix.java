package multyDimentionalArrays;

import java.util.Scanner;

public class PalendromeMatrix {

	public static void main(String[] args) {
		String[][] matrix = fillMatrix();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static String[][] fillMatrix() {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		String[][] matrix = new String[n][m];	
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = "";
				char firstAndLastLetter = (char)('a' + i);
				char middleLetter = (char)('a' + i+j);	
				matrix[i][j] += firstAndLastLetter;
				matrix[i][j] += middleLetter;
				matrix[i][j] += firstAndLastLetter;
			}
		}			
		sc.close();
		return matrix;
	}
}
