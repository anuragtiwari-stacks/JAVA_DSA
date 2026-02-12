package _5Queue._2QUESTIONS;

public class _2StudentUnableToEatLunch
{
    public static int countStudents(int[] students, int[] sandwiches)
    {
        int countOnes = 0;
        int countZeros = 0;

        // Count preferences
        for (int student : students)
        {
            if (student == 1)
            {
                countOnes++;
            }
            else
            {
                countZeros++;
            }
        }

        // Process sandwiches
        for (int sandwich : sandwiches)
        {
            if (sandwich == 0)
            {
                if (countZeros == 0)
                {
                    return countOnes;
                }
                countZeros--;
            }
            else
            {
                if (countOnes == 0)
                {
                    return countZeros;
                }
                countOnes--;
            }
        }

        return 0;
    }

    public static void main(String[] args)
    {
        int[] students = { 1, 1, 1, 0 };
        int[] sandwiches = { 0, 0, 0, 1 };

        int result = countStudents(students, sandwiches);
        System.out.println("Students unable to eat: " + result);
    }
}

/*
========================
DRY RUN
========================

students   = [1, 1, 1, 0]
sandwiches = [0, 0, 0, 1]

Step 1: Count student preferences
--------------------------------
countOnes  = 3
countZeros = 1

Step 2: Process sandwiches
--------------------------

Sandwich 1 = 0
countZeros > 0
countZeros-- → countZeros = 0

Sandwich 2 = 0
countZeros == 0
→ No student wants sandwich 0

Return countOnes = 3

========================
OUTPUT
========================
Students unable to eat: 3
========================
END
========================
*/
