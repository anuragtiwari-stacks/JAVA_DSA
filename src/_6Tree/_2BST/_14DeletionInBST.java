package _6Tree._2BST;

public class _14DeletionInBST
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
        else if (value > root.value)
            root.right = insert(root.right, value);

        return root;
    }

    // Find minimum value node in BST (used for deletion)
    private Node minValueNode(Node root)
    {
        Node current = root;
        while (current.left != null)
        {
            current = current.left;
        }
        return current;
    }

    public Node delete(Node root, int key)
    {
        if (root == null)
            return null;

        if (key < root.value)
        {
            root.left = delete(root.left, key);
        }
        else if (key > root.value)
        {
            root.right = delete(root.right, key);
        }
        else
        {
            // Node to be deleted found

            // Case 1: No child
            if (root.left == null && root.right == null)
            {
                return null;
            }
            // Case 2: One child (right)
            else if (root.left == null)
            {
                return root.right;
            }
            // Case 3: One child (left)
            else if (root.right == null)
            {
                return root.left;
            }
            else
            {
                // Case 4: Two children
                // Get inorder successor (smallest in right subtree)
                Node successor = minValueNode(root.right);
                // Copy successor's value to root
                root.value = successor.value;
                // Delete successor node from right subtree
                root.right = delete(root.right, successor.value);
            }
        }

        return root;
    }

    // Inorder traversal to verify tree after deletion
    public void inorder(Node root)
    {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    public static void main(String[] args)
    {
        _14DeletionInBST tree = new _14DeletionInBST();
        Node root = null;

        int[] values = {20, 10, 30, 5, 15, 25, 35};
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        /*
        Tree Diagram:

                20
               /  \
             10    30
            / \    / \
           5  15  25 35
        */

        System.out.print("Original BST (Inorder): ");
        tree.inorder(root);
        System.out.println();

        int keyToDelete = 10;
        root = tree.delete(root, keyToDelete);

        System.out.println("BST after deleting " + keyToDelete + " (Inorder): ");
        tree.inorder(root);
        System.out.println();
    }
}
