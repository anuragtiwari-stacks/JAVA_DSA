package _6Tree._2BST;

public class _11SortedArrayToBST
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

    // Convert sorted array to balanced BST
    public Node sortedArrayToBST(int[] arr, int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        int mid = (start + end) / 2;

        Node root = new Node(arr[mid]);

        root.left = sortedArrayToBST(arr, start, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, end);

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
        _11SortedArrayToBST tree = new _11SortedArrayToBST();

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        Node root = tree.sortedArrayToBST(arr, 0, arr.length - 1);

        /*
                BST formed from sorted array:

                            4
                          /   \
                         2     6
                        / \   / \
                       1   3 5   7
        */

        System.out.print("Inorder Traversal: ");
        tree.inorder(root);
    }
}

/*
Dry run (Sorted Array to BST)

Array:
1 2 3 4 5 6 7

Call:
sortedArrayToBST(0, 6)
mid = (0 + 6) / 2 = 3
root = 4

Left subtree:
sortedArrayToBST(0, 2)
mid = 1
root.left = 2

Left of 2:
sortedArrayToBST(0, 0)
mid = 0
node = 1

Right of 2:
sortedArrayToBST(2, 2)
mid = 2
node = 3

Right subtree:
sortedArrayToBST(4, 6)
mid = 5
root.right = 6

Left of 6:
sortedArrayToBST(4, 4)
mid = 4
node = 5

Right of 6:
sortedArrayToBST(6, 6)
mid = 6
node = 7

Final BST:

            4
          /   \
         2     6
        / \   / \
       1   3 5   7

Inorder traversal output:
1 2 3 4 5 6 7
*/
