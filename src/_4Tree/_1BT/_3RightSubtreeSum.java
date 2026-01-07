package _4Tree._1BT;

public class _3RightSubtreeSum
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

    void display(Node node)
    {
        if (node == null)
        {
            return;
        }

        System.out.print(node.data + " ");
        display(node.left);
        display(node.right);
    }

    int sumOfTree(Node node)
    {
        if (node == null)
        {
            return 0;
        }

        int leftSum = sumOfTree(node.left);
        int rightSum = sumOfTree(node.right);

        return node.data + leftSum + rightSum;
    }

    int leftSubtreeSum(Node root)
    {
        if (root == null || root.left == null)
        {
            return 0;
        }

        return sumOfTree(root.left);
    }

    int rightSubtreeSum(Node root)
    {
        if (root == null || root.right == null)
        {
            return 0;
        }

        return sumOfTree(root.right);
    }

    public static void main(String[] args)
    {
        _3RightSubtreeSum tree = new _3RightSubtreeSum();

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.print("Traversal: ");
        tree.display(a);
        System.out.println();

        int totalSum = tree.sumOfTree(a);
        int leftSum = tree.leftSubtreeSum(a);
        int rightSum = tree.rightSubtreeSum(a);

        System.out.println("Total sum of all nodes: " + totalSum);
        System.out.println("Sum of left subtree: " + leftSum);
        System.out.println("Sum of right subtree: " + rightSum);
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
Traversal (Preorder)
--------------------------------
1 2 4 5 3

--------------------------------
sumOfTree(a)
--------------------------------
sumOfTree(4) = 4
sumOfTree(5) = 5
sumOfTree(2) = 2 + 4 + 5 = 11
sumOfTree(3) = 3
sumOfTree(1) = 1 + 11 + 3 = 15

Total Sum = 15

--------------------------------
leftSubtreeSum(a)
--------------------------------
root.left = 2

sumOfTree(2)
= 2 + 4 + 5
= 11

Left Subtree Sum = 11

--------------------------------
rightSubtreeSum(a)
--------------------------------
root.right = 3

sumOfTree(3)
= 3 + 0 + 0
= 3

Right Subtree Sum = 3

--------------------------------
Final Output
--------------------------------
Total sum of all nodes: 15
Sum of left subtree: 11
Sum of right subtree: 3
--------------------------------
*/
