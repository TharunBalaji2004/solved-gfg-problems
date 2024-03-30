#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends
#User function Template for python3

class Solution:
    def minRemoval(self, N, intervals):
        ans = 0
        index = 0
        intervals.sort(key = lambda x: x[1])
        
        for i in range(1, N):
            if (intervals[i][0] < intervals[index][1]):
                ans += 1
            else:
                index = i

        return ans



#{ 
 # Driver Code Starts.
if __name__ == '__main__': 
    t = int(input ())
    for _ in range (t):
        N = int(input())
        intervals = [list(map(int, input().split())) for i in range(N)]
        ob = Solution()
        res = ob.minRemoval(N, intervals)
        print(res)
# } Driver Code Ends