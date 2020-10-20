#include<bits/stdc++.h>
using namespace std;
 
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int T;
    cin>>T;
    while(T--)
    {
        int N;
        cin>>N;
        vector<int> A(N);
        for(int i=0;i<N;i++)
        {
            cin>>A[i];
        }
        int flag = 0;
        int i1,i2,i3 = N;
        for(int i=0;i<N-1;i++)
        {
            if(A[i]+A[i+1]<=A[N-1])
            {
                flag= 1;
                i1 = i+1;
                i2 = i+2;
                break;
            }
        }
        if(flag)
        {
            cout<<i1<<" "<<i2<<" "<<i3<<endl;
        }
        else
        {
            cout<<-1<<endl;
        }
    }
    return 0;
}
