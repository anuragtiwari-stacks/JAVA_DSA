package _3LinkedList._3PW;

public class _10SortLinkedList
{
    static class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    // Function to sort the linked list (Bubble sort)
    public static Node sortList(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node current = head;
        while (current != null)
        {
            Node index = current.next;

            while (index != null)
            {
                if (current.data > index.data)
                {
                    // Swap data
                    int temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }

            current = current.next;
        }

        return head;
    }

    // Utility function to print the list
    public static void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // Driver code
    public static void main(String[] args)
    {
        Node head = new Node(4);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(3);

        System.out.print("Original List: ");
        printList(head);

        head = sortList(head);

        System.out.print("Sorted List: ");
        printList(head);
    }
}
