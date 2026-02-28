package _06Tree._1BT;

public class _5FindMinNodeValue
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

    int findMin(Node root)
    {
        if (root == null)
        {
            return Integer.MAX_VALUE;
        }

        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
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
        _5FindMinNodeValue tree = new _5FindMinNodeValue();

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

        int minValue = tree.findMin(a);
        System.out.println("Minimum node value: " + minValue);
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
findMin(a)
--------------------------------

findMin(4)
left = MAX
right = MAX
return min(4, MAX) = 4

findMin(5)
left = MAX
right = MAX
return min(5, MAX) = 5

findMin(9)
leftMin = 4
rightMin = 5
return min(9, 4) = 4

findMin(3)
left = MAX
right = MAX
return min(3, MAX) = 3

findMin(1)
leftMin = 4
rightMin = 3
return min(1, 3) = 1

--------------------------------
Final Output
--------------------------------
Minimum node value: 1
--------------------------------
*/
