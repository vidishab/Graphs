

import java.util.*;

public class prims_algo {
    static class Graph
    {
        int V;
        LinkedList<Integer> adjList[];
        int weight[][];
        static boolean visit[];
        static int parent=0,res=0;
        //ArrayList<Integer> arr = new ArrayList<Integer>();
        Hashtable<Integer,Integer> ht= new Hashtable<Integer, Integer>();
        Graph(int v)
        {
            this.V=v;
            visit=new boolean[this.V];
            adjList=new LinkedList[this.V];
            weight=new int[V][V];
            ht.put(0,0);
            for(int i=0;i<this.V;i++)
            {
                adjList[i]=new LinkedList<Integer>();
            }
            visit=new boolean[this.V];
            for(int i=0;i<this.V;i++)
            {
                visit[i]=false;
            }
        }
        public void print()
        {
            for(int i=0;i<adjList.length;i++)
            {
                System.out.println("Adjacent Nodes to " + i);
                System.out.println(adjList[i]);
            }
        }
        public void addEdge(Graph graph, int src, int dest,int w)
        {
            adjList[src].add(dest);
            weight[src][dest]=w;
        }
        public boolean check(int arr[],int res)
        {
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]==res)
                    return true;
            }
            return false;
        }
        public void calculate(int v)
        {

            System.out.println(weight[parent][v]);
            res+=weight[parent][v];
            System.out.println(parent + " " + v + " " + res);
            parent=v;
        }
        public void prim(int src,int dest)
        {
            int arr[]=new int[this.V];
            int count=0,c=0,parent=0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(weight[src][dest]);
            while ( pq.size() > 0 )
            {
                int p = pq.poll();
                int val1=ht.get(p);
                visit[val1]=true;
                System.out.println("Visited vertex: " + val1);
                //calculate(val1);
                arr[c]=val1;
                c++;
                Iterator<Integer> it = adjList[val1].listIterator();
                while (it.hasNext())
                {
                    int val = it.next();
                    if (visit[val] == false)
                    {
                        ht.put(weight[val1][val], val);
                        pq.add(weight[val1][val]);
                        count+=weight[val1][val];

                    }
                }
            }
            System.out.println(count);
        }

    }
    public static void main(String args[])
    {
        /*Graph graph = new Graph(9);
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
        graph.addEdge(graph,7,8,7);*/
        Graph graph = new Graph(9);
        graph.addEdge(graph,0,1,4);
        graph.addEdge(graph,1,2,8);
        graph.addEdge(graph,2,3,7);
        graph.addEdge(graph,3,4,9);
        graph.addEdge(graph,4,5,10);
        graph.addEdge(graph,5,6,2);
        graph.addEdge(graph,6,7,1);
        graph.addEdge(graph,7,0,8);
        //graph.print();
        graph.prim(0,0);

    }
}

