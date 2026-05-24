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
    static int steps = 0;

    public static void main(String[] args)
    {
        int n = 2;

        towerOfHanoi(n, 1, 2, 3);

        System.out.println("Total Steps = " + steps);
    }

    static void towerOfHanoi(int n, int src, int helper, int dest)
    {
        if (n == 0)
        {
            return;
        }

        // move n-1 disks from source -> helper
        towerOfHanoi(n - 1, src, dest, helper);

        // move nth disk
        System.out.println("move disk " + n + " from rod " + src + " to rod " + dest);

        steps++;

        // move n-1 disks from helper -> destination
        towerOfHanoi(n - 1, helper, src, dest);
    }
}