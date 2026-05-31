package _09Graph._3QUESTIONS;

import java.util.*;

// 802. Find Eventual Safe States
public class _5FindEventualSafeStates
{
    public List<Integer> eventualSafeNodes(int[][] graph)
    {
        int n = graph.length;

        List<List<Integer>> reverse = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            reverse.add(new ArrayList<>());
        }

        for (int u = 0; u < n; u++)
        {
            for (int v : graph[u])
            {
                reverse.get(v).add(u);
            }
        }

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++)
        {
            for (int neighbor : reverse.get(i))
            {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++)
        {
            if (indegree[i] == 0)
            {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty())
        {
            int node = queue.remove();

            result.add(node);

            for (int parent : reverse.get(node))
            {
                indegree[parent]--;

                if (indegree[parent] == 0)
                {
                    queue.add(parent);
                }
            }
        }

        Collections.sort(result);

        return result;
    }

    public static void main(String[] args)
    {
        _5FindEventualSafeStates obj = new _5FindEventualSafeStates();

        int[][] graph =
                {
                        {1, 2},
                        {2, 3},
                        {5},
                        {0},
                        {5},
                        {},
                        {}
                };

        System.out.println(obj.eventualSafeNodes(graph));
    }
}

/*
Dry Run:

graph =
0 → 1,2
1 → 2,3
2 → 5
3 → 0
4 → 5
5 →
6 →

Step 1 : Reverse Graph

Original:
0 → 1,2
1 → 2,3
2 → 5
3 → 0
4 → 5

Reverse:
1 → 0
2 → 0
2 → 1
3 → 1
5 → 2
0 → 3
5 → 4

reverse adjacency list:

0 -> [3]
1 -> [0]
2 -> [0,1]
3 -> [1]
4 -> []
5 -> [2,4]
6 -> []

Step 2 : Calculate Indegree

indegree means original outdegree

0 -> 2
1 -> 2
2 -> 1
3 -> 1
4 -> 1
5 -> 0
6 -> 0

Step 3 : Add indegree 0 nodes into queue

Queue = [5,6]

Step 4 : BFS

Remove 5

result = [5]

parents of 5 = [2,4]

indegree[2] = 1 → 0
push 2

indegree[4] = 1 → 0
push 4

Queue = [6,2,4]

------------------------------------------------

Remove 6

result = [5,6]

No parents

Queue = [2,4]

------------------------------------------------

Remove 2

result = [5,6,2]

parents of 2 = [0,1]

indegree[0] = 2 → 1
indegree[1] = 2 → 1

Queue = [4]

------------------------------------------------

Remove 4

result = [5,6,2,4]

No parents

Queue = []

------------------------------------------------

BFS Ends

Unprocessed nodes:
0,1,3

Because they are part of cycle:

0 → 1 → 3 → 0

Step 5 : Sort Result

[2,4,5,6]

Final Answer:

[2,4,5,6]
*/