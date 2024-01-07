//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Binary Search Approach
    static int splitArray(int[] nums, int N, int k) {
        // Apply Binary search b/w max(nums)...sum(nums)
        int left = Arrays.stream(nums).max().orElse(0);
        int right = Arrays.stream(nums).sum();
        int res = right;

        while (left <= right) {
            int mid = left + (right - left)/2;

            // Determine the minimised possible sum - mid, and find its split
            if (canSplit(nums, mid, k)) {   
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    private static boolean canSplit(int[] nums, int largest, int k) {
        int subarray = 0, currSum = 0;

        for (int n: nums) {
            currSum += n;

            if (currSum > largest) {
                subarray++;
                currSum = n;
            }
        }

        // Check whether the no. of subarrays < k count
        return subarray + 1 <= k;
    }
};