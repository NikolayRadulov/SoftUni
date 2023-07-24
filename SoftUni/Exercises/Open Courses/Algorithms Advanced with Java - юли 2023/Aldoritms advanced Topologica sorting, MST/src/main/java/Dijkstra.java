import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public static List<Integer> dijkstraAlgorithm(int[][] graph, int sourceNode, int destinationNode) {
    	int[] d = new int[graph.length];
    	int[] parent = new int[graph.length];
    	boolean[] visited = new boolean[graph.length];
    	
    	PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(node -> d[node]));
    	
    	Arrays.fill(d, Integer.MAX_VALUE);
    	d[sourceNode] = 0;
    	Arrays.fill(parent, -1);
    	
    	queue.offer(sourceNode);
    	
    	while (!queue.isEmpty()) {
			int node = queue.poll();
			visited[node] = true;
    		
    		for (int i = 0; i < graph[node].length; i++) {
    			if(graph[node][i] == 0 || visited[i]) continue;
    			
    			queue.offer(i);
    			
    			int newDistance = d[node] + graph[node][i];
    			
    			if(newDistance < d[i]) {
    				d[i] = newDistance;
    				parent[i] = node;
    			}
    		}
		}
    	if(!visited[destinationNode]) return null;
    	int index = destinationNode;
    	List<Integer> path = new ArrayList<>();
    	while (index != -1) {
			path.add(index);
			index = parent[index];
		}
    	Collections.reverse(path);
    	
        return path;
    }
}
