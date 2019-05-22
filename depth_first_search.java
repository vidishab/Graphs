import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class depth_first_search {
    static class Graph
    {
         int V;
         LinkedList<Integer> adjlist[];
         Graph(int v)
         {
             this.V=v;
             adjlist = new LinkedList[V];
             for(int i=0;i<V;i++)
             {
                 adjlist[i] = new LinkedList<>();
             }
         }
         public void addEdge(Graph graph, int src, int dest)
         {
             graph.adjlist[src].add(dest);
         }
         public void print(Graph graph)
         {
             for(int i=0;i<adjlist.length;i++)
             {
                 System.out.println(graph.adjlist[i]);
             }
         }
         public void dfsutil(int val,boolean visited[])
         {
             visited[val]=true;
             System.out.println(val);
             Iterator<Integer> it = adjlist[val].listIterator();
             while (it.hasNext())
             {
                 int n = it.next();
                 //System.out.println(n);
                 if(visited[n]==false)
                 {
                     //visited[n]=true;
                     dfsutil(n,visited);
                 }
             }
         }
         public void dfs(int d)
         {
             boolean visited[]=new boolean[this.V];
             dfsutil(d,visited);
         }
         public void dfs1( )
         {
             boolean visited[]=new boolean[this.V];
             for(int i=0;i<this.V;i++)
             {
                 //System.out.println("DFS for node " + i);
                 if(visited[i]==false)
                     dfsutil(i,visited);
             }
         }
    }
    public static void main(String args[])
    {
        Graph graph = new Graph(4);
        graph.addEdge(graph,0,1);
        graph.addEdge(graph,0,2);
        graph.addEdge(graph,1,2);
        graph.addEdge(graph,2,0);
        graph.addEdge(graph,2,3);
        graph.addEdge(graph,3,3);
        graph.print(graph);
        //System.out.println("Depth First Traversal for one Souce Vertex");
        //graph.dfs(2);
        System.out.println("Depth First Traversal for all Source Vertex");
        graph.dfs1();
    }
}

