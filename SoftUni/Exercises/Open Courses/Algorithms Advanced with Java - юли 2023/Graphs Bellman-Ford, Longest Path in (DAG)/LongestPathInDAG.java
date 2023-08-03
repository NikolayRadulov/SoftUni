package advanced.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class LongestPathInDAG {

	private int[][] graph;
	private boolean[] visited;
	private int[] distance;
	private Scanner sc;
	
	public LongestPathInDAG() {
		sc = new Scanner(System.in);
		
		this.graph = getGraph();
		ArrayDeque<Integer> sorted = new ArrayDeque<>();
		int sorce = Integer.parseInt(sc.nextLine());
		int destination = Integer.parseInt(sc.nextLine());
		
		topologicalSort(1, sorted);
		
		while (!sorted.isEmpty()) {
			int node = sorted.pop();
			
			for(int i = 1; i < graph[node].length; i++) {
				if(graph[node][i] != 0) {
					int newDistance = distance[node] + graph[node][i];
					if(newDistance > distance[i]) {
						distance[i] = newDistance;
					}
				}
			}
		}
		
		System.out.println(distance[destination]);
	}
	
	private void topologicalSort(int node, ArrayDeque<Integer> sorted) {
		if(visited[node]) return;
		
		visited[node] = true;
		
		for (int i = 1; i < graph[node].length; i++) {
			if(graph[node][i] != 0) {
				topologicalSort(i, sorted);
			}
		}
		
		sorted.push(node);
	}
	
	private int[][] getGraph() {
		int nodes = Integer.parseInt(sc.nextLine());
		int[][] graph = new int[nodes+1][nodes+1];
		visited = new boolean[nodes+1];
		distance = new int[nodes+1];
		int edges = Integer.parseInt(sc.nextLine());
		
		for(int i = 0; i < edges; i++) {
			int[] tokens = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			
			graph[tokens[0]][tokens[1]] = tokens[2];
		}
		
		return graph;
		
	}
	
	
	public static void main(String... args) {
		new LongestPathInDAG();
	}

}
