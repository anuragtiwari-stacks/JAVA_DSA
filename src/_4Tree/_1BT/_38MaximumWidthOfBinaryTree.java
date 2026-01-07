package _4Tree._1BT;

import java.util.*;

/*
LeetCode 662 – Maximum Width of Binary Tree

Problem:
Given the root of a binary tree, return the maximum width of the tree.
Width = (rightmost index - leftmost index + 1) at any level.
*/

public class _38MaximumWidthOfBinaryTree
{

    /*
    Logic:

    - Level Order Traversal (BFS)
    - Har node ke saath ek index store karte hain
      (complete binary tree jaisa)

      root index = 0
      left  = 2*i + 1
      right = 2*i + 2

    - Har level par:
        width = rightIndex - leftIndex + 1
    - Maximum width answer hoga
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
        long index;

        Pair(Node node, long index)
        {
            this.node = node;
            this.index = index;
        }
    }

    static int widthOfBinaryTree(Node root)
    {
        if (root == null)
        {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        long maxWidth = 0;

        while (!q.isEmpty())
        {
            int size = q.size();

            long leftIndex = q.peek().index;
            long rightIndex = q.peek().index;

            for (int i = 0; i < size; i++)
            {
                Pair curr = q.remove();
                Node node = curr.node;
                long idx = curr.index;

                rightIndex = idx;

                if (node.left != null)
                {
                    q.add(new Pair(node.left, 2 * idx + 1));
                }

                if (node.right != null)
                {
                    q.add(new Pair(node.right, 2 * idx + 2));
                }
            }

            maxWidth = Math.max(maxWidth, rightIndex - leftIndex + 1);
        }

        return (int) maxWidth;
    }

    public static void main(String[] args)
    {
        /*
                1
               / \
              3   2
             /
            5
        */

        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);

        System.out.println(widthOfBinaryTree(root));
    }

    /*
    Dry Run (for given tree):

    Tree:
                1
               / \
              3   2
             /
            5

    Indexing (complete binary tree style):

                1(0)
               /    \
           3(1)     2(2)
           /
       5(3)

    Level 0:
    Queue = [(1,0)]
    leftIndex = 0, rightIndex = 0
    width = 0 - 0 + 1 = 1
    maxWidth = 1

    Level 1:
    Queue = [(3,1), (2,2)]
    leftIndex = 1, rightIndex = 2
    width = 2 - 1 + 1 = 2
    maxWidth = 2

    Level 2:
    Queue = [(5,3)]
    leftIndex = 3, rightIndex = 3
    width = 3 - 3 + 1 = 1
    maxWidth = 2

    Final Answer:
    Maximum Width = 2
    */
}
