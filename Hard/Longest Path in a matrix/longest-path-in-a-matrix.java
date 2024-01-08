//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n  = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    matrix[i][j] = Integer.parseInt(S2[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.longestIncreasingPath(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length, maxLength = 0;
        int[][] memo = new int[rows][cols];

        // DFS Approach
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                maxLength = Math.max(maxLength, dfs(i, j, matrix, memo));
            }
        }

        return maxLength;
    }

    private static int dfs(int i, int j, int[][] matrix, int[][] memo) {
        if (memo[i][j] > 0) return memo[i][j];

        int curr = matrix[i][j], left=0, right=0, top=0, bottom=0;

        if (j > 0 && matrix[i][j-1] > curr) left = dfs(i, j-1, matrix, memo);
        if (j < matrix[0].length-1 && matrix[i][j+1] > curr) right = dfs(i, j+1, matrix, memo);
        if (i > 0 && matrix[i-1][j] > curr) top = dfs(i-1, j, matrix, memo);
        if (i < matrix.length-1 && matrix[i+1][j] > curr) bottom = dfs(i+1, j, matrix, memo);

        memo[i][j] = 1 + Math.max(Math.max(left, right), Math.max(top, bottom));

        return memo[i][j];
    }
}