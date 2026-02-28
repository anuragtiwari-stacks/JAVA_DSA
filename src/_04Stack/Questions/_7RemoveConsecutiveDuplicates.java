package _04Stack.Questions;

public class _7RemoveConsecutiveDuplicates
{
    public static String removeConsecutiveDuplicates(String str)
    {
        if (str == null || str.length() <= 1)
        {
            return str;
        }

        StringBuilder result = new StringBuilder();
        result.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++)
        {
            if (str.charAt(i) != str.charAt(i - 1))
            {
                result.append(str.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args)
    {
        String input1 = "aaabbbcccaaa";
        String input2 = "aabbccddeeff";
        String input3 = "abcde";

        System.out.println("Original: " + input1 + " -> Result: " + removeConsecutiveDuplicates(input1));
        System.out.println("Original: " + input2 + " -> Result: " + removeConsecutiveDuplicates(input2));
        System.out.println("Original: " + input3 + " -> Result: " + removeConsecutiveDuplicates(input3));
    }

}
