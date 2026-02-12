package _6Tree._1BT;

public class _31InorderPredecessorSuccessor
{
    public static class Node
    {
        int data;
        Node left, right;

        Node(int data)
        {
            this.data = data;
        }
    }

    Node findPredecessor(Node root, int key)
    {
        Node predecessor = null;

        while (root != null)
        {
            if (key > root.data)
            {
                predecessor = root;
                root = root.right;
            }
            else
            {
                root = root.left;
            }
        }

        return predecessor;
    }

    Node findSuccessor(Node root, int key)
    {
        Node successor = null;

        while (root != null)
        {
            if (key < root.data)
            {
                successor = root;
                root = root.left;
            }
            else
            {
                root = root.right;
            }
        }

        return successor;
    }

    public static void main(String[] args)
    {
        _31InorderPredecessorSuccessor tree = new _31InorderPredecessorSuccessor();

        Node root = new Node(20);
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.right.left = new Node(25);
        root.right.right = new Node(35);

        int key = 15;

        Node pred = tree.findPredecessor(root, key);
        Node succ = tree.findSuccessor(root, key);

        if (pred != null)
        {
            System.out.println("Predecessor: " + pred.data);
        }
        else
        {
            System.out.println("Predecessor: null");
        }

        if (succ != null)
        {
            System.out.println("Successor: " + succ.data);
        }
        else
        {
            System.out.println("Successor: null");
        }
    }
}

/*
DRY RUN

BST:

              20
             /  \
           10    30
          /  \   / \
         5   15 25 35

Inorder:
5 10 15 20 25 30 35

Key = 15

--------------------------------
findPredecessor(root, 15)

Start root = 20
15 < 20 → move left

root = 10
15 > 10
→ predecessor = 10
→ move right

root = 15
15 <= 15 → move left → null

Return predecessor = 10

--------------------------------
findSuccessor(root, 15)

Start root = 20
15 < 20
→ successor = 20
→ move left

root = 10
15 > 10 → move right

root = 15
15 >= 15 → move right → null

Return successor = 20

--------------------------------
Final Output:
Predecessor: 10
Successor: 20
--------------------------------

NOTES:
- Works only for BST
- Time Complexity: O(H)
- Space Complexity: O(1)
*/
