
import java.util.*;

public class PrimMST {

    // Method to find the Minimum Spanning Tree using Prim's algorithm
    public static List<int[]> primMST(int[][] graph) {
        List<int[]> mst = new ArrayList<>(); // List to store MST edges
        int V = graph.length; // Number of vertices
        boolean[] visited = new boolean[V]; // Array to keep track of visited vertices
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1])); // Priority queue to store edges

        // Start from vertex 0
        pq.offer(new int[]{0, 0}); // Start with vertex 0 with weight 0

        // Main loop of Prim's algorithm
        while (!pq.isEmpty()) {
            int[] minEdge = pq.poll(); // Retrieve the smallest weighted edge from the priority queue

            int u = minEdge[0]; // Source vertex of the minimum weighted edge

            // Skip if the vertex is already visited
            if (visited[u]) continue;

            visited[u] = true; // Mark the vertex as visited

            mst.add(minEdge); // Add the minimum weighted edge to the MST

            // Iterate through all adjacent vertices of u
            for (int v = 0; v < V; v++) {
                // Check if there is an edge between u and v and v is not visited
                if (graph[u][v] != 0 && !visited[v]) {
                    // Add the edge to the priority queue
                    pq.offer(new int[]{v, graph[u][v]});
                }
            }
        }

        return mst; // Return the list of MST edges
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int[][] graph = {
            {0, 2, 0, 6, 0}, // Weighted graph represented as an adjacency matrix
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        List<int[]> mst = primMST(graph); // Find MST using Prim's algorithm
        System.out.println("Edges of Minimum Spanning Tree:");
        for (int[] edge : mst) {
            // Print the edges of the Minimum Spanning Tree
            System.out.println("Edge " + edge[0] + " - " + edge[1]);
        }
    }
}
