//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        int fmax = -1, smax = -1;
        
        for (int curr : arr) {
            // CASE 1: curr > fmax
            if (curr > fmax) {
                smax = fmax;
                fmax = curr;
            }
            // CASE 2: curr > smax
            else if (curr > smax && curr < fmax) {
                smax = curr;
            }
        }
        
        return (fmax == smax) ? -1 : smax;
    }
} 