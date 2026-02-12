package _6Tree._1BT;

import java.util.Stack;

public class _10PostorderIterative
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

    public void postorder(Node root)
    {
        if (root == null) return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty())
        {
            Node current = stack1.pop();
            stack2.push(current);

            if (current.left != null) stack1.push(current.left);
            if (current.right != null) stack1.push(current.right);
        }

        while (!stack2.isEmpty())
        {
            System.out.print(stack2.pop().data + " ");
        }
    }

    public static void main(String[] args)
    {
        _10PostorderIterative tree = new _10PostorderIterative();

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

        tree.postorder(a);
    }
}

/*
Tree Diagram:

          1
        /   \
       2     3
      / \   / \
     4   5 6   7

Postorder Traversal:
4 5 2 6 7 3 1
*/
