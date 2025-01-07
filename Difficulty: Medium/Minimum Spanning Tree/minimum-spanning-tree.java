//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


class Node {
    int vertex;
    int weight;
    
    public Node (int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}

class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i=0;i<V;i++) adjList.add(new ArrayList<>());
        
        for (int i=0;i<V;i++) {
            for (int[] arr : adj.get(i)) {
                int dest = arr[0];
                int weight = arr[1];
                
                adjList.get(i).add(new Node(dest, weight));
                adjList.get(dest).add(new Node(i, weight));
            }
        }
        
        
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a,b) -> a.weight - b.weight
        );
        pq.add(new Node(0, 0));
        
        boolean[] visited = new boolean[V];
        int total = 0;
        List<Node> mst = new ArrayList<>();
        
        while (!pq.isEmpty()) {
            Node curr = pq.remove();
            
            if (visited[curr.vertex]) continue;
            
            visited[curr.vertex] = true;
            total += curr.weight;
            
            for (Node neighbor : adjList.get(curr.vertex)) {
                if (!visited[neighbor.vertex]) {
                    pq.add(new Node(neighbor.vertex, neighbor.weight));
                    // mst.add(new Node())
                }
            }
        }
        
        return total;
    }
}