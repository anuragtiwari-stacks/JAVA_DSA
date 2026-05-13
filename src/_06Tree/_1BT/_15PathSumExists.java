package _06Tree._1BT;

public class _15PathSumExists
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

    public static boolean hasPathSum(Node root, int targetSum)
    {
        // Null node
        if(root == null)
        {
            return false;
        }

        // Leaf node
        if(root.left == null && root.right == null)
        {
            return targetSum == root.data;
        }

        // Remaining target
        int remainingSum = targetSum - root.data;

        // Check left subtree
        boolean left = hasPathSum(root.left, remainingSum);

        // Check right subtree
        boolean right = hasPathSum(root.right, remainingSum);

        // Any one path true
        return left || right;
    }

    public static void main(String[] args)
    {
        _15PathSumExists tree = new _15PathSumExists();

        Node a = new Node(5);
        Node b = new Node(4);
        Node c = new Node(8);
        Node d = new Node(11);
        Node e = new Node(13);
        Node f = new Node(4);
        Node g = new Node(7);
        Node h = new Node(2);
        Node i = new Node(1);

        a.left = b;
        a.right = c;
        b.left = d;
        d.left = g;
        d.right = h;
        c.left = e;
        c.right = f;
        f.right = i;

        System.out.println(tree.hasPathSum(a, 22)); // true
    }
}

/*
TREE DIAGRAM

        5
       / \
      4   8
     /   / \
   11   13  4
   / \         \
  7   2         1

DRY RUN (only one example)

target = 22

hasPathSum(5,22)
→ remaining = 17

hasPathSum(4,17)
→ remaining = 13

hasPathSum(11,13)
→ remaining = 2

hasPathSum(7,2)
→ leaf → 7 != 2 → false

hasPathSum(2,2)
→ leaf → 2 == 2 → true

false || true → true

FINAL OUTPUT → true
*/
