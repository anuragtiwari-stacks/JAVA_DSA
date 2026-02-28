package _04Stack.Questions;

import java.util.Stack;

public class _13
{
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public _13()
    {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val)
    {
        mainStack.push(val);

        if (minStack.isEmpty())
        {
            minStack.push(val);
        }
        else
        {
            int currentMin = minStack.peek();
            minStack.push(Math.min(val, currentMin));
        }
    }

    public void pop()
    {
        mainStack.pop();
        minStack.pop();
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
        _13 st = new _13();

        st.push(-2);
        st.push(0);
        st.push(-3);

        System.out.println(st.getMin()); // -3

        st.pop();
        st.pop();

        System.out.println(st.getMin()); // -2
    }
}

/*
DRY RUN:

Operation: push(-2)
mainStack = [-2]
minStack  = [-2]

Operation: push(0)
currentMin = -2
minStack.push(min(0, -2)) = -2
mainStack = [-2, 0]
minStack  = [-2, -2]

Operation: push(-3)
currentMin = -2
minStack.push(min(-3, -2)) = -3
mainStack = [-2, 0, -3]
minStack  = [-2, -2, -3]

--------------------------------
getMin() → -3
--------------------------------

Operation: pop()
mainStack.pop()
minStack.pop()

mainStack = [-2, 0]
minStack  = [-2, -2]

Operation: pop()
mainStack.pop()
minStack.pop()

mainStack = [-2]
minStack  = [-2]

--------------------------------
getMin() → -2
--------------------------------
*/
