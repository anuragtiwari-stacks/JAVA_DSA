package _4Stack.Basic;

import java.util.Stack;

public class _9PostfixEvaluation
{
    public static int evaluatePostfix(String expr)
    {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < expr.length(); i++)
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
                int v2 = stack.pop();
                int v1 = stack.pop();

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
        String postfix = "92*6+84/-";
        System.out.println(evaluatePostfix(postfix));
    }
}

/*
==============================
LOGIC
==============================
1. Traverse POSTFIX expression LEFT → RIGHT.
2. Operand → push to stack.
3. Operator:
   - pop TWO operands
   - apply operator (v1 op v2)
   - push result back.
4. Final stack top is the answer.

==============================
DRY RUN
==============================
Postfix = 9 2 * 6 + 8 4 / -
(remove spaces → "92*6+84/-")

Read '9'
stack = [9]

Read '2'
stack = [9, 2]

Read '*'
v1 = 9, v2 = 2
9 * 2 = 18
stack = [18]

Read '6'
stack = [18, 6]

Read '+'
v1 = 18, v2 = 6
18 + 6 = 24
stack = [24]

Read '8'
stack = [24, 8]

Read '4'
stack = [24, 8, 4]

Read '/'
v1 = 8, v2 = 4
8 / 4 = 2
stack = [24, 2]

Read '-'
v1 = 24, v2 = 2
24 - 2 = 22
stack = [22]

==============================
FINAL ANSWER = 22
==============================
*/
