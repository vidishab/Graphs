import java.util.*;

public class dijikstras_algo {
    static class Graph
    {
        int V,count=0;
        LinkedList<Integer> adjList[];
        Hashtable<Integer,Integer> ht;
        static int distance[];
        boolean visited[];
        int weight[][];
        Graph(int v)
        {
            this.V=v;
            adjList=new LinkedList[this.V];
            for(int i=0;i<adjList.length;i++)
            {
                adjList[i]=new LinkedList<>();
                weight=new int[V][V];
                ht=new Hashtable<Integer, Integer>();
            }
            weight[0][0]=0;
            weight[0][1]=10;
            weight[0][2]=15;
            weight[1][3]=12;
            weight[1][5]=15;
            weight[2][4]=10;
            weight[3][4]=2;
            weight[3][5]=1;
            weight[5][4]=5;
        }
        public void addEdge(Graph graph,int src,int dest)
        {
            adjList[src].add(dest);
        }

        public void print()
        {
            for(int i=0;i<adjList.length;i++)
            {
                System.out.println("The adjacent nodes for node " + i);
                System.out.println(adjList[i]);
            }
        }

        public void dijikstras(int src)
        {
            visited=new boolean[this.V];
            distance=new int[this.V];
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            pq.add(weight[0][0]);
            for(int i=0;i<V;i++)
            {
                distance[i]=-1;
                visited[i]=false;
            }
            distance[src]=0;
            ht.put(0,0);
            while (! pq.isEmpty())
            {
                int v=pq.poll();
                int val = ht.get(v);
                visited[val]=true;
                System.out.println("***Node:*** "+ val);
                Iterator<Integer> it = adjList[val].listIterator();
                while (it.hasNext()) {
                    int p = it.next();
                        //System.out.println("Distance of : " + distance[p]);
                        int dist = distance[val] + weight[val][p];
                        //System.out.println("Distance from " + val + " to " + p + " " + dist);
                        if (distance[p] == -1) {
                            distance[p] = dist;
                            visited[p] = true;
                            ht.put(dist, p);
                            pq.add(dist);
                        }
                        else if (distance[p] > dist)
                        {
                            //System.out.println("Distance: "+ dist);
                            distance[p] = dist;
                            pq.add(dist);
                            ht.put(dist, p);
                            visited[p] = true;
                        }
                    }
            }
            for(int i=0;i<adjList.length;i++)
            {
                //System.out.println(distance[i]);
                System.out.println(distance[i]);
            }

        }

    }
    public static void main(String args[])
    {
        /*Graph graph = new Graph(6);
        graph.addEdge(graph,0,1);
        graph.addEdge(graph,0,2);
        graph.addEdge(graph,1,4);
        graph.addEdge(graph,2,1);
        graph.addEdge(graph,2,3);
        graph.addEdge(graph,3,4);*/

        Graph graph = new Graph(6);
        graph.addEdge(graph,0,1);
        graph.addEdge(graph,0,2);
        graph.addEdge(graph,1,3);
        graph.addEdge(graph,1,5);
        graph.addEdge(graph,2,4);
        graph.addEdge(graph,3,4);
        graph.addEdge(graph,3,5);
        graph.addEdge(graph,5,4);
        System.out.println("Graph - ");
        graph.print();
        graph.print();
        graph.dijikstras(0);

    }
}

