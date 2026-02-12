package _6Tree._1BT;

import java.util.*;

/*
LeetCode 113 – Path Sum II

Problem:
Given the root of a binary tree and an integer targetSum,
return all root-to-leaf paths where the sum of the node values
in the path equals targetSum.

A leaf is a node with no left and right children.
*/

public class _26PathSum2_BackTracking
{

    /*
    Logic (BACKTRACKING):

    - Root se leaf tak DFS chalao
    - Har node par:
        1. path me node ka data add karo
        2. targetSum me se node ka data minus karo
    - Agar leaf node hai aur targetSum == node.data
        -> current path answer me add karo
    - Backtracking:
        - recursion se wapas aate waqt
          last added node ko path se remove karo

    Backtracking ka matlab:
    "Try karo → kaam ho gaya → undo karo"
    */

    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
        }
    }

    static List<List<Integer>> pathSum(Node root, int targetSum)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    static void dfs(Node root, int targetSum, List<Integer> path, List<List<Integer>> result)
    {
        if (root == null)
        {
            return;
        }

        // choose
        path.add(root.data);

        // check (leaf condition)
        if (root.left == null && root.right == null && targetSum == root.data)
        {
            result.add(new ArrayList<>(path));
        }

        // explore
        dfs(root.left, targetSum - root.data, path, result);
        dfs(root.right, targetSum - root.data, path, result);

        // un-choose (BACKTRACK)
        path.remove(path.size() - 1);
    }

    public static void main(String[] args)
    {
        /*
                     5
                   /   \
                  4     8
                 /     / \
                11    13  4
               /  \        \
              7    2        1

        targetSum = 22
        */

        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);

        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);

        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);

        List<List<Integer>> ans = pathSum(root, 22);
        System.out.println(ans);
    }

    /*
    Dry Run:

    Start:
    path = []
    targetSum = 22

    Go to 5:
    path = [5], target = 17

    Go to 4:
    path = [5, 4], target = 13

    Go to 11:
    path = [5, 4, 11], target = 2

    Go to 7:
    path = [5, 4, 11, 7], target = -5
    Leaf but sum != 0 → ignore
    Backtrack → path = [5, 4, 11]

    Go to 2:
    path = [5, 4, 11, 2], target = 0
    Leaf + sum matched → add [5, 4, 11, 2]

    Backtrack step-by-step:
    remove 2 → [5, 4, 11]
    remove 11 → [5, 4]
    remove 4 → [5]

    Right subtree paths checked similarly

    Final Answer:
    [[5, 4, 11, 2]]
    */
}
