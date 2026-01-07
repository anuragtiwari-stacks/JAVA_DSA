package _4Tree._1BT;

public class _3SumRootToLeafNumbers
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

    int totalSum = 0;

    int sumNumbers(TreeNode root)
    {
        traverse(root, 0);
        return totalSum;
    }

    void traverse(TreeNode node, int current)
    {
        if (node == null)
        {
            return;
        }

        current = current * 10 + node.val;

        if (node.left == null && node.right == null)
        {
            totalSum += current;
            return;
        }

        traverse(node.left, current);
        traverse(node.right, current);
    }

    public static void main(String[] args)
    {
        _3SumRootToLeafNumbers tree = new _3SumRootToLeafNumbers();

        /*
            TREE CREATION:

                    1
                   / \
                  2   3

            Root → Leaf paths:
            1 → 2  = 12
            1 → 3  = 13
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int result = tree.sumNumbers(root);
        System.out.println("Sum of Root to Leaf Numbers: " + result);
    }
}

/*
===========================
PROPER DRY RUN
===========================

Tree:

        1
       / \
      2   3

--------------------------------
Initial values:
totalSum = 0

--------------------------------
Call: sumNumbers(root)

→ traverse(node = 1, current = 0)

current = 0 * 10 + 1 = 1

--------------------------------
Go LEFT:
→ traverse(node = 2, current = 1)

current = 1 * 10 + 2 = 12

Node 2 is LEAF
→ totalSum = 0 + 12 = 12
→ return

--------------------------------
Go RIGHT:
→ traverse(node = 3, current = 1)

current = 1 * 10 + 3 = 13

Node 3 is LEAF
→ totalSum = 12 + 13 = 25
→ return

--------------------------------
Traversal finished

Return totalSum = 25

--------------------------------
FINAL OUTPUT:
Sum of Root to Leaf Numbers: 25
--------------------------------

INTERVIEW POINT:
- DFS traversal
- Carry number using current * 10 + value
- Add only at leaf node
- Global variable used to store result
*/
