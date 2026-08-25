package OA.Accenture.Strings;

// Question: Check for balanced parentheses in an expression

import java.util.Stack;

public class _8BalancedParentheses
{
    public static void main(String[] args)
    {
        String s = "{[()]}";

        System.out.println(isValid(s));
    }

    static boolean isValid(String s)
    {
        Stack<Character> stack = new Stack<>();

        int n = s.length();

        for(int i = 0; i < n; i++)
        {
            char ch = s.charAt(i);

            if(ch == '(')
            {
                stack.push(ch);
            }

            else if(ch == '{')
            {
                stack.push(ch);
            }

            else if(ch == '[')
            {
                stack.push(ch);
            }

            else if(ch == ')')
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                else
                {
                    char top = stack.pop();

                    if(top != '(')
                    {
                        return false;
                    }
                }
            }

            else if(ch == '}')
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                else
                {
                    char top = stack.pop();

                    if(top != '{')
                    {
                        return false;
                    }
                }
            }

            else if(ch == ']')
            {
                if(stack.isEmpty())
                {
                    return false;
                }
                else
                {
                    char top = stack.pop();

                    if(top != '[')
                    {
                        return false;
                    }
                }
            }
        }

        if(!stack.isEmpty())
        {
            return false;
        }

        return true;
    }
}