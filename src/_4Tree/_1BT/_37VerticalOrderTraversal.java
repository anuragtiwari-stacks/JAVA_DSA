package _4Tree._1BT;

import java.util.*;

public class _37VerticalOrderTraversal
{

    /*
    Logic:

    Vertical order traversal means:
    Print nodes column by column from left to right.

    Steps:
    - Use TreeMap to store list of nodes for each horizontal distance (HD)
    - Use Queue for level order traversal
    - Root has HD = 0
    - Left child HD = parent HD - 1
    - Right child HD = parent HD + 1
    - For each node, add its value to map at its HD
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

    static class Pair
    {
        Node node;
        int hd;

        Pair(Node node, int hd)
        {
            this.node = node;
            this.hd = hd;
        }
    }

    void verticalOrder(Node root)
    {
        if (root == null)
        {
            return;
        }

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty())
        {
            Pair current = queue.remove();
            int hd = current.hd;
            Node node = current.node;

            if (!map.containsKey(hd))
            {
                map.put(hd, new ArrayList<>());
            }

            map.get(hd).add(node.data);

            if (node.left != null)
            {
                queue.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null)
            {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        for (List<Integer> list : map.values())
        {
            for (int val : list)
            {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        _37VerticalOrderTraversal tree = new _37VerticalOrderTraversal();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(5);

        tree.verticalOrder(root);
    }

    /*
    Dry Run:

    Tree:
                  1 (HD=0)
                /           \
           2 (HD=-1)      3 (HD=+1)
                 \             \
               4 (HD=0)      5 (HD=+2)

    Initial:
    Queue = [(1,0)]
    Map = {}

    Step 1:
    Remove (1,0)
    Map: 0 -> [1]
    Add (2,-1), (3,+1)

    Step 2:
    Remove (2,-1)
    Map: -1 -> [2]
    Add (4,0)

    Step 3:
    Remove (3,+1)
    Map: +1 -> [3]
    Add (5,+2)

    Step 4:
    Remove (4,0)
    Map: 0 -> [1,4]

    Step 5:
    Remove (5,+2)
    Map: +2 -> [5]

    Final Map:
    HD  -1   0     +1   +2
         2   1 4    3    5

    Output:
    2
    1 4
    3
    5
    */
}
