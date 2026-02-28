package _09Graph._3QUESTIONS;

// Logic:
// 1. Topological sort sirf Directed Acyclic Graph (DAG) me possible hota hai.
// 2. Har node ka indegree (incoming edges count) calculate karte hain.
// 3. Jinke indegree 0 hote hain, unhe queue me daalte hain.
// 4. BFS chalate hain:
//    - queue se node nikaalte hain
//    - topo array me add karte hain
//    - uske neighbors ka indegree -- karte hain
//    - agar kisi neighbor ka indegree 0 ho jaaye, queue me daal dete hain.
// 5. Queue se nikla hua order hi topological order hota hai.

import java.util.*;

public class _2TopologicalSortUsingBFS
{
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] indegree = new int[V];

        for (int i = 0; i < V; i++)
        {
            for (int neighbor : adj.get(i))
            {
                indegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++)
        {
            if (indegree[i] == 0)
            {
                queue.add(i);
            }
        }

        int[] topo = new int[V];
        int index = 0;

        while (!queue.isEmpty())
        {
            int node = queue.remove();
            topo[index++] = node;

            for (int neighbor : adj.get(node))
            {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0)
                {
                    queue.add(neighbor);
                }
            }
        }

        return topo;
    }

    public static void main(String[] args)
    {
        int V = 6;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        _2TopologicalSortUsingBFS obj =
                new _2TopologicalSortUsingBFS();

        int[] result = obj.topoSort(V, adj);

        for (int x : result)
        {
            System.out.print(x + " ");
        }
    }
}

/*
Dry Run (Topological Sort using BFS – Kahn’s Algorithm):

Graph edges:
5 → 2
5 → 0
4 → 0
4 → 1
2 → 3
3 → 1

Step 1: Indegree calculation

Initial indegree:
node : indegree
0 : 0
1 : 0
2 : 0
3 : 0
4 : 0
5 : 0

After processing edges:
5 → 2  → indegree[2] = 1
5 → 0  → indegree[0] = 1
4 → 0  → indegree[0] = 2
4 → 1  → indegree[1] = 1
2 → 3  → indegree[3] = 1
3 → 1  → indegree[1] = 2

Final indegree:
node : indegree
0 : 2
1 : 2
2 : 1
3 : 1
4 : 0
5 : 0

Step 2: Push indegree = 0 nodes into queue
Queue = [4, 5]
Topo  = []

Step 3: BFS processing

Process 4
Topo = [4]
Neighbors: 0, 1
indegree[0] = 2 → 1
indegree[1] = 2 → 1
Queue = [5]

Process 5
Topo = [4, 5]
Neighbors: 2, 0
indegree[2] = 1 → 0 → push 2
indegree[0] = 1 → 0 → push 0
Queue = [2, 0]

Process 2
Topo = [4, 5, 2]
Neighbors: 3
indegree[3] = 1 → 0 → push 3
Queue = [0, 3]

Process 0
Topo = [4, 5, 2, 0]
Neighbors: none
Queue = [3]

Process 3
Topo = [4, 5, 2, 0, 3]
Neighbors: 1
indegree[1] = 1 → 0 → push 1
Queue = [1]

Process 1
Topo = [4, 5, 2, 0, 3, 1]
Neighbors: none
Queue = []

Final Topological Order:
[4, 5, 2, 0, 3, 1]
*/
