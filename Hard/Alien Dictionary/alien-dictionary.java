//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    if(order.length() != k){
		        System.out.println("INCOMPLETE");
		        return;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


class Solution{
    private void dfs(List<List<Integer>> adjList, Stack<Integer> stack, boolean[] visited, int node) {
        visited[node] = true;
        
        for (int neighbor: adjList.get(node)) {
            if (!visited[neighbor]) dfs(adjList, stack, visited, neighbor);   
        }
        
        stack.add(node);
    }
    
    private int[] topoSort(List<List<Integer>> adjList, int V) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0;i<V;i++) {
            if (!visited[i]) dfs(adjList, stack, visited, i);
        }
        
        int[] res = new int[V];
        int index = 0;
        
        while (!stack.isEmpty()) {
            res[index] = stack.pop();
            index++;
        }
        
        return res;
    }
    
    public String findOrder(String [] dict, int N, int K){
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0;i<K;i++) adjList.add(new ArrayList<>());
        
        for (int i=0;i<N-1;i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];
            
            int minLength = Math.min(s1.length(), s2.length());
            
            for (int index=0;index<minLength;index++) {
                if (s1.charAt(index) != s2.charAt(index)) {
                    adjList.get(s1.charAt(index) - 'a').add(s2.charAt(index) - 'a');
                    break;
                }
            }
        }
        
        int[] res = topoSort(adjList, K);
        
        StringBuilder sb = new StringBuilder();
        for (int num: res) {
            sb.append((char)(num + 'a'));
        }
        
        return sb.toString();
    }
}