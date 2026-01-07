package _3Queue._2QUESTIONS;

/*
QUESTION:
First Negative Integer in Every Window of Size K

SIMPLE SLIDING WINDOW LOGIC:
1. Window size = k
2. Har window ke andar left se right check karo
3. Jo pehla negative mile, wahi print
4. Agar koi negative na mile, 0 print
*/

public class _5FirstNegativeInWindow
{

    public static void firstNegative(int[] arr, int k)
    {
        int n = arr.length;

        for (int i = 0; i <= n - k; i++)
        {
            boolean found = false;

            // check current window
            for (int j = i; j < i + k; j++)
            {
                if (arr[j] < 0)
                {
                    System.out.print(arr[j] + " ");
                    found = true;
                    break;
                }
            }

            if (!found)
            {
                System.out.print("0 ");
            }
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;

        firstNegative(arr, k);
    }
}

/*
========================
DRY RUN
========================

Array = [12, -1, -7, 8, -15, 30, 16, 28]
k = 3

Window 1: [12, -1, -7]
First negative = -1

Window 2: [-1, -7, 8]
First negative = -1

Window 3: [-7, 8, -15]
First negative = -7

Window 4: [8, -15, 30]
First negative = -15

Window 5: [-15, 30, 16]
First negative = -15

Window 6: [30, 16, 28]
No negative → 0

FINAL OUTPUT:
-1 -1 -7 -15 -15 0
========================
END
========================
*/
