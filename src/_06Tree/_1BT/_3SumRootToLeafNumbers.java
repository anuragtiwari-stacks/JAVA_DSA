package _06Tree._1BT;

public class _3SumRootToLeafNumbers
{
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val)
        {
            this.val = val;
        }
    }

    // Function to calculate sum
    public static int sumNumbers(TreeNode root)
    {
        return helper(root, 0);
    }

    public static int helper(TreeNode node, int current)
    {
        // Base Case
        if(node == null)
        {
            return 0;
        }

        // Create current number
        current = current * 10 + node.val;

        // Leaf node
        if(node.left == null && node.right == null)
        {
            return current;
        }

        // Left subtree sum
        int leftSum = helper(node.left, current);

        // Right subtree sum
        int rightSum = helper(node.right, current);

        return leftSum + rightSum;
    }

    public static void main(String[] args)
    {
        /*
                1
               / \
              2   3

            Numbers:
            12
            13

            Sum = 25
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumNumbers(root));
    }
}