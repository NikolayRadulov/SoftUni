package fundamentals.exam_prep1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Guards {

	
	private static boolean[] visited;
	//private static HashSet<Integer> reachable;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		Map<Integer, List<Integer>> graph = new LinkedHashMap<>();
		
		
		int n = Integer.parseInt(sc.nextLine());
		visited = new boolean[n+1];
		//reachable = new HashSet<>();
		
		int m = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i <= n; i++) {
			graph.putIfAbsent(i, new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			String[] tokens = sc.nextLine().split("\\s+");
						
			if(tokens.length == 2) graph.get(Integer.parseInt(tokens[0])).add(Integer.parseInt(tokens[1])); 
		}
		
		int startPoint = Integer.parseInt(sc.nextLine());

		dfs(graph, startPoint);
		
		StringBuilder sBuilder = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) sBuilder.append(i).append(" ");
		}
		System.out.println(sBuilder.toString().trim());
		
		sc.close();
	}
	
	private static void dfs(Map<Integer, List<Integer>> graph, int node) {
				
		if(visited[node]) return; 	
		visited[node] = true;
		
		for(int child : graph.get(node)) {	
			dfs(graph, child);
		}
	}

}
