package _4Tree._2BST;

public class MorrisTraversal
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

    public void morrisInorder(Node root)
    {
        Node current = root;

        while (current != null)
        {
            if (current.left == null)
            {
                System.out.print(current.value + " ");
                current = current.right;
            }
            else
            {
                // Find inorder predecessor of current
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current)
                {
                    predecessor = predecessor.right;
                }

                // Make current as right child of predecessor
                if (predecessor.right == null)
                {
                    predecessor.right = current;
                    current = current.left;
                }
                // Revert the changes (removing the thread)
                else
                {
                    predecessor.right = null;
                    System.out.print(current.value + " ");
                    current = current.right;
                }
            }
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

    public static void main(String[] args)
    {
        MorrisTraversal tree = new MorrisTraversal();
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

        System.out.print("Morris Inorder Traversal: ");
        tree.morrisInorder(root);
    }
}
