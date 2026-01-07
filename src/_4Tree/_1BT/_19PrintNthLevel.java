package _4Tree._1BT;

public class _19PrintNthLevel
{
    public static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    void printNthLevel(Node root, int level)
    {
        if (root == null)
        {
            return;
        }

        if (level == 1)
        {
            System.out.print(root.data + " ");
            return;
        }

        printNthLevel(root.left, level - 1);
        printNthLevel(root.right, level - 1);
    }

    public static void main(String[] args)
    {
        _19PrintNthLevel tree = new _19PrintNthLevel();

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        Node h = new Node(8);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = h;
        d.left = f;
        d.right = g;

        int level = 3;
        System.out.print("Nodes at level " + level + ": ");
        tree.printNthLevel(a, level);
    }
}

/*
TREE DIAGRAM

               1
             /   \
            2     3
           / \   /
          4   5 8
         / \
        6   7

SIMPLE DRY RUN (level = 3)

Step 1:
printNthLevel(1,3)
→ level not 1
→ go to children with level 2

Step 2:
printNthLevel(2,2)
→ level not 1
→ go to children with level 1

Step 3:
printNthLevel(4,1)
→ level == 1 → print 4

printNthLevel(5,1)
→ level == 1 → print 5

Step 4:
printNthLevel(3,2)
→ level not 1
→ go to children with level 1

Step 5:
printNthLevel(8,1)
→ level == 1 → print 8

Step 6:
printNthLevel(null,1)
→ return

FINAL OUTPUT:
4 5 8
*/
