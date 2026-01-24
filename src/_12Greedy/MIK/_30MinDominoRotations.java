package _12Greedy.MIK;
// LeetCode 1007: Minimum Domino Rotations For Equal Row

public class _30MinDominoRotations
{
    public int minDominoRotations(int[] tops, int[] bottoms)
    {
        int val1 = tops[0];
        int val2 = bottoms[0];

        int ans1 = check(tops, bottoms, val1);
        int ans2 = check(tops, bottoms, val2);

        if (ans1 == -1 && ans2 == -1)
        {
            return -1;
        }
        if (ans1 == -1)
        {
            return ans2;
        }
        if (ans2 == -1)
        {
            return ans1;
        }

        return Math.min(ans1, ans2);
    }

    private int check(int[] tops, int[] bottoms, int target)
    {
        int rotateTop = 0;
        int rotateBottom = 0;

        for (int i = 0; i < tops.length; i++)
        {
            if (tops[i] != target && bottoms[i] != target)
            {
                return -1;
            }
            else if (tops[i] != target)
            {
                rotateTop++;
            }
            else if (bottoms[i] != target)
            {
                rotateBottom++;
            }
        }

        return Math.min(rotateTop, rotateBottom);
    }

    public static void main(String[] args)
    {
        _30MinDominoRotations obj = new _30MinDominoRotations();

        int[] tops = {2, 1, 2, 4, 2, 2};
        int[] bottoms = {5, 2, 6, 2, 3, 2};

        System.out.println("Output: " + obj.minDominoRotations(tops, bottoms));
    }
}


/*
===================== DRY RUN =====================

Input:
tops =    [2, 1, 2, 4, 2, 2]
bottoms = [5, 2, 6, 2, 3, 2]

Step-1:
val1 = tops[0] = 2
val2 = bottoms[0] = 5

Check for target = 2:

i=0: tops=2 (ok), bottoms=5, no rotation needed
i=1: tops=1 !=2 but bottoms=2 -> rotateTop++
i=2: tops=2 (ok)
i=3: tops=4 !=2 but bottoms=2 -> rotateTop++
i=4: tops=2 (ok)
i=5: tops=2 (ok)

rotateTop = 2
rotateBottom = 0

So rotations = min(2,0) = 0

Check for target = 5:
i=0 ok
i=1 tops=1,bottom=2 => both !=5 => return -1

So answer from val2 = -1

Final:
ans1 = 0
ans2 = -1

Output = 0

===================================================
*/
