package _4Tree._1BT;

public class _14DiameterOfBinaryTree
{
    public static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
        }
    }

    public int height(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public int diameter(Node root)
    {
        if(root == null)
        {
            return 0;
        }

        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        int currDia = lh + rh + 1;

        return Math.max(Math.max(leftDia, rightDia), currDia);
    }

    public static void main(String[] args)
    {
        _14DiameterOfBinaryTree tree = new _14DiameterOfBinaryTree();

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        int result = tree.diameter(a);
        System.out.println("Diameter: " + result);
    }
}

/*
============================
DRY RUN (Matching MyDia Style)
============================

Tree:
        1
       / \
      2   3
     / \
    4   5

At Node 4:
- leftDia = 0
- rightDia = 0
- lh = 0, rh = 0
- currDia = 1
return = 1

At Node 5:
- same as Node 4
return = 1

At Node 2:
leftDia (from 4) = 1
rightDia (from 5) = 1
lh = 1 (height of 4)
rh = 1 (height of 5)
currDia = 1+1+1 = 3
return max(1,1,3) = 3

At Node 3:
leftDia = 0
rightDia = 0
lh = 0, rh = 0
currDia = 1
return = 1

At Node 1:
leftDia = 3
rightDia = 1
lh = 2
rh = 1
currDia = 2+1+1 = 4
return max(3,1,4) = 4

Final Answer = 4 (in nodes)
================================
*/
