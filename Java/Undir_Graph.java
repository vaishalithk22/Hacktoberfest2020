import java.util.*;


class Undir_Graph
{
    
    public static void main(String[] args)
    {
        int v=8;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>(v);
        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<>());
        }
        addEdge(0,1,adj);
        addEdge(0,3,adj);
        addEdge(1,4,adj);
        addEdge(1,3,adj);
        addEdge(5,0,adj);
        addEdge(5,2,adj);
        addEdge(2,3,adj);
        addEdge(3,4,adj);
        addEdge(6,7,adj);
        printGraph(adj);
        BFS(adj);
        DFS(adj);
    }
    private static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    private static void printGraph(ArrayList<ArrayList<Integer>> adj)
    {
        for(int i=0;i<adj.size();i++)
        {
            System.out.println("Adjacency List of "+i);
            for(int j=0;j<adj.get(i).size();j++)
            {
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    private static void BFS(ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[]=new boolean[adj.size()];
        System.out.println("BFS : ");
        int count=0;
        for(int i=0;i<adj.size();i++)
        {
            if(visited[i]==false)
            {
                BFSUtil(adj,visited,i);
                count++;
            }
               
        }
        System.out.println();
        System.out.println("Number of connected components : "+count);
    }
    private static void BFSUtil(ArrayList<ArrayList<Integer>> adj, boolean[] visited,int s)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(s);
        visited[s]=true;
        while(!q.isEmpty())
        {
            int v=q.poll();
            System.out.print(v+" ");
            for(int i=0;i<adj.get(v).size();i++)
            {
                if(visited[adj.get(v).get(i)]==false)
                {
                    q.add(adj.get(v).get(i));
                    visited[adj.get(v).get(i)]=true;
                }
                
            }
        }
    }
    private static void DFS(ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[]=new boolean[adj.size()];
        System.out.println("DFS : ");
        for(int i=0;i<adj.size();i++)
        {
            if(visited[i]==false)
            {
                DFSUtil(adj,i,visited);
            }
            
        }
        System.out.println();
    }
    private static void DFSUtil(ArrayList<ArrayList<Integer>> adj,int s,boolean[] visited)
    {
        Stack<Integer> st=new Stack<>();
        st.push(s);
        visited[s]=true;
        while(!st.isEmpty())
        {
            int v=st.pop();
            System.out.print(v+" ");
            for(int i=0;i<adj.get(v).size();i++)
            {
                if(visited[adj.get(v).get(i)]==false)
                {
                    st.push(adj.get(v).get(i));
                    visited[adj.get(v).get(i)]=true;
                }
            }


        }
    }
}