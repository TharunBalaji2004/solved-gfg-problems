//{ Driver Code Starts
import java.util.*;

// Driver code
class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt(); // Taking number of test cases as input

        while (testcases-- > 0) {
            int V = sc.nextInt(); // Number of vertices
            int E = sc.nextInt(); // Number of edges

            // Initialize adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>()); // Create a new list for each vertex
            }

            // Add edges to the adjacency list
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v); // Adding edge u -> v
                adj.get(v).add(u); // Adding edge v -> u (undirected graph)
            }

            // Create Solution object and call bfsOfGraph
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.bfsOfGraph(V, adj);

            // Print the result
            for (int node : result) {
                System.out.print(node + " ");
            }
            System.out.println();
        }

        sc.close(); // Close the scanner
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        
        boolean[] visited = new boolean[V];
        ArrayList<Integer> traversal = new ArrayList<>();
        
        // STEP 1: Create a queue and insert source code
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        traversal.add(0);
        visited[0] = true;
        
        // STEP 2: Explore the neighboring nodes
        while (!queue.isEmpty()) {
            int node = queue.remove();
            
            for (int neighbor : adj.get(node)) {
                // STEP 3: Insert the non-visited neighboring nodes into the queue
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    traversal.add(neighbor);
                }
            }
        }
        
        return traversal;
    }
}