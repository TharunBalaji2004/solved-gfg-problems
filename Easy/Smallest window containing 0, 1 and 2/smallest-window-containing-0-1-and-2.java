//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    public int smallestSubstring(String S) {
        int i=0,j=0;
        int ans = Integer.MAX_VALUE;
        int[] count = new int[3];
        
        while (j < S.length()) {
            // Update the count
            count[S.charAt(j)-'0']++;
            
            while (count[0] >= 1 && count[1] >= 1 && count[2] >= 1) {
                int size = j - i + 1;
                ans = Math.min(ans, size);
                
                // Shrink the window
                count[S.charAt(i)-'0']--;
                i++;
            }
            
            
            j++;
        }
        
        return (ans == Integer.MAX_VALUE)?-1:ans;
    }
};
