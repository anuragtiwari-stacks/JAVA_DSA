package _6Tree._1BT;

public class _29ConstructBTFromInPre
{

    /*
    Logic:

    Inorder  = Left Root Right
    Preorder = Root Left Right

    Observations:
    - First element of preorder is always ROOT
    - Find root position in inorder
    - Left subtree = inorder left part
    - Right subtree = inorder right part

    Steps:
    1. Take current element from preorder as root
    2. Find root index in inorder
    3. Recursively build left subtree
    4. Recursively build right subtree
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

    static int preIndex = 0;

    static Node buildTree(int[] inorder, int[] preorder, int inStart, int inEnd)
    {
        if (inStart > inEnd)
        {
            return null;
        }

        int element = preorder[preIndex];
        preIndex++;

        Node root = new Node(element);

        if (inStart == inEnd) //  if (inStart == inEnd)
        {
            return root;
        }

        int inIndex = findIndex(inorder, element, inStart, inEnd);

        root.left = buildTree(inorder, preorder, inStart, inIndex - 1);
        root.right = buildTree(inorder, preorder, inIndex + 1, inEnd);

        return root;
    }

    static int findIndex(int[] inorder, int value, int start, int end)
    {
        for (int i = start; i <= end; i++)
        {
            if (inorder[i] == value)
            {
                return i;
            }
        }
        return -1;
    }

    static void inorderPrint(Node root)
    {
        if (root == null)
        {
            return;
        }

        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args)
    {
        /*
        Inorder   : [3, 1, 4, 0, 5, 2]
        Preorder  : [0, 1, 3, 4, 2, 5]
        */

        int[] inorder = {3, 1, 4, 0, 5, 2};
        int[] preorder = {0, 1, 3, 4, 2, 5};

        Node root = buildTree(inorder, preorder, 0, inorder.length - 1);

        inorderPrint(root);
    }

    /*
    Dry Run:

    Inorder   : [3, 1, 4, 0, 5, 2]
    Preorder  : [0, 1, 3, 4, 2, 5]

    Step 1:
    preIndex = 0
    root = 0

    Inorder split:
    Left  = [3, 1, 4]
    Right = [5, 2]

    Step 2 (Left Subtree):
    root = 1
    Left  = [3]
    Right = [4]

    Step 3:
    root = 3 (leaf)
    root = 4 (leaf)

    Step 4 (Right Subtree):
    root = 2
    Left  = [5]
    Right = []

    Final Tree:

                0
              /   \
             1     2
            / \   /
           3   4 5

    Inorder Output:
    3 1 4 0 5 2
    */
}
