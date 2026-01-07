package _4Tree._1BT;

public class _14DiameterOfBinaryTree
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

    int diameter = 0;

    /*
    This function returns HEIGHT of tree
    and updates diameter at the same time
    */
    int height(Node root)
    {
        if (root == null)
        {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        int currDiameter = lh + rh + 1;
        diameter = Math.max(diameter, currDiameter);

        return Math.max(lh, rh) + 1;
    }

    int getDiameter(Node root)
    {
        height(root);
        return diameter;
    }

    public static void main(String[] args)
    {
        _14DiameterOfBinaryTree tree = new _14DiameterOfBinaryTree();

        /*
            TREE:

                    1
                   / \
                  2   3
                 / \
                4   5

            Longest Path:
            4 → 2 → 1 → 3
            Diameter = 4 nodes
        */

        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        int result = tree.getDiameter(a);
        System.out.println("Diameter of Tree: " + result);
    }
}

/*
===========================
PROPER DRY RUN (MATCHING IMAGE)
===========================

At Node 4:
lh = 0, rh = 0
diameter = max(0, 0+0+1) = 1
return height = 1

At Node 5:
lh = 0, rh = 0
diameter = max(1, 1) = 1
return height = 1

--------------------------------
At Node 2:
lh = 1 (from 4)
rh = 1 (from 5)

currDiameter = 1 + 1 + 1 = 3
diameter = max(1, 3) = 3

return height = max(1,1) + 1 = 2

--------------------------------
At Node 3:
lh = 0, rh = 0
diameter = max(3, 1) = 3
return height = 1

--------------------------------
At Node 1:
lh = 2
rh = 1

currDiameter = 2 + 1 + 1 = 4
diameter = max(3, 4) = 4

return height = 3

--------------------------------
FINAL ANSWER:
Diameter = 4

--------------------------------
IMPORTANT:
- Diameter is counted in NUMBER OF NODES
- For EDGES → answer = diameter - 1
--------------------------------

TIME COMPLEXITY:
O(n)  ✅ (single traversal)

SPACE COMPLEXITY:
O(h)  (recursion stack)
*/
