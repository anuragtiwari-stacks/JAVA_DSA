package _06Tree._2BST;

public class _9LowestCommonAncestor
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

    public Node insert(Node root, int value)
    {
        if (root == null)
            return new Node(value);

        if (value < root.value)
            root.left = insert(root.left, value);
        else
            root.right = insert(root.right, value);

        return root;
    }

    public Node lowestCommonAncestor(Node root, Node p, Node q)
    {
        if (root == null)
            return null;

        if (p.value < root.value && q.value < root.value)
        {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (p.value > root.value && q.value > root.value)
        {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public static void main(String[] args)
    {
        _9LowestCommonAncestor tree = new _9LowestCommonAncestor();

        Node root = null;
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        Node p = new Node(5);
        Node q = new Node(15);

        Node lca = tree.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.value + " and " + q.value + " = " + lca.value);
    }
}
