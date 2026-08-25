package OA.Accenture.Strings;

// Question: Reverse the words in a sentence without reversing the letters within each word

public class _3ReverseWords
{
    public static void main(String[] args)
    {
        String str = "I love Java";

        System.out.println(reverseWords(str));
    }

    static String reverseWords(String str)
    {
        String[] words = str.split(" ");

        int left = 0;
        int right = words.length - 1;

        while(left < right)
        {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;

            left++;
            right--;
        }

        String result = "";

        for(int i = 0; i < words.length; i++)
        {
            result += words[i];

            if(i != words.length - 1)
            {
                result += " ";
            }
        }

        return result;
    }
}