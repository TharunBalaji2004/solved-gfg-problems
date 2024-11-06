//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u); // Added this line to make the graph undirected
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.bfsOfGraph(adj);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adjList) {
        ArrayList<Integer> traversal = new ArrayList<>();
        
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        
        // STEP 1: Mark the start node as visited
        visited[0] = true;
        queue.add(0);
        traversal.add(0);
        
        // STEP 2: Remove the node and add its neighbors
        while (!queue.isEmpty()) {
            int node = queue.remove();
            
            for (int neighbor : adjList.get(node)) {
                
                // Mark the neighbor node as visited, and add to queue and list
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    traversal.add(neighbor);
                }
            }
        }
        
        
        return traversal;
    }
}