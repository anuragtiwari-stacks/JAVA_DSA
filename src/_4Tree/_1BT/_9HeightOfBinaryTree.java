package _4Tree._1BT;

public class _9HeightOfBinaryTree
{
    public static class Node
    {
        int data;
        Node left, right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    int height(Node root)
    {
        if (root == null)
        {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args)
    {
        _9HeightOfBinaryTree tree = new _9HeightOfBinaryTree();

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        int result = tree.height(a);
        System.out.println("Height of Tree: " + result);
    }
}

/*
DRY RUN

Binary Tree Structure:

        1
       / \
      2   3
     / \
    4   5

--------------------------------
height(a)
--------------------------------

height(4)
left = 0
right = 0
return max(0, 0) + 1 = 1

height(5)
left = 0
right = 0
return max(0, 0) + 1 = 1

height(2)
leftHeight = 1
rightHeight = 1
return max(1, 1) + 1 = 2

height(3)
left = 0
right = 0
return max(0, 0) + 1 = 1

height(1)
leftHeight = 2
rightHeight = 1
return max(2, 1) + 1 = 3

--------------------------------
Final Output
--------------------------------
Height of Tree: 3
--------------------------------

NOTE:
Height is the number of nodes
on the longest path from root
to any leaf node.
*/
