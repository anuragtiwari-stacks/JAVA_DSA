package _06Tree._2BST;

public class _7KthSmallestAndLargest
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

    int count = 0;
    int result = -1;

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

    public void findKthSmallest(Node root, int k)
    {
        if (root == null)
        {
            return;
        }

        findKthSmallest(root.left, k);

        count++;
        if (count == k)
        {
            result = root.value;
            return;
        }

        findKthSmallest(root.right, k);
    }

    public void findKthLargest(Node root, int k)
    {
        if (root == null)
        {
            return;
        }

        findKthLargest(root.right, k);

        count++;
        if (count == k)
        {
            result = root.value;
            return;
        }

        findKthLargest(root.left, k);
    }

    public static void main(String[] args)
    {
        _7KthSmallestAndLargest tree = new _7KthSmallestAndLargest();
        Node root = null;

        int[] values = {20, 10, 30, 5, 15, 25, 35};
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        /*
                Tree formed:

                          20
                         /  \
                       10    30
                      / \   /  \
                     5  15 25  35
        */

        int k = 3;

        tree.count = 0;
        tree.result = -1;
        tree.findKthSmallest(root, k);
        System.out.println("Kth Smallest (" + k + "): " + tree.result);

        tree.count = 0;
        tree.result = -1;
        tree.findKthLargest(root, k);
        System.out.println("Kth Largest (" + k + "): " + tree.result);
    }
}

/*
Dry run for Kth Smallest (k = 3)

Inorder traversal: Left → Root → Right

Visit 5   → count = 1
Visit 10  → count = 2
Visit 15  → count = 3  → result = 15 (stop counting)

Output:
Kth Smallest (3): 15


Dry run for Kth Largest (k = 3)

Reverse inorder traversal: Right → Root → Left

Visit 35 → count = 1
Visit 30 → count = 2
Visit 25 → count = 3 → result = 25

Output:
Kth Largest (3): 25
*/
