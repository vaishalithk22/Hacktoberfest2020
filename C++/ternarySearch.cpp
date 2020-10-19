#include <bits/stdc++.h>
using namespace std;

int ternary_search(int l,int r, int x, int ar[])
{
    if(r>=l)
    {
        int mid1 = l + (r-l)/3;
        int mid2 = r -  (r-l)/3;
        if(ar[mid1] == x)
            return mid1;
        if(ar[mid2] == x)
            return mid2;
        if(x<ar[mid1])
            return ternary_search(l,mid1-1,x);
        else if(x>ar[mid2])
            return ternary_search(mid2+1,r,x);
        else
            return ternary_search(mid1+1,mid2-1,x);

    }
    return -1;
}

int main()
{
  int N;        //No. of elements in array
  cin>>N;
  const int M=N;
  int ar[M];
  for(int i=0;i<N;i++){     //inserting array elements
    cin>>ar[i];
  }
  int ele;              //element to be searched
  cin>>ele;
  cout<<"Element found at "<<ternary_search(0, n-1, ele, ar);
}
