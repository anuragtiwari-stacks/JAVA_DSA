package _06Tree._2BST;

public class _8ValidateBST
{
    // Node class
    static class Node
    {
        int value;
        Node left, right;

        Node(int value)
        {
            this.value = value;
        }
    }

    // Insert in BST
    public Node insert(Node root, int value)
    {
        if (root == null)
        {
            return new Node(value);
        }

        if (value < root.value)
        {
            root.left = insert(root.left, value);
        }
        else if (value > root.value)
        {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Main function
    public boolean isValidBST(Node root)
    {
        return validate(root, null, null);
    }

    // Helper function
    public boolean validate(Node root, Integer min, Integer max)
    {
        // Base case
        if (root == null)
        {
            return true;
        }

        // Check BST condition
        if ((min != null && root.value <= min) || (max != null && root.value >= max))
        {
            return false;
        }

        // Recursive calls
        return validate(root.left, min, root.value) && validate(root.right, root.value, max);
    }

    public static void main(String[] args)
    {
        _8ValidateBST tree = new _8ValidateBST();

        Node root = null;

        int[] values = {20, 10, 30, 5, 15, 25, 35};

        // Create BST
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        /*
                    20
                   /  \
                 10    30
                / \   / \
               5  15 25 35
        */

        boolean ans = tree.isValidBST(root);

        System.out.println("Is Valid BST : " + ans);
    }
}