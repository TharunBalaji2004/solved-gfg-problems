//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            String[] dictionary = new String[N];
            for(int i=0;i<N;i++)
            {
                dictionary[i] = sc.next();
            }
            
            int R = Integer.parseInt(sc.next());
            int C = Integer.parseInt(sc.next());
            
            char board[][] = new char[R][C];
            for(int i=0;i<R;i++)
            {
                for(int j=0;j<C;j++)
                {
                    board[i][j] = sc.next().charAt(0);
                }
            }
            
            Solution obj = new Solution();
            String[] ans = obj.wordBoggle(board, dictionary);
            
            if(ans.length == 0) System.out.println("-1");
            else
            {
                Arrays.sort(ans);
                for(int i=0;i<ans.length;i++)
                {
                    System.out.print(ans[i] + " ");
                }
                System.out.println();
            }
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0},{-1,-1},{1,1},{1,-1},{-1,1}};
    
    private boolean dfs(char[][] board, boolean[][] visited, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        
        visited[row][col] = true;
        
        for (int[] dir : directions) {
            int currRow = row + dir[0];
            int currCol = col + dir[1];
            
            if (dfs(board, visited, word, currRow, currCol, index + 1)) {
                visited[row][col] = false;
                return true;
            }
        }
        
        visited[row][col] = false;
        return false;
    }
    
    public String[] wordBoggle(char board[][], String[] dictionary){
        Set<String> resultSet = new HashSet<>();
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        for (String word : dictionary) {
            boolean found = false;
            for (int i = 0; i < rows && !found; i++) {
                for (int j = 0; j < cols && !found; j++) {
                    if (board[i][j] == word.charAt(0) && dfs(board, visited, word, i, j, 0)) {
                        resultSet.add(word);
                        found = true;
                    }
                }
            }
        }
        
        return resultSet.toArray(new String[0]);
    }
}