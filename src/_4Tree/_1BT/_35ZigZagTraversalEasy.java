package _4Tree._1BT;

import java.util.*;

public class _35ZigZagTraversalEasy
{
    /*
    Logic:
    Use two stacks.

    stack1 -> left to right
    stack2 -> right to left

    1. Push root into stack1
    2. While any stack is not empty:
       - Pop from stack1
         print node
         push left then right child into stack2
       - Pop from stack2
         print node
         push right then left child into stack1
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

    public static void zigzagTraversal(Node root)
    {
        if (root == null)
        {
            return;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.add(root);

        while (!stack1.isEmpty() || !stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                Node curr = stack1.pop();
                System.out.print(curr.data + " ");

                if (curr.left != null)
                {
                    stack2.add(curr.left);
                }

                if (curr.right != null)
                {
                    stack2.add(curr.right);
                }
            }

            while (!stack2.isEmpty())
            {
                Node curr = stack2.pop();
                System.out.print(curr.data + " ");

                if (curr.right != null)
                {
                    stack1.add(curr.right);
                }

                if (curr.left != null)
                {
                    stack1.add(curr.left);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        zigzagTraversal(root);
    }

    /*
    Dry Run:

    Tree:
                1
               / \
              2   3
                 / \
                4   5

    stack1 = [1]
    stack2 = []

    Step 1:
    pop 1 -> print 1
    push 2, 3 into stack2

    stack1 = []
    stack2 = [2, 3]

    Step 2:
    pop 3 -> print 3
    push 5, 4 into stack1

    pop 2 -> print 2

    stack1 = [5, 4]
    stack2 = []

    Step 3:
    pop 4 -> print 4
    pop 5 -> print 5

    Output:
    1 3 2 4 5
    */
}
