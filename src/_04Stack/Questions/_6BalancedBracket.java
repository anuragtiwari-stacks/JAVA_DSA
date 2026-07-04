package _04Stack.Questions;

import java.util.Stack;

public class _6BalancedBracket
{
    public static boolean isBalanced(String expression)
    {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++)
        {
            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[')
            {
                stack.push(ch);
            }

            if (ch == ']')
            {
                if (stack.isEmpty())
                {
                    return false;
                }

                char top = stack.pop();

                if (top != '[')
                {
                    return false;
                }
            }

            if (ch == ')')
            {
                if (stack.isEmpty())
                {
                    return false;
                }

                char top = stack.pop();

                if (top != '(')
                {
                    return false;
                }
            }

            if (ch == '}')
            {
                if (stack.isEmpty())
                {
                    return false;
                }

                char top = stack.pop();

                if (top != '{')
                {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args)
    {
        String expr1 = "{[()]}";
        String expr2 = "{[(])}";
        String expr3 = "((()))[]{}";
        String expr4 = "[({})](]";
        String expr5 = "(";
        String expr6 = "]";

        System.out.println(expr1 + " -> " + isBalanced(expr1));
        System.out.println(expr2 + " -> " + isBalanced(expr2));
        System.out.println(expr3 + " -> " + isBalanced(expr3));
        System.out.println(expr4 + " -> " + isBalanced(expr4));
        System.out.println(expr5 + " -> " + isBalanced(expr5));
        System.out.println(expr6 + " -> " + isBalanced(expr6));
    }
}