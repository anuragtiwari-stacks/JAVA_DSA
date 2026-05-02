package _07Hashing.Questions;

import java.util.HashSet;

public class _5HappyNumber
{
    /*
     * 🔢 HAPPY NUMBER THEORY:
     *
     * Step 1: number ke digits lo
     * Step 2: unka square karo aur sum nikalo
     * Step 3: same process repeat karo
     *
     * ✔️ Agar end me 1 aa jata hai → Happy Number
     * ❌ Agar number repeat hone lagta hai → cycle → Not Happy
     *
     * Example:
     * 19 → 82 → 68 → 100 → 1 (Happy)
     * 2 → 4 → 16 → ... → 4 (repeat → Not Happy)
     *
     * 🔥 Why use HashSet?
     * - Ye visited numbers store karta hai
     * - Agar koi number dubara aaye → loop detect
     * - Infinite loop se bachne ke liye
     *
     * 💡 One line:
     * Set = repeat pakadne ke liye
     */

    public static boolean isHappy(int n)
    {

        HashSet<Integer> set = new HashSet<>();

        // jab tak 1 nahi milta
        while (n != 1)
        {

            // agar repeat ho gaya → cycle
            if (set.contains(n))
            {
                return false;
            }

            // number ko store karo
            set.add(n);

            int sum = 0;

            // digits ka square sum
            while (n > 0)
            {
                int digit = n % 10;     // last digit
                sum += digit * digit;  // square add
                n = n / 10;            // digit remove
            }

            // next iteration ke liye update
            n = sum;
        }

        // agar 1 mil gaya → happy
        return true;
    }

    public static void main(String[] args)
    {

        int n = 19;

        if (isHappy(n))
        {
            System.out.println(n + " is Happy Number");
        }
        else
        {
            System.out.println(n + " is Not Happy Number");
        }
    }
}