package _16Backtracking;

// LeetCode 1079: Letter Tile Possibilities
import java.util.*;

public class _15LetterTilePossibilities
{
    public int numTilePossibilities(String tiles)
    {
        char[] arr = tiles.toCharArray();
        boolean[] used = new boolean[arr.length];
        Set<String> set = new HashSet<>();

        backtrack(arr, used, "", set);

        return set.size();
    }

    public void backtrack(char[] arr, boolean[] used, String curr, Set<String> set)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (used[i])
            {
                continue;
            }

            used[i] = true;                 // choose
            String next = curr + arr[i];

            set.add(next);                  // store non-empty sequence
            backtrack(arr, used, next, set); // explore

            used[i] = false;                // unchoose
        }
    }

    public static void main(String[] args)
    {
        _15LetterTilePossibilities obj = new _15LetterTilePossibilities();

        String tiles = "AAB";

        System.out.println(obj.numTilePossibilities(tiles));
    }
}

/*
---------------- DRY RUN ----------------

tiles = "AAB"

Start:
curr = ""

Pick A → "A"
Pick A → "AA"
Pick B → "AAB"

Backtrack
Pick B → "AB"

Pick second A (different index)
→ duplicates handled by HashSet

Pick B → "B"
Pick A → "BA"
Pick A → "BAA"

Unique sequences:
[A, AA, AAB, AB, B, BA, BAA]

Total = 7

----------------------------------------
*/
