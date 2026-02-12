package _4Stack.Basic;

import java.util.Stack;

public class _8InfixToPrefix
{
    public static String infixToPrefix(String infix)
    {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = infix.length() - 1; i >= 0; i--)
        {
            char ch = infix.charAt(i);

            if (ch == ' ')
            {
                continue;
            }

            if (Character.isLetterOrDigit(ch))
            {
                result.append(ch);
            }
            else if (ch == ')')
            {
                stack.push(ch);
            }
            else if (ch == '(')
            {
                while (!stack.isEmpty() && stack.peek() != ')')
                {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            else
            {
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(ch))
                {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty())
        {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    private static int precedence(char ch)
    {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }

    public static void main(String[] args)
    {
        String infix = "(A-B/C)*(A/K-L)";
        System.out.println(infixToPrefix(infix));
    }
}

/*
==============================
LOGIC
==============================
1. Traverse infix expression from RIGHT to LEFT.
2. Operand → directly add to result.
3. ')' → push to stack.
4. '(' → pop until ')' is found.
5. Operator:
   - pop operators from stack having HIGHER precedence
   - then push current operator.
6. After traversal, pop remaining operators.
7. Reverse result to get PREFIX expression.

==============================
DRY RUN
==============================
Infix = (A-B/C)*(A/K-L)

Traverse RIGHT → LEFT

Read ')'
stack = [)]

Read 'L'
result = L

Read '-'
stack = [), -]

Read 'K'
result = LK

Read '/'
'/' > '-' → push
stack = [), -, /]

Read 'A'
result = LKA

Read '('
pop until ')'
result = LKA/-
stack = []

Read '*'
stack = [*]

Read ')'
stack = [*, )]

Read 'C'
result = LKA/-C

Read '/'
stack = [*, ), /]

Read 'B'
result = LKA/-CB

Read '-'
'/' > '-' → pop '/'
result = LKA/-CB/
stack = [*, )]

push '-'
stack = [*, ), -]

Read 'A'
result = LKA/-CB/A

Read '('
pop until ')'
result = LKA/-CB/A-
stack = [*]

End of scan
pop '*'
result = LKA/-CB/A-*

Reverse result:
*-A/BC-/AKL

==============================
FINAL PREFIX = *-A/BC-/AKL
==============================
*/


