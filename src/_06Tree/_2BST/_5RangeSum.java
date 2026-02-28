package _06Tree._2BST;

public class _5RangeSum
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

    public int rangeSum(Node root, int low, int high)
    {
        if (root == null)
        {
            return 0;
        }

        int sum = 0;

        if (root.value > low)
        {
            sum += rangeSum(root.left, low, high);
        }

        if (root.value >= low && root.value <= high)
        {
            sum += root.value;
        }

        if (root.value < high)
        {
            sum += rangeSum(root.right, low, high);
        }

        return sum;
    }

    public static void main(String[] args)
    {
        _5RangeSum tree = new _5RangeSum();
        Node root = null;

        int[] values = {10, 5, 15, 3, 7, 18};

        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        /*
                Tree formed:

                        10
                       /  \
                      5    15
                     / \     \
                    3   7    18
        */

        int low = 7;
        int high = 15;

        int sum = tree.rangeSum(root, low, high);
        System.out.println("Range Sum [" + low + ", " + high + "] = " + sum);
    }
}

/*
rangeSum(root = 10, low = 7, high = 15)

10 > 7 → go left
10 in range → add 10
10 < 15 → go right

rangeSum(5)
5 > 7 → false (skip left)
5 in range → false
5 < 15 → go right

rangeSum(7)
7 > 7 → false
7 in range → add 7
7 < 15 → go right (null)

rangeSum(15)
15 > 7 → go left (null)
15 in range → add 15
15 < 15 → false

Final sum = 10 + 7 + 15 = 32
*/
