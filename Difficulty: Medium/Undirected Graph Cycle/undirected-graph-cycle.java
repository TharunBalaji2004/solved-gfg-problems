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
    private boolean dfs(int curr, int prev, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        visited[curr] = true;
        
        for (int neighbor: adjList.get(curr)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, curr, adjList, visited) == true) return true;
            } else if (neighbor != prev) {
                return true; // There is a cycle
            }
        }
        
        return false;
    }
    
    public boolean isCycle(ArrayList<ArrayList<Integer>> adjList) {
        int V = adjList.size();
        boolean[] visited = new boolean[V];
        
        
        for (int i=0;i<V;i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adjList, visited) == true) return true;
            }
        }
        
        return false;
    }
}