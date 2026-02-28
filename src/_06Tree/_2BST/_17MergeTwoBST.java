package _06Tree._2BST;

import java.util.ArrayList;
import java.util.Collections;

public class _17MergeTwoBST
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

    public void inorder(Node root, ArrayList<Integer> list)
    {
        if (root == null)
        {
            return;
        }

        inorder(root.left, list);
        list.add(root.value);
        inorder(root.right, list);
    }

    public Node buildBST(ArrayList<Integer> list, int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(list.get(mid));

        root.left = buildBST(list, start, mid - 1);
        root.right = buildBST(list, mid + 1, end);

        return root;
    }

    public Node mergeBST(Node root1, Node root2)
    {
        ArrayList<Integer> list = new ArrayList<>();

        inorder(root1, list);
        inorder(root2, list);

        Collections.sort(list);

        return buildBST(list, 0, list.size() - 1);
    }

    public void inorderPrint(Node root)
    {
        if (root == null)
        {
            return;
        }

        inorderPrint(root.left);
        System.out.print(root.value + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args)
    {
        _17MergeTwoBST tree = new _17MergeTwoBST();

        Node root1 = new Node(3);
        root1.left = new Node(1);
        root1.right = new Node(5);

        Node root2 = new Node(4);
        root2.left = new Node(2);
        root2.right = new Node(6);

        Node mergedRoot = tree.mergeBST(root1, root2);

        System.out.print("Inorder of merged BST: ");
        tree.inorderPrint(mergedRoot);
    }
}

/*
Tree 1:
        3
       / \
      1   5

Tree 2:
        4
       / \
      2   6

Step 1: Inorder traversal
Tree 1 inorder: 1 3 5
Tree 2 inorder: 2 4 6

Step 2: Merge lists
Combined list: [1, 3, 5, 2, 4, 6]

Step 3: Sort using Collections.sort
Sorted list: [1, 2, 3, 4, 5, 6]

Step 4: Build BST from sorted list

mid = 2 → root = 3

Left subtree from [1, 2]
mid = 0 → root = 1
right child = 2

Right subtree from [4, 5, 6]
mid = 4 → root = 5
left child = 4
right child = 6

Final Merged Balanced BST:

              3
            /   \
           1     5
            \   / \
             2 4   6

Final inorder traversal:
1 2 3 4 5 6
*/
