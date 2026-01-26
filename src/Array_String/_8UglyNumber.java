package Array_String;

// LeetCode 263: Ugly Number
public class _8UglyNumber
{
    public boolean isUgly(int n)
    {
        if (n <= 0)
        {
            return false;
        }

        while (n % 2 == 0)
        {
            n = n / 2;
        }

        while (n % 3 == 0)
        {
            n = n / 3;
        }

        while (n % 5 == 0)
        {
            n = n / 5;
        }

        return n == 1;
    }

    public static void main(String[] args)
    {
        _8UglyNumber obj = new _8UglyNumber();

        System.out.println(obj.isUgly(6));   // true
        System.out.println(obj.isUgly(14));  // false
        System.out.println(obj.isUgly(1));   // true
    }
}

/*
---------------- DRY RUN ----------------

Input: n = 6

Step 1:
6 % 2 == 0 → n = 6 / 2 = 3

Step 2:
3 % 3 == 0 → n = 3 / 3 = 1

Step 3:
1 % 5 != 0 → stop

Final n == 1 ✔
Output: true

----------------------------------------

Input: n = 14

Step 1:
14 % 2 == 0 → n = 7

Step 2:
7 % 3 != 0
7 % 5 != 0

Final n != 1 ❌
Output: false

----------------------------------------
*/
