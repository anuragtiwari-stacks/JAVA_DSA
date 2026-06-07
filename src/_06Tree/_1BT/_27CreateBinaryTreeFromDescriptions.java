package _06Tree._1BT;

import java.util.*;

// 2196. Create Binary Tree From Descriptions
public class _27CreateBinaryTreeFromDescriptions
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

    public static TreeNode createBinaryTree(int[][] descriptions)
    {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int[] value : descriptions)
        {
            int parent = value[0];
            int child = value[1];
            int isLeft = value[2];

            if(!map.containsKey(parent))
            {
                map.put(parent, new TreeNode(parent));
            }

            if(!map.containsKey(child))
            {
                map.put(child, new TreeNode(child));
            }

            if(isLeft == 1)
            {
                map.get(parent).left = map.get(child);
            }
            else
            {
                map.get(parent).right = map.get(child);
            }

            set.add(child);
        }

        for(int x : map.keySet())
        {
            if(!set.contains(x))
            {
                return map.get(x);
            }
        }

        return null;
    }

    public static void preorder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args)
    {
        int[][] descriptions =
                {
                        {20,15,1},
                        {20,17,0},
                        {50,20,1},
                        {50,80,0},
                        {80,19,1}
                };

        TreeNode root = createBinaryTree(descriptions);

        System.out.println("Root = " + root.val);

        System.out.print("Preorder Traversal: ");
        preorder(root);
    }
}