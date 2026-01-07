package _2Stack.Basic;

import java.util.Stack;

public class _6InfixWithoutParenthesis
{
    public static int evaluate(String s)
    {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);

            if (ch == ' ')
            {
                continue;
            }

            if (Character.isDigit(ch))
            {
                numStack.push(ch - '0');
            }
            else
            {
                while (!opStack.isEmpty() && precedence(opStack.peek()) >= precedence(ch))
                {
                    solve(numStack, opStack);
                }
                opStack.push(ch);
            }
        }

        while (!opStack.isEmpty())
        {
            solve(numStack, opStack);
        }

        return numStack.peek();
    }

    private static void solve(Stack<Integer> nums, Stack<Character> ops)
    {
        int v2 = nums.pop();
        int v1 = nums.pop();
        char op = ops.pop();

        if (op == '+') nums.push(v1 + v2);
        else if (op == '-') nums.push(v1 - v2);
        else if (op == '*') nums.push(v1 * v2);
        else if (op == '/') nums.push(v1 / v2);
    }

    private static int precedence(char op)
    {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static void main(String[] args)
    {
        String expr = "9-5+3*4/6";
        System.out.println(evaluate(expr));
    }
}

/*
==============================
LOGIC
==============================
1. Use two stacks:
   - numStack for numbers
   - opStack for operators
2. If digit → push into numStack
3. If operator:
   - while top operator has >= precedence
     solve (pop 2 nums + operator)
   - push current operator
4. At end, solve remaining operators
5. Result = top of numStack

==============================
DRY RUN
==============================
Expression: 9-5+3*4/6

Read 9
numStack = [9]
opStack  = []

Read -
opStack = [-]

Read 5
numStack = [9, 5]

Read +
'-' >= '+' → solve
v1=9, v2=5 → 4
numStack = [4]
opStack  = [+]

Read 3
numStack = [4, 3]

Read *
'*' > '+' → push
opStack = [+, *]

Read 4
numStack = [4, 3, 4]

Read /
'*' >= '/' → solve
v1=3, v2=4 → 12
numStack = [4, 12]
opStack  = [+]

push '/'
opStack = [+, /]

Read 6
numStack = [4, 12, 6]

End → solve remaining

12 / 6 = 2
numStack = [4, 2]

4 + 2 = 6
numStack = [6]

==============================
FINAL ANSWER = 6
==============================
*/
