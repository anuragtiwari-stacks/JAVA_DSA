package OA.Accenture.Strings;

import java.util.*;

// Question: Find the first-last character combination
// having the highest frequency

public class _21FirstLastCharacterFrequency
{
    public static void main(String[] args)
    {
        String str = "apple angle ball bottle axe";

        System.out.println(findCombination(str));
    }

    public static String findCombination(String str)
    {
        String []arr = str.split("\\s+");
        int n = arr.length;

        HashMap<StringBuilder,Integer>map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String s = arr[i];
            char ch1 = s.charAt(0);
            char ch2 = s.charAt(s.length()-1);

            StringBuilder sb = new StringBuilder();
            sb.append(ch1);
            sb.append(ch2);

            if(!map.containsKey(sb))
            {
                map.put(sb,1);
            }

            else
            {
                map.put(sb,map.get(sb)+1);
            }
        }

        int max = 0;
        StringBuilder result = new StringBuilder();
        for(StringBuilder st: map.keySet())
        {
            if(map.get(st)>max)
            {
                max = map.get(st);
                result = st;
            }
        }
        String ans = result.toString();
        return ans;
    }
}