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
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(adj);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    private void dfs(
        int node, 
        boolean[] visited, 
        ArrayList<Integer> traversal, 
        ArrayList<ArrayList<Integer>> adj) {
            
        // STEP 1: Add the current node to traversal list
        traversal.add(node);
        
        // STEP 2: Mark the current node as visited
        visited[node] = true;
        
        // STEP 3: Call dfs for neighbors
        for (int neighbor : adj.get(node)) {
            // STEP 4: Check for non visited neighbor, and apply DFS
            if (!visited[neighbor]) {
                dfs(neighbor, visited, traversal, adj);
            }
        }
    }
    
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        
        int V = adj.size();
        
        boolean[] visited = new boolean[V];
        
        ArrayList<Integer> traversal = new ArrayList<>();
        
        dfs(0, visited, traversal, adj);
        
        return traversal;
    }
}