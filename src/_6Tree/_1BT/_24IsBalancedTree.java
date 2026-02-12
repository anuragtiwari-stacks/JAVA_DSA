package _6Tree._1BT;

public class _24IsBalancedTree
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

    // Returns height (levels) of tree
    public int levels(Node root)
    {
        if (root == null)
        {
            return 0;
        }

        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    // Checks whether tree is height-balanced
    public boolean isBalanced(Node root)
    {
        if (root == null)
        {
            return true;
        }

        int leftHeight = levels(root.left);
        int rightHeight = levels(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
        {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args)
    {
        _24IsBalancedTree tree = new _24IsBalancedTree();

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println("Is the tree balanced? " + tree.isBalanced(a));
    }
}

/*
TREE DIAGRAM

          1
        /   \
       2     3
      / \
     4   5

================================
SIMPLE & EASY DRY RUN
================================

Check isBalanced(1)

Step 1:
levels(left of 1) = levels(2)
→ max(levels(4), levels(5)) + 1
→ max(1,1) + 1 = 2

levels(right of 1) = levels(3)
→ 1

Difference at node 1:
|2 - 1| = 1  → OK

--------------------------------
Check isBalanced(2)

levels(left of 2) = levels(4) = 1
levels(right of 2) = levels(5) = 1

|1 - 1| = 0 → OK

--------------------------------
Check isBalanced(3)

levels(left) = 0
levels(right) = 0

|0 - 0| = 0 → OK

--------------------------------
All nodes satisfy height difference ≤ 1

FINAL ANSWER:
Tree is BALANCED → true
================================
*/
