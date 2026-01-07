package _4Tree._1BT;

import java.util.LinkedList;
import java.util.Queue;

public class
_9LevelOfEachNode
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

    void printLevelOfNodes(Node root)
    {
        if (root == null)
        {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 1;

        while (!q.isEmpty())
        {
            int size = q.size();

            System.out.print("Level " + level + ": ");

            for (int i = 0; i < size; i++)
            {
                Node current = q.poll();
                System.out.print(current.data + " ");

                if (current.left != null)
                {
                    q.add(current.left);
                }

                if (current.right != null)
                {
                    q.add(current.right);
                }
            }

            System.out.println();
            level++;
        }
    }

    public static void main(String[] args)
    {
        _9LevelOfEachNode tree = new _9LevelOfEachNode();

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        tree.printLevelOfNodes(a);
    }
}

/*
DRY RUN

Tree Structure:

        1
       / \
      2   3
     / \
    4   5

--------------------------------
Initial:
Queue = [1]
level = 1

--------------------------------
Iteration 1:
size = 1
print: Level 1: 1
enqueue children → 2, 3
Queue = [2, 3]
level = 2

--------------------------------
Iteration 2:
size = 2
print: Level 2: 2 3
enqueue children of 2 → 4, 5
Queue = [4, 5]
level = 3

--------------------------------
Iteration 3:
size = 2
print: Level 3: 4 5
no children
Queue = []
level = 4

--------------------------------
Final Output:

Level 1: 1
Level 2: 2 3
Level 3: 4 5
--------------------------------

NOTE:
- Level is counted from root (root level = 1)
- Implemented using Queue (BFS)
*/
