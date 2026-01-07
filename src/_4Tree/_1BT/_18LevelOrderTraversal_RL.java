package _4Tree._1BT;

import java.util.*;

public class _18LevelOrderTraversal_RL
{
    public static class Node
    {
        int data;
        Node left, right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    void levelOrder(Node root)
    {
        if (root == null)
        {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.right != null)
            {
                queue.add(current.right);
            }

            if (current.left != null)
            {
                queue.add(current.left);
            }
        }
    }

    public static void main(String[] args)
    {
        _18LevelOrderTraversal_RL tree =
                new _18LevelOrderTraversal_RL();

        /*
            TREE CREATION:

                    1
                   / \
                  2   3
                 / \
                4   5
        */

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.print("Level Order Traversal (Right to Left): ");
        tree.levelOrder(a);
    }
}

/*
===========================
PROPER DRY RUN
===========================

Tree:

        1
       / \
      2   3
     / \
    4   5

--------------------------------
Initial:
Queue = [1]

--------------------------------
Step 1:
poll 1 → print 1
enqueue right (3), then left (2)
Queue = [3, 2]

--------------------------------
Step 2:
poll 3 → print 3
(no children)
Queue = [2]

--------------------------------
Step 3:
poll 2 → print 2
enqueue right (5), then left (4)
Queue = [5, 4]

--------------------------------
Step 4:
poll 5 → print 5
(no children)
Queue = [4]

--------------------------------
Step 5:
poll 4 → print 4
(no children)
Queue = []

--------------------------------
Traversal ends

Final Output:
Level Order Traversal (Right to Left): 1 3 2 5 4

--------------------------------
CONCEPT:
- Uses Queue (FIFO)
- Right child is enqueued before left
- Still BFS, but traversal order is Right → Left
*/
