#User function Template for python3

class Solution:
    def sequence(self, n):
        mod = 10**9 + 7
        total = 0
        
        start = 1
        for i in range(1,n+1):
            curr = 1
            for j in range(i):
                curr = (curr * start) % mod
                start += 1
            total = (total + curr)%mod
            
        return total%mod


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        N = int(input())
        
        ob = Solution()
        print(ob.sequence(N))
# } Driver Code Ends