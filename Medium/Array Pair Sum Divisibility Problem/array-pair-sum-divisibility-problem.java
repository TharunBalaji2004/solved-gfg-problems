//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean canPair(int[] nums, int k) {
        
        int n=nums.length;
        if(n%2!=0)return false;
        
        for(int i=0;i<n;i++){
            nums[i]=nums[i]%k;
        }
        
        
        int pairs=0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int count0=0;

        for(int num:nums){
            if(num==0){
                count0++;
                continue;
            }
            if(map.containsKey(k-num)){
                pairs++;
                map.put(k-num,map.get(k-num)-1);
                if(map.get(k-num)==0)
                    map.remove(k-num);
            }
            else{
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        
        return ((pairs+(count0/2))==n/2) ? true:false;
    }
}