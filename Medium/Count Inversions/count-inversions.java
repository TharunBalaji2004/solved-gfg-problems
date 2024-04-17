//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static long mergeAndCount(long[] arr, long left, long mid, long right) {
        long[] leftArray = Arrays.copyOfRange(arr, (int)left, (int)(mid + 1));
        long[] rightArray = Arrays.copyOfRange(arr, (int)(mid + 1), (int)right + 1);
        
        int i = 0, j = 0, k = (int)left;
        long count = 0;
        
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            
                count += (mid - left + 1) - i;
            }
        }
        
        while (i < leftArray.length) {
            arr[k++] = leftArray[i++];
        }
        
        while (j < rightArray.length) {
            arr[k++] = rightArray[j++];
        }
        
        return count;
    }
    
    static long mergeSort(long[] arr, long left, long right) {
        long count = 0;
        if (left < right) {
            long mid = (left + right) / 2;
            
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            
            count += mergeAndCount(arr, left, mid, right);
        }
        
        return count;
    }
    
    static long inversionCount(long arr[], long N){
        return mergeSort(arr, 0, N-1);
    }

}