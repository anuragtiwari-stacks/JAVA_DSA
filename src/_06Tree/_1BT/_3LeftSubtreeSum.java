package _06Tree._1BT;

public class _3LeftSubtreeSum
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

    public static void main(String[] args)
    {
        _3LeftSubtreeSum tree = new _3LeftSubtreeSum();

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

        System.out.println("Total sum of all nodes: " + totalSum);
        System.out.println("Sum of left subtree: " + leftSum);
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
display(1) → print 1
display(2) → print 2
display(4) → print 4
display(null) → return
display(null) → return
display(5) → print 5
display(null) → return
display(null) → return
display(3) → print 3
display(null) → return
display(null) → return

Traversal Output:
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
root.left = Node(2)

sumOfTree(2)
= 2 + 4 + 5
= 11

--------------------------------
Final Output
--------------------------------
Total sum of all nodes: 15
Sum of left subtree: 11
--------------------------------
*/
