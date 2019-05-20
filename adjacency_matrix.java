//For undirected and directed graph. For undirected remove the commented line for the matrix.
import java.util.Scanner;

public class adjacency_matrix {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        int v = sc.nextInt();
        int arr[][]=new int[v][v];
        System.out.println("Enter the edges");
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                System.out.println("Is there an edge between " + i + "and"+ j);
                int r = sc.nextInt();
                if( r == 1)
                {
                    arr[i][j] = 1;
                    //arr[j][i]= 1;
                }
            }
        }
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                if(arr[i][j]==1)
                    System.out.println("Edge exists between " + i + "and " + j);
            }
        }
    }
}

