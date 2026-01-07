package _15Recursion;

/*
QUESTION:
You are given a number n representing the number of stairs.
You are currently standing at stair 0.
You can jump either 1 step, 2 steps, or 3 steps at a time.

Print all possible paths to reach stair n using recursion.
*/

public class _1StairPath
{
    public static void main(String[] args)
    {
        int n = 3;

        printStairPath(n, "");
    }

    static void printStairPath(int n, String path)
    {
        if (n == 0)
        {
            System.out.println(path);
            return;
        }

        if (n < 0)
        {
            return;
        }

        printStairPath(n - 1, path + "1");
        printStairPath(n - 2, path + "2");
        printStairPath(n - 3, path + "3");
    }
}

/*
==================== SIMPLE DRY RUN (BEGINNER FRIENDLY) ====================

Input:
n = 3

Meaning:
Hume 0 se 3 stair tak jaana hai.
Har jump me hum 1, 2 ya 3 step le sakte hain.

---------------------------------------------------------------------------
STEP 1:
main() call karta hai:
printStairPath(3, "")

path = ""  (abhi koi jump nahi liya)

---------------------------------------------------------------------------
STEP 2:
n = 3
Hum 3 choices try karte hain:

1) 1-step jump
   printStairPath(2, "1")

2) 2-step jump
   printStairPath(1, "2")

3) 3-step jump
   printStairPath(0, "3")

---------------------------------------------------------------------------
STEP 3:
printStairPath(2, "1")

Again 3 choices:

1) printStairPath(1, "11")
2) printStairPath(0, "12")
3) printStairPath(-1, "13") → n < 0 so STOP

"12" print hoga kyunki n == 0

---------------------------------------------------------------------------
STEP 4:
printStairPath(1, "11")

1) printStairPath(0, "111") → PRINT
2) printStairPath(-1, "112") → STOP
3) printStairPath(-2, "113") → STOP

---------------------------------------------------------------------------
STEP 5:
printStairPath(1, "2")

1) printStairPath(0, "21") → PRINT
2) printStairPath(-1, "22") → STOP
3) printStairPath(-2, "23") → STOP

---------------------------------------------------------------------------
STEP 6:
printStairPath(0, "3")

n == 0 → PRINT "3"

---------------------------------------------------------------------------
FINAL OUTPUT:
111
12
21
3

---------------------------------------------------------------------------
SIMPLE RULE YAAD RAKHO:
- n == 0 → path print
- n < 0 → return
- Har call me 3 choices (1, 2, 3 jump)

===========================================================================
*/
