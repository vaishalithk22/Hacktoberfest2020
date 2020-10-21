def binarySearch(arr,n):
  start=0;
  end=len(arr)-1

  while start<=end:
    mid=(start+end)//2
    if arr[mid]==n:
      return mid
    elif arr[mid]<n:
      start=mid+1
    else:
      end=mid-1
  return -1      


print("Enter The Elements of The List")
arr=[int(x) for x in input().split()]
n=int(input("Enter the element which need to find in the list "))
index=binarySearch(arr,n)
if index>-1:
  print("Hence the entered element ",n," is present in the list. ")
  print("Index of the given element ",n," is ",index)
else:
  print("There is no such element present in a list")
