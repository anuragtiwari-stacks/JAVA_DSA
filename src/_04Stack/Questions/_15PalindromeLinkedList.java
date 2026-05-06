package _04Stack.Questions;

import java.util.Stack;

class Nodes
{
    int data;
    Nodes next;

    Nodes(int data)
    {
        this.data = data;
        this.next = null;
    }
}

public class _15PalindromeLinkedList
{
    public static boolean isPalindrome(Nodes head)
    {
        Stack<Integer> st = new Stack<>();

        Nodes temp = head;

        // Push all nodes into stack
        while(temp != null)
        {
            st.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        // Compare stack with linked list
        while(temp != null)
        {
            if(temp.data != st.pop())
            {
                return false;
            }

            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args)
    {
        Nodes head = new Nodes(1);
        head.next = new Nodes(2);
        head.next.next = new Nodes(3);
        head.next.next.next = new Nodes(1);

        System.out.println(isPalindrome(head));
    }
}