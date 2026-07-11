package _06Tree._1BT;

import java.util.*;

public class _28MinTimeToBurnTree
{

    /*
    Logic:

    Tree ko GRAPH me convert kar denge.

    For every node:
    - connect node <-> left child
    - connect node <-> right child
    (bidirectional edges)

    Example:
    2 = [1, 4, 5]
    1 = [2, 3]

    Phir:
    - Target node se BFS chalao
    - Har BFS level = 1 second
    - Jab tak saare nodes visit na ho jaaye
    */

    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
        }
    }

    // Step 1: build graph (adjacency list)
    static void buildGraph(Node root, Map<Integer, List<Integer>> graph)
    {
        if (root == null)
        {
            return;
        }

        if (!graph.containsKey(root.data))
        {
            graph.put(root.data, new ArrayList<>());
        }

        if (root.left != null)
        {
            graph.get(root.data).add(root.left.data);

            if (!graph.containsKey(root.left.data))
            {
                graph.put(root.left.data, new ArrayList<>());
            }

            graph.get(root.left.data).add(root.data);

            buildGraph(root.left, graph);
        }

        if (root.right != null)
        {
            graph.get(root.data).add(root.right.data);

            if (!graph.containsKey(root.right.data))
            {
                graph.put(root.right.data, new ArrayList<>());
            }

            graph.get(root.right.data).add(root.data);

            buildGraph(root.right, graph);
        }
    }

    // Step 2: BFS to calculate burn time
    static int minTime(Map<Integer, List<Integer>> graph, int target)
    {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int time = 0;

        while (!q.isEmpty())
        {
            int size = q.size();

            for (int i = 0; i < size; i++)
            {
                int curr = q.remove();

                for (int nbr : graph.get(curr))
                {
                    if (!visited.contains(nbr))
                    {
                        visited.add(nbr);
                        q.add(nbr);
                    }
                }
            }
            time++;
        }

        return time-1;
    }

    public static void main(String[] args)
    {
        /*
                     1
                   /   \
                  2     3
                 / \     \
                4   5     6
                   / \
                  7   8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);

        root.right.right = new Node(6);

        int target = 8;

        Map<Integer, List<Integer>> graph = new HashMap<>();

        buildGraph(root, graph);

        System.out.println("Connections:");
        for (int key : graph.keySet())
        {
            System.out.println(key + " = " + graph.get(key));
        }

        System.out.println("Min Time = " + minTime(graph, target));
    }

    /*
    Dry Run:

    Graph connections:
    1 = [2, 3]
    2 = [1, 4, 5]
    3 = [1, 6]
    4 = [2]
    5 = [2, 7, 8]
    6 = [3]
    7 = [5]
    8 = [5]

    Target = 8

    Time 0:
    [8]

    Time 1:
    [5]

    Time 2:
    [2, 7]

    Time 3:
    [1, 4]

    Time 4:
    [3]

    Time 5:
    [6]

    Answer = 5
    */
}
