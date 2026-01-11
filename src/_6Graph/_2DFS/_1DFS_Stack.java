package _6Graph._2DFS;

import java.util.*;

public class _1DFS_Stack
{
    public static void main(String[] args)
    {
        int vertices = 5;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++)
        {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);

        boolean[] visited = new boolean[vertices];

        System.out.println("DFS traversal using stack from node 0:");
        dfsStack(0, graph, visited);
    }

    public static void addEdge(List<List<Integer>> graph, int u, int v)
    {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void dfsStack(int start, List<List<Integer>> graph, boolean[] visited)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty())
        {
            int node = stack.pop();

            if (!visited[node])
            {
                visited[node] = true;
                System.out.print(node + " ");

                for (int i = graph.get(node).size() - 1; i >= 0; i--)
                {
                    int neighbor = graph.get(node).get(i);
                    if (!visited[neighbor])
                    {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
