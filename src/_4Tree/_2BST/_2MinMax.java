package _4Tree._2BST;

public class _2MinMax
{
    static class Node
    {
        int value;
        Node left, right;

        Node(int value)
        {
            this.value = value;
        }
    }

    // Insert value into BST
    public Node insert(Node root, int value)
    {
        if (root == null)
            return new Node(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else if (value > root.value)
            root.right = insert(root.right, value);

        return root;
    }

    // Find minimum (leftmost node)
    public int findMin(Node root)
    {
        if (root == null)
            throw new RuntimeException("Tree is empty");

        while (root.left != null)
        {
            root = root.left;
        }
        return root.value;
    }

    // Find maximum (rightmost node)
    public int findMax(Node root)
    {
        if (root == null)
            throw new RuntimeException("Tree is empty");

        while (root.right != null)
        {
            root = root.right;
        }
        return root.value;
    }

    public static void main(String[] args)
    {
        _2MinMax tree = new _2MinMax();
        Node root = null;

        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        System.out.println("Minimum value in BST: " + tree.findMin(root));
        System.out.println("Maximum value in BST: " + tree.findMax(root));
    }
}

/*
BST Structure:

              8
           /     \
         3        10
        / \         \
       1   6         14
          / \       /
         4   7     13

Min = 1 (leftmost)
Max = 14 (rightmost)
*/
