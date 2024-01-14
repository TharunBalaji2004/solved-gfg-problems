//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int A[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    A[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(N, M, A);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[][] rotateMatrix(int rows, int cols, int mat[][]) {
        int row = 0, col = 0, prev = 0, curr = 0;

        while (row < rows && col < cols) {
            // Base case
            if (row + 1 == rows || col + 1 == cols) break;

            prev = mat[row + 1][col];

            // Top row
            for (int j = col; j < cols; j++) {
                curr = mat[row][j];
                mat[row][j] = prev;
                prev = curr;
            }
            row++;

            // Right Col
            for (int i = row; i < rows; i++) {
                curr = mat[i][cols - 1];
                mat[i][cols - 1] = prev;
                prev = curr;
            }
            cols--;

            if (row < rows) {
                for (int j = cols - 1; j >= col; j--) {
                    curr = mat[rows - 1][j];
                    mat[rows - 1][j] = prev;
                    prev = curr;
                }
                rows--;
            }

            if (col < cols) {
                for (int i = rows - 1; i >= row; i--) {
                    curr = mat[i][col];
                    mat[i][col] = prev;
                    prev = curr;
                }
                col++;
            }
        }
        
        return mat;
    }
}