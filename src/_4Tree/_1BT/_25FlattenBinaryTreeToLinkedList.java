package _4Tree._1BT;

public class _25FlattenBinaryTreeToLinkedList
{

    /*
    Logic:

    Flatten binary tree into linked list using PREORDER order.

    Idea (Morris style):

    For every node:
    - If left child exists:
        1. Find rightmost node of left subtree
        2. Connect its right to current.right
        3. Move current.left to current.right
        4. Set current.left = null
    - Move current = current.right

    No extra space, no recursion.
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

    static void flatten(Node root)
    {
        Node curr = root;

        while (curr != null)
        {
            if (curr.left != null)
            {
                Node pred = curr.left;

                // find rightmost node of left subtree
                while (pred.right != null)
                {
                    pred = pred.right;
                }

                // connect
                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }

            curr = curr.right;
        }
    }

    static void printLinkedList(Node root)
    {
        Node curr = root;
        while (curr != null)
        {
            System.out.print(curr.data + " -> ");
            curr = curr.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args)
    {
        /*
                 1
                / \
               2   5
              / \   \
             3   4   6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        flatten(root);
        printLinkedList(root);
    }

    /*
    Dry Run:

    Initial Tree:
                 1
                / \
               2   5
              / \   \
             3   4   6

    Step 1: curr = 1
    left exists → find rightmost of left subtree = 4
    4.right = 5
    1.right = 2
    1.left = null

    Tree now:
    1 -> 2 -> 3 -> 4 -> 5 -> 6

    Step 2:
    curr moves using right pointer only

    Final Linked List (Preorder):
    1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
    */
}
