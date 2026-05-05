package _05Queue._2QUESTIONS;

import java.util.*;

public class _7RevealCard
{
    public static int[] deckRevealedIncreasing(int[] deck)
    {
        Arrays.sort(deck);

        int n = deck.length;
        int[] result = new int[n];

        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < n; i++)
        {
            dq.offer(i);
        }

        for (int card : deck)
        {
            int idx = dq.pollFirst();
            result[idx] = card;

            if (!dq.isEmpty())
            {
                dq.offerLast(dq.pollFirst());
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};

        int[] ans = deckRevealedIncreasing(deck);

        System.out.println("Result:");
        for (int x : ans)
        {
            System.out.print(x + " ");
        }
    }
}

/*
==================== DRY RUN ====================

Input:
deck = [17,13,11,2,3,5,7]

Step 1: Sort deck
deck = [2,3,5,7,11,13,17]

Step 2: Initialize deque with indices
dq = [0,1,2,3,4,5,6]

--------------------------------------------

card = 2
idx = 0 → result[0] = 2
dq = [1,2,3,4,5,6]
move front to back → dq = [2,3,4,5,6,1]

--------------------------------------------

card = 3
idx = 2 → result[2] = 3
dq = [3,4,5,6,1]
move → dq = [4,5,6,1,3]

--------------------------------------------

card = 5
idx = 4 → result[4] = 5
dq = [5,6,1,3]
move → dq = [6,1,3,5]

--------------------------------------------

card = 7
idx = 6 → result[6] = 7
dq = [1,3,5]
move → dq = [3,5,1]

--------------------------------------------

card = 11
idx = 3 → result[3] = 11
dq = [5,1]
move → dq = [1,5]

--------------------------------------------

card = 13
idx = 1 → result[1] = 13
dq = [5]
(no move)

--------------------------------------------

card = 17
idx = 5 → result[5] = 17
dq = []

--------------------------------------------

Final Result:
[2,13,3,11,5,17,7]

================================================
*/