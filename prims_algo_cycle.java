import java.util.*;

public class prims_algo_cycle {
    static class Graph
    {
        int V;
        Queue<Integer> queue = new LinkedList<Integer>();
        LinkedList<Integer> adjList[];
        static int weight[][];
        static boolean visit[];
        static int parent=0,res=0;
        HashMap<Integer,Integer> ht= new HashMap<Integer, Integer>();
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
        public void addEdge(Graph graph, int src, int dest,int w)
        {
            adjList[src].add(dest);
            adjList[dest].add(src);
            weight[src][dest]=w;
            //weight[dest][src]=w;
        }
        public void print()
        {
            for(int i=0;i<adjList.length;i++)
            {
                System.out.println("Adjacent Node to " + i);
                System.out.println(adjList[i]);
            }
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
        public void calculate(int arr[],int weight[][])
        {
            int count=0;
            for(int i=0;i<arr.length-1;i++)
            {
                int j=i+1;
                int s = arr[i];
                int d = arr[j];
                //System.out.println("Res:" + weight[8][7]);
                System.out.println(s+ " " + d);
                System.out.println(weight[s][d]);
                count+=weight[s][d];
            }
            System.out.println(count);
        }
        public void primsalgo(int src, int dest)
        {

            int arr[]=new int[this.V];
            int count=0,c=0,parent=0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.add(weight[src][dest]);
            while ( c < this.V )
            {
                int p = pq.poll();
                int val1=ht.get(p);
                visit[val1]=true;
                queue.add(val1);
                System.out.println("Visited vertex: " + val1);
                arr[c]=val1;
                c++;
                Iterator<Integer> it = adjList[val1].listIterator();
                while (it.hasNext())
                {
                    int val = it.next();
                    boolean res = check(arr,val);
                    if(!res)
                    {
                        if (visit[val] == false)
                        {
                            //System.out.println("Visited " + val + " " + res);
                            ht.put(weight[val1][val], val);
                            pq.add(weight[val1][val]);
                        }
                    }
                }
            }
            //calculate(arr,weight);
            //System.out.println(count);
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

