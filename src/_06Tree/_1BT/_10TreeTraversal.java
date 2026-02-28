package _06Tree._1BT;

public class _10TreeTraversal
{
    // ✅ Static nested Node class
    public static class Node
    {
        int data;
        Node left, right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public void inorder(Node root)
    {
        if (root == null)
        {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void preorder(Node root)
    {
        if (root == null)
        {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public void postorder(Node root)
    {
        if (root == null)
        {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args)
    {
        _10TreeTraversal tree = new _10TreeTraversal();

        Node a = new Node(1);
        Node b = new Node(9);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.print("Inorder traversal: ");
        tree.inorder(a);
        System.out.println();

        System.out.print("Preorder traversal: ");
        tree.preorder(a);
        System.out.println();

        System.out.print("Postorder traversal: ");
        tree.postorder(a);
        System.out.println();
    }
}
