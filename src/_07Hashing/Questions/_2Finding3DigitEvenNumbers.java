/*
2094. Finding 3-Digit Even Numbers

Find all unique 3-digit even numbers using HashMap
*/

package _07Hashing.Questions;

import java.util.HashMap;
import java.util.ArrayList;

public class _2Finding3DigitEvenNumbers
{
    public static int[] findEvenNumbers(int[] digits)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency of each digit
        for (int d : digits)
        {
            if (map.containsKey(d))
            {
                map.put(d, map.get(d) + 1);
            }
            else
            {
                map.put(d, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        // Step 2: Check all 3-digit even numbers
        for (int num = 100; num <= 999; num++)
        {
            if (num % 2 != 0)
            {
                continue;
            }

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            boolean possible = true;

            // copy original map
            HashMap<Integer, Integer> copy = new HashMap<>(map);

            // check digit a
            if (!copy.containsKey(a) || copy.get(a) == 0)
            {
                possible = false;
            }
            else
            {
                copy.put(a, copy.get(a) - 1);
            }

            // check digit b
            if (possible)
            {
                if (!copy.containsKey(b) || copy.get(b) == 0)
                {
                    possible = false;
                }
                else
                {
                    copy.put(b, copy.get(b) - 1);
                }
            }

            // check digit c
            if (possible)
            {
                if (!copy.containsKey(c) || copy.get(c) == 0)
                {
                    possible = false;
                }
                else
                {
                    copy.put(c, copy.get(c) - 1);
                }
            }

            if (possible)
            {
                list.add(num);
            }
        }

        // Step 3: Convert list to array
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] digits = {2, 1, 3, 0};

        int[] ans = findEvenNumbers(digits);

        for (int x : ans)
        {
            System.out.print(x + " ");
        }
    }
}

/*
Input:
digits = [2, 1, 3, 0]

Step 1: Frequency Map
map = {0=1, 1=1, 2=1, 3=1}

----------------------------------
Step 2: Check even numbers

num = 120
a=1, b=2, c=0
copy = {0=1, 1=1, 2=1, 3=1}

use 1 → copy {1=0}
use 2 → copy {2=0}
use 0 → copy {0=0}

possible = true → add 120

----------------------------------
num = 210
a=2, b=1, c=0
all available → add 210

----------------------------------
num = 230
a=2, b=3, c=0
all available → add 230

----------------------------------
num = 222
a=2, b=2, c=2
need 3 copies of 2 but only 1 available
possible = false → reject

----------------------------------
num = 320
a=3, b=2, c=0
all available → add 320

----------------------------------
Final List:
[120, 210, 230, 320]

 */