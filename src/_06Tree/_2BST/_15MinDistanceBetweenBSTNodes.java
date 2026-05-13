package _06Tree._2BST;

public class _15MinDistanceBetweenBSTNodes
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

    int minDiff = Integer.MAX_VALUE;
    Node prev = null;

    public int minDiffInBST(Node root)
    {
        inorder(root);
        return minDiff;
    }

    public void inorder(Node root)
    {
        if (root == null)
        {
            return;
        }

        // Left
        inorder(root.left);

        // Process current node
        if (prev != null)
        {
            minDiff = Math.min(minDiff, root.value - prev.value);
        }

        prev = root;

        // Right
        inorder(root.right);
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
        else
        {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static void main(String[] args)
    {
        _15MinDistanceBetweenBSTNodes tree = new _15MinDistanceBetweenBSTNodes();

        Node root = null;

        int[] values = {4, 2, 6, 1, 3};

        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        int ans = tree.minDiffInBST(root);

        System.out.println("Minimum Difference = " + ans);
    }
}