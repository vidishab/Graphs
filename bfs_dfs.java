import javax.swing.text.View;
import java.util.Iterator;
import java.util.LinkedList;

public class bfs_dfs {
    static class Graph
    {
        int V;
        LinkedList<Integer> adjlist[];
        Graph(int v)
        {
            this.V=v;
            adjlist=new LinkedList[V];
            for (int i=0;i<adjlist.length;i++)
            {
                adjlist[i]=new LinkedList<>();
            }
        }
        public void addEdge(Graph graph,int src,int dest)
        {
            adjlist[src].add(dest);
        }
        public void print(Graph graph)
        {
            for(int i=0;i<adjlist.length;i++)
            {
                System.out.println("Adjacent Nodes for " + i);
                System.out.println(adjlist[i]);
            }
        }
        public void bfsutil(int val,boolean visited[])
        {
            LinkedList<Integer> queue = new LinkedList<Integer>();
            visited[val]=true;
            queue.add(val);
            while (queue.size() != 0)
            {
                int n = queue.poll();
                System.out.println(n);
                Iterator<Integer> it = adjlist[n].listIterator();
                while (it.hasNext())
                {
                    int res=it.next();
                    if(visited[res] == false)
                    {
                        visited[res]=true;
                        queue.add(res);
                    }
                }
            }

        }
        public void bfs()
        {
            boolean visited[] = new boolean[V];
            for(int i=0;i<adjlist.length;i++)
            {
                //System.out.println("BFS for node " + i);
                if(visited[i]==false)
                    bfsutil(i,visited);
            }

        }
        public void dfsutil(int val,boolean visited[])
        {
            visited[val]=true;
            System.out.println(val);
            Iterator<Integer> it = adjlist[val].listIterator();
            while (it.hasNext())
            {
                int res=it.next();
                if(visited[res]==false)
                {
                    dfsutil(res,visited);
                }
            }
        }
        public void dfs()
        {
            boolean visited[] = new boolean[V];
            for(int i=0;i<adjlist.length;i++)
            {
                if(visited[i]==false)
                    dfsutil(i,visited);
            }

        }
    }
    public static void main(String args[])
    {
        Graph graph = new Graph(5);
        graph.addEdge(graph,0,1);
        graph.addEdge(graph,0,4);
        graph.addEdge(graph,1,0);
        graph.addEdge(graph,1,2);
        graph.addEdge(graph,1,3);
        graph.addEdge(graph,1,4);
        graph.addEdge(graph,2,1);
        graph.addEdge(graph,2,3);
        graph.addEdge(graph,3,1);
        graph.addEdge(graph,3,2);
        graph.addEdge(graph,3,4);
        graph.addEdge(graph,4,0);
        graph.addEdge(graph,4,1);
        graph.addEdge(graph,4,3);

        graph.print(graph);
        System.out.println("Breadth First Search");
        graph.bfs();
        System.out.println("Depth First Search");
        graph.dfs();
    }
}

