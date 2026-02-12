package _6Tree._2BST;

public class _8ValidateBST
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

        return validate(root.left, min, root.value) && validate(root.right, root.value, max);
    }

    public static void main(String[] args)
    {
        _8ValidateBST tree = new _8ValidateBST();
        _8ValidateBST.Node root = null;

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

        boolean ans = tree.isValidBST(root);
        System.out.println(ans);   // true
    }
}

/*
Dry run (Min–Max approach)

Start:
isValidBST(20)
→ validate(20, min=null, max=null)

Node 20:
min = null, max = null → valid
Left call  → validate(10, null, 20)
Right call → validate(30, 20, null)

------------------------------------------------

Node 10:
min = null, max = 20
10 < 20 → valid
Left  → validate(5, null, 10)
Right → validate(15, 10, 20)

Node 5:
min = null, max = 10
5 < 10 → valid
Left  → null → true
Right → null → true

Node 15:
min = 10, max = 20
10 < 15 < 20 → valid
Left  → null → true
Right → null → true

------------------------------------------------

Node 30:
min = 20, max = null
30 > 20 → valid
Left  → validate(25, 20, 30)
Right → validate(35, 30, null)

Node 25:
min = 20, max = 30
20 < 25 < 30 → valid
Left  → null → true
Right → null → true

Node 35:
min = 30, max = null
35 > 30 → valid
Left  → null → true
Right → null → true

------------------------------------------------

All recursive calls returned true
No violation of min–max rule

Final result: true
*/
