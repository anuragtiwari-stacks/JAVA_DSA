package _4Tree._2BST;

public class _13PredecessorAndSuccessor
{
    static class Node
    {
        int value;
        Node left, right;

        Node(int value)
        {
            this.value = value;
        }
    }

    public Node insert(Node root, int value)
    {
        if (root == null)
        {
            return new Node(value);
        }

        if (value < root.value)
        {
            root.left = insert(root.left, value);
        }
        else if (value > root.value)
        {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Find ONLY predecessor
    public Node findPredecessor(Node root, int key)
    {
        Node predecessor = null;
        Node curr = root;

        while (curr != null)
        {
            if (key <= curr.value)
            {
                curr = curr.left;
            }
            else
            {
                predecessor = curr;
                curr = curr.right;
            }
        }

        return predecessor;
    }

    // Find ONLY successor
    public Node findSuccessor(Node root, int key)
    {
        Node successor = null;
        Node curr = root;

        while (curr != null)
        {
            if (key >= curr.value)
            {
                curr = curr.right;
            }
            else
            {
                successor = curr;
                curr = curr.left;
            }
        }

        return successor;
    }

    public static void main(String[] args)
    {
        _13PredecessorAndSuccessor tree =
                new _13PredecessorAndSuccessor();

        Node root = null;

        int[] values = {20, 10, 30, 5, 15, 25, 35};
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        /*
                BST formed:

                          20
                         /  \
                       10    30
                      / \   /  \
                     5  15 25  35
        */

        int key = 15;

        Node pred = tree.findPredecessor(root, key);
        Node succ = tree.findSuccessor(root, key);

        System.out.println("Key: " + key);

        if (pred != null)
        {
            System.out.println("Predecessor: " + pred.value);
        }
        else
        {
            System.out.println("Predecessor: null");
        }

        if (succ != null)
        {
            System.out.println("Successor: " + succ.value);
        }
        else
        {
            System.out.println("Successor: null");
        }
    }
}

/*
Dry run for predecessor (key = 15)

Start curr = 20
15 <= 20 → move left

curr = 10
15 > 10 → predecessor = 10 → move right

curr = 15
15 <= 15 → move left

curr = null
Stop

Predecessor = 10


Dry run for successor (key = 15)

Start curr = 20
15 < 20 → successor = 20 → move left

curr = 10
15 >= 10 → move right

curr = 15
15 >= 15 → move right

curr = null
Stop

Successor = 20
*/
