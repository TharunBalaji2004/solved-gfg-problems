#User function Template for python3

class Solution:
    def numTrees(self,n):
        numTree = [0] * (n+1)
        mod = 10**9+7
        
        # Base case
        numTree[0] = 1
        numTree[1] = 1
        
        for nodes in range(2, n+1):
            total = 0
            for root in range(1, n+1):
                left = root-1
                right = nodes-root
                total += numTree[left] * numTree[right] % mod
            numTree[nodes] = total
    

        return numTree[n] % mod;
#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__=="__main__":
    t=int(input())
    for _ in range(0,t):
        n = int(input());
        ob=Solution()
        print(ob.numTrees(n))
# } Driver Code Ends