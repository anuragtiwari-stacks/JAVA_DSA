package _4Tree._1BT;

public class _30ConstructBTFromInPost
{

    /*
    Logic:

    Inorder   = Left Root Right
    Postorder = Left Right Root

    Important observations:
    - Last element of postorder is always ROOT
    - Find root index in inorder
    - Left subtree = inorder left part
    - Right subtree = inorder right part

    Steps:
    1. Take last element from postorder as root
    2. Find root position in inorder
    3. Recursively build right subtree
    4. Recursively build left subtree
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

    static int postIndex;

    static Node buildTree(int[] inorder, int[] postorder, int inStart, int inEnd)
    {
        if (inStart > inEnd)
        {
            return null;
        }

        Node root = new Node(postorder[postIndex]);
        postIndex--;

        if (inStart == inEnd)
        {
            return root;
        }

        int inIndex = findIndex(inorder, root.data, inStart, inEnd);

        root.right = buildTree(inorder, postorder, inIndex + 1, inEnd);
        root.left = buildTree(inorder, postorder, inStart, inIndex - 1);

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

    static void inorder(Node root)
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
        /*
        Inorder    : [3, 1, 4, 0, 5, 2]
        Postorder  : [3, 4, 1, 5, 2, 0]
        */

        int[] inorder = {3, 1, 4, 0, 5, 2};
        int[] postorder = {3, 4, 1, 5, 2, 0};

        postIndex = postorder.length - 1;

        Node root = buildTree(inorder, postorder, 0, inorder.length - 1);

        inorder(root);
    }

    /*
    Dry Run:

    Inorder    : [3, 1, 4, 0, 5, 2]
    Postorder  : [3, 4, 1, 5, 2, 0]

    Step 1:
    postIndex = 5
    root = 0

    Inorder split:
    Left  = [3, 1, 4]
    Right = [5, 2]

    Step 2 (Right Subtree):
    root = 2
    Left  = [5]
    Right = []

    Step 3:
    root = 5 (leaf)

    Step 4 (Left Subtree):
    root = 1
    Left  = [3]
    Right = [4]

    Final Tree:

                0
              /   \
             1     2
            / \   /
           3   4 5

*/
}
