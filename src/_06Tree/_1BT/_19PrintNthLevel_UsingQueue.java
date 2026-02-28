package _06Tree._1BT;

import java.util.*;

public class _19PrintNthLevel_UsingQueue
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

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 1;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            if (currentLevel == level)
            {
                for (int i = 0; i < size; i++)
                {
                    System.out.print(queue.poll().data + " ");
                }
                return;
            }

            for (int i = 0; i < size; i++)
            {
                Node curr = queue.poll();

                if (curr.left != null)
                {
                    queue.add(curr.left);
                }

                if (curr.right != null)
                {
                    queue.add(curr.right);
                }
            }

            currentLevel++;
        }
    }

    public static void main(String[] args)
    {
        _19PrintNthLevel_UsingQueue tree =
                new _19PrintNthLevel_UsingQueue();

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

SIMPLE DRY RUN (using Queue, level = 3)

Initial:
Queue = [1]
currentLevel = 1

----------------------------
Level 1:
Queue size = 1
currentLevel != 3
Remove 1
Add children → 2, 3
Queue = [2, 3]
currentLevel = 2

----------------------------
Level 2:
Queue size = 2
currentLevel != 3
Remove 2 → add 4, 5
Remove 3 → add 8
Queue = [4, 5, 8]
currentLevel = 3

----------------------------
Level 3:
Queue size = 3
currentLevel == 3
Print all elements in queue:
4 5 8

STOP

FINAL OUTPUT:
Nodes at level 3: 4 5 8
*/
