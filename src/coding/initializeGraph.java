package coding;

import java.util.*;

public class initializeGraph {

	/**
	 * Main method to demonstrate the creation and manipulation of an adjacency list
	 * representing a graph with n nodes.
	 */

	public static void initGraphSizeKnown() {
		List<int[]>[] g = new ArrayList[10]; // Adjacency list to represent the graph
		System.out.println(g.length);

		Arrays.setAll(g, k -> new ArrayList<>());
		// Initialize the adjacency list
//		for (int i = 0; i < 10; ++i) {
//			g[i] = new ArrayList<>();
//		}

		// Add an edge from node 0 to node 1
		g[0].add(new int[]{1, 1});

		// Print the number of edges from node 0
		System.out.println(g[0].size());
	}

	public static void initGraphSizeUnknown(int n) {
		List<List<Integer[]>> g = new ArrayList<>(); // Adjacency list to represent the graph
		System.out.println(g.size());

		for (int i = 0; i < n; ++i) {
			g.add(new ArrayList<>());
		}

		// Add an edge from node 0 to node 1
		g.get(0).add(new Integer[]{1, 1});

		// Print the number of edges from node 0
		System.out.println(g.get(0).size());
	}

	public static void main(String[] args) {
		initGraphSizeKnown();
		System.out.println("##################################");
		initGraphSizeUnknown(10);
	}
}
