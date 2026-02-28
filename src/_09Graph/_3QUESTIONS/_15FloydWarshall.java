package _09Graph._3QUESTIONS;

// Logic:
// 1. Floyd–Warshall ALL PAIRS shortest path nikalta hai.
// 2. Undirected graph me edge dono taraf hota hai.
// 3. Har node ko intermediate (via) maan kar
//    dist[i][j] = min(dist[i][j], dist[i][via] + dist[via][j]).
// 4. Yahan simplicity ke liye:
//    - Negative cycle check nahi kiya
//    - INF condition check nahi kiya

public class _15FloydWarshall
{
    static final int INF = 1000000000;

    public void floydWarshall(int V, int[][] graph)
    {
        int[][] dist = new int[V][V];

        // Copy graph into dist
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                dist[i][j] = graph[i][j];
            }
        }

        // Floyd–Warshall core logic
        for (int via = 0; via < V; via++)
        {
            for (int i = 0; i < V; i++)
            {
                for (int j = 0; j < V; j++)
                {
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }

        // Print result
        System.out.println("All Pairs Shortest Path:");
        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < V; j++)
            {
                if (dist[i][j] >= INF)
                {
                    System.out.print("INF ");
                }
                else
                {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int V = 4;

        int[][] graph =
                {
                        {0,   3,   INF, 7},
                        {3,   0,   2,   INF},
                        {INF, 2,   0,   1},
                        {7,   INF, 1,   0}
                };

        _15FloydWarshall obj =
                new _15FloydWarshall();

        obj.floydWarshall(V, graph);
    }
}


/*
Dry Run:

Graph (Undirected):
V = 4

Initial dist matrix:

      0   1   2   3
    ----------------
0 |   0   3   INF 7
1 |   3   0   2   INF
2 |   INF 2   0   1
3 |   7   INF 1   0

--------------------------------
via = 0

Check paths i -> 0 -> j

1 -> 3 : 1->0 (3) + 0->3 (7) = 10 < INF → update
2 -> 1 : 2->0 (INF) + 0->1 (3) = INF (no change)
3 -> 1 : 3->0 (7) + 0->1 (3) = 10 < INF → update

Matrix after via = 0:

0  3  INF 7
3  0  2   10
INF 2  0   1
7  10 1   0

--------------------------------
via = 1

Check paths i -> 1 -> j

0 -> 2 : 0->1 (3) + 1->2 (2) = 5 < INF → update
3 -> 2 : 3->1 (10) + 1->2 (2) = 12 > 1 (no change)

Matrix after via = 1:

0  3  5  7
3  0  2  10
5  2  0  1
7  10 1  0

--------------------------------
via = 2

Check paths i -> 2 -> j

0 -> 3 : 0->2 (5) + 2->3 (1) = 6 < 7 → update
1 -> 3 : 1->2 (2) + 2->3 (1) = 3 < 10 → update
3 -> 1 : 3->2 (1) + 2->1 (2) = 3 < 10 → update

Matrix after via = 2:

0  3  5  6
3  0  2  3
5  2  0  1
6  3  1  0

--------------------------------
via = 3

Check paths i -> 3 -> j

0 -> 2 : 0->3 (6) + 3->2 (1) = 7 > 5 (no change)
1 -> 0 : 1->3 (3) + 3->0 (6) = 9 > 3 (no change)

Matrix after via = 3:

0  3  5  6
3  0  2  3
5  2  0  1
6  3  1  0

--------------------------------
Final Answer:
All Pairs Shortest Path matrix:

0  3  5  6
3  0  2  3
5  2  0  1
6  3  1  0
*/
