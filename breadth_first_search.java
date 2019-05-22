import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class breadth_first_search {
    static class Graph
    {
        int V;
        LinkedList<Integer> adjList[];
        Graph(int v)
        {
            this.V=v;
            adjList=new LinkedList[V];
            for(int i=0;i<adjList.length;i++)
            {
                adjList[i]=new LinkedList<>();
            }
        }
        public void addEdge(Graph graph, int src , int dest)
        {
            adjList[src].add(dest);
        }
        public void print(Graph graph)
        {
            for(int i=0;i<adjList.length;i++)
            {
                System.out.println("Adjacent nodes to "+ i);
                System.out.println(adjList[i]);
            }
        }
        public void bfs(int v)
        {
            boolean visited[] = new boolean[V];
            LinkedList<Integer> queue= new LinkedList<Integer>();
            visited[v]=true;
            queue.add(v);
            while (queue.size() != 0)
            {
                int n = queue.poll();
                System.out.println(n);
                //queue.remove();
                Iterator<Integer> it = adjList[n].listIterator();
                //queue.remove();
                while (it.hasNext())
                {
                    int p = it.next();
                    if(visited[p]==false)
                    {
                        visited[p]=true;
                        queue.add(p);
                    }
                }
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
        graph.bfs(2);
    }
}

