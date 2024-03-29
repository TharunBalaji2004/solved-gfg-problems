//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class ModifyQueue {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // Taking count of total number of elements
            int n = sc.nextInt();

            // Taking count of total elements
            // that need to be reversed
            int k = sc.nextInt();

            // Creating a Queue
            Queue<Integer> q = new LinkedList<>();

            // adding all the elements to the Queue
            while (n-- > 0) {
                q.add((int)sc.nextInt());
            }

            // Creating an object of class GfG
            GfG g = new GfG();

            // calling modifyQueue of class GfG
            // and passing Queue and k as arguments
            // and storing the reuslt in a new Queue
            Queue<Integer> ans = g.modifyQueue(q, k);

            // Printing all the elements from the
            // new Queue and polling them out
            while (!ans.isEmpty()) {
                int a = ans.peek();
                ans.poll();
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class GfG {
   
    public Queue<Integer> modifyQueue(Queue<Integer> queue, int k) {
        
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            if (k > 0){
                stack.push(queue.remove());
                k--;
            } else {
                list.add(queue.remove());
            }
        }
        
        Queue<Integer> res = new LinkedList<>();
        
        while (!stack.isEmpty()) res.add(stack.pop());
        
        for (int num: list) res.add(num);
        
        return res;
    }
}
