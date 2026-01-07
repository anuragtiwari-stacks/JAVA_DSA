package _4Tree._2BST;

public class _1CreateBST
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

    // Insert value in BST
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

    // Inorder traversal (LNR)
    public void inorder(Node root)
    {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    public static void main(String[] args)
    {
        _1CreateBST tree = new _1CreateBST();

        Node root = null;
        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        System.out.print("Inorder traversal of BST: ");
        tree.inorder(root);
    }
}

/*
BST Structure (Based on Insert Order):

              8
           /     \
         3        10
        / \         \
       1   6         14
          / \       /
         4   7     13

Inorder Output (Sorted): 1 3 4 6 7 8 10 13 14
*/
