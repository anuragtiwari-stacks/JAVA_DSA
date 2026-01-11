package _17DynamicProgramming;

public class _38MatrixChainMultiplication_Pattern2
{
    public static int cost(int i, int j, int[] arr)
    {
        if(i == j)
        {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for(int k = i; k < j; k++)
        {
            int x = arr[i] * arr[k + 1] * arr[j + 1];
            int tc = cost(i, k, arr) + cost(k + 1, j, arr) + x;
            minCost = Math.min(minCost, tc);
        }

        return minCost;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 4, 2};
        int n = arr.length;

        int result = cost(0, n - 2, arr);
        System.out.println("Minimum Cost = " + result);
    }
}

/*
===================== DRY RUN =====================

arr = {1, 2, 3, 4, 2}

Matrix dimensions:
A1 = 1x2
A2 = 2x3
A3 = 3x4
A4 = 4x2

We call:
cost(0, 3, arr)

------------------------------------
Case: i=0, j=3

k = 0:
 x = arr[0] * arr[1] * arr[4]
   = 1 * 2 * 2 = 4

 tc = cost(0,0) + cost(1,3) + 4
 cost(0,0)=0

 compute cost(1,3):

   k = 1:
     x = arr[1]*arr[2]*arr[4]
       = 2 * 3 * 2 = 12
     tc = cost(1,1)+cost(2,3)+12
     cost(1,1)=0

     compute cost(2,3):

       k = 2:
         x = arr[2]*arr[3]*arr[4]
           = 3 * 4 * 2 = 24
         cost(2,2)=0, cost(3,3)=0
         so cost(2,3)=24

     so cost(1,3) using k=1 = 0 + 24 + 12 = 36

   k = 2:
     x = arr[1]*arr[3]*arr[4]
       = 2 * 4 * 2 = 16
     tc = cost(1,2)+cost(3,3)+16

     compute cost(1,2):

       k = 1:
         x = arr[1]*arr[2]*arr[3]
           = 2 * 3 * 4 = 24
         cost(1,1)=0, cost(2,2)=0
         so cost(1,2)=24

     so cost(1,3) using k=2 = 24 + 0 + 16 = 40

=> cost(1,3) = min(36, 40) = 36

So first split k=0:
tc = 0 + 36 + 4 = 40

------------------------------------
k = 1:
 x = arr[0]*arr[2]*arr[4]
   = 1 * 3 * 2 = 6
 tc = cost(0,1) + cost(2,3) + 6

 compute cost(0,1):

   k = 0:
     x = arr[0]*arr[1]*arr[2]
       = 1 * 2 * 3 = 6
     cost(0,0)=0, cost(1,1)=0
     so cost(0,1)=6

 cost(2,3)=24 (from above)

So tc = 6 + 24 + 6 = 36

------------------------------------
k = 2:
 x = arr[0]*arr[3]*arr[4]
   = 1 * 4 * 2 = 8
 tc = cost(0,2) + cost(3,3) + 8

 compute cost(0,2):

   k=0:
     x = 1*2*4=8
     cost(0,0)+cost(1,2)=0+24=24
     tc = 24 + 8 = 32

   k=1:
     x = 1*3*4 = 12
     cost(0,1)=6, cost(2,2)=0
     tc = 6 + 12 = 18

 cost(0,2)=min(32,18)=18

So k=2:
tc = 18 + 0 + 8 = 26

------------------------------------
FINAL MINIMUM:

k=0 => 40
k=1 => 36
k=2 => 26

ANSWER = 26

=====================
Minimum Cost = 26
====================================================
*/
