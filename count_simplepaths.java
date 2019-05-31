
public class count_simplepaths {
    static class Graph
    {
        int V;
        int adjmatrix[][];
        int visited[];
        static int count;
        Graph(int v)
        {
            this.V=v;
            adjmatrix=new int[this.V][this.V];
            visited=new int[this.V];
            count=0;
            for (int i=1;i<this.V;i++)
            {
                for(int j=1; j<this.V;j++ )
                {
                    adjmatrix[i][j]=0;
                }
            }
            for (int i=1;i<this.V;i++)
            {
                visited[i]=0;
            }
        }
        public void addEdge(Graph graph, int s , int d , int w)
        {
            adjmatrix[s][d]=w;
            adjmatrix[d][s]=w;
        }
        public void dfs(int s,int d) {
            visited[s] = 1;
            if(s==d)
            {
                count++;
                visited[s]=0;
                return;
            }
            for (int i = 1; i < this.V; i++) {
                if (adjmatrix[s][i] != 0 && visited[i] == 0) {
                    visited[i]=0;
                    dfs(i,d);
                }
            }
            System.out.println(count);
        }
        public void print()
        {
            for(int i=1;i<this.V;i++)
            {
                for(int j=1;j<this.V;j++)
                {
                    System.out.print(adjmatrix[i][j]);
                }
                System.out.println();
            }
        }
    }
    public static void main(String args[])
    {
        Graph graph = new Graph(7);
        //graph.addEdge(graph,1,2,1);
        graph.addEdge(graph,1,4,4);
        graph.addEdge(graph,2,3,3);
        graph.addEdge(graph,2,5,3);
        graph.addEdge(graph,3,5,2);
        graph.addEdge(graph,3,6,1);
        graph.addEdge(graph,4,5,1);
        graph.addEdge(graph,5,6,4);
        graph.print();
        graph.dfs(1,2);
    }
}

