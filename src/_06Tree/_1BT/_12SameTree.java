package _06Tree._1BT;

public class _12SameTree
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

    boolean isSameTree(Node p, Node q)
    {
        // Both null
        if(p == null && q == null)
        {
            return true;
        }

        // Only one null
        if((p == null && q != null) ||
                (p != null && q == null))
        {
            return false;
        }

        // Both are not null
        if(p != null && q != null)
        {
            // Data mismatch
            if(p.data != q.data)
            {
                return false;
            }
        }

        // Check left and right subtree
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args)
    {
        _12SameTree tree = new _12SameTree();

        // Test Case 1 (Same Trees)
        Node a1 = new Node(1);
        a1.left = new Node(2);
        a1.right = new Node(3);

        Node a2 = new Node(1);
        a2.left = new Node(2);
        a2.right = new Node(3);

        System.out.println("Tree1 vs Tree2 (same): " + tree.isSameTree(a1, a2)
        );

        // Test Case 2 (Different Structure)
        Node b1 = new Node(1);
        b1.left = new Node(2);

        Node b2 = new Node(1);
        b2.right = new Node(2);

        System.out.println("Tree3 vs Tree4 (different): " + tree.isSameTree(b1, b2)
        );
    }
}

/*
===========================
DRY RUN
===========================

Tree1 & Tree2:

        1
       / \
      2   3

Call isSameTree(1,1)
→ values same
→ check left: isSameTree(2,2) → true
→ check right: isSameTree(3,3) → true
→ return true

--------------------------------

Tree3:

        1
       /
      2

Tree4:

        1
         \
          2

Call isSameTree(1,1)
→ values same
→ check left: isSameTree(2,null) → false
→ return false

--------------------------------
Final Output:
true
false
--------------------------------

CONCEPT:
- SameTree checks BOTH structure + values
- DFS recursion
*/
