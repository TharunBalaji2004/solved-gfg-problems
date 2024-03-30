#User function Template for python3

class Solution:
    def findTwoElement(self,arr, n): 
        s, s2 = 0,0
        sn = (n * (n+1))//2
        s2n = (n * (n+1) * (2*n + 1))//6
                
        for num in arr:
            s += num
            s2 += num * num
        
        val1 = s - sn
        val2 = s2 - s2n
        
        val2 = val2 // val1
        
        x = (val1 + val2)//2
        y = x - val1
        
        return [x, y]
        
        
#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__': 

    tc=int(input())
    while tc > 0:
        n=int(input())
        arr=list(map(int, input().strip().split()))
        ob = Solution()
        ans=ob.findTwoElement(arr, n)
        print(str(ans[0])+" "+str(ans[1]))
        tc=tc-1
# } Driver Code Ends