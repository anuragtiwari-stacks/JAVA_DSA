package _06Tree._1BT;

public class _1Implementation
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

    public void display(Node node)
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
        _1Implementation tree = new _1Implementation();

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
    }
}

/*
DRY RUN (Preorder Traversal: Root → Left → Right)

Tree Structure:

        1
       / \
      2   3
     / \
    4   5

Step-by-step execution of display(a):

1) display(1)
   print 1
   call display(2)

2) display(2)
   print 2
   call display(4)

3) display(4)
   print 4
   call display(null) → return
   call display(null) → return

4) back to display(2)
   call display(5)

5) display(5)
   print 5
   call display(null) → return
   call display(null) → return

6) back to display(1)
   call display(3)

7) display(3)
   print 3
   call display(null) → return
   call display(null) → return

Final Output:
Traversal: 1 2 4 5 3
*/
