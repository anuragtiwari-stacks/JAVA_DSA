package _6Tree._2BST;

import java.util.ArrayList;

public class _16BalanceBST
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

    // Insert into BST (may create unbalanced tree)
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

    // Step 1: Store inorder traversal (sorted values)
    public void inorderStore(Node root, ArrayList<Integer> list)
    {
        if (root == null)
        {
            return;
        }

        inorderStore(root.left, list);
        list.add(root.value);
        inorderStore(root.right, list);
    }

    // Step 2: Build balanced BST from sorted list
    public Node buildBalancedBST(ArrayList<Integer> list, int start, int end)
    {
        if (start > end)
        {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(list.get(mid));

        root.left = buildBalancedBST(list, start, mid - 1);
        root.right = buildBalancedBST(list, mid + 1, end);

        return root;
    }

    // Main method to balance BST
    public Node balanceBST(Node root)
    {
        ArrayList<Integer> list = new ArrayList<>();
        inorderStore(root, list);
        return buildBalancedBST(list, 0, list.size() - 1);
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
        _16BalanceBST tree = new _16BalanceBST();
        Node root = null;

        int[] values = {1, 2, 3, 4, 5, 6, 7};
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        /*
            Unbalanced BST (right skewed):

            1
             \
              2
               \
                3
                 \
                  4
                   \
                    5
                     \
                      6
                       \
                        7
        */

        root = tree.balanceBST(root);

        /*
            Balanced BST after conversion:

                        4
                      /   \
                     2     6
                    / \   / \
                   1   3 5   7
        */

        System.out.print("Inorder of Balanced BST: ");
        tree.inorderPrint(root);
    }
}

/*
Dry run (Balance a BST)

Initial BST inorder traversal:
1 2 3 4 5 6 7

Step 1:
Store inorder in list:
[1, 2, 3, 4, 5, 6, 7]

Step 2:
Build balanced BST using mid element

start=0, end=6 → mid=3 → root=4

Left subtree:
start=0, end=2 → mid=1 → node=2
  left: start=0,end=0 → node=1
  right:start=2,end=2 → node=3

Right subtree:
start=4,end=6 → mid=5 → node=6
  left: start=4,end=4 → node=5
  right:start=6,end=6 → node=7

Final tree is height balanced.

Inorder output:
1 2 3 4 5 6 7
*/
