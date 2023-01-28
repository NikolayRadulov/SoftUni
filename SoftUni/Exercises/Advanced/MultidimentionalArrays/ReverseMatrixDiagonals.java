package multyDimentionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReverseMatrixDiagonals {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		sc.nextLine();
		int[][] matrix = new int[n][m];
		
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		}
		
		for(int i = matrix.length-1; i >= 0; i--) {
			List<Integer> list = new ArrayList<>();
			int r = i;
		    int c;
		    if(i == n-1) {	    	
		    	for (int j = m-1; j >= 0; j--) {
		    		c = j;
		    		r = i;
		    		while(r >= 0 && c < matrix[i].length) {
						list.add(matrix[r][c]);
						r--;
						c++;
					}	
		    		for(Integer num:list) {
						System.out.print(num+" ");
					}
					if(j > 0)System.out.println();
					list.clear();
				}
		    }
		    else {
		    	c = 0;
				while(r >= 0 && c < matrix[i].length) {
					list.add(matrix[r][c]);
					r--;
					c++;
				}
		    }
			
			for(Integer num:list) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
		
		
		sc.close();

	}
}
