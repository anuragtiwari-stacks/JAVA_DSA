package _06Tree._1BT;

public class _4FindMaxNodeValue
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

    int findMax(Node root)
    {
        if (root == null)
        {
            return Integer.MIN_VALUE;
        }

        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
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

    public static void main(String[] args)
    {
        _4FindMaxNodeValue tree = new _4FindMaxNodeValue();

        Node a = new Node(1);
        Node b = new Node(9);
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

        int maxValue = tree.findMax(a);
        System.out.println("Maximum node value: " + maxValue);
    }
}

/*
DRY RUN

Binary Tree Structure:

        1
       / \
      9   3
     / \
    4   5

--------------------------------
Traversal (Preorder)
--------------------------------
display(1) → print 1
display(9) → print 9
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
1 9 4 5 3

--------------------------------
findMax(a)
--------------------------------

findMax(4)
left = MIN
right = MIN
return max(4, MIN) = 4

findMax(5)
left = MIN
right = MIN
return max(5, MIN) = 5

findMax(9)
leftMax = 4
rightMax = 5
return max(9, 5) = 9

findMax(3)
left = MIN
right = MIN
return max(3, MIN) = 3

findMax(1)
leftMax = 9
rightMax = 3
return max(1, 9) = 9

--------------------------------
Final Output
--------------------------------
Maximum node value: 9
--------------------------------
*/
