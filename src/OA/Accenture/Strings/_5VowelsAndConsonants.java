package OA.Accenture.Strings;

// Question: Count the number of vowels and consonants in a string

public class _5VowelsAndConsonants
{
    public static void main(String[] args)
    {
        String str = "Hello World";

        countVowelsAndConsonants(str);
    }

    static void countVowelsAndConsonants(String str)
    {
        int vowels = 0;
        int consonants = 0;

        for(int i = 0; i < str.length(); i++)
        {
            char ch = Character.toLowerCase(str.charAt(i));

            if(ch >= 'a' && ch <= 'z')
            {
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                {
                    vowels++;
                }
                else
                {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels = " + vowels);
        System.out.println("Consonants = " + consonants);
    }
}