package _2Stack.Questions;

import java.util.Stack;

public class _5ReverseStackRecursive
{
    // Push an element at the bottom of the stack
    public static void pushAtBottom(Stack<Integer> stack, int value)
    {
        if (stack.isEmpty())
        {
            stack.push(value);
            return;
        }

        int top = stack.pop();
        pushAtBottom(stack, value);
        stack.push(top);
    }

    // Recursively reverse the stack
    public static void reverseStack(Stack<Integer> stack)
    {
        if (stack.isEmpty())
        {
            return;
        }

        int top = stack.pop();

        reverseStack(stack);

        pushAtBottom(stack, top);
    }

    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println("Original Stack: " + s);

        reverseStack(s);

        System.out.println("Reversed Stack: " + s);
    }
}

/*
Initial Stack: [10, 20, 30, 40]  (40 is the top)

reverseStack([10, 20, 30, 40])
  - stack not empty
  - pop top -> 40
  - stack now: [10, 20, 30]
  - call reverseStack([10, 20, 30])

reverseStack([10, 20, 30])
  - stack not empty
  - pop top -> 30
  - stack now: [10, 20]
  - call reverseStack([10, 20])

reverseStack([10, 20])
  - stack not empty
  - pop top -> 20
  - stack now: [10]
  - call reverseStack([10])

reverseStack([10])
  - stack not empty
  - pop top -> 10
  - stack now: []
  - call reverseStack([])

reverseStack([])
  - stack is empty, return immediately

Returning to reverseStack([10]):
  - stack = []
  - pushAtBottom([], 10)
    - stack empty -> push 10
    - stack = [10]

Returning to reverseStack([10, 20]):
  - stack = [10]
  - pushAtBottom([10], 20)
    - pop 10, stack = []
    - pushAtBottom([], 20)
      - stack empty -> push 20
      - stack = [20]
    - push 10 back
    - stack = [20, 10]

Returning to reverseStack([10, 20, 30]):
  - stack = [20, 10]
  - pushAtBottom([20, 10], 30)
    - pop 10, stack = [20]
    - pushAtBottom([20], 30)
      - pop 20, stack = []
      - pushAtBottom([], 30)
        - stack empty -> push 30
        - stack = [30]
      - push 20 back
      - stack = [30, 20]
    - push 10 back
    - stack = [30, 20, 10]

Returning to reverseStack([10, 20, 30, 40]):
  - stack = [30, 20, 10]
  - pushAtBottom([30, 20, 10], 40)
    - pop 10, stack = [30, 20]
    - pushAtBottom([30, 20], 40)
      - pop 20, stack = [30]
      - pushAtBottom([30], 40)
        - pop 30, stack = []
        - pushAtBottom([], 40)
          - stack empty -> push 40
          - stack = [40]
        - push 30 back
        - stack = [40, 30]
      - push 20 back
      - stack = [40, 30, 20]
    - push 10 back
    - stack = [40, 30, 20, 10]

Final reversed stack: [40, 30, 20, 10]
*/
