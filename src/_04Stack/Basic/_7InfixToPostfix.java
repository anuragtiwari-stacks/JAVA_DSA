package _04Stack.Basic;

import java.util.Stack;

public class _7InfixToPostfix
{
    public static String infixToPostfix(String infix)
    {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++)
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
            else if (ch == '(')
            {
                stack.push(ch);
            }
            else if (ch == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            else
            {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch))
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

        return result.toString();
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
        System.out.println(infixToPostfix(infix));
    }
}

/*
==============================
LOGIC
==============================
1. Traverse infix LEFT → RIGHT.
2. Operand (A–Z, 0–9) → add directly to result.
3. '(' → push to stack.
4. ')' → pop from stack to result until '(' is found, then discard '('.
5. Operator:
   - while stack top has GREATER or EQUAL precedence,
     pop to result
   - push current operator.
6. After traversal, pop remaining operators.
7. Final string = POSTFIX expression.

==============================
DRY RUN
==============================
Infix = (A-B/C)*(A/K-L)

--------------------------------
Read '('
stack  = [(]
result = ""

--------------------------------
Read 'A'
result = A
--------------------------------
Read '-'
stack = [(, -]

--------------------------------
Read 'B'
result = AB

--------------------------------
Read '/'
'/' > '-' → push
stack = [(, -, /]

--------------------------------
Read 'C'
result = ABC

--------------------------------
Read ')'
pop '/' → result = ABC/
pop '-' → result = ABC/-
pop '(' → discard

stack = []

--------------------------------
Read '*'
stack = [*]

--------------------------------
Read '('
stack = [*, (]

--------------------------------
Read 'A'
result = ABC/-A

--------------------------------
Read '/'
stack = [*, (, /]

--------------------------------
Read 'K'
result = ABC/-AK

--------------------------------
Read '-'
'/' >= '-' → pop '/'
result = ABC/-AK/
stack = [*, (]

push '-'
stack = [*, (, -]

--------------------------------
Read 'L'
result = ABC/-AK/L

--------------------------------
Read ')'
pop '-' → result = ABC/-AK/L-
pop '(' → discard

stack = [*]

--------------------------------
End of expression
pop '*'
result = ABC/-AK/L-*

==============================
FINAL POSTFIX
==============================
ABC/-AK/L-*
==============================
*/
