package _02String;

// LeetCode 3838 - Weighted Word Mapping

public class _13WeightedWordMapping
{
    public static String mapWordWeights(String[] words, int[] weights)
    {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < words.length; i++)
        {
            int sum = 0;

            for(int j = 0; j < words[i].length(); j++)
            {
                sum += weights[words[i].charAt(j) - 'a'];
            }

            int modulo = sum % 26;

            sb.append((char)('z' - modulo));
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        String[] words = {"abcd", "def", "xyz"};

        int[] weights =
                {
                        5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7,
                        8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2
                };

        String ans = mapWordWeights(words, weights);

        System.out.println(ans);
    }
}