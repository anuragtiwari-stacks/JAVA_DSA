package OA.Accenture.Strings;

// Question: Perform string compression (e.g., "aabcc" becomes "a2b1c2")

import java.util.*;

public class _9StringCompression
{
    public static void main(String[] args)
    {
        char[] chars = {'a', 'a', 'b', 'c', 'c'};

        System.out.println(compress(chars));
    }

    static int compress(char[] chars)
    {
        StringBuilder sb = new StringBuilder();

        int count = 1;
        int n = chars.length;

        for(int i = 1; i < n; i++)
        {
            if(chars[i] == chars[i - 1])
            {
                count++;
            }
            else
            {
                if(count == 1)
                {
                    sb.append(chars[i - 1]);
                    count = 1;
                }
                else
                {
                    sb.append(chars[i - 1]);
                    sb.append(count);

                    count = 1;
                }
            }
        }

        if(count == 1)
        {
            sb.append(chars[chars.length - 1]);
        }
        else
        {
            sb.append(chars[chars.length - 1]);
            sb.append(count);
        }

        int len = sb.length();

        for(int i = 0; i < len; i++)
        {
            chars[i] = sb.charAt(i);
        }

        return len;
    }
}