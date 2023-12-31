//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


class GfG{
    private void sortInsert(Stack<Integer> s, int element) {
        // Base case
        if (s.isEmpty() || element > s.peek()) s.push(element);
        else {
            int topElement = s.pop();
            sortInsert(s, element);
            s.push(topElement);
        }
    }
    
	public Stack<Integer> sort(Stack<Integer> s){
	    if (!s.isEmpty()) {
	        int topElement = s.pop();
	        sort(s);
	        sortInsert(s,topElement);
	    }
	    return s;
	}
}