package _06Tree._1BT;

public class _8ProductOfNonZeroNodes
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

    long productOfNonZeroTree(Node root)
    {
        if (root == null)
        {
            return 1;
        }

        long leftProduct = productOfNonZeroTree(root.left);
        long rightProduct = productOfNonZeroTree(root.right);

        if (root.data == 0)
        {
            return leftProduct * rightProduct;
        }

        return root.data * leftProduct * rightProduct;
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
        _8ProductOfNonZeroNodes tree = new _8ProductOfNonZeroNodes();

        Node a = new Node(1);
        Node b = new Node(9);
        Node c = new Node(0);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.print("Traversal: ");
        tree.display(a);
        System.out.println();

        long product = tree.productOfNonZeroTree(a);
        System.out.println("Product of all non-zero nodes: " + product);
    }
}

/*
DRY RUN

Binary Tree Structure:

        1
       / \
      9   0
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
display(0) → print 0
display(null) → return
display(null) → return

Traversal Output:
1 9 4 5 0

--------------------------------
productOfNonZeroTree(a)
--------------------------------

productOfNonZeroTree(4)
left = 1
right = 1
return 4

productOfNonZeroTree(5)
left = 1
right = 1
return 5

productOfNonZeroTree(9)
leftProduct = 4
rightProduct = 5
return 9 * 4 * 5 = 180

productOfNonZeroTree(0)
left = 1
right = 1
data = 0 → skip
return 1 * 1 = 1

productOfNonZeroTree(1)
leftProduct = 180
rightProduct = 1
return 1 * 180 * 1 = 180

--------------------------------
Final Output
--------------------------------
Product of all non-zero nodes: 180
--------------------------------
*/
