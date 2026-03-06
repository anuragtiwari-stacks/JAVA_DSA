package _02String;

/*
Trim Trailing Vowels
Leetcode-3856
*/

public class _9TrimTrailingVowels
{

    public String trimTrailingVowels(String s)
    {
        StringBuilder sb = new StringBuilder(s);

        for(int i = sb.length() - 1; i >= 0; i--)
        {
            char c = sb.charAt(i);

            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            {
                sb.deleteCharAt(i);
            }
            else
            {
                break;
            }
        }

        return sb.toString();
    }


    public static void main(String[] args)
    {
        _9TrimTrailingVowels obj = new _9TrimTrailingVowels();

        String s = "hellooouu";

        String result = obj.trimTrailingVowels(s);

        System.out.println("After Trimming Trailing Vowels: " + result);
    }

}


/*
possible pattern

hellooouu -> hell
codee     -> cod
java      -> jav

logic
start from end
if vowel -> deleteCharAt(i)
else -> break

Time Complexity  : O(n)
Space Complexity : O(n)   // because of StringBuilder

*/