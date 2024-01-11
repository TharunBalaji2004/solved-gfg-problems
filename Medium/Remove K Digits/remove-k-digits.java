//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        Stack<Character> stack = new Stack<>();

        for (char ch: num.toCharArray()) {

            while (k >0 && !stack.isEmpty() && stack.peek()-'0' > ch - '0') {
                stack.pop();
                k--;
            }
            
            stack.push(ch);
        }

        // Handling repition of digits - "1111"
        while(k>0){
            stack.pop();
            k--;            
        }
        
        return convert(stack);
    }

    private String convert(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()) sb.append(stack.pop());

        sb.reverse();

        // Removing Leading zeroes : "00123" -> "123"
        while(sb.length()>1 && sb.charAt(0)=='0') sb.deleteCharAt(0);

        return sb.toString();
    }
}