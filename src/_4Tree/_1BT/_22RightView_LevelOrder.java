package _4Tree._1BT;

import java.util.*;

public class _22RightView_LevelOrder
{
    public static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
        }
    }

    void rightView(Node root)
    {
        if (root == null)
        {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 1; i <= size; i++)
            {
                Node curr = queue.poll();

                // last node of each level
                if (i == size)
                {
                    System.out.print(curr.data + " ");
                }

                if (curr.left != null)
                {
                    queue.add(curr.left);
                }

                if (curr.right != null)
                {
                    queue.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        _22RightView_LevelOrder tree = new _22RightView_LevelOrder();

        /*
                TREE USED (same as image)

                        1
                      /   \
                     2     3
                    / \     \
                   4   5     7
                      /
                     6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);

        root.right.right = new Node(7);

        System.out.print("Right View: ");
        tree.rightView(root);
    }
}

/*
TREE DIAGRAM

            1
          /   \
         2     3
        / \     \
       4   5     7
          /
         6

================================
SIMPLE & EASY DRY RUN
================================

Initial:
Queue = [1]

----------------------------
Level 1:
size = 1
poll → 1
i == size → print 1
add children → 2, 3

Queue = [2, 3]

----------------------------
Level 2:
size = 2

i = 1:
poll → 2
(not last)
add children → 4, 5

i = 2:
poll → 3
i == size → print 3
add child → 7

Queue = [4, 5, 7]

----------------------------
Level 3:
size = 3

i = 1:
poll → 4
(not last)

i = 2:
poll → 5
(not last)
add child → 6

i = 3:
poll → 7
i == size → print 7

Queue = [6]

----------------------------
Level 4:
size = 1
poll → 6
i == size → print 6

Queue empty → STOP

--------------------------------
RIGHT VIEW OUTPUT:
1 3 7 6
================================
*/
