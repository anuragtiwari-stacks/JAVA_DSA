package _4Stack.Basic;

import java.util.Stack;

public class _10PrefixEvaluation
{
    public static int evaluatePrefix(String expr)
    {
        Stack<Integer> stack = new Stack<>();

        for (int i = expr.length() - 1; i >= 0; i--)
        {
            char ch = expr.charAt(i);

            if (ch == ' ')
            {
                continue;
            }

            if (Character.isDigit(ch))
            {
                stack.push(ch - '0');
            }
            else
            {
                int v1 = stack.pop();
                int v2 = stack.pop();

                if (ch == '+') stack.push(v1 + v2);
                else if (ch == '-') stack.push(v1 - v2);
                else if (ch == '*') stack.push(v1 * v2);
                else if (ch == '/') stack.push(v1 / v2);
            }
        }

        return stack.peek();
    }

    public static void main(String[] args)
    {
        String prefix = "-+9*26/84";
        System.out.println(evaluatePrefix(prefix));
    }
}

/*
==============================
LOGIC
==============================
1. Traverse PREFIX expression RIGHT → LEFT.
2. Operand → push to stack.
3. Operator:
   - pop two operands
   - apply operator
   - push result back.
4. Final stack top is the answer.

==============================
DRY RUN
==============================
Prefix = - + 9 * 2 6 / 8 4
(remove spaces → "-+9*26/84")

Traverse RIGHT → LEFT

Read '4'
stack = [4]

Read '8'
stack = [4, 8]

Read '/'
v1 = 8, v2 = 4
8 / 4 = 2
stack = [2]

Read '6'
stack = [2, 6]

Read '2'
stack = [2, 6, 2]

Read '*'
v1 = 2, v2 = 6
2 * 6 = 12
stack = [2, 12]

Read '9'
stack = [2, 12, 9]

Read '+'
v1 = 9, v2 = 12
9 + 12 = 21
stack = [2, 21]

Read '-'
v1 = 21, v2 = 2
21 - 2 = 19
stack = [19]

==============================
FINAL ANSWER = 19
==============================
*/
