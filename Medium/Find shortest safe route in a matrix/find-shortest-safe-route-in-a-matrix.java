//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] a = IntArray.input(br, 2);

            int[][] mat = IntMatrix.input(br, a[0], a[1]);

            Solution obj = new Solution();
            int res = obj.findShortestPath(mat);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
     int[] delrow = {-1, 0, 1, 0};
    int[] delcol = {0, 1, 0, -1};

    int ans = Integer.MAX_VALUE;

    void f(int row, int col, int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis = new int[m][n];
        q.offer(new int[]{row, col, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];

            if (y == n - 1) {
                ans = Math.min(ans, steps + 1);
            }
            vis[x][y] = 1;

            for (int i = 0; i < 4; i++) {
                int nrow = x + delrow[i];
                int ncol = y + delcol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1) {
                    q.offer(new int[]{nrow, ncol, steps + 1});
                    vis[nrow][ncol] = 1;
                }
            }
        }
    }

    public int findShortestPath(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis = new int[m][n];

        // Mark unsafe spots and mark visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int nrow = i + delrow[k];
                        int ncol = j + delcol[k];

                        if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n) {
                            mat[nrow][ncol] = -1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = 0; // Mark unsafe spot
                    vis[i][j] = 1; // Mark visited
                }
            }
        }

        // Check for each cell in the leftmost column
        for (int i = 0; i < m; i++) {
            if (mat[i][0] == 1) {
                f(i, 0, mat); // Function for every '1' in the 0th column
            }
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}

