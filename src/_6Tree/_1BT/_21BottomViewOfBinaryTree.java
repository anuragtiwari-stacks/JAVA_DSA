package _6Tree._1BT;

import java.util.*;

public class _21BottomViewOfBinaryTree
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

    // Pair class to store node with Horizontal Distance (HD)
    static class Pair
    {
        Node node;
        int hd;

        Pair(Node node, int hd)
        {
            this.node = node;
            this.hd = hd;
        }
    }

    // ================= BOTTOM VIEW LOGIC =================
    void bottomView(Node root)
    {
        if (root == null)
        {
            return;
        }

        // Map stores the LAST node for each HD
        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty())
        {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            // Overwrite value at same HD (bottom-most node wins)
            map.put(hd, node.data);

            if (node.left != null)
            {
                queue.add(new Pair(node.left, hd - 1));
            }

            if (node.right != null)
            {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Print Bottom View
        for (int val : map.values())
        {
            System.out.print(val + " ");
        }
    }

    // ================= MAIN =================
    public static void main(String[] args)
    {
        _21BottomViewOfBinaryTree tree = new _21BottomViewOfBinaryTree();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(5);

        System.out.print("Bottom View: ");
        tree.bottomView(root);
    }
}

/*
TREE DIAGRAM (with Horizontal Distance - HD)

              1 (HD=0)
            /     \
       2 (HD=-1)  3 (HD=+1)
            \         \
          4 (HD=0)   5 (HD=+2)

========================================
SIMPLE & EASY DRY RUN (ONE EXAMPLE)
========================================

Initial:
Queue = [(1,0)]
Map = {}

----------------------------------------
Step 1:
Remove (1,0)
Map.put(0,1)

Add children:
2 with HD -1
3 with HD +1

Queue = [(2,-1), (3,+1)]

----------------------------------------
Step 2:
Remove (2,-1)
Map.put(-1,2)

Add child:
4 with HD 0

Queue = [(3,+1), (4,0)]

----------------------------------------
Step 3:
Remove (3,+1)
Map.put(+1,3)

Add child:
5 with HD +2

Queue = [(4,0), (5,+2)]

----------------------------------------
Step 4:
Remove (4,0)
Map.put(0,4)   // overwrite 1 → bottom node at HD 0

Queue = [(5,+2)]

----------------------------------------
Step 5:
Remove (5,+2)
Map.put(+2,5)

Queue empty → STOP

----------------------------------------
Final Map (sorted by HD):
HD  -1   0   +1   +2
     2   4    3    5

BOTTOM VIEW OUTPUT:
2 4 3 5
========================================
*/
