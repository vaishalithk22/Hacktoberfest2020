import java.io.*;
import java.util.Scanner;
class Link
{
	public int data;
	public Link lchild;
	public Link rchild;
	Link(int d)
	{
	data=d;
	lchild=null;
	rchild=null;
	}
	public void display()
	{
	System.out.println(data);
	}
}
class TreeS
{
	public Link root;
	TreeS()
	{
	 root=null;

	}

	public void insert(int d)
	{
	Link node=new Link(d);
	if(root==null)
	{
	root=node;
	}
	else{
	Link current=root;
	Link prev=root;
	while(current!=null)
	{
	if(current.data>d)
	{
	 prev=current;
	 current=current.lchild;
	}
	else{
	prev=current;
	current=current.rchild;
	}
	}
   if(prev.data>d)
   {
    prev.lchild=node;
   }
   else{
   prev.rchild=node;
   }
	}

	}
	
	public int height(Link r)
	{
		
        if(r==null)
        	return 0;
        int ldepth=height(r.lchild);
        int rdepth=height(r.rchild);

        if(ldepth>rdepth)
        	return ldepth+1;
        else
        	return rdepth+1;
	}
	public void preorder(Link r)
	{
		if(r==null)
			return;

		r.display();
		preorder(r.lchild);
		preorder(r.rchild);
	}
}
class BST
{
	public static void main(String[] args)
	{
	TreeS T=new TreeS();
	Scanner myObj=new Scanner(System.in);
		int n,deep;
	n=myObj.nextInt();
	int arr[];
	arr=new int[n];
	    for(int i=0;i<n;i++)
    {
    arr[i]=myObj.nextInt();
    }
    for(int i=0;i<n;i++)
    {
     T.insert(arr[i]);
    }
    deep=T.height(T.root);
	
	T.preorder(T.root);
	System.out.println(deep);
}
}