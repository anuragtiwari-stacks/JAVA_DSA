package _18Recursion;

/*
QUESTION: You are given n disks placed on source rod.
You have three rods:
1. Source rod
2. Helper rod
3. Destination rod

Rules:
1. Ek time par sirf ek disk move kar sakte ho.
2. Badi disk ko chhoti disk ke upar nahi rakh sakte.

Write a recursive program to print the steps to move all disks
from source rod to destination rod using helper rod.
*/

public class _3TowerOfHanoi
{
    public static void main(String[] args)
    {
        int n = 3;

        towerOfHanoi(n, "Source", "Helper", "Destination");
    }

    static void towerOfHanoi(int n, String src, String helper, String dest)
    {
        if (n == 0)
        {
            return;
        }

        towerOfHanoi(n - 1, src, dest, helper);

        System.out.println("Move disk " + n + " from " + src + " to " + dest);

        towerOfHanoi(n - 1, helper, src, dest);
    }
}

/*
==================== SIMPLE DRY RUN (BEGINNER FRIENDLY) ====================

Input:
n = 3

Meaning:
3 disks ko Source se Destination le jana hai
Helper rod ka use karke.

---------------------------------------------------------------------------
STEP 1:
towerOfHanoi(3, S, H, D)

Pehle 2 disks ko Source → Helper bhejo
Call:
towerOfHanoi(2, S, D, H)

---------------------------------------------------------------------------
STEP 2:
towerOfHanoi(2, S, D, H)

Pehle 1 disk ko Source → Destination bhejo
Call:
towerOfHanoi(1, S, H, D)

---------------------------------------------------------------------------
STEP 3:
towerOfHanoi(1, S, H, D)

Pehle 0 disks move (kuch nahi)
Move disk 1 from Source to Destination

---------------------------------------------------------------------------
STEP 4:
Wapas aate hue:
Move disk 2 from Source to Helper

---------------------------------------------------------------------------
STEP 5:
Helper pe rakhi 1 disk ko Destination pe bhejo
Move disk 1 from Destination to Helper

---------------------------------------------------------------------------
STEP 6:
Ab largest disk move karo
Move disk 3 from Source to Destination

---------------------------------------------------------------------------
STEP 7:
Ab Helper se 2 disks Destination pe bhejo

Moves:
Move disk 1 from Helper to Source
Move disk 2 from Helper to Destination
Move disk 1 from Source to Destination

---------------------------------------------------------------------------
FINAL OUTPUT ORDER:
Move disk 1 from Source to Destination
Move disk 2 from Source to Helper
Move disk 1 from Destination to Helper
Move disk 3 from Source to Destination
Move disk 1 from Helper to Source
Move disk 2 from Helper to Destination
Move disk 1 from Source to Destination

---------------------------------------------------------------------------
IMPORTANT POINTS:
- Base case: n == 0 → return
- First call → n-1 disks ko helper pe le jao
- Middle step → nth disk ko destination pe le jao
- Last call → n-1 disks ko destination pe le jao

===========================================================================
*/
