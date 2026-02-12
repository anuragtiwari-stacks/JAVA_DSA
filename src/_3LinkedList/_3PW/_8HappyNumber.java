/*
A happy number is a special kind of positive integer defined by the following process:

1-Start with any positive integer n.
2-Replace the number by the sum of the squares of its digits.

Repeat this process until either:
The number becomes 1 (which means the original number is happy), or
The process loops endlessly in a cycle that does not include 1 (which means the number is not happy).
If the process eventually reaches 1, the number is called a happy number.
 */
package _3LinkedList._3PW;

import java.util.HashSet;
import java.util.Set;

public class _8HappyNumber
{

    public static boolean isHappy(int n)
    {
        HashSet<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n))
        {
            seen.add(n);
            n = getSumOfSquares(n);
        }

        if(n==1)
        {
            return true;
        }
        return false;
    }

    private static int getSumOfSquares(int num)
    {
        int sum = 0;

        while (num > 0)
        {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int n1 = 19;
        System.out.println("Is " + n1 + " a happy number? " + isHappy(n1));

        int n2 = 2;
        System.out.println("Is " + n2 + " a happy number? " + isHappy(n2));
    }
}


/*
Initial:
n = 19
seen = {}

Loop condition: n != 1 AND n not in seen
=> 19 != 1 (true)
=> 19 not in {} (true)
=> Enter loop

Iteration 1:
seen.add(19)
seen = {19}
n = getSumOfSquares(19)
  = 1^2 + 9^2 = 1 + 81 = 82

Loop condition:
n = 82 != 1 (true)
82 not in {19} (true)
Enter loop

Iteration 2:
seen.add(82)
seen = {19, 82}
n = getSumOfSquares(82)
  = 8^2 + 2^2 = 64 + 4 = 68

Loop condition:
n = 68 != 1 (true)
68 not in {19, 82} (true)
Enter loop

Iteration 3:
seen.add(68)
seen = {19, 82, 68}
n = getSumOfSquares(68)
  = 6^2 + 8^2 = 36 + 64 = 100

Loop condition:
n = 100 != 1 (true)
100 not in {19, 82, 68} (true)
Enter loop

Iteration 4:
seen.add(100)
seen = {19, 82, 68, 100}
n = getSumOfSquares(100)
  = 1^2 + 0^2 + 0^2 = 1 + 0 + 0 = 1

Loop condition:
n = 1 == 1 (false) → Exit loop

Return:
n == 1 → true
*/