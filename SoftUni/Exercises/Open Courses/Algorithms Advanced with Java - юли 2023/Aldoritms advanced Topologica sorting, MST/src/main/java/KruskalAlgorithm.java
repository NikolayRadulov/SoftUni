import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {

    public static List<Edge> kruskal(int numberOfVertices, List<Edge> edges) {
    	
    	Collections.sort(edges);
    	
    	List<Edge> forest = new ArrayList<>();
    	
    	int[] parents = new int[numberOfVertices];
    	
    	for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}
    	
    	while (!edges.isEmpty()) {
			Edge child = edges.remove(0);
			
			int firstRoot = findRoot(child.getStartNode(), parents);
			int secondRoot = findRoot(child.getEndNode(), parents);
			
			if(firstRoot != secondRoot) {
				forest.add(child);
				parents[firstRoot] = secondRoot;
			}

    	}
    	
        return forest;
    }

    public static int findRoot(int node, int[] parents) {
    	
    	while (parents[node] != node) {
			node = parents[node];
		}
    	
        return node;
    }
}
