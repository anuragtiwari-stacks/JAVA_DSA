package _13Searching;

public class _7Sqrt
{
    public static int sqrt(int x)
    {
        if (x == 0 || x == 1)
        {
            return x;
        }

        int lo = 1;
        int hi = x;

        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;

            if (mid * mid == x)
            {
                return mid;
            }
            else if (mid * mid < x)
            {
                lo = mid + 1;
            }
            else
            {
                hi = mid - 1;
            }
        }

        return hi; // floor of sqrt(x)
    }

    public static void main(String[] args)
    {
        int num = 10;
        System.out.println("Square root of " + num + " is: " + sqrt(num));

        num = 81;
        System.out.println("Square root of " + num + " is: " + sqrt(num));

        num = 100;
        System.out.println("Square root of " + num + " is: " + sqrt(num));
    }
}

/*
====================== DRY RUN ======================

Case 1: x = 10

Initial:
lo = 1, hi = 10

Iteration 1:
mid = (1 + 10) / 2 = 5
5 * 5 = 25 > 10
→ hi = mid - 1 = 4

Iteration 2:
lo = 1, hi = 4
mid = (1 + 4) / 2 = 2
2 * 2 = 4 < 10
→ lo = mid + 1 = 3

Iteration 3:
lo = 3, hi = 4
mid = (3 + 4) / 2 = 3
3 * 3 = 9 < 10
→ lo = mid + 1 = 4

Iteration 4:
lo = 4, hi = 4
mid = (4 + 4) / 2 = 4
4 * 4 = 16 > 10
→ hi = mid - 1 = 3

Loop ends (lo > hi)

Return hi = 3
⇒ √10 = 3 (floor value)

----------------------------------------------------

Case 2: x = 81

lo = 1, hi = 81
mid = 41 → 41*41 > 81 → hi = 40
mid = 20 → 400 > 81 → hi = 19
mid = 10 → 100 > 81 → hi = 9
mid = 5  → 25 < 81  → lo = 6
mid = 7  → 49 < 81  → lo = 8
mid = 8  → 64 < 81  → lo = 9
mid = 9  → 81 == 81 → return 9

----------------------------------------------------

Case 3: x = 100

Exact square → returns 10

====================================================
*/
