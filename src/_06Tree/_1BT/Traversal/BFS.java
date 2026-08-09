package _06Tree._1BT.Traversal;

import java.util.*;

public class BFS
{
    public static void bfs(TreeNode root)
    {
        if(root == null)
        {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        System.out.print("BFS Traversal: ");

        while(!q.isEmpty())
        {
            TreeNode current = q.remove();

            System.out.print(current.val + " ");

            if(current.left != null)
            {
                q.add(current.left);
            }

            if(current.right != null)
            {
                q.add(current.right);
            }
        }

        System.out.println();
    }

    public static void main(String[] args)
    {
        /*
                    1
                  /   \
                 2     3
                / \   / \
               4   5 6   7
              / \
             8   9
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        bfs(root);
    }
}