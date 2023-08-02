package advanced.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BellmanFordAlgorithm {

	private static final class Edge {
		private int source;
		private int destination;
		private int weight;
		
		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}

		public int getSource() {
			return source;
		}

		public void setSource(int source) {
			this.source = source;
		}

		public int getDestination() {
			return destination;
		}

		public void setDestination(int destination) {
			this.destination = destination;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

	}
	
	
	private int[] distance;
	private int[] prev;
	private boolean isNegativeCycleFound;
	private boolean checkForNegativeCycle;
	
	public BellmanFordAlgorithm() {
		Scanner sc = new Scanner(System.in);
		int nodes = Integer.parseInt(sc.nextLine());
		distance = new int[nodes+1];
		prev = new int[nodes+1];
		List<Edge> edges = getEdges(sc);
		
		int source = Integer.parseInt(sc.nextLine());
		int destination = Integer.parseInt(sc.nextLine());
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(prev, -1);
		
		distance[source] = 0;
		
		bellmanFord(edges, nodes, source);
		checkForNegativeCycle = true;
		bellmanFord(edges, nodes, source);
		
		if(!isNegativeCycleFound) {
			List<Integer> path = new ArrayList<>();
			int node = destination;
			while (node != -1) {
				path.add(node);
				node = prev[node];
			}
			Collections.reverse(path);	
			String ans = "";
			for (int pathNode : path) {
				ans += pathNode + " ";
			}
			System.out.println(ans.trim());
			System.out.println(distance[destination]);
		}
	}
	
	
	private void bellmanFord(List<Edge> edges, int nodes, int sourceNode) {
		
		for(int i = 1; i < nodes - 1; i++) {
			for (Edge edge : edges) {
				int newDistance = distance[edge.getSource()] + edge.getWeight();
				if(distance[edge.getSource()] != Integer.MAX_VALUE && newDistance < distance[edge.getDestination()]) {
					if(checkForNegativeCycle) {
						System.out.println("Negative Cycle Detected");
						isNegativeCycleFound = true;
						return;
					}
					distance[edge.getDestination()] = newDistance;
					prev[edge.getDestination()] = edge.getSource(); 
				}
			}
		}
	}
	
	
	private List<Edge> getEdges(Scanner sc) {
		List<Edge> edges = new ArrayList<>();
		
		int edgesCount = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < edgesCount; i++) {
			int[] tokens = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();	
			edges.add(new Edge(tokens[0], tokens[1], tokens[2]));
		}
		
		
		return edges;
	}
	
	
	
	
	public static void main(String... args) {
		new BellmanFordAlgorithm();
	}

}
