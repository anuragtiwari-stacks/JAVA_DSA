package _04Stack.Questions;

import java.util.Stack;

public class _13MinStack
{
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public _13MinStack()
    {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val)
    {
        mainStack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek())
        {
            minStack.push(val);
        }
    }

    public void pop()
    {
        int removed = mainStack.pop();

        if (removed == minStack.peek())
        {
            minStack.pop();
        }
    }

    public int top()
    {
        return mainStack.peek();
    }

    public int getMin()
    {
        return minStack.peek();
    }

    public static void main(String[] args)
    {
        _13MinStack st = new _13MinStack();

        st.push(-2);
        st.push(0);
        st.push(-3);

        System.out.println(st.getMin()); // -3
        st.pop();
        System.out.println(st.top());    // 0
        System.out.println(st.getMin()); // -2
    }
}

/*
INPUT:
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

--------------------------------
DRY RUN:
--------------------------------

Operation: MinStack()
mainStack = []
minStack  = []

--------------------------------
Operation: push(-2)
mainStack = [-2]
minStack  = [-2]

--------------------------------
Operation: push(0)
0 <= -2 ? NO
mainStack = [-2, 0]
minStack  = [-2]

--------------------------------
Operation: push(-3)
-3 <= -2 → push
mainStack = [-2, 0, -3]
minStack  = [-2, -3]

--------------------------------
Operation: getMin()
minStack.peek() = -3
OUTPUT: -3

--------------------------------
Operation: pop()
removed = -3
removed == minStack.peek() → pop minStack
mainStack = [-2, 0]
minStack  = [-2]

--------------------------------
Operation: top()
mainStack.peek() = 0
OUTPUT: 0

--------------------------------
Operation: getMin()
minStack.peek() = -2
OUTPUT: -2

--------------------------------
FINAL OUTPUT:
[null, null, null, null, -3, null, 0, -2]
--------------------------------
*/
