package fundamentals.graph;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AreasInMatrix {

	private static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		

		char[][] matrix = new char[n][];
		visited = new boolean[n][];
		
		for(int i = 0; i < n; i++) {
			matrix[i] = sc.nextLine().toCharArray();
			visited[i] = new boolean[matrix[i].length];
		}
		
		Map<Character, Integer> map = new TreeMap<>();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(!visited[i][j]) {
					findArea(matrix, matrix[i][j], i, j);
					map.putIfAbsent(matrix[i][j], 0);
					map.put(matrix[i][j], map.get(matrix[i][j]) + 1);
				}
			}
		}
		int sum = 0;
		StringBuilder sBuilder = new StringBuilder();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			Character key = entry.getKey();
			Integer val = entry.getValue();
			
			sum += val;
			sBuilder.append(String.format("Letter '%c' -> %d", key, val)).append(System.lineSeparator());
			
		}
		System.out.println("Areas: " + sum);
		System.out.println(sBuilder.toString().trim());
		
		sc.close();
	}
	
	private static void findArea(char[][] matrix, char letter, int i, int j) {	
		
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length) return;
		if(matrix[i][j] != letter) return;
		
		
		if(!visited[i][j]) {
			visited[i][j] = true;
			findArea(matrix, letter, i+1, j);
			findArea(matrix, letter, i, j+1);
			findArea(matrix, letter, i-1, j);
			findArea(matrix, letter, i, j-1);
		}
	}

}
