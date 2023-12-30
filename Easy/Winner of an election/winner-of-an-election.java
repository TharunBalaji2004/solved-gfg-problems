//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    public static String[] winner(String arr[], int n){
        Map<String, Integer> map = new HashMap<>();
        
        for (String name: arr) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        
        int maxi = 0;
        String winner = "";
        
        for (String name: map.keySet()) {
            int votes = map.get(name);
            
            if (votes > maxi || (votes == maxi && name.compareTo(winner) < 0)) {
                maxi = votes;
                winner = name;
            }
        }
        
        return new String[]{winner, String.valueOf(maxi)};
    }
}

