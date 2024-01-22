//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        visited[i][j] = true;

        int[] dx = {-1, 0, 1, 0,1 , -1, -1, 1};
        int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

        for (int d = 0; d < 8; d++) {
            int currX = i + dx[d];
            int currY = j + dy[d];

            if (currX >= 0 && currY >= 0 && currX < grid.length && currY < grid[0].length && !visited[currX][currY] && grid[currX][currY] == '1') {
                dfs(currX, currY, grid, visited);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length, islands = 0;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    islands++;
                    dfs(i, j, grid, visited);
                }
            }
        }

        return islands;
    }
}