package _4Tree._1BT;

import java.util.*;

public class _32MostFrequentSubtreeSum
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

    Map<Integer, Integer> freqMap = new HashMap<>();
    int maxFreq = 0;

    int[] findFrequentTreeSum(TreeNode root)
    {
        if (root == null)
        {
            return new int[0];
        }

        subtreeSum(root);

        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet())
        {
            if (entry.getValue() == maxFreq)
            {
                list.add(entry.getKey());
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }

        return result;
    }

    int subtreeSum(TreeNode node)
    {
        if (node == null)
        {
            return 0;
        }

        int leftSum = subtreeSum(node.left);
        int rightSum = subtreeSum(node.right);

        int sum = leftSum + rightSum + node.val;

        if (freqMap.containsKey(sum))
        {
            freqMap.put(sum, freqMap.get(sum) + 1);
        }
        else
        {
            freqMap.put(sum, 1);
        }

        if (freqMap.get(sum) > maxFreq)
        {
            maxFreq = freqMap.get(sum);
        }

        return sum;
    }

    public static void main(String[] args)
    {
        _32MostFrequentSubtreeSum tree =
                new _32MostFrequentSubtreeSum();

        /*
            TREE:

                    5
                   / \
                  2  -3

            Subtree sums:
            Node 2  -> 2
            Node -3 -> -3
            Node 5  -> 4
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);

        int[] result = tree.findFrequentTreeSum(root);

        System.out.print("Most Frequent Subtree Sum(s): ");
        for (int val : result)
        {
            System.out.print(val + " ");
        }
    }
}

/*
===========================
PROPER DRY RUN
===========================

Initial:
freqMap = {}
maxFreq = 0

--------------------------------
subtreeSum(2)

left = 0
right = 0
sum = 2

freqMap = {2=1}
maxFreq = 1
return 2

--------------------------------
subtreeSum(-3)

left = 0
right = 0
sum = -3

freqMap = {2=1, -3=1}
maxFreq = 1
return -3

--------------------------------
subtreeSum(5)

left = 2
right = -3
sum = 5 + 2 + (-3) = 4

freqMap = {2=1, -3=1, 4=1}
maxFreq = 1
return 4

--------------------------------
All subtree sums:
2, -3, 4

All appear once → frequency = 1

--------------------------------
Final Output:
2 -3 4

--------------------------------
INTERVIEW POINT:
- Postorder traversal
- Subtree sum = left + right + node
- HashMap for frequency
*/
