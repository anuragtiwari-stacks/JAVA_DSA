package _4Tree._1BT;

import java.util.ArrayList;

public class _25FlattenBTUsingArrayList
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

    // Step 1: Preorder traversal - collect nodes
    public void preorder(Node root, ArrayList<Node> nodes)
    {
        if (root == null)
        {
            return;
        }

        nodes.add(root);
        preorder(root.left, nodes);
        preorder(root.right, nodes);
    }

    // Step 2: Flatten tree to right-linked list
    public void flatten(Node root)
    {
        ArrayList<Node> nodes = new ArrayList<>();
        preorder(root, nodes);

        for (int i = 0; i < nodes.size() - 1; i++)
        {
            Node current = nodes.get(i);
            current.left = null;
            current.right = nodes.get(i + 1);
        }

        if (!nodes.isEmpty())
        {
            Node last = nodes.get(nodes.size() - 1);
            last.left = null;
            last.right = null;
        }
    }

    // Helper: Print flattened tree
    public void printLinkedList(Node root)
    {
        Node current = root;
        while (current != null)
        {
            System.out.print(current.data + " -> ");
            current = current.right;
        }
        System.out.println("null");
    }

    // Insert node in BST
    public Node insert(Node root, int data)
    {
        if (root == null)
        {
            return new Node(data);
        }

        if (data < root.data)
        {
            root.left = insert(root.left, data);
        }
        else
        {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static void main(String[] args)
    {
        _25FlattenBTUsingArrayList tree = new _25FlattenBTUsingArrayList();

        Node root = null;

        int[] values = {10, 5, 15, 3, 7, 12, 18};
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        /*
        Original Tree:

                10
               /  \
              5    15
             / \   / \
            3   7 12 18
        */

        tree.flatten(root);

        System.out.print("Flattened Linked List: ");
        tree.printLinkedList(root);
    }
}
