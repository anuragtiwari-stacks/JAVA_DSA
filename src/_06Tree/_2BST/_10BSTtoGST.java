package _06Tree._2BST;

public class _10BSTtoGST
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

    int sum = 0;

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

    // Convert BST to Greater Sum Tree (GST)
    public void bstToGst(Node root)
    {
        if (root == null)
        {
            return;
        }

        // reverse inorder: Right → Root → Left
        bstToGst(root.right);

        sum += root.value;
        root.value = sum;

        bstToGst(root.left);
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
        _10BSTtoGST tree = new _10BSTtoGST();
        Node root = null;

        int[] values = {4, 2, 6, 1, 3, 5, 7};
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        /*
                Original BST:

                        4
                      /   \
                     2     6
                    / \   / \
                   1   3 5   7
        */

        tree.bstToGst(root);

        System.out.print("Inorder of GST: ");
        tree.inorder(root);
    }
}

/*
Dry run (BST to GST using reverse inorder)

Original inorder (ascending):
1 2 3 4 5 6 7

Reverse inorder traversal order:
7 → 6 → 5 → 4 → 3 → 2 → 1

sum = 0

Visit 7:
sum = 0 + 7 = 7
node.value = 7

Visit 6:
sum = 7 + 6 = 13
node.value = 13

Visit 5:
sum = 13 + 5 = 18
node.value = 18

Visit 4:
sum = 18 + 4 = 22
node.value = 22

Visit 3:
sum = 22 + 3 = 25
node.value = 25

Visit 2:
sum = 25 + 2 = 27
node.value = 27

Visit 1:
sum = 27 + 1 = 28
node.value = 28

Final GST structure:

                        22
                      /    \
                    27      13
                   /  \    /  \
                 28   25  18   7

Inorder of GST (should be decreasing original sums):
28 27 25 22 18 13 7
*/
