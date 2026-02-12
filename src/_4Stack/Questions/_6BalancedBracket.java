package _4Stack.Questions;

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
            else if (ch == ')' || ch == '}' || ch == ']')
            {
                if (stack.isEmpty())
                {
                    return false;
                }

                char top = stack.pop();

                if (!isMatchingPair(top, ch))
                {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isMatchingPair(char open, char close)
    {
        if (open == '(' && close == ')')
        {
            return true;
        }
        else if (open == '{' && close == '}')
        {
            return true;
        }
        else if (open == '[' && close == ']')
        {
            return true;
        }

        return false;
    }

    public static void main(String[] args)
    {
        String expr1 = "{[()]}";
        String expr2 = "{[(])}";
        String expr3 = "((()))[]{}";
        String expr4 = "[({})](]";

        System.out.println(expr1 + " -> " + isBalanced(expr1));
        System.out.println(expr2 + " -> " + isBalanced(expr2));
        System.out.println(expr3 + " -> " + isBalanced(expr3));
        System.out.println(expr4 + " -> " + isBalanced(expr4));
    }

}
