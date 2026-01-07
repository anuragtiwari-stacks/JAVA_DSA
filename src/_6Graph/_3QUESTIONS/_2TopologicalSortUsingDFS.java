package _6Graph._3QUESTIONS;

// Logic:
// 1. Topological sort sirf Directed Acyclic Graph (DAG) me hota hai.
// 2. DFS use karte hain aur node ko list me tab add karte hain
//    jab uske saare neighbors process ho jaate hain.
// 3. DFS ke baad list ko reverse kar dete hain,
//    wahi final topological order hota hai.

import java.util.*;

public class _2TopologicalSortUsingDFS
{
    private void dfs(
            int node,
            ArrayList<ArrayList<Integer>> adj,
            boolean[] visited,
            List<Integer> list
    )
    {
        visited[node] = true;

        for (int neighbor : adj.get(node))
        {
            if (!visited[neighbor])
            {
                dfs(neighbor, adj, visited, list);
            }
        }

        list.add(node);
    }

    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < V; i++)
        {
            if (!visited[i])
            {
                dfs(i, adj, visited, list);
            }
        }

        Collections.reverse(list);

        int[] result = new int[V];
        for (int i = 0; i < V; i++)
        {
            result[i] = list.get(i);
        }

        return result;
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

        _2TopologicalSortUsingDFS obj =
                new _2TopologicalSortUsingDFS();

        int[] topo = obj.topoSort(V, adj);

        for (int x : topo)
        {
            System.out.print(x + " ");
        }
    }
}

/*
Dry Run:

Edges:
5 → 2
5 → 0
4 → 0
4 → 1
2 → 3
3 → 1

DFS order:

Start 0
0 has no neighbors
list = [0]

Start 1
1 has no neighbors
list = [0, 1]

Start 2
 go to 3
  go to 1 (visited)
  add 3
 add 2
list = [0, 1, 3, 2]

Start 4
 neighbors 0,1 (visited)
 add 4
list = [0, 1, 3, 2, 4]

Start 5
 neighbors 2,0 (visited)
 add 5
list = [0, 1, 3, 2, 4, 5]

Reverse list:
[5, 4, 2, 3, 1, 0]

Final Topological Order:
5 4 2 3 1 0
*/
