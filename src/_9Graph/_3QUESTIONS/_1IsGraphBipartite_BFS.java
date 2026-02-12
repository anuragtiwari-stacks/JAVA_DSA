package _9Graph._3QUESTIONS;

// Logic:
// 1. Graph ko 2 colors (0 and 1) se color karna hai.
// 2. BFS use karte hain, start node ko color 0 dete hain.
// 3. Har neighbor ko opposite color dete hain.
// 4. Agar kisi edge par adjacent nodes ka color same ho jaaye,
//    to graph bipartite nahi hota.
// 5. Graph disconnected ho sakta hai, isliye har unvisited node se BFS start karte hain.

import java.util.*;

public class _1IsGraphBipartite_BFS
{
    public boolean isBipartite(int[][] graph)
    {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++)
        {
            if (color[i] == -1)
            {
                if (!bfs(i, graph, color))
                {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int start, int[][] graph, int[] color)
    {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        color[start] = 0;

        while (!queue.isEmpty())
        {
            int node = queue.remove();

            for (int neighbor : graph[node])
            {
                if (color[neighbor] == -1)
                {
                    color[neighbor] = 1 - color[node];
                    queue.add(neighbor);
                }
                else if (color[neighbor] == color[node])
                {
                    return false;
                }
            }
        }
        return true;
    }

    // ✅ MAIN METHOD (Runnable in IDE)
    public static void main(String[] args)
    {
        _1IsGraphBipartite_BFS obj = new _1IsGraphBipartite_BFS();

        int[][] graph =
                {
                        {1, 3},
                        {0, 2},
                        {1, 3},
                        {0, 2}
                };

        boolean result = obj.isBipartite(graph);
        System.out.println(result);
    }
}

/*
Dry Run:

graph = [[1,3],[0,2],[1,3],[0,2]]

Initial:
color = [-1, -1, -1, -1]

Start BFS from node 0
color[0] = 0
queue = [0]

Process node 0
neighbors = 1, 3
color[1] = 1, queue = [1]
color[3] = 1, queue = [1,3]

Process node 1
neighbors = 0, 2
0 has color 0 (ok)
color[2] = 0, queue = [3,2]

Process node 3
neighbors = 0, 2
both have color 0 (ok)

Process node 2
neighbors = 1, 3
both have color 1 (ok)

No conflict found
Output = true
*/


/*
Dry Run (Conflict Case - Not Bipartite):

graph =
{
    {1, 2},
    {0, 2},
    {0, 1}
}

Initial:
color = [-1, -1, -1]
queue = []

Start BFS from node 0
color[0] = 0
queue = [0]

Process node 0
neighbors = 1, 2

neighbor 1:
 color[1] == -1
 color[1] = 1
 queue = [1]

neighbor 2:
 color[2] == -1
 color[2] = 1
 queue = [1, 2]

color = [0, 1, 1]

Process node 1
neighbors = 0, 2

neighbor 0:
 color[0] = 0
 color[1] = 1
 different → OK

neighbor 2:
 color[2] = 1
 color[1] = 1
 SAME COLOR → CONFLICT

Return false
*/
