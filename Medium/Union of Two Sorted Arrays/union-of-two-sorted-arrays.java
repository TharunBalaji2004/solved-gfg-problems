//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
              arr1[i] = Integer.parseInt(st[i]);
            
            st = read.readLine().trim().split(" ");  
            for(int i = 0; i< M; i++)
              arr2[i] = Integer.parseInt(st[i]);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(arr1, arr2, N, M);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println(); 
        }
    }
}



// } Driver Code Ends


class Solution{
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m){
        ArrayList<Integer> list = new ArrayList<>();
        
        int ptr1 = 0, ptr2 = 0;
        
        while (ptr1 < n && ptr2 < m) {
            if (arr1[ptr1] <= arr2[ptr2]) {
                if (list.size() == 0 || list.get(list.size()-1) != arr1[ptr1]) 
                    list.add(arr1[ptr1]);
                ptr1++;
            } else {
                if (list.size() == 0 || list.get(list.size()-1) != arr2[ptr2]) 
                    list.add(arr2[ptr2]);
                ptr2++;
            }
        }
        
        while (ptr1 < n) {
            if (list.size() == 0 || list.get(list.size()-1) != arr1[ptr1]) 
                list.add(arr1[ptr1]);
            ptr1++;
        }
        
        while (ptr2 < m) {
            if (list.size() == 0 || list.get(list.size()-1) != arr2[ptr2]) 
                list.add(arr2[ptr2]);
            ptr2++;
        }
        
        return list;
    }
}



