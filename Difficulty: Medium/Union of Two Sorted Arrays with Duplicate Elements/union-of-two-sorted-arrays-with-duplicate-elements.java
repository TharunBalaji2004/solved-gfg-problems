//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(a, b);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// a,b : the arrays
class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        int n = a.length, m = b.length;
        ArrayList<Integer> res = new ArrayList<>();
        
        // STEP 1: Initialize the pointers
        int p1 = 0, p2 = 0;
        
        // STEP 2: Start the comparison
        while (p1 < n && p2 < m) {
            // CASE 1: value of p1 = p2
            if (a[p1] == b[p2]) {
                if (res.size() == 0 || res.get(res.size()-1) != a[p1]) res.add(a[p1]);
                
                p1++;
                p2++;
            } 
            // CASE 2: Value of p1 < p2
            else if (a[p1] < b[p2]) {
                if (res.size() == 0 || res.get(res.size()-1) != a[p1]) res.add(a[p1]);
                
                p1++;
            }
            // CASE 3: Value of p1 > p2
            else if (a[p1] > b[p2]) {
                if (res.size() == 0 || res.get(res.size()-1) != b[p2]) res.add(b[p2]);
                
                p2++;
            }
        }
        
        // STEP 3: Identify the pointer which is not yet completed
        while (p1 < n) {
            if (res.size() == 0 || res.get(res.size()-1) != a[p1]) res.add(a[p1]);
                
            p1++;
        }
        
        while (p2 < m) {
            if (res.size() == 0 || res.get(res.size()-1) != b[p2]) res.add(b[p2]);
                
            p2++;
        }
        
        return res;
    }
}
