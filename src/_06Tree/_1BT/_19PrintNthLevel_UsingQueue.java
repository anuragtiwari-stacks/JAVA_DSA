package _06Tree._1BT;

import java.util.*;

public class _19PrintNthLevel_UsingQueue
{
    public static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    static void printNthLevel(Node root, int n)
    {
        if (root == null)
        {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            // If current level is nth level
            if (level == n)
            {
                for (int i = 0; i < size; i++)
                {
                    Node current = queue.remove();
                    System.out.print(current.data + " ");
                }

                return;
            }

            // Normal BFS
            for (int i = 0; i < size; i++)
            {
                Node current = queue.remove();

                if (current.left != null)
                {
                    queue.add(current.left);
                }

                if (current.right != null)
                {
                    queue.add(current.right);
                }
            }

            level++;
        }
    }

    public static void main(String[] args)
    {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = h;

        d.left = f;
        d.right = g;

        int level = 3;

        System.out.print("Nodes at level " + level + ": ");

        printNthLevel(a, level);
    }
}