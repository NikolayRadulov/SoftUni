package fundamentals.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Salaries {

	private static Map<Integer, Integer> memo;
	private static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		visited = new boolean[n];
		Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
		memo = new HashMap<>();
		
		for(int i = 0; i < n; i++) {
			String symbols = sc.nextLine();
			graph.put(i, new ArrayList<>());
			for(int j = 0; j < symbols.length(); j++) {
				if(symbols.charAt(j) == 'Y') graph.get(i).add(j);
			}
		}
		/*Map<Integer, Integer> dependensiesMap = getDependencies(graph);
		
		int startKey = graph.keySet().stream()
									 .filter(key -> dependensiesMap.get(key) == 0)
									 .findFirst()
									 .orElse(null);
		*/
		int totalSalary = 0;
		for(int i = 0; i < n; i++) {
			totalSalary += getSalary(i, graph);
		}
		
		
		System.out.println(totalSalary);

		sc.close();
	}
	
	
	private static int getSalary(int node, Map<Integer, List<Integer>> graph) {
		
		if(visited[node]) return 0;
		if(memo.containsKey(node)) return memo.get(node);
		if(graph.get(node).size() == 0) return 1;
		
		
		
		int totalEmployeeSalary = 0;
		visited[node] = true;
		
		for (int child : graph.get(node)) {
			int salary = getSalary(child, graph);
			totalEmployeeSalary += salary;
		}
		visited[node] = false;
		memo.put(node, totalEmployeeSalary);
		return totalEmployeeSalary;
	}

}
