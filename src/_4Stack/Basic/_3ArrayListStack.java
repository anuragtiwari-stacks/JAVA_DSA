/*
| Keyword/Part         | Meaning                                                                                                                                                       |
| -------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `private`            | Access modifier — means this variable can **only be accessed inside the class** `MyArrayListStack`. It hides the variable from other classes (encapsulation). |
| `ArrayList<Integer>` | Declares the type: it's a **Java ArrayList** that will store **`Integer` objects** (not `int`, because Java collections store objects, not primitives).       |
| `stack`              | This is just the **variable name**, representing your stack data structure.                                                                                   |
*/
package _4Stack.Basic;

import java.util.ArrayList;

// Stack implementation using ArrayList
class MyArrayListStack
{
    private ArrayList<Integer> stack;

    public MyArrayListStack()
    {
        stack = new ArrayList<>();
    }

    public void push(int value)
    {
        stack.add(value);
        System.out.println("Pushed " + value);
    }

    public int pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return stack.remove(stack.size() - 1);
    }

    public int peek()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public void display()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Stack elements: ");
        for (int i = 0; i < stack.size(); i++)
        {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }
}

// Main class to test stack
public class _3ArrayListStack
{
    public static void main(String[] args)
    {
        MyArrayListStack stack = new MyArrayListStack();

        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.display();

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        stack.display();

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
