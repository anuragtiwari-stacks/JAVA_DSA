package _07Hashing.Questions;

/*
2094. Finding 3-Digit Even Numbers
*/

import java.util.*;

public class _2Finding3DigitEvenNumbers
{

    public int[] findEvenNumbers(int[] digits)
    {

        List<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency of digits
        for (int d : digits)
        {

            if (freq.containsKey(d))
            {
                freq.put(d, freq.get(d) + 1);
            }
            else
            {
                freq.put(d, 1);
            }

        }

        // Step 2: Check all 3-digit even numbers
        for (int num = 100; num <= 998; num += 2)
        {

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            HashMap<Integer, Integer> temp = new HashMap<>();

            if (temp.containsKey(a))
            {
                temp.put(a, temp.get(a) + 1);
            }
            else
            {
                temp.put(a, 1);
            }

            if (temp.containsKey(b))
            {
                temp.put(b, temp.get(b) + 1);
            }
            else
            {
                temp.put(b, 1);
            }

            if (temp.containsKey(c))
            {
                temp.put(c, temp.get(c) + 1);
            }
            else
            {
                temp.put(c, 1);
            }

            boolean valid = true;

            for (int key : temp.keySet())
            {

                if (!freq.containsKey(key) || temp.get(key) > freq.get(key))
                {
                    valid = false;
                    break;
                }

            }

            if (valid)
            {
                list.add(num);
            }

        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
        {
            ans[i] = list.get(i);
        }

        return ans;

    }

    // 🔥 IDE runnable main method
    public static void main(String[] args)
    {

        _2Finding3DigitEvenNumbers obj = new _2Finding3DigitEvenNumbers();

        int[] digits = {2, 1, 3, 0};

        int[] result = obj.findEvenNumbers(digits);

        System.out.println(Arrays.toString(result));

        // Output:
        // [102, 120, 130, 132, 210, 230, 302, 310, 312, 320]

    }

}


/*
==================== FULL DRY RUN ====================

Input:
digits = [2, 1, 3, 0]

------------------------------------------------------
Step 1: Frequency map

freq = {2=1, 1=1, 3=1, 0=1}

------------------------------------------------------
Step 2: Check numbers 100 to 998 (even only)

Example → 132

Digits:
1, 3, 2

temp = {1=1, 3=1, 2=1}

Compare with freq:
Valid ✔ → Add

------------------------------------------------------

Example → 222

Digits:
2, 2, 2

temp = {2=3}

Compare:
3 > 1 ❌

Invalid → Skip

------------------------------------------------------

Final Output:
[102, 120, 130, 132, 210, 230, 302, 310, 312, 320]

======================================================
*/