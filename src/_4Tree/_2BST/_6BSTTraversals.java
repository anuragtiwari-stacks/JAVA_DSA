package _4Tree._2BST;

public class _6BSTTraversals
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

    // Insert into BST
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

    // Inorder: Left, Root, Right
    public void inorder(Node root)
    {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    // Preorder: Root, Left, Right
    public void preorder(Node root)
    {
        if (root == null) return;

        System.out.print(root.value + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder: Left, Right, Root
    public void postorder(Node root)
    {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.value + " ");
    }

    public static void main(String[] args)
    {
        _6BSTTraversals tree = new _6BSTTraversals();
        Node root = null;

        int[] values = {10, 5, 15, 3, 7, 13, 18};
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        System.out.print("Inorder   : ");
        tree.inorder(root);
        System.out.println();

        System.out.print("Preorder  : ");
        tree.preorder(root);
        System.out.println();

        System.out.print("Postorder : ");
        tree.postorder(root);
        System.out.println();
    }
}

/*
Tree Structure:

        10
       /  \
      5    15
     / \   / \
    3   7 13 18

Traversals:
- Inorder   : 3 5 7 10 13 15 18
- Preorder  : 10 5 3 7 15 13 18
- Postorder : 3 7 5 13 18 15 10
*/
