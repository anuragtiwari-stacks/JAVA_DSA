// LeetCode 2038 - Remove Colored Pieces if Both Neighbors are the Same Color

package _12Greedy.MIK;

public class _17RemoveColoredPieces
{
    public boolean winnerOfGame(String colors)
    {
        int countA = 0;
        int countB = 0;

        for (int i = 1; i < colors.length() - 1; i++)
        {
            if (colors.charAt(i - 1) == 'A' && colors.charAt(i) == 'A' && colors.charAt(i + 1) == 'A')
            {
                countA++;
            }

            if (colors.charAt(i - 1) == 'B' && colors.charAt(i) == 'B' && colors.charAt(i + 1) == 'B')
            {
                countB++;
            }
        }

        return countA > countB;
    }

    public static void main(String[] args)
    {
        _17RemoveColoredPieces obj = new _17RemoveColoredPieces();

        String colors = "AAABABB";
        boolean result = obj.winnerOfGame(colors);

        System.out.println("Input Colors: " + colors);
        System.out.println("Alice wins? " + result);
    }
}

/*
==================== DRY RUN ====================

colors = "AAABABB"

Indices: 0 1 2 3 4 5 6
Chars : A A A B A B B

Loop from i = 1 to i = 5

i = 1 → chars[0..2] = "AAA" → countA = 1
i = 2 → chars[1..3] = "AAB" → no change
i = 3 → chars[2..4] = "ABA" → no change
i = 4 → chars[3..5] = "BAB" → no change
i = 5 → chars[4..6] = "ABB" → no change (only double B, not triple)

Final counts:
    countA = 1
    countB = 0

So countA > countB → true → therefore Alice wins.

Console Output:
    Input Colors: AAABABB
    Alice wins? true

=================================================
*/
