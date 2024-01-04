//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.singleElement(arr,N));
        }
    }
}
// } Driver Code Ends

class Solution {
    static int singleElement(int[] arr , int N) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int num: arr) {
            freq.put(num, freq.getOrDefault(num,0) + 1);
        }
        
        for (int key: freq.keySet()) {
            if (freq.get(key) == 1) return key;
        }
        
        return -1;
    }
}