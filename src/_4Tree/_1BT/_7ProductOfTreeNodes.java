package _4Tree._1BT;

public class _7ProductOfTreeNodes
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

    long productOfTree(Node root)
    {
        if (root == null)
        {
            return 1;
        }

        long leftProduct = productOfTree(root.left);
        long rightProduct = productOfTree(root.right);

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
        _7ProductOfTreeNodes tree = new _7ProductOfTreeNodes();

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

        long product = tree.productOfTree(a);
        System.out.println("Product of all nodes: " + product);
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
productOfTree(a)
--------------------------------

productOfTree(4)
left = 1
right = 1
return 4

productOfTree(5)
left = 1
right = 1
return 5

productOfTree(9)
leftProduct = 4
rightProduct = 5
return 9 * 4 * 5 = 180

productOfTree(3)
left = 1
right = 1
return 3

productOfTree(1)
leftProduct = 180
rightProduct = 3
return 1 * 180 * 3 = 540

--------------------------------
Final Output
--------------------------------
Product of all nodes: 540
--------------------------------
*/
