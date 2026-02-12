package _9Graph._3QUESTIONS;

// Logic:
// 1. Undirected graph → Floyd–Warshall lagao (all pairs shortest path).
// 2. dist[i][j] = min(dist[i][j], dist[i][via] + dist[via][j]).
// 3. Har city ke liye count karo:
//    dist <= distanceThreshold.
// 4. Minimum count wali city answer.
// 5. Tie me larger index return karo.

public class _16FindTheCity
{
    static final int INF = 1000000000;

    public int findTheCity(int n, int[][] edges, int distanceThreshold)
    {
        int[][] dist = new int[n][n];

        // initialize
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (i == j)
                {
                    dist[i][j] = 0;
                }
                else
                {
                    dist[i][j] = INF;
                }
            }
        }

        // undirected edges
        for (int[] e : edges)
        {
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }

        // Floyd–Warshall
        for (int via = 0; via < n; via++)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    dist[i][j] =
                            Math.min(dist[i][j],
                                    dist[i][via] + dist[via][j]);
                }
            }
        }

        int city = -1;
        int minCount = n;

        // count reachable cities
        for (int i = 0; i < n; i++)
        {
            int count = 0;

            for (int j = 0; j < n; j++)
            {
                if (i != j && dist[i][j] <= distanceThreshold)
                {
                    count++;
                }
            }

            if (count <= minCount)
            {
                minCount = count;
                city = i;
            }
        }

        return city;
    }

    public static void main(String[] args)
    {
        _16FindTheCity obj = new _16FindTheCity();

        int n = 4;
        int[][] edges =
                {
                        {0, 1, 3},
                        {1, 2, 1},
                        {1, 3, 4},
                        {2, 3, 1}
                };

        int distanceThreshold = 4;

        System.out.println(obj.findTheCity(n, edges, distanceThreshold));
    }
}
/*
Input:
n = 4
distanceThreshold = 4

Edges (undirected):
0-1 (3)
1-2 (1)
1-3 (4)
2-3 (1)

--------------------------------
Initial dist matrix:

0  3  INF INF
3  0  1   4
INF 1  0   1
INF 4  1   0

--------------------------------
via = 0

No useful update

Matrix:
0  3  INF INF
3  0  1   4
INF 1  0   1
INF 4  1   0

--------------------------------
via = 1

0->2 : 0->1 (3) + 1->2 (1) = 4 < INF → update
0->3 : 0->1 (3) + 1->3 (4) = 7 < INF → update

Matrix:
0  3  4  7
3  0  1  4
4  1  0  1
7  4  1  0

--------------------------------
via = 2

0->3 : 0->2 (4) + 2->3 (1) = 5 < 7 → update
1->3 : 1->2 (1) + 2->3 (1) = 2 < 4 → update

Matrix:
0  3  4  5
3  0  1  2
4  1  0  1
5  2  1  0

--------------------------------
via = 3

No better update

Final dist matrix:
0  3  4  5
3  0  1  2
4  1  0  1
5  2  1  0

--------------------------------
Count cities within threshold (≤ 4):

City 0: {1,2} → count = 2
City 1: {0,2,3} → count = 3
City 2: {0,1,3} → count = 3
City 3: {1,2} → count = 2

Minimum count = 2
Tie between city 0 and 3
Choose larger index → 3

--------------------------------
Answer = 3
*/
