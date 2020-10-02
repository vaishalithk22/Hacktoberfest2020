import math 
  
def jumpSearch( arr , x , n ): 
    step = math.sqrt(n) 
    prev = 0
    while arr[int(min(step, n)-1)] < x: 
        prev = step 
        step += math.sqrt(n) 
        if prev >= n: 
            return -1
      
    while arr[int(prev)] < x: 
        prev += 1
          

        if prev == min(step, n): 
            return -1
      
    if arr[int(prev)] == x: 
        return prev 
      
    return -1
  
arr=list(map(int, input().split()))
x=int(input())
n = len(arr) 
  
index = jumpSearch(arr, x, n) 

if index!= -1:
    print("Present")
else:
    print("Absent")
