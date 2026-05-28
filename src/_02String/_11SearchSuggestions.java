package _02String;

import java.util.*;

// LeetCode 1268 - Search Suggestions System
public class _11SearchSuggestions
{
    public static List<List<String>> suggestedProducts(String[] products, String searchWord)
    {
        Arrays.sort(products);

        List<List<String>> result = new ArrayList<>();

        String prefix = "";

        for (int i = 0; i < searchWord.length(); i++)
        {
            prefix += searchWord.charAt(i);

            List<String> temp = new ArrayList<>();

            for (String product : products)
            {
                if (product.startsWith(prefix))
                {
                    temp.add(product);
                }

                if (temp.size() == 3)
                {
                    break;
                }
            }

            result.add(temp);
        }

        return result;
    }

    public static void main(String[] args)
    {
        String[] products =
                {
                        "mobile",
                        "mouse",
                        "moneypot",
                        "monitor",
                        "mousepad"
                };

        String searchWord = "mouse";

        List<List<String>> ans = suggestedProducts(products, searchWord);

        System.out.println(ans);
    }
}