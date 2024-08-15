//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
    String reverseWords(String sentence){
        // We have to split at dot
        int dotIndex = sentence.indexOf('.'); 
        
        if (dotIndex == -1) return sentence; // Base case
        
        String left = sentence.substring(0, dotIndex);
        String right = sentence.substring(dotIndex + 1);
        
        // Recursive case
        return reverseWords(right) + "." + left;
    }
}