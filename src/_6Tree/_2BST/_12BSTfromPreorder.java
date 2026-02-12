package _6Tree._2BST;

public class _12BSTfromPreorder
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

    // Insert node into BST (brute force approach)
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

    // Build BST from preorder using brute force insertion
    public Node bstFromPreorder(int[] preorder)
    {
        Node root = null;

        for (int val : preorder)
        {
            root = insert(root, val);
        }

        return root;
    }

    public void inorder(Node root)
    {
        if (root == null)
        {
            return;
        }

        inorder(root.left);
        System.out.print(root.value + " ");
        inorder(root.right);
    }

    public static void main(String[] args)
    {
        _12BSTfromPreorder tree =
                new _12BSTfromPreorder();

        int[] preorder = {8, 5, 1, 7, 10, 12};

        Node root = tree.bstFromPreorder(preorder);

        /*
            BST formed from preorder (brute force):

                        8
                      /   \
                     5     10
                    / \      \
                   1   7      12
        */

        System.out.print("Inorder traversal: ");
        tree.inorder(root);
    }
}

/*
Dry run (BST from preorder using brute force)

Preorder array:
8, 5, 1, 7, 10, 12

Step 1:
Insert 8
root = 8

Step 2:
Insert 5
5 < 8 → goes left

    8
   /
  5

Step 3:
Insert 1
1 < 8 → left
1 < 5 → left

    8
   /
  5
 /
1

Step 4:
Insert 7
7 < 8 → left
7 > 5 → right

    8
   /
  5
 / \
1   7

Step 5:
Insert 10
10 > 8 → right

    8
   / \
  5   10
 / \
1   7

Step 6:
Insert 12
12 > 8 → right
12 > 10 → right

    8
   / \
  5   10
 / \    \
1   7    12

Final BST constructed.

Inorder traversal output (sorted):
1 5 7 8 10 12
*/
