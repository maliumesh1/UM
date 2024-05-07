import java.util.*;

public class PrimMST {

    public static List<int[]> primMST(int[][] graph) { // garp is a Weighted graph matrix 
        List<int[]> mst = new ArrayList<>(); // used to store MST edges 
        int V = graph.length;
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));

        // Start from vertex 0
        pq.offer(new int[]{0, 0}); // start with 0 using 0 weight 

        while (!pq.isEmpty()) {
            int[] minEdge = pq.poll(); // retrive smallest weight from pq and store it

            int u = minEdge[0];// asign source vertex 

            if (visited[u]) continue;
            visited[u] = true;

            mst.add(minEdge); // add to mst minimum edge 

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    pq.offer(new int[]{v, graph[u][v]});
                }
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        List<int[]> mst = primMST(graph);
        System.out.println("Edges of Minimum Spanning Tree:");
        for (int[] edge : mst) {
            System.out.println("Edge " + edge[0] + " - " + edge[1]);
        }
    }
}


/*
Edges of Minimum Spanning Tree:
Edge 0 - 0
Edge 1 - 2
Edge 2 - 3
Edge 4 - 5
Edge 3 - 6 
    */
