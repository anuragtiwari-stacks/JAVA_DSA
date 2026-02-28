package _06Tree._1BT;

import java.util.*;

public class _10InorderTraversal_Morris
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

    /*
    CONCEPT (Very Simple):

    Inorder = Left → Root → Right

    Morris Traversal does inorder WITHOUT:
    - recursion
    - stack

    Idea:
    - If left child is NULL → print node, go right
    - If left child exists →
        find inorder predecessor (rightmost of left subtree)

        If predecessor.right == NULL
            make temporary link (thread) to current
            move to left child

        Else (thread already exists)
            remove thread
            print current
            move to right child
    */

    static List<Integer> morrisInorder(Node root)
    {
        List<Integer> ans = new ArrayList<>();

        Node curr = root;

        while (curr != null)
        {
            if (curr.left == null)
            {
                ans.add(curr.data);
                curr = curr.right;
            }
            else
            {
                Node pred = curr.left;

                while (pred.right != null && pred.right != curr)
                {
                    pred = pred.right;
                }

                if (pred.right == null)
                {
                    pred.right = curr;      // create thread
                    curr = curr.left;
                }
                else
                {
                    pred.right = null;      // delete thread
                    ans.add(curr.data);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        /*
            Tree used (same as image):

                    1
                   / \
                  2   3
                     / \
                    4   5

            Expected Inorder:
            2 1 4 3 5
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        List<Integer> inorder = morrisInorder(root);

        System.out.println("Morris Inorder Traversal: " + inorder);
    }
}

/*
==========================
DRY RUN (STEP BY STEP)
==========================

Tree:

        1
       / \
      2   3
         / \
        4   5

--------------------------------
Start:
curr = 1
ans = []

--------------------------------
curr = 1
left exists → find predecessor
predecessor = 2

2.right == null
→ make thread: 2.right = 1
→ move curr = 2

--------------------------------
curr = 2
left == null
→ print 2
ans = [2]
→ move curr = 2.right (thread) → 1

--------------------------------
curr = 1
left exists → predecessor = 2
pred.right == curr (thread exists)

→ remove thread: 2.right = null
→ print 1
ans = [2, 1]
→ move curr = 3

--------------------------------
curr = 3
left exists → predecessor = 4

4.right == null
→ make thread: 4.right = 3
→ move curr = 4

--------------------------------
curr = 4
left == null
→ print 4
ans = [2, 1, 4]
→ move curr = 4.right (thread) → 3

--------------------------------
curr = 3
left exists → predecessor = 4
pred.right == curr

→ remove thread: 4.right = null
→ print 3
ans = [2, 1, 4, 3]
→ move curr = 5

--------------------------------
curr = 5
left == null
→ print 5
ans = [2, 1, 4, 3, 5]
→ move curr = null

--------------------------------
END

Final Output:
2 1 4 3 5

--------------------------------
KEY POINTS:
- No recursion
- No stack
- O(1) extra space
- Tree restored after traversal
--------------------------------
*/
