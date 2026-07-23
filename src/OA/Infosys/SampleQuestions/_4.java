package OA.Infosys.SampleQuestions;

import java.util.Scanner;

class Main4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // n is given as String
        String n = sc.next();

        // String n -> int
        int num = Integer.parseInt(n);

        // Create limit
        // n = "1" -> "10"
        // n = "2" -> "100"
        // n = "3" -> "1000"

        StringBuilder sb = new StringBuilder("1");

        while (num != 0)
        {
            sb.append("0");
            num--;
        }

        // StringBuilder -> String -> int
        int digit = Integer.parseInt(sb.toString());

        int count = 0;

        // Check from 0 to digit - 1
        for (int i = 0; i < digit; i++)
        {
            // int i -> String -> StringBuilder
            StringBuilder sb1 = new StringBuilder(String.valueOf(i));

            // Make required digit format
            String st = valid(sb1, n);

            // Check adjacent digits
            boolean adj = checkAdjacent(st);

            // StringBuilder -> String -> int
            int number = Integer.parseInt(sb1.toString());

            // Calculate digit sum
            int sum = calculateSum(number);

            // Check both conditions
            if (adj && sum % 3 == 0)
            {
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }


    // Make number required length
    // Example:
    // n = "2"
    // 1 -> "01"
    // 5 -> "05"
    // 12 -> "12"

    static String valid(StringBuilder sb1, String n)
    {
        int requiredLength = Integer.parseInt(n);

        while (sb1.length() < requiredLength)
        {
            sb1.insert(0, "0");
        }

        return sb1.toString();
    }


    // Check adjacent digits
    // "12" -> true
    // "11" -> false
    // "001" -> false

    static boolean checkAdjacent(String st)
    {
        for (int i = 0; i < st.length() - 1; i++)
        {
            if (st.charAt(i) == st.charAt(i + 1))
            {
                return false;
            }
        }

        return true;
    }


    // Calculate sum using int
    // 123 -> 1 + 2 + 3 = 6

    static int calculateSum(int number)
    {
        int sum = 0;

        while (number != 0)
        {
            int digit = number % 10;

            sum = sum + digit;

            number = number / 10;
        }

        return sum;
    }
}