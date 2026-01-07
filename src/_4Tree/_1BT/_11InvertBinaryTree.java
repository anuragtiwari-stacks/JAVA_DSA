package _4Tree._1BT;

public class _11InvertBinaryTree
{
    public static class Node
    {
        int data;
        Node left, right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public void invertTree(Node root)
    {
        if (root == null)
        {
            return;
        }

        // swap left and right
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        // invert subtrees
        invertTree(root.left);
        invertTree(root.right);
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

    public static void main(String[] args)
    {
        _11InvertBinaryTree tree = new _11InvertBinaryTree();

        /*
            ORIGINAL TREE:

                    1
                   / \
                  9   3
                 / \
                4   5
        */

        Node a = new Node(1);
        Node b = new Node(9);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.print("Original Inorder: ");
        tree.inorder(a);
        System.out.println();

        tree.invertTree(a);

        System.out.print("Inverted Inorder: ");
        tree.inorder(a);
    }
}

/*
===========================
PROPER DRY RUN
===========================

Original Tree:

        1
       / \
      9   3
     / \
    4   5

Original Inorder:
4 9 5 1 3

--------------------------------
Call: invertTree(1)

Swap children of 1
left = 3
right = 9

Tree becomes:

        1
       / \
      3   9
         / \
        4   5

--------------------------------
invertTree(3)
- children are null
- return

--------------------------------
invertTree(9)

Swap children of 9
left = 5
right = 4

Tree becomes:

        1
       / \
      3   9
         / \
        5   4

--------------------------------
invertTree(5) → leaf → return
invertTree(4) → leaf → return

--------------------------------
Final Inverted Tree:

        1
       / \
      3   9
         / \
        5   4

--------------------------------
Inverted Inorder:
3 1 5 9 4

--------------------------------
CONCEPT:
- Invert Binary Tree = Mirror Tree
- Swap left & right at every node
- Use DFS (recursion)
*/
