package _06Tree._1BT;

import java.util.Stack;

public class _10PreorderIterative
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

    public void preorder(Node root)
    {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            Node current = stack.pop();
            System.out.print(current.data + " ");

            // Push right first so left is processed first
            if (current.right != null)
                stack.push(current.right);

            if (current.left != null)
                stack.push(current.left);
        }
    }

    public static void main(String[] args)
    {
        _10PreorderIterative tree = new _10PreorderIterative();

        // Creating tree with values 1–7
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

        tree.preorder(a);
    }
}

/*
Tree Diagram:

          1
        /   \
       2     3
      / \   / \
     4   5 6   7

Preorder traversal (Root → Left → Right):
Output:
1 2 4 5 3 6 7
*/
