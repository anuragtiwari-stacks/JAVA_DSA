package _6Tree._1BT;

import java.util.*;

public class _17BinaryTreePath
{
    public static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public void path(Node root, String s, List<String> ans)
    {
        if (root == null)
        {
            return;
        }

        if (root.left == null && root.right == null)
        {
            s += root.data;
            ans.add(s);
            return;
        }

        s += root.data + "->";

        path(root.left, s, ans);
        path(root.right, s, ans);
    }

    public List<String> binaryTreePaths(Node root)
    {
        List<String> ans = new ArrayList<>();
        path(root, "", ans);
        return ans;
    }

    public static void main(String[] args)
    {
        _17BinaryTreePath tree = new _17BinaryTreePath();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(5);

        List<String> paths = tree.binaryTreePaths(root);

        for (String p : paths)
        {
            System.out.println(p);
        }
    }
}

/*
TREE DIAGRAM

        1
       / \
      2   3
       \
        5

================================
DRY RUN (only one example)
================================

Call: binaryTreePaths(1)
→ path(1, "", ans)

At node 1:
s = "" + "1->" = "1->"
→ go left and right

--------------------------------
Left call: path(2, "1->", ans)

At node 2:
s = "1->" + "2->" = "1->2->"
→ left is null
→ go right

--------------------------------
Right call: path(5, "1->2->", ans)

At node 5 (leaf):
s = "1->2->" + "5" = "1->2->5"
→ add to ans

ans = ["1->2->5"]

--------------------------------
Back to node 1, Right call:
path(3, "1->", ans)

At node 3 (leaf):
s = "1->" + "3" = "1->3"
→ add to ans

ans = ["1->2->5", "1->3"]

--------------------------------
FINAL OUTPUT:
1->2->5
1->3
================================
*/
