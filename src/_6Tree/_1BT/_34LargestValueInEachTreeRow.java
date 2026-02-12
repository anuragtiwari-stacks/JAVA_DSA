package _6Tree._1BT;

import java.util.*;

public class _34LargestValueInEachTreeRow
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

    List<Integer> largestValues(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();

        if (root == null)
        {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);

                if (node.left != null)
                {
                    queue.add(node.left);
                }

                if (node.right != null)
                {
                    queue.add(node.right);
                }
            }

            result.add(max);
        }

        return result;
    }

    public static void main(String[] args)
    {
        _34LargestValueInEachTreeRow tree =
                new _34LargestValueInEachTreeRow();

        /*
            TREE:

                    1
                   / \
                  3   2
                 / \   \
                5   3   9

            Output:
            [1, 3, 9]
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        List<Integer> ans = tree.largestValues(root);
        System.out.println("Largest value in each row: " + ans);
    }
}

/*
===========================
PROPER DRY RUN
===========================

Tree:

        1
       / \
      3   2
     / \   \
    5   3   9

--------------------------------
Level 0:
Queue = [1]
max = 1
result = [1]

--------------------------------
Level 1:
Queue = [3, 2]
max = max(3,2) = 3
result = [1, 3]

--------------------------------
Level 2:
Queue = [5, 3, 9]
max = max(5,3,9) = 9
result = [1, 3, 9]

--------------------------------
FINAL OUTPUT:
[1, 3, 9]
--------------------------------

INTERVIEW IDEA:
- Use Level Order Traversal (BFS)
- For each level, track maximum value
- Add max of each level to result list
*/
