package OA.Accenture.Strings;

// Question: Evaluate a string of binary digits joined by A/B/C operators standing for AND/OR/XOR, scanned left to right

public class _13BinaryStringEvaluation
{
    public static void main(String[] args)
    {
        String s = "1A0B1C1";

        System.out.println(evaluate(s));
    }

    static int evaluate(String s)
    {
        // s.charAt(0) returns '1' as a character, so subtracting '0' converts it into integer 1
        int result = s.charAt(0) - '0';

        for(int i = 1; i < s.length(); i += 2)
        {
            char operator = s.charAt(i);
            int value = s.charAt(i + 1) - '0';

            if(operator == 'A')
            {
                result = result & value;
            }
            else if(operator == 'B')
            {
                result = result | value;
            }
            else if(operator == 'C')
            {
                result = result ^ value;
            }
        }

        return result;
    }
}