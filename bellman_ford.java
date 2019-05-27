import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class bellman_ford {
    static class Graph {
        int V,p;
        LinkedList<Integer> adjList[];
        static int distance[];
        static int cost[][];
        Graph(int v)
        {
            this.V = v;
            adjList = new LinkedList[V];
            distance=new int[this.V];
            Hashtable<Integer,Integer> ht = new Hashtable<Integer, Integer>();
            cost=new int[V][V];
            for (int i = 0; i < adjList.length; i++) {
                adjList[i] = new LinkedList<Integer>();
            }
            cost[0][1]=-1;
            cost[0][2]=4;
            cost[1][2]=3;
            cost[1][3]=2;
            cost[1][4]=2;
            cost[3][1]=1;
            cost[3][2]=5;
            cost[4][3]=-3;

        }

        public void addEdge(Graph graph, int src, int dest)
        {
            adjList[src].add(dest);
        }

        public void print()
        {
            for (int i = 0; i < adjList.length; i++) {
                System.out.println("Adjacent Nodes of " + i);
                System.out.println(adjList[i]);
            }
        }
        public void bellman(int src)
        {
            for(int i=0;i<this.V;i++)
            {
                distance[i]= Integer.MAX_VALUE;
            }
            distance[src]=0;
            for(int i=0;i<V-1;i++)
            {
                for(int j=0;j<adjList.length;j++)
                {
                    Iterator<Integer> it = adjList[j].listIterator();
                    while (it.hasNext())
                    {
                        p = (int)it.next();
                        int dist=distance[j]+cost[j][p];
                        if(distance[p]>= dist)
                        {
                            distance[p]=dist;
                        }

                    }
                }
            }
            print1();

        }
        public void print1()
        {
            for(int i=0;i<V;i++)
            {
                System.out.println("Shortest Distance from " + i + " is " + distance[i]);
            }
        }
    }
        public static void main(String args[])
        {
            Graph graph = new Graph(5);
            graph.addEdge(graph,0,1);
            graph.addEdge(graph,0,2);
            graph.addEdge(graph,1,2);
            graph.addEdge(graph,1,3);
            graph.addEdge(graph,1,4);
            graph.addEdge(graph,3,1);
            graph.addEdge(graph,3,2);
            graph.addEdge(graph,4,3);
            graph.print();
            graph.bellman(0);
        }
}

