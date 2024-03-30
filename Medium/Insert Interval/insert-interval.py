#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends
#User function Template for python3

class Solution:
    def insertNewEvent(self, N, intervals, newInterval):
        intervals.append(newInterval)
        intervals.sort(key = lambda x: x[0])
        index = 0
        
        # Apply Merge intervals algo
        for i in range(1, len(intervals)):
            if (intervals[index][1] >= intervals[i][0]):
                intervals[index][1] = max(intervals[index][1], intervals[i][1])
            else:
                index += 1 # Update the last merged index
                intervals[index] = intervals[i]
        
        return intervals[:index + 1]
        



#{ 
 # Driver Code Starts.
if __name__ == '__main__': 
    t = int(input ())
    for _ in range (t):
        N = int(input())
        intervals = [list(map(int, input().split())) for i in range(N)]
        newEvent = list(map(int, input().split()))
        ob = Solution()
        res = ob.insertNewEvent(N, intervals, newEvent)
        print('[', end = '')
        for i in range(len(res)):
            print('[', end = '')
            print(str(res[i][0])+','+str(res[i][1]), end = '')
            print(']', end = '')
            if i < len(res)-1:
                print(',', end='')
        print(']')
# } Driver Code Ends