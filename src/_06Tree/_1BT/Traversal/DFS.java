package _06Tree._1BT.Traversal;

import java.util.*;

public class DFS
{
    public static void dfs(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> result)
    {
        if(root == null)
        {
            return;
        }

        list.add(root.val);
        targetSum = targetSum - root.val;

        if(root.left == null && root.right == null)
        {
            if(targetSum == 0)
            {
                result.add(new ArrayList<>(list));
            }

            list.remove(list.size() - 1);
            return;
        }

        dfs(root.left, targetSum, list, result);
        dfs(root.right, targetSum, list, result);

        list.remove(list.size() - 1);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        dfs(root, targetSum, list, result);

        return result;
    }

    public static void main(String[] args)
    {
        /*
                    5
                  /   \
                 4     8
                /     / \
               11    13  4
              /  \       / \
             7    2     5   1
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        List<List<Integer>> result = pathSum(root, targetSum);

        System.out.println("Paths with sum " + targetSum + ":");
        System.out.println(result);
    }
}