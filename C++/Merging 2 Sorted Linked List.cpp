//C++ program Merge 2-sorted Linked-List

#include <iostream>
using namespace std;
struct node
{
    int info;
    node *next;
}*head1=NULL,*head2=NULL,*rear1,*rear2;

/* Merging  2 sorted Linked List */
node *merge(node *a,node *b)
{
    node *result =NULL;
    if(a==NULL)
        return b;
    if (b==NULL)
        return a;
    if(a->info <= b->info)
    {
        result=a;
        result->next=merge(a->next,b);
    }
    else
    {
        result=b;
        result->next=merge(a,b->next);
    }
    return result;
}
void insert_list1(int data) // Insertion in List 1
{
    node *temp1 = new node;
    if(head1==NULL || rear1==NULL)
    {
        temp1->info=data;
        temp1->next=head1;
        head1=temp1;
        rear1=temp1;
    }
    else
    {
        temp1->info=data;
        rear1->next=temp1;
        temp1->next=NULL;
        rear1 =temp1;
    }
}
void insert_list2(int data) // Insertion in List 2
{
    node *temp2 = new node;
    if(head2==NULL || rear2==NULL)
    {
        temp2->info=data;
        temp2->next=head2;
        head2=temp2;
        rear2=temp2;
    }
    else
    {
        temp2->info=data;
        rear2->next=temp2;
        temp2->next=NULL;
        rear2=temp2;
    }

}
void display(node *temp)
{
    while(temp!=NULL)
    {
        cout<<temp->info<<"->" ;
        temp=temp->next;
    }
}
int main()
{
    int n1,n2;
    int data ;
    cout<<"Enter no. of elements in list-1 : ";
    cin>>n1;
    cout<<"Enter no. of elements in list-2 : ";
    cin>>n2;
    cout<<"\n---Insertion in list 1 ---\n ";
    for(int i=0; i<n1; i++)
    {
        cin>>data;
        insert_list1(data);
    }
    cout<<"\n---Insertion  in list 2---\n ";
    for(int i=0; i<n2; i++)
    {
        cin>>data;
        insert_list2(data);
    }
    cout<<"\n List1: ";
    display(head1);
    cout<<" \n List2: ";
    display(head2);
    node *ptr=merge(head1,head2);
    cout<<"\n ---Merged sorted list is---\n ";
    display(ptr);
    return 0;
}
