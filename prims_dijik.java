import java.util.*;

public class prims_dijik {
    static class Graph
    {
        int V;
        int c[];
        LinkedList<Integer> adjList[];
        static int cost[][];
        Hashtable<Integer,Integer> ht1 = new Hashtable<Integer, Integer>();
        Graph(int v)
        {
            this.V=v;
            adjList=new LinkedList[this.V];
            cost=new int[V][V];
            c=new int[this.V];
            ht1.put(0,0);
            for(int i=0;i<this.V;i++)
            {
                adjList[i]=new LinkedList<Integer>();
            }
            for(int i=0;i<this.V;i++)
            {
                c[i]=-1;
            }

        }
        public void addEdge(Graph graph, int src, int dest,int w)
        {
            adjList[src].add(dest);
            //adjList[dest].add(src);
            cost[src][dest]=w;
        }
        public void print()
        {
            for(int i=0;i<adjList.length;i++)
            {
                System.out.println("Adjacent Node to " + i);
                System.out.println(adjList[i]);
            }
        }
        public void primsalgo(int src, int dest)
        {
            int count=0;
            c[src]=0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(cost[src][dest]);
            while ( pq.size() > 0 )
            {
                int p = pq.poll();
                int val1=ht1.get(p);
                System.out.println(val1);
                Iterator<Integer> it = adjList[val1].listIterator();
                while (it.hasNext())
                {
                    int val = it.next();
                    int res=c[val1]+cost[val1][val];
                    if (c[val]==-1)
                    {
                        c[val]=cost[val1][val];
                        pq.add(cost[val1][val]);
                        ht1.put(cost[val1][val],val);
                    }
                    else if(c[val] > res)
                    {
                        c[val]=cost[val1][val];
                        pq.add(cost[val1][val]);
                        ht1.put(cost[val1][val],val);
                    }
                }
            }
        }

    }
    public static void main(String args[])
    {
        Graph graph = new Graph(9);
        graph.addEdge(graph,0,1,4);
        graph.addEdge(graph,0,7,8);
        graph.addEdge(graph,1,7,11);
        graph.addEdge(graph,1,2,8);
        graph.addEdge(graph,2,8,2);
        graph.addEdge(graph,2,5,4);
        graph.addEdge(graph,2,3,7);
        graph.addEdge(graph,3,5,14);
        graph.addEdge(graph,3,4,9);
        graph.addEdge(graph,4,5,10);
        graph.addEdge(graph,5,6,2);
        graph.addEdge(graph,6,7,1);
        graph.addEdge(graph,6,8,6);
        graph.addEdge(graph,7,8,7);
        /*Graph graph = new Graph(7);
        graph.addEdge(graph,0,1,7);
        graph.addEdge(graph,0,3,5);
        graph.addEdge(graph,1,3,9);
        graph.addEdge(graph,1,4,7);
        graph.addEdge(graph,1,2,8);
        graph.addEdge(graph,2,4,5);
        graph.addEdge(graph,3,4,15);
        graph.addEdge(graph,3,5,6);
        graph.addEdge(graph,4,5,8);
        graph.addEdge(graph,4,6,9);
        graph.addEdge(graph,5,6,11);*/
        //graph.print();
        graph.primsalgo(0,0);
    }
}



