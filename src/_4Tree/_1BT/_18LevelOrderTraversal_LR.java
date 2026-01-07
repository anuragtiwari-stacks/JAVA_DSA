package _4Tree._1BT;

import java.util.*;

public class _18LevelOrderTraversal_LR
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
            Node current = queue.remove();
            System.out.print(current.data + " ");

            if (current.left != null)
            {
                queue.add(current.left);
            }

            if (current.right != null)
            {
                queue.add(current.right);
            }
        }
    }

    public static void main(String[] args)
    {
        _18LevelOrderTraversal_LR tree = new _18LevelOrderTraversal_LR();

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

        System.out.print("Level Order Traversal: ");
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
remove 1 → print 1
add left (2), right (3)
Queue = [2, 3]

--------------------------------
Step 2:
remove 2 → print 2
add left (4), right (5)
Queue = [3, 4, 5]

--------------------------------
Step 3:
remove 3 → print 3
no children
Queue = [4, 5]

--------------------------------
Step 4:
remove 4 → print 4
no children
Queue = [5]

--------------------------------
Step 5:
remove 5 → print 5
no children
Queue = []

--------------------------------
Traversal ends

Final Output:
Level Order Traversal: 1 2 3 4 5

--------------------------------
CONCEPT:
- Uses Queue (FIFO)
- Visits nodes level by level
- Also called Breadth First Search (BFS)
*/
