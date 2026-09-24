package OA.Accenture.Strings;

import java.util.Stack;

public class _22RemoveAdjacentDuplicates
{
    public static String removeDuplicates(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray())
        {
            if(!stack.isEmpty() && stack.peek() == ch)
            {
                stack.pop();
            }
            else
            {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        for(char ch : stack)
        {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args)
    {
        String s = "abbaca";

        System.out.println(removeDuplicates(s));
    }
}
