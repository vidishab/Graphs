import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class topological_sort {
    static class Graph
    {
        int V;
        LinkedList<Integer> adjList[];
        Graph(int v)
        {
            this.V=v;
            adjList=new LinkedList[this.V];
            //System.out.println(adjList.length);
            for(int i=0;i<adjList.length;i++)
            {
                adjList[i]=new LinkedList<Integer>();
            }
        }
        public void addEdge(Graph graph, int src, int dest)
        {
            adjList[src].add(dest);
        }
        public void print()
        {
            for(int i=1;i<adjList.length;i++)
            {
                System.out.println("Nodes adjacent on " + i);
                System.out.println(adjList[i]);
            }
        }
        public void toputil(int v,boolean visited[],Stack stack)
        {
            visited[v]=true;
            Iterator<Integer> it = adjList[v].listIterator();
            while (it.hasNext())
            {
                int p = it.next();
                if(visited[p]==false)
                    toputil(p,visited,stack);
            }
            stack.push(v);
        }
        public void toposort(Graph graph)
        {
            Stack<Integer> stack = new Stack<>();
            boolean visited[] = new boolean[this.V];
            //System.out.println(this.V);
            for(int i=0;i<this.V;i++)
            {
                visited[i]=false;
            }
            for (int i=1;i<this.V;i++)
            {
                if(visited[i]==false)
                {
                    toputil(i,visited,stack);
                }
            }
            while (stack.size() > 0)
            {
                System.out.println(stack.pop());
            }

        }

    }

    public static void main(String args[])
    {
        Graph graph = new Graph(8);
        graph.addEdge(graph,1,3);
        graph.addEdge(graph,1,4);
        graph.addEdge(graph,2,4);
        graph.addEdge(graph,2,7);
        graph.addEdge(graph,3,5);
        graph.addEdge(graph,3,6);
        graph.addEdge(graph,3,7);
        graph.addEdge(graph,4,6);
        graph.toposort(graph);
        graph.print();
    }
}

