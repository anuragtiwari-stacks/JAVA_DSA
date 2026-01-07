package _3Queue._2QUESTIONS;

import java.util.*;

public class _7RevelCard
{

    public static int[] deckRevealedIncreasing(int[] deck)
    {
        int n = deck.length;

        // Step 1: Sort cards (smallest to largest)
        Arrays.sort(deck);

        // Step 2: Queue to store positions (indexes)
        Queue<Integer> indexQueue = new LinkedList<>();

        for (int i = 0; i < n; i++)
        {
            indexQueue.offer(i);
        }

        int[] result = new int[n];

        // Step 3: Place cards using queue simulation
        for (int card : deck)
        {
            int index = indexQueue.poll();
            result[index] = card;

            if (!indexQueue.isEmpty())
            {
                indexQueue.offer(indexQueue.poll());
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] deck = { 17, 13, 11, 2, 3, 5, 7 };

        int[] ans = deckRevealedIncreasing(deck);

        System.out.println(Arrays.toString(ans));
    }
}

/*
========================
QUESTION:
Reveal Cards In Increasing Order
(LeetCode #950)

RULES:
1. Reveal top card.
2. Remove it.
3. Move next top card to bottom.
4. Repeat.

Goal:
Arrange deck such that revealed cards come out in increasing order.

========================
DRY RUN
========================

Input deck:
[17, 13, 11, 2, 3, 5, 7]

Step 1: Sort deck
[2, 3, 5, 7, 11, 13, 17]

Step 2: Initialize index queue
indexQueue = [0, 1, 2, 3, 4, 5, 6]
result     = [_, _, _, _, _, _, _]

--------------------------------
card = 2
poll index = 0
result[0] = 2
move next index to back
indexQueue = [2, 3, 4, 5, 6, 1]

--------------------------------
card = 3
poll index = 2
result[2] = 3
move next index to back
indexQueue = [4, 5, 6, 1, 3]

--------------------------------
card = 5
poll index = 4
result[4] = 5
move next index to back
indexQueue = [6, 1, 3, 5]

--------------------------------
card = 7
poll index = 6
result[6] = 7
move next index to back
indexQueue = [3, 5, 1]

--------------------------------
card = 11
poll index = 3
result[3] = 11
move next index to back
indexQueue = [1, 5]

--------------------------------
card = 13
poll index = 1
result[1] = 13
move next index to back
indexQueue = [5]

--------------------------------
card = 17
poll index = 5
result[5] = 17
indexQueue empty → stop

--------------------------------
Final result array:
[2, 13, 3, 11, 5, 17, 7]

========================
OUTPUT:
[2, 13, 3, 11, 5, 17, 7]

========================
TIME COMPLEXITY:
O(n log n)  (sorting)

SPACE COMPLEXITY:
O(n)  (queue + result)

========================
END
========================
*/
