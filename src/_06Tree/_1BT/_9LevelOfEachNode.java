package _06Tree._1BT;

import java.util.LinkedList;
import java.util.Queue;

public class _9LevelOfEachNode
{
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

    public static void levelOrder(Node root)
    {
        if(root == null)
        {
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            // Print one level
            for(int i = 0; i < size; i++)
            {
                Node current = q.poll();

                System.out.print(current.data + " ");

                if(current.left != null)
                {
                    q.offer(current.left);
                }

                if(current.right != null)
                {
                    q.offer(current.right);
                }
            }

            // Next line after one level
            System.out.println();
        }
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

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        levelOrder(root);
    }
}