package _4Tree._1BT;

import java.util.*;

public class _23LeftView_LevelOrder
{
    // ================= NODE CLASS =================
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

    // ================= LEFT VIEW USING LEVEL ORDER =================
    void leftView(Node root)
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

                // FIRST node of each level → Left View
                if (i == 1)
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

    // ================= MAIN =================
    public static void main(String[] args)
    {
        _23LeftView_LevelOrder tree = new _23LeftView_LevelOrder();

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

        System.out.print("Left View: ");
        tree.leftView(root);
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
i == 1 → print 1
add children → 2, 3

Queue = [2, 3]

----------------------------
Level 2:
size = 2

i = 1:
poll → 2
i == 1 → print 2
add children → 4, 5

i = 2:
poll → 3
add child → 7

Queue = [4, 5, 7]

----------------------------
Level 3:
size = 3

i = 1:
poll → 4
i == 1 → print 4

i = 2:
poll → 5
add child → 6

i = 3:
poll → 7

Queue = [6]

----------------------------
Level 4:
size = 1
poll → 6
i == 1 → print 6

Queue empty → STOP

--------------------------------
LEFT VIEW OUTPUT:
1 2 4 6
================================
*/
