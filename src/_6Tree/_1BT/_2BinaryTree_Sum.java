package _6Tree._1BT;

public class _2BinaryTree_Sum
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

    public static void main(String[] args)
    {
        _2BinaryTree_Sum tree = new _2BinaryTree_Sum();

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

        int sum = tree.sumOfTree(a);
        System.out.println("Sum of all nodes: " + sum);
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
display(a)  → Preorder Traversal
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
sumOfTree(a)  → Postorder Logic
--------------------------------

sumOfTree(4)
left = 0
right = 0
return 4

sumOfTree(5)
left = 0
right = 0
return 5

sumOfTree(2)
left = 4
right = 5
return 2 + 4 + 5 = 11

sumOfTree(3)
left = 0
right = 0
return 3

sumOfTree(1)
left = 11
right = 3
return 1 + 11 + 3 = 15

--------------------------------
Final Output:
Sum of all nodes: 15
--------------------------------
*/
