package _06Tree._2BST;

public class _4Search
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

    public boolean search(Node root, int target)
    {
        if (root == null)
        {
            return false;
        }

        if (target == root.value)
        {
            return true;
        }
        else if (target < root.value)
        {
            return search(root.left, target);
        }
        else
        {
            return search(root.right, target);
        }
    }

    public static void main(String[] args)
    {
        _4Search tree = new _4Search();
        Node root = null;

        int[] values = {5, 3, 8, 1, 4};

        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        /*
            Tree formed:

                    5
                   / \
                  3   8
                 / \
                1   4
        */

        System.out.println(tree.search(root, 4));  // true
        System.out.println(tree.search(root, 6));  // false
    }
}

/*
search(root, 4)

root = 5
4 < 5 → left

root = 3
4 > 3 → right

root = 4
4 == 4 → found → true


search(root, 6)

root = 5
6 > 5 → right

root = 8
6 < 8 → left

root = null
not found → false
*/
