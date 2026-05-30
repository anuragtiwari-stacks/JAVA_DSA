package _09Graph._2DFS;

import java.util.*;

public class _1DFS_Stack
{
    public static void main(String[] args)
    {
        int vertices = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++)
        {
            graph.add(new ArrayList<>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);

        dfs(0, graph, vertices);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v)
    {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void dfs(int start, ArrayList<ArrayList<Integer>> graph, int vertices)
    {
        boolean[] visited = new boolean[vertices];

        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        visited[start] = true;

        while (!stack.isEmpty())
        {
            int current = stack.pop();

            System.out.print(current + " ");

            for (int x : graph.get(current))
            {
                if (!visited[x])
                {
                    stack.push(x);

                    visited[x] = true;
                }
            }
        }
    }
}