package _4Tree._2BST;

public class _15MinDistanceBetweenBSTNodes
{
    static class Node
    {
        int value;
        Node left, right;

        Node(int value)
        {
            this.value = value;
        }
    }

    Node prev = null;

    public Node insert(Node root, int value)
    {
        if (root == null)
        {
            return new Node(value);
        }

        if (value < root.value)
        {
            root.left = insert(root.left, value);
        }
        else if (value > root.value)
        {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Use (inorder + prev)
    public int minDistance(Node root)
    {
        if (root == null)
        {
            return Integer.MAX_VALUE;
        }

        int ans = Integer.MAX_VALUE;

        // 1. Left subtree
        if (root.left != null)
        {
            int leftMin = minDistance(root.left);
            ans = Math.min(ans, leftMin);
        }

        // 2. Current node vs previous node
        if (prev != null)
        {
            ans = Math.min(ans, root.value - prev.value);
        }

        prev = root;

        // 3. Right subtree
        if (root.right != null)
        {
            int rightMin = minDistance(root.right);
            ans = Math.min(ans, rightMin);
        }

        return ans;
    }

    public static void main(String[] args)
    {
        _15MinDistanceBetweenBSTNodes tree = new _15MinDistanceBetweenBSTNodes();

        Node root = null;

        int[] values = {83, 62, 88, 42, 82, 52};
        for (int val : values)
        {
            root = tree.insert(root, val);
        }

        /*
                BST formed (same as image):

                          83
                         /  \
                       62    88
                      /  \
                    42    82
                      \
                       52
        */

        int ans = tree.minDistance(root);
        System.out.println("Minimum distance between BST nodes = " + ans);
    }
}

/*
Dry run (exact logic from image)

Inorder traversal order (sorted):
42 52 62 82 83 88

prev = null

Visit 42
prev = 42

Visit 52
diff = 52 - 42 = 10
ans = 10
prev = 52

Visit 62
diff = 62 - 52 = 10
ans = 10
prev = 62

Visit 82
diff = 82 - 62 = 20
ans = 10
prev = 82

Visit 83
diff = 83 - 82 = 1
ans = 1
prev = 83

Visit 88
diff = 88 - 83 = 5
ans = 1
prev = 88

Final minimum distance = 1
*/
