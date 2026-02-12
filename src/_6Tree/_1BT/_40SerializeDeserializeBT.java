package _6Tree._1BT;

import java.util.*;

/*
Serialize and Deserialize Binary Tree

Problem:
Convert a Binary Tree into a string (serialize)
and then rebuild the same Binary Tree from that string (deserialize).

Approach:
Preorder Traversal (Root Left Right)
Use "null" to represent empty nodes.
*/

public class _40SerializeDeserializeBT
{

    /*
    Logic:

    SERIALIZE:
    - Preorder traversal
    - Root -> Left -> Right
    - Agar node null hai → "null" store karo

    DESERIALIZE:
    - Same preorder order me tree wapas banao
    - "null" mile → return null
    - Otherwise node banao
      left subtree banao
      right subtree banao
    */

    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
        }
    }

    // ================= SERIALIZE =================
    static void serialize(Node root, StringBuilder sb)
    {
        if (root == null)
        {
            sb.append("null,");
            return;
        }

        sb.append(root.data).append(",");

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // ================= DESERIALIZE =================
    static Node deserialize(Queue<String> q)
    {
        String val = q.remove();

        if (val.equals("null"))
        {
            return null;
        }

        Node root = new Node(Integer.parseInt(val));

        root.left = deserialize(q);
        root.right = deserialize(q);

        return root;
    }

    public static void main(String[] args)
    {
        /*
                    1
                   / \
                  2   3
                     / \
                    4   5
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        // Serialize
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        String data = sb.toString();

        System.out.println("Serialized:");
        System.out.println(data);

        // Deserialize
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        Node newRoot = deserialize(q);

        // Verify by serializing again
        StringBuilder check = new StringBuilder();
        serialize(newRoot, check);

        System.out.println("After Deserialize:");
        System.out.println(check.toString());
    }

    /*
    Dry Run:

    Tree:
                    1
                   / \
                  2   3
                     / \
                    4   5

    Preorder Serialization:

    1
    2
    null
    null
    3
    4
    null
    null
    5
    null
    null

    Serialized String:
    "1,2,null,null,3,4,null,null,5,null,null,"

    Deserialization:
    - Read 1 → root
    - Read 2 → left child
    - Read null → 2.left = null
    - Read null → 2.right = null
    - Read 3 → right child
    - Read 4 → left of 3
    - Read null → 4.left
    - Read null → 4.right
    - Read 5 → right of 3
    - Read null → 5.left
    - Read null → 5.right

    Tree rebuilt successfully ✅
    */
}
