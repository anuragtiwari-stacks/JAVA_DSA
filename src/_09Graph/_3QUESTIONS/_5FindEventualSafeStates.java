package _09Graph._3QUESTIONS;

// Logic:
// 1. Eventual Safe State = a node jisse koi bhi path cycle me nahi jaata.
// 2. Directed graph ko REVERSE kar dete hain.
//    Original edge: u → v
//    Reverse edge : v → u
// 3. Original graph me jinke outgoing edges = 0 (terminal nodes),
//    unka indegree (in reverse graph) = 0 hota hai.
// 4. BFS (Topo logic):
//    - indegree 0 nodes ko queue me daalo (safe nodes)
//    - queue se node nikaalo
//    - reverse graph ke neighbors ki indegree -- karo
//    - agar indegree 0 ho jaaye, queue me daalo
// 5. BFS ke baad jo nodes process ho jaate hain wahi eventual safe states hote hain.
// 6. Output ko sorted order me return karte hain.

import java.util.*;

public class _5FindEventualSafeStates
{
    public List<Integer> eventualSafeNodes(int[][] graph)
    {
        int n = graph.length;

        ArrayList<ArrayList<Integer>> reverse = new ArrayList<>();
        for (int i = 0; i < n; i++)
        {
            reverse.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int u = 0; u < n; u++)
        {
            for (int v : graph[u])
            {
                reverse.get(v).add(u);
                indegree[u]++;
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

        boolean[] safe = new boolean[n];

        while (!queue.isEmpty())
        {
            int node = queue.remove();
            safe[node] = true;

            for (int parent : reverse.get(node))
            {
                indegree[parent]--;

                if (indegree[parent] == 0)
                {
                    queue.add(parent);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            if (safe[i])
            {
                result.add(i);
            }
        }

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

Step 1: Reverse graph + indegree (original outdegree)

reverse graph:
1 → 0
2 → 0
2 → 1
3 → 1
5 → 2
0 → 3
5 → 4

indegree (original outdegree):
node : indegree
0 : 2
1 : 2
2 : 1
3 : 1
4 : 1
5 : 0
6 : 0

Step 2: Push indegree = 0 nodes into queue
Queue = [5, 6]

Step 3: BFS processing

Process 5
safe[5] = true
parents: 2,4
indegree[2] = 1 → 0 → push 2
indegree[4] = 1 → 0 → push 4
Queue = [6, 2, 4]

Process 6
safe[6] = true
parents: none
Queue = [2, 4]

Process 2
safe[2] = true
parents: 0,1
indegree[0] = 2 → 1
indegree[1] = 2 → 1
Queue = [4]

Process 4
safe[4] = true
parents: none
Queue = []

Queue empty

Safe nodes marked:
2, 4, 5, 6

Final Answer (sorted):
[2, 4, 5, 6]
*/
