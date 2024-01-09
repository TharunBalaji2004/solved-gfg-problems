//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


class Solution{
    
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int m = pat.length();
        int n = txt.length();
        
        int[] lps = new int[m];
        computeLPS(pat, m, lps);
        
        int i = 0;   
        int j = 0;
        
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
                
                if (j == m) {
                    ans.add(i - j + 1);  // Add index (one-based) of the occurrence
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        if (ans.isEmpty()) {
            ans.add(-1);   
        }
        
        return ans;
    }
    
     void computeLPS(String pat, int m, int[] lps) {
        int len = 0;
        int i = 1;
        
        lps[0] = 0;
        
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}