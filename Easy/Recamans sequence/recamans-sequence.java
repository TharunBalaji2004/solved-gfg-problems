//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.recamanSequence(n);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends



class Solution{
    static ArrayList<Integer> recamanSequence(int n){
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        res.add(0);
        set.add(0);
        int count = 1;
        
        while (count < n) {
            int val = res.get(count - 1) - count;
            
            if (val < 0 || set.contains(val)) {
                val = val + 2*count;
            }
            
            count++;
            res.add(val);
            set.add(val);
        }
        
        
        return res;
    }
}