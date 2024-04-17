//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();  
            System.out.println(obj.countPairs(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {  
    static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArray = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(arr, mid + 1, right + 1);
        
        int i = 0, j = 0, k = left, count = 0;
        
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
    
    static int mergeSort(int[] arr, int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            
            count += mergeAndCount(arr, left, mid, right);
        }
        
        return count;
    }
    
    static int countPairs(int arr[], int n) {
        for (int i=0;i<n;i++) arr[i] = i * arr[i];
        
        return mergeSort(arr, 0, n-1);
    }
}
