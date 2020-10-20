#include <iostream>
using namespace std;

int main() {
    int n,i,cd=0,dm=0,nd=0,maxb=0,maxbs=0,bs=0;
    cin>>n;
    char ch;
    for(i=0;i<n;i++)
    {
        cin>>ch;
        if(ch=='1')
        {
            cd++;
            if(cd==1)
            {
                bs=i;
            }
            if(cd>dm)
            {
                dm=cd;
                nd=i+1;
            }
        } 
        else
        {
            cd--;
            if(cd==0)
            {
                if(i-bs+1>maxb)
                {
                    maxb=i-bs+1;
                    maxbs=bs+1;
                }
            }
        }
    }
    cout<<dm<<" "<<nd<<" "<<maxb<<" "<<maxbs<<"\n";
	return 0;
}