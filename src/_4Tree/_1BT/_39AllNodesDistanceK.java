package _4Tree._1BT;

import java.util.*;

public class _39AllNodesDistanceK
{

    /*
    Logic (same as Min Time to Burn Tree):

    1. Binary Tree ko GRAPH me convert kar do
       - node <-> left child
       - node <-> right child
       (bidirectional edges)

    2. Target node se BFS chalao
       - Har BFS level = distance 1
       - Jab distance == k ho jaaye
         → queue me jo nodes hain wahi answer

    3. HashSet visited use karo
       - cycle / repeat se bachne ke liye
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

    // Step 1: Build graph (same as burn tree)
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

    // Step 2: BFS till distance k
    static List<Integer> distanceK(Map<Integer, List<Integer>> graph, int target, int k)
    {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty())
        {
            int size = q.size();

            if (distance == k)
            {
                break;
            }

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

            distance++;
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty())
        {
            result.add(q.remove());
        }

        return result;
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

        int target = 5;
        int k = 2;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, graph);

        System.out.println("Graph:");
        for (int key : graph.keySet())
        {
            System.out.println(key + " = " + graph.get(key));
        }

        System.out.println("Nodes at distance " + k + " = " + distanceK(graph, target, k));
    }

    /*
    Dry Run:

    Graph:
    1 = [2, 3]
    2 = [1, 4, 5]
    3 = [1, 6]
    4 = [2]
    5 = [2, 7, 8]
    6 = [3]
    7 = [5]
    8 = [5]

    Target = 5, k = 2

    Distance 0:
    Queue = [5]

    Distance 1:
    Neighbors of 5 -> [2, 7, 8]
    Queue = [2, 7, 8]

    Distance 2:
    From 2 -> [1, 4]
    From 7 -> []
    From 8 -> []
    Queue = [1, 4]

    distance == k → STOP

    Answer:
    [1, 4]
    */
}
