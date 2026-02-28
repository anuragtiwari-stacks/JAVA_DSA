package _06Tree._1BT;

public class _13SymmetricTree
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

    /*
    CONCEPT:
    A binary tree is symmetric if the left subtree is a mirror image
    of the right subtree.

    To check mirror:
    - left.data == right.data
    - left.left  ↔ right.right
    - left.right ↔ right.left
    */

    boolean isSymmetric(Node root)
    {
        if (root == null)
        {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    boolean isMirror(Node left, Node right)
    {
        if (left == null && right == null)
        {
            return true;
        }

        if (left == null || right == null)
        {
            return false;
        }

        if (left.data != right.data)
        {
            return false;
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args)
    {
        _13SymmetricTree tree = new _13SymmetricTree();

        /*
        ===========================
        SYMMETRIC TREE
        ===========================

                1
              /   \
             2     2
            / \   / \
           3   4 4   3
        */

        Node a = new Node(1);
        a.left = new Node(2);
        a.right = new Node(2);

        a.left.left = new Node(3);
        a.left.right = new Node(4);

        a.right.left = new Node(4);
        a.right.right = new Node(3);

        System.out.println("Is symmetric? " + tree.isSymmetric(a));

        /*
        ===========================
        NON-SYMMETRIC TREE
        ===========================

                1
              /   \
             2     2
              \
               3
        */

        Node x = new Node(1);
        x.left = new Node(2);
        x.right = new Node(2);
        x.left.right = new Node(3);

        System.out.println("Is symmetric? " + tree.isSymmetric(x));
    }
}

/*
===========================
PROPER DRY RUN
===========================

SYMMETRIC TREE:

        1
      /   \
     2     2
    / \   / \
   3   4 4   3

--------------------------------
Call: isSymmetric(1)
→ isMirror(2,2)

Check values: 2 == 2 ✔

→ isMirror(3,3)
   → children null → return true

→ isMirror(4,4)
   → children null → return true

Return true && true → true

--------------------------------
NON-SYMMETRIC TREE:

        1
      /   \
     2     2
      \
       3

Call: isMirror(2,2)

→ isMirror(null, null) → true
→ isMirror(3, null) → false

Return false

--------------------------------
FINAL OUTPUT:
Is symmetric? true
Is symmetric? false

--------------------------------
KEY POINTS:
- Uses recursion
- Mirror comparison
- Early termination if mismatch found
--------------------------------

INTERVIEW ONE-LINER:
A binary tree is symmetric if its left and right subtrees are mirror images of each other.
*/
