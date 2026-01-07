package _15Recursion;

/*
QUESTION:
You are given a maze of size n x m.
You are starting from the top-left cell (0,0).
You want to reach the bottom-right cell (n-1, m-1).

You can move only in two directions:
1. Horizontal move (H) → right
2. Vertical move (V) → down

Write a recursive program to print all possible paths.
*/

public class _2MazePath
{
    public static void main(String[] args)
    {
        int n = 3;
        int m = 3;

        printMazePath(0, 0, n - 1, m - 1, "");
    }

    static void printMazePath(int sr, int sc, int dr, int dc, String path)
    {
        if (sr == dr && sc == dc)
        {
            System.out.println(path);
            return;
        }

        if (sr > dr || sc > dc)
        {
            return;
        }

        printMazePath(sr, sc + 1, dr, dc, path + "H");
        printMazePath(sr + 1, sc, dr, dc, path + "V");
    }
}

/*
==================== SIMPLE DRY RUN (BEGINNER FRIENDLY) ====================

Maze Size: 3 x 3
Start: (0,0)
Destination: (2,2)

Meaning:
H → Right move
V → Down move

---------------------------------------------------------------------------
STEP 1:
main() call karta hai:
printMazePath(0, 0, 2, 2, "")

path = ""

---------------------------------------------------------------------------
STEP 2:
At (0,0)
2 choices:
1) Right → H → (0,1)
2) Down  → V → (1,0)

---------------------------------------------------------------------------
STEP 3:
Path = "H"
At (0,1)

Again 2 choices:
1) H → (0,2)
2) V → (1,1)

---------------------------------------------------------------------------
STEP 4:
Path = "HH"
At (0,2)

Only V possible:
printMazePath(1,2,"HHV")

---------------------------------------------------------------------------
STEP 5:
Path = "HHV"
At (1,2)

Only V possible:
printMazePath(2,2,"HHVV")

Destination reached → PRINT "HHVV"

---------------------------------------------------------------------------
STEP 6:
Backtrack and explore other paths:

HVHV
HVVH
VHHV
VHVH
VVHH

---------------------------------------------------------------------------
FINAL OUTPUT:
HHVV
HVHV
HVVH
VHHV
VHVH
VVHH

---------------------------------------------------------------------------
SIMPLE RULE YAAD RAKHO:
- Destination pe pahunch gaye → path print
- Maze ke bahar gaye → return
- Har cell se 2 choices (H, V)

===========================================================================
*/
