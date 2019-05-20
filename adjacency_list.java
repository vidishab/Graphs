import java.util.LinkedList;
import java.util.Scanner;

public class adjacency_list {
        LinkedList<Integer> adjList[];
        int V;
        adjacency_list(int V)
        {
            this.V = V;
            adjList=new LinkedList[V];
            for(int i=0;i<this.V;i++)
            {
                adjList[i]=new LinkedList<Integer>();
            }
        }
        static public void addEdge(adjacency_list graph ,int src,int dest)
        {
            graph.adjList[src].add(dest);
            //graph.adjList[dest].add(src);
        }
        public void print(adjacency_list graph)
        {
            for(int i=0;i<graph.V;i++)
            {
                    System.out.println("List of " + i);
                    System.out.println(graph.adjList[i]);
                    /*for(Integer p: graph.adjList[i])
                    {
                        System.out.println("-->" + p);
                    }
                    System.out.println();*/
            }
        }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int f = sc.nextInt();
        adjacency_list graph = new adjacency_list(f);
        System.out.println("Enter the source and destination of edges");
        for(int i=0;i<f;i++)
        {
            for(int j=0;j<f;j++)
            {
                System.out.println("Is there an index between " + i + " and " + j );
                int res=sc.nextInt();
                if(res==1)
                {
                    addEdge(graph,i,j);
                }
            }
        }
        graph.print(graph);
    }
}
`
