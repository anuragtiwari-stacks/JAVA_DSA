package _6Tree._1BT;

public class _25FlattenBTUsingRecursion
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


    public void flatten(Node root)
    {
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            return;

        Node lst = root.left;
        Node rst = root.right;

        flatten(lst);
        flatten(rst);

        root.left = null;
        root.right = lst;

        Node temp = root;
        while (temp.right != null)
        {
            temp = temp.right;
        }

        temp.right = rst;
    }

    public void printLinkedList(Node root)
    {
        Node temp = root;
        while (temp != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.right;
        }
        System.out.println("null");
    }

    public Node insert(Node root, int value)
    {
        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    public static void main(String[] args)
    {
        _25FlattenBTUsingRecursion tree = new _25FlattenBTUsingRecursion();

        Node root = null;
        int[] values = {10, 5, 15, 3, 7, 12, 18};
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        /*
        Tree Diagram:

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
