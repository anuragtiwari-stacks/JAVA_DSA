package _06Tree._1BT;

public class _16LowestCommonAncestor
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

    Node lowestCommonAncestor(Node root, Node p, Node q)
    {
        if (root == null)
        {
            return null;
        }

        if (root == p || root == q)
        {
            return root;
        }

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
        {
            return root;
        }

        if (left != null)
        {
            return left;
        }

        else
        {
            return right;
        }
    }

    public static void main(String[] args)
    {
        _16LowestCommonAncestor tree = new _16LowestCommonAncestor();

        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(1);
        Node d = new Node(6);
        Node e = new Node(2);
        Node f = new Node(0);
        Node g = new Node(8);
        Node h = new Node(7);
        Node i = new Node(4);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        e.left = h;
        e.right = i;

        Node result = tree.lowestCommonAncestor(a, h, g);
        System.out.println("LCA of 7 and 8: " + result.data);
    }
}

/*
TREE DIAGRAM

         3
       /   \
      5     1
     / \   / \
    6   2 0   8
       / \
      7   4

DRY RUN (only one example)

Find LCA of nodes 7 and 8

lowestCommonAncestor(3,7,8)
→ left = LCA(5,7,8)
→ right = LCA(1,7,8)

LCA(5,7,8)
→ left = LCA(6,7,8) → null
→ right = LCA(2,7,8)

LCA(2,7,8)
→ left = LCA(7,7,8) → returns 7
→ right = LCA(4,7,8) → null
→ returns 7

So left subtree of 3 returns 7

LCA(1,7,8)
→ left = LCA(0,7,8) → null
→ right = LCA(8,7,8) → returns 8
→ returns 8

Now at node 3:
left = 7
right = 8
Both non-null → return 3

FINAL ANSWER:
LCA of 7 and 8 = 3
*/
