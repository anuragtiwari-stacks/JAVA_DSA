package _2Stack.Basic;

// Custom Stack implementation using array
class MyStack
{
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor
    public MyStack(int size)
    {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    // Push operation
    public void push(int value)
    {
        if (isFull())
        {
            System.out.println("Stack Overflow! Cannot push " + value);
            return;
        }
        stackArray[++top] = value;
        System.out.println("Pushed " + value + " to the stack.");
    }

    // Pop operation
    public int pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack Underflow! Cannot pop from an empty stack.");
            return -1;
        }
        return stackArray[top--];
    }

    // Peek at top element
    public int peek()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty. No elements to peek.");
            return -1;
        }
        return stackArray[top];
    }

    // Check if stack is empty
    public boolean isEmpty()
    {
        return (top == -1);
    }

    // Check if stack is full
    public boolean isFull()
    {
        return (top == maxSize - 1);
    }

    // Display stack contents
    public void display()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++)
        {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
}

// Main class
public class _1ArrayStack
{
    public static void main(String[] args)
    {
        MyStack s = new MyStack(5);  // Create a stack of size 5

        s.push(10);
        s.push(20);
        s.push(30);
        s.display();

        System.out.println("Top element is: " + s.peek());

        System.out.println("Popped element: " + s.pop());
        System.out.println("Popped element: " + s.pop());
        s.display();

        System.out.println("Is stack empty? " + s.isEmpty());
    }
}
