package _04Stack.Basic;

import java.util.Stack;

public class _6InfixWithParentheses
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
            else if (ch == '(')
            {
                opStack.push(ch);
            }
            else if (ch == ')')
            {
                while (!opStack.isEmpty() && opStack.peek() != '(')
                {
                    solve(numStack, opStack);
                }
                opStack.pop();
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
        String expr = "(9-5)+(3*4)/6";
        System.out.println(evaluate(expr));
    }
}

/*
==============================
LOGIC
==============================
1. Two stacks:
   - numStack: operands
   - opStack : operators
2. Digit → push to numStack
3. '(' → push to opStack
4. ')' → solve until '(' is found, then pop '('
5. Operator:
   - while opStack top has >= precedence, solve
   - push current operator
6. End → solve remaining operators
7. Answer = numStack.peek()

==============================
DRY RUN
==============================
Expression: (9-5)+(3*4)/6

Read '('
opStack = [(]

Read 9
numStack = [9]

Read '-'
opStack = [(, -]

Read 5
numStack = [9, 5]

Read ')'
solve 9 - 5 = 4
numStack = [4]
opStack = []
(pop '(')

Read '+'
opStack = [+]

Read '('
opStack = [+, (]

Read 3
numStack = [4, 3]

Read '*'
opStack = [+, (, *]

Read 4
numStack = [4, 3, 4]

Read ')'
solve 3 * 4 = 12
numStack = [4, 12]
opStack = [+]
(pop '(')

Read '/'
'+' < '/' → push
opStack = [+, /]

Read 6
numStack = [4, 12, 6]

End:
solve 12 / 6 = 2
numStack = [4, 2]

solve 4 + 2 = 6
numStack = [6]

==============================
FINAL ANSWER = 6
==============================
*/
