//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            String []input_line = read.readLine().trim().split("\\s+");
            String S1 = input_line[0];
            String S2 = input_line[1];
            Solution obj = new Solution();
            int ans = obj.minManipulation(N, S1, S2); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution { 
    int minManipulation(int N, String s, String t) {
        int[] freq = new int[26];

        for (int i=0;i<s.length();i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        int count = 0;
        for (int num: freq) {
            if (num > 0) count += num;
        }

        return count;
    }
} 