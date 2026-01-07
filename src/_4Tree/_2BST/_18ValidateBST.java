package _4Tree._2BST;

public class _18ValidateBST
{
    static class Node
    {
        int value;
        Node left, right;

        Node(int value)
        {
            this.value = value;
        }
    }

    public Node insert(Node root, int value)
    {
        if (root == null)
        {
            return new Node(value);
        }

        if (value < root.value)
        {
            root.left = insert(root.left, value);
        }
        else if (value > root.value)
        {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Validate BST using Min-Max approach
    public boolean isValidBST(Node root)
    {
        return validate(root, null, null);
    }

    public boolean validate(Node root, Integer min, Integer max)
    {
        if (root == null)
        {
            return true;
        }

        if (min != null && root.value <= min)
        {
            return false;
        }

        if (max != null && root.value >= max)
        {
            return false;
        }

        return validate(root.left, min, root.value)
                && validate(root.right, root.value, max);
    }

    // Count nodes in tree
    public int countNodes(Node root)
    {
        if (root == null)
        {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args)
    {
        _18ValidateBST tree = new _18ValidateBST();
        Node root = null;

        int[] values = {20, 10, 30, 5, 15, 25, 35};
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        /*
                Tree formed:

                          20
                         /  \
                       10    30
                      / \   /  \
                     5  15 25  35
        */

        if (tree.isValidBST(root))
        {
            int count = tree.countNodes(root);
            System.out.println("Valid BST");
            System.out.println("Total Nodes = " + count);
        }
        else
        {
            System.out.println("Not a Valid BST");
        }
    }
}

/*
====================== DRY RUN ======================

STEP 1: Validate BST (Min–Max)

Call:
isValidBST(20)
→ validate(20, min=null, max=null)

Node 20:
min=null, max=null → OK
Left  → validate(10, null, 20)
Right → validate(30, 20, null)

-----------------------------------

Node 10:
min=null, max=20
10 < 20 → OK
Left  → validate(5, null, 10)
Right → validate(15, 10, 20)

Node 5:
min=null, max=10
5 < 10 → OK
Left=null → true
Right=null → true

Node 15:
min=10, max=20
10 < 15 < 20 → OK
Left=null → true
Right=null → true

-----------------------------------

Node 30:
min=20, max=null
30 > 20 → OK
Left  → validate(25, 20, 30)
Right → validate(35, 30, null)

Node 25:
min=20, max=30
20 < 25 < 30 → OK
Left=null → true
Right=null → true

Node 35:
min=30, max=null
35 > 30 → OK
Left=null → true
Right=null → true

All nodes satisfy min–max condition
BST is VALID ✅

----------------------------------------------------

STEP 2: Count Nodes

countNodes(20)
= 1 + countNodes(10) + countNodes(30)

countNodes(10)
= 1 + countNodes(5) + countNodes(15)
= 1 + 1 + 1 = 3

countNodes(30)
= 1 + countNodes(25) + countNodes(35)
= 1 + 1 + 1 = 3

Total Nodes
= 1 + 3 + 3
= 7

OUTPUT:
Valid BST
Total Nodes = 7
====================================================
*/
