//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            int  k = Integer.parseInt(read.readLine());
            int  n = Integer.parseInt(read.readLine());
            int arr[][] = new int[n][n];
            String input_line1[] = read.readLine().trim().split("\\s+");
            int c = 0;
            for(int i=0;i<n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            Solution obj = new Solution();
            System.out.println(obj.numberOfPath(n, k, arr));
        }
    }
}

// } Driver Code Ends


// Backtracking approach
class Solution {
    long count = 0;
    long numberOfPath(int n, int k, int [][]mat) {
        helper(mat, 0, 0, n, k, 0);
        
        return count;
    }
    
    void helper(int[][]mat, int i, int j, int n, int k, int sum) {
        sum += mat[i][j];
        // Base case
        if (sum > k) return;
        if (i == n-1 && j == n-1) {
            if (sum == k) count++;
            return;
        }
        
        if (j < n-1) helper(mat, i, j+1, n, k, sum);
        if (i < n-1) helper(mat, i+1, j, n, k, sum);
    }
}