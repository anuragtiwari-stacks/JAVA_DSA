package _4Stack.Basic;

// Node class (separate, not inner)
class Node
{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

// Stack implementation using linked list
class MyLinkedListStack
{
    private Node top;

    public MyLinkedListStack()
    {
        top = null;
    }

    public void push(int value)
    {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed " + value);
    }

    public int pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack Underflow!");
            return -1;
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    public int peek()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty!");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public void display()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Stack elements: ");
        Node current = top;
        while (current != null)
        {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Main class to run the program
public class _2LinkedListStack
{
    public static void main(String[] args)
    {
        MyLinkedListStack stack = new MyLinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        stack.display();

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
