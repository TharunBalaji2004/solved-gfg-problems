//{ Driver Code Starts
// Initial Template for Java
import java.util.*;

class Tree {
    int data;
    Tree left;
    Tree right;

    Tree(int d) {
        data = d;
        left = null;
        right = null;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}


// } Driver Code Ends
// User function Template for Java
class Solution {
    public Tree convert(Node head, Tree node) {
        List<Tree> list = new ArrayList<>();

        while (head != null) {
            list.add(new Tree(head.data));
            head = head.next;
        }
        
        int n = list.size();
        if (n == 0) return null;
        
        for (int i=0;i<n;i++) {
            int left = 2*i + 1;
            int right = 2*i + 2;
            
            if (left < n) {
                list.get(i).left = list.get(left);
            } 
            if (right < n) {
                list.get(i).right = list.get(right);
            }
        }
        
        return list.get(0);
    }
}


//{ Driver Code Starts.
class GFG {
    static Node lhead;
    static Queue<Tree> queue = new LinkedList<Tree>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Tree node = null;
            lhead = null;
            Node head = null;
            while (!queue.isEmpty()) {
                queue.poll();
            }
            int n = sc.nextInt();
            if (n != 0) {
                GFG llist = new GFG();
                int a1 = sc.nextInt();
                head = new Node(a1);
                llist.addToTheLast(head);
                lhead = head;
                for (int i = 1; i < n; i++) {
                    int a = sc.nextInt();
                    llist.addToTheLast(new Node(a));
                }
            }
            Solution g = new Solution();
            Tree root = g.convert(lhead, node);
            try {
                levelOrder(root, n);
            } catch (NullPointerException ex) {
                System.out.println(-1);
            }
            System.out.println();
        }
    }

    public static void levelOrder(Tree root, int n) {
        queue.add(root);
        while (!queue.isEmpty() && n-- > 0) {
            Tree proot = queue.remove();
            try {
                queue.add(proot.left);
                queue.add(proot.right);
                System.out.print(proot.data + " ");
            } catch (NullPointerException ex) {
            }
        }
    }

    public void addToTheLast(Node head) {
        if (lhead == null)
            lhead = head;
        else {
            Node temp = lhead;
            while (temp.next != null) temp = temp.next;
            temp.next = head;
        }
    }
}
// } Driver Code Ends