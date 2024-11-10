//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class DriverClass {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<iPair>> adj = new ArrayList<ArrayList<iPair>>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<iPair>());
            }

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                iPair t1 = new iPair(v, w);
                iPair t2 = new iPair(u, w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            int src = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.dijkstra(adj, src);

            for (i = 0; i < V; i++) System.out.print(res.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
*/

class Solution {
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        PriorityQueue<iPair> pq = new PriorityQueue<>((a,b) -> a.second - b.second);
        
        int V = adj.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // start from source node
        dist[src] = 0;
        pq.add(new iPair(src, 0));
        
        while (!pq.isEmpty()) {
            iPair curr = pq.remove();
            int dest = curr.first;
            
            for (int i=0;i<adj.get(dest).size();i++) {
                int neighbor = adj.get(dest).get(i).first;
                int weight = adj.get(dest).get(i).second;
                
                if (curr.second + weight < dist[neighbor]) {
                    dist[neighbor] = curr.second + weight;
                    pq.add(new iPair(neighbor, dist[neighbor]));
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : dist) res.add(num);
        
        return res;
    }
}