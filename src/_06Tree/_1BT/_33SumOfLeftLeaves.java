package _06Tree._1BT;

public class _33SumOfLeftLeaves
{
    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val)
        {
            this.val = val;
        }
    }

    public int sumOfLeftLeaves(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        int sum = 0;

        if (root.left != null && root.left.left == null && root.left.right == null)
        {
            sum += root.left.val;
        }

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }

    public static void main(String[] args)
    {
        _33SumOfLeftLeaves tree = new _33SumOfLeftLeaves();

        /*
            TREE:

                    3
                   / \
                  9   20
                     /  \
                    15   7

            Left Leaves:
            9, 15

            Sum = 24
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = tree.sumOfLeftLeaves(root);
        System.out.println("Sum of Left Leaves: " + result);
    }
}

/*
===========================
PROPER DRY RUN
===========================

Tree:

        3
       / \
      9   20
         /  \
        15   7

--------------------------------
Call: sumOfLeftLeaves(3)

root.left = 9
9 is a leaf → add 9
sum = 9

→ sumOfLeftLeaves(9)
   root.left = null
   return 0

→ sumOfLeftLeaves(20)

--------------------------------
At node 20:

root.left = 15
15 is a leaf → add 15
sum = 15

→ sumOfLeftLeaves(15) → return 0
→ sumOfLeftLeaves(7)  → return 0

Return from node 20 = 15

--------------------------------
Final calculation at root 3:
sum = 9 + 15 = 24

--------------------------------
FINAL OUTPUT:
Sum of Left Leaves: 24
--------------------------------

INTERVIEW IDEA:
- Check if left child exists and is a leaf
- Add its value
- Recur on left and right subtree
*/
