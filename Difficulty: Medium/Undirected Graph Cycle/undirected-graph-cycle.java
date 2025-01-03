//{ Driver Code Starts
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
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    
    private boolean dfs(int node, int prev, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, adjList, visited) == true) return true;
            } else if (neighbor != prev) {
                return true; // Cycle is formed
            }
        }
        
        return false;
    }
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adjList) {
        int vertices = adjList.size();
        
        boolean[] visited = new boolean[vertices];
        
        for (int i=0;i<vertices;i++) {
            // Apply DFS for non visited node
            if (!visited[i]) {
                if (dfs(i, -1, adjList, visited) == true) {
                    return true;
                }
            }
        }
        
        return false;
    }
}