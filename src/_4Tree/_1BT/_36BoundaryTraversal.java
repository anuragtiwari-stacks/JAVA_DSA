package _4Tree._1BT;

public class _36BoundaryTraversal
{

    /*
    Logic:

    Boundary traversal consists of:
    1. Root node
    2. Left boundary (excluding leaf nodes)
    3. All leaf nodes (left to right)
    4. Right boundary (excluding leaf nodes, printed bottom to top)

    Steps:
    - Print root
    - Traverse left boundary
    - Traverse all leaf nodes
    - Traverse right boundary in reverse order
    */

    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
        }
    }

    public static void boundaryTraversal(Node root)
    {
        if (root == null)
        {
            return;
        }

        System.out.print(root.data + " ");

        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }

    private static void printLeftBoundary(Node node)
    {
        if (node == null)
        {
            return;
        }

        if (node.left != null)
        {
            System.out.print(node.data + " ");
            printLeftBoundary(node.left);
        }
        else if (node.right != null)
        {
            System.out.print(node.data + " ");
            printLeftBoundary(node.right);
        }
    }

    private static void printLeaves(Node node)
    {
        if (node == null)
        {
            return;
        }

        printLeaves(node.left);

        if (node.left == null && node.right == null)
        {
            System.out.print(node.data + " ");
        }

        printLeaves(node.right);
    }

    private static void printRightBoundary(Node node)
    {
        if (node == null)
        {
            return;
        }

        if (node.right != null)
        {
            printRightBoundary(node.right);
            System.out.print(node.data + " ");
        }
        else if (node.left != null)
        {
            printRightBoundary(node.left);
            System.out.print(node.data + " ");
        }
    }



    public static void main(String[] args)
    {
        /*
                     1
                   /   \
                  2     4
                 / \     \
                3   5     7
                   / \     \
                  6   8     9
                           / \
                          10  11
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(4);

        root.left.left = new Node(3);
        root.left.right = new Node(5);

        root.left.right.left = new Node(6);
        root.left.right.right = new Node(8);

        root.right.right = new Node(7);
        root.right.right.right = new Node(9);

        root.right.right.right.left = new Node(10);
        root.right.right.right.right = new Node(11);

        boundaryTraversal(root);
    }

    /*
    Dry Run:

    Tree:
                     1
                   /   \
                  2     4
                 / \     \
                3   5     7
                   / \     \
                  6   8     9
                           / \
                          10  11

    Step 1: Root
    Output: 1

    Step 2: Left Boundary (excluding leaf)
    2

    Step 3: Leaf Nodes (left to right)
    3 6 8 10 11

    Step 4: Right Boundary (bottom to top, excluding leaf)
    9 7 4

    Final Boundary Traversal:
    1 2 3 6 8 10 11 9 7 4
    */
}
