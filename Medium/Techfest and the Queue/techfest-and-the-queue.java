//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long a;
            a = Long.parseLong(br.readLine().trim());
            
            
            long b;
            b = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    
    private static long prime(long n) {
        long ans = 0;
        
        for (long i=2;i<=Math.sqrt(n);i++) {
            while (n%i == 0) {
                ans++;
                n = n/i;
            }
        }
        
        if (n > 1) ans++;
        
        return ans;
    }
    
    public static long sumOfPowers(long a, long b) {
        long total = 0;
        
        for (long i=a;i<=b;i++) {
            total += prime(i);
        }
        
        return total;
    }
}
        