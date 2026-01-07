package _4Tree._1BT;

import java.util.Stack;

public class _10InorderIterative
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
    public void inorder(Node root)
    {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty())
        {
            // Reach the leftmost Node
            while (current != null)
            {
                stack.push(current);
                current = current.left;
            }

            // Current is null at this point
            current = stack.pop();
            System.out.print(current.data + " ");

            // Visit the right subtree
            current = current.right;
        }
    }

    public static void main(String[] args)
    {
        _10InorderIterative tree = new _10InorderIterative();

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;

        tree.inorder(a);
    }
}

/*
Tree Structure:

          1
        /   \
       2     3
      / \   / \
     4   5 6   7

Inorder Traversal (Left → Root → Right):
Output:
4 2 5 1 6 3 7
*/
