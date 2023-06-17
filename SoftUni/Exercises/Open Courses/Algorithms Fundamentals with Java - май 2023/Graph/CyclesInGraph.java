package fundamentals.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CyclesInGraph {

	private static boolean isAcyclic = true;
	public static void main(String[] args) {
		Map<String, List<String>> graph = fillGraph();
		String entry = graph.entrySet().iterator().next().getKey();
		
		dfs(entry, graph, new HashSet<>(), new HashSet<>());
		
		System.out.print("Acyclic: ");
		if(!isAcyclic) System.out.print("No");
		else System.out.print("Yes");
	}
	
	private static void dfs(String node, Map<String, List<String>> graph, HashSet<String> cycled, HashSet<String> visited) {
		
		if(visited.contains(node)) return;
		if(cycled.contains(node)) {
			isAcyclic = false;
			return;
		}
		cycled.add(node);
		visited.add(node);
		for(String child : graph.get(node)) {
			dfs(child, graph, cycled, visited);
		}
		visited.remove(node);

	}
	
	private static Map<String, List<String>> fillGraph() {
		Scanner sc = new Scanner(System.in);
		
		
		Map<String, List<String>> graph = new LinkedHashMap<>();
		String input = sc.nextLine();
		
		while (!input.equals("End")) {
			String[] tokens = input.split("\\-");
			
			graph.putIfAbsent(tokens[0], new ArrayList<>());
			graph.get(tokens[0]).add(tokens[1]);
			graph.putIfAbsent(tokens[1], new ArrayList<>());
			graph.get(tokens[1]).add(tokens[0]);
			
			input = sc.nextLine();
		}
		sc.close();
		
		return graph;
		
	}
	
	
	

}
