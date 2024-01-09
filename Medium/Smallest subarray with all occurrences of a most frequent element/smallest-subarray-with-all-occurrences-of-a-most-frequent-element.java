//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    
    ArrayList<Integer> smallestSubsegment(int arr[], int n){
        ArrayList<Integer> list = new ArrayList<>();
        
        // Stores frequency of element
        Map<Integer, Integer> freqTable = new HashMap<>();
        // Stores the starting index
        Map<Integer, Integer> startTable = new HashMap<>();
        
        int highestFreq = 0;
        int start=0, end = 0;
        int maxLength = end - start + 1;
        
        for (int i=0;i<n;i++) {
            int curr = arr[i];
            
            if (freqTable.containsKey(curr)) {
                freqTable.put(curr, freqTable.get(curr) + 1);
            } else {
                freqTable.put(curr, 1);
                startTable.put(curr, i);
            }
            
            if (freqTable.get(curr) > highestFreq) {
                highestFreq = freqTable.get(curr);
                start = startTable.get(curr);
                end = i;
                maxLength = end - start + 1;
            } else if (freqTable.get(curr) == highestFreq) {
                // Now compare with sub array length
                int currSubarrayLength = i - startTable.get(curr) + 1;
                
                if (currSubarrayLength < maxLength) {
                    highestFreq = freqTable.get(curr);
                    start = startTable.get(curr);
                    end = i;
                    
                    maxLength = end - start + 1;
                }
            }
        }
        
        for (int i=start;i<=end;i++) {
            list.add(arr[i]);
        }
         
        return list;
    }
 
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		    res = obj.smallestSubsegment(arr, sizeOfArray);
		    for(int i:res)
		        System.out.print(i + " ");
		    System.out.println();
		}
	}
}


            


// } Driver Code Ends