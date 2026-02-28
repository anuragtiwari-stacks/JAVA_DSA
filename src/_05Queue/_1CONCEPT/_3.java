package _05Queue._1CONCEPT;

import java.util.Stack;

/*
LOGIC: Implement Queue using Two Stacks

Queue follows FIFO (First In First Out)
Stack follows LIFO (Last In First Out)

We use TWO stacks:
1. stackIn  → for enqueue (push)
2. stackOut → for dequeue (pop)

Operations:
1. enqueue(x):
   - Push element into stackIn

2. dequeue():
   - If stackOut is empty:
       - Move all elements from stackIn to stackOut
       - This reverses order
   - Pop from stackOut (front of queue)

3. peek():
   - Same logic as dequeue, but return top without removing
*/

public class _3
{

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public _3()
    {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void enqueue(int x)
    {
        stackIn.push(x);
    }

    public int dequeue()
    {
        if (stackOut.isEmpty())
        {
            while (!stackIn.isEmpty())
            {
                stackOut.push(stackIn.pop());
            }
        }

        if (stackOut.isEmpty())
        {
            System.out.println("Queue is empty");
            return -1;
        }

        return stackOut.pop();
    }

    public int peek()
    {
        if (stackOut.isEmpty())
        {
            while (!stackIn.isEmpty())
            {
                stackOut.push(stackIn.pop());
            }
        }

        if (stackOut.isEmpty())
        {
            System.out.println("Queue is empty");
            return -1;
        }

        return stackOut.peek();
    }

    public boolean isEmpty()
    {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    public static void main(String[] args)
    {
        _3 queue = new _3();

        // Pre-taken operations
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.peek());    // 20

        queue.enqueue(40);

        System.out.println(queue.dequeue()); // 20
        System.out.println(queue.dequeue()); // 30
        System.out.println(queue.dequeue()); // 40
    }
}

/*
========================
DRY RUN
========================

Initial:
stackIn  = []
stackOut = []

enqueue(10)
stackIn  = [10]

enqueue(20)
stackIn  = [10, 20]

enqueue(30)
stackIn  = [10, 20, 30]

dequeue():
stackOut empty → move all from stackIn to stackOut
stackOut = [30, 20, 10]
stackIn  = []

pop from stackOut → 10

peek():
stackOut = [30, 20]
peek → 20

enqueue(40)
stackIn = [40]

dequeue():
stackOut not empty
pop → 20

dequeue():
pop → 30

dequeue():
stackOut empty → move stackIn to stackOut
stackOut = [40]
pop → 40

Final:
stackIn  = []
stackOut = []

========================
QUEUE BEHAVIOR (FIFO)
10 → 20 → 30 → 40
========================
END
========================
*/
