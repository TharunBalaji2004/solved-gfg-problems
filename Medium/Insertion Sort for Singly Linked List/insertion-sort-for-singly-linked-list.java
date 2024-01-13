//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			insertion llist = new insertion(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.insertionSort(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }}
// } Driver Code Ends


class Solution{
    static Node sortedHead;
    
    public static Node insertionSort(Node head){
        sortedHead = null;
        Node curr = head;

        while (curr != null) {
            Node nextNode = curr.next;
            sort(curr);
            curr = nextNode;
        }

        return sortedHead;
    }
    
    private static void sort(Node newNode) {
        // Check whether head is null or newnode < head
        if (sortedHead == null || newNode.data < sortedHead.data) {
            newNode.next = sortedHead;
            sortedHead = newNode;
        } else { // newnode > head then add when newnode < curr.next
            Node curr = sortedHead;
            
            while (curr.next != null && newNode.data > curr.next.data) {
                curr = curr.next;
            }
            
            Node nextNode = curr.next;
            curr.next = newNode;
            newNode.next = nextNode;
        }
    }
}