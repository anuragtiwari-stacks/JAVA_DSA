package _05Queue._2QUESTIONS;

import java.util.*;

public class _7RevealCard
{
    public static int[] deckRevealedIncreasing(int[] deck)
    {
        Arrays.sort(deck);

        int n = deck.length;

        int[] result = new int[n];

        Queue<Integer> q = new LinkedList<>();

        // Store indices in queue
        for (int i = 0; i < n; i++)
        {
            q.add(i);
        }

        // Place cards
        for (int card : deck)
        {
            // Take front index
            int idx = q.remove();

            result[idx] = card;

            // Move next front to back
            if (!q.isEmpty())
            {
                q.add(q.remove());
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] deck = {17, 13, 11, 2, 3, 5, 7};

        int[] ans = deckRevealedIncreasing(deck);

        System.out.println(Arrays.toString(ans));
    }
}

/*
==================== DRY RUN ====================

Input:
deck = [17,13,11,2,3,5,7]

------------------------------------------------
Step 1: Sort the deck
------------------------------------------------

deck = [2,3,5,7,11,13,17]

------------------------------------------------
Step 2: Put all indices in queue
------------------------------------------------

q = [0,1,2,3,4,5,6]

result = [_,_,_,_,_,_,_]

================================================
card = 2
================================================

idx = q.remove() = 0

result[0] = 2

result = [2,_,_,_,_,_,_]

Queue after remove:
q = [1,2,3,4,5,6]

Move front to back:

q.remove() = 1
q.add(1)

q = [2,3,4,5,6,1]

================================================
card = 3
================================================

idx = q.remove() = 2

result[2] = 3

result = [2,_,3,_,_,_,_]

q = [3,4,5,6,1]

Move front to back:

remove() = 3
add(3)

q = [4,5,6,1,3]

================================================
card = 5
================================================

idx = q.remove() = 4

result[4] = 5

result = [2,_,3,_,5,_,_]

q = [5,6,1,3]

Move:

remove() = 5
add(5)

q = [6,1,3,5]

================================================
card = 7
================================================

idx = q.remove() = 6

result[6] = 7

result = [2,_,3,_,5,_,7]

q = [1,3,5]

Move:

remove() = 1
add(1)

q = [3,5,1]

================================================
card = 11
================================================

idx = q.remove() = 3

result[3] = 11

result = [2,_,3,11,5,_,7]

q = [5,1]

Move:

remove() = 5
add(5)

q = [1,5]

================================================
card = 13
================================================

idx = q.remove() = 1

result[1] = 13

result = [2,13,3,11,5,_,7]

q = [5]

(No move because only one element left)

================================================
card = 17
================================================

idx = q.remove() = 5

result[5] = 17

result = [2,13,3,11,5,17,7]

q = []

================================================
FINAL ANSWER
================================================

[2,13,3,11,5,17,7]

================================================
*/