package _20DynamicProgramming;

public class _35MatrixChainMultiplication_Pattern1
{
    public static int cost(int i, int j, int[][] arr)
    {
        if(i >= j)
        {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for(int k = i; k < j; k++)
        {
            int x = arr[i][0] * arr[k][1] * arr[j][1];
            int tc = cost(i, k, arr) + cost(k + 1, j, arr) + x;
            minCost = Math.min(minCost, tc);
        }

        return minCost;
    }

    public static void main(String[] args)
    {
        int[][] arr =
                {
                        {1, 2},
                        {2, 3},
                        {3, 4},
                        {4, 2}
                };

        int n = arr.length;
        int result = cost(0, n - 1, arr);
        System.out.println("Minimum Cost = " + result);
    }
}

/*
==================== DRY RUN ====================

Matrices:
A1 = 1x2
A2 = 2x3
A3 = 3x4
A4 = 4x2

Dimensions used in cost:
arr[i][0] = rows
arr[i][1] = cols

Formula at partition k:
cost = cost(i,k) + cost(k+1,j) + (arr[i][0] * arr[k][1] * arr[j][1])

---------------------------------------
Compute cost(0,3):

Try k = 0:
  left  = cost(0,0) = 0
  right = cost(1,3)
  mult  = 1*2*2 = 4
  so tc = 0 + cost(1,3) + 4

Compute cost(1,3):

Try k = 1:
  left  = cost(1,1)=0
  right = cost(2,3)
  mult  = 2*3*2 = 12
  so tc = 0 + cost(2,3) + 12

Compute cost(2,3):

Try k = 2:
  left  = cost(2,2)=0
  right = cost(3,3)=0
  mult  = 3*4*2 = 24
  cost(2,3)=24

So back to cost(1,3) k=1:
tc = 0 + 24 + 12 = 36

Try k = 2 in cost(1,3):
  left  = cost(1,2)
  right = cost(3,3)=0
  mult  = 2*4*2 = 16

Compute cost(1,2):

Try k=1:
  left = cost(1,1)=0
  right=cost(2,2)=0
  mult = 2*3*4 = 24
so cost(1,2)=24

So cost(1,3) k=2:
tc = 24 + 0 + 16 = 40

So cost(1,3) = min(36, 40) = 36

Back to cost(0,3) k=0:
tc = 0 + 36 + 4 = 40

---------------------------------------
Try k = 1 in cost(0,3):
  left  = cost(0,1)
  right = cost(2,3)=24
  mult  = 1*3*2 = 6

Compute cost(0,1):

Try k=0:
  left=cost(0,0)=0
  right=cost(1,1)=0
  mult=1*2*3=6
  so cost(0,1)=6

So tc = 6 + 24 + 6 = 36

---------------------------------------
Try k = 2 in cost(0,3):
  left  = cost(0,2)
  right = cost(3,3)=0
  mult  = 1*4*2 = 8

Compute cost(0,2):

Try k=0:
  left=0, right=cost(1,2)=24, mult=1*2*4=8
  so tc=0+24+8=32

Try k=1:
  left=cost(0,1)=6
  right=cost(2,2)=0
  mult=1*3*4=12
  so tc=6+0+12=18

So cost(0,2)=min(32,18)=18

Back to cost(0,3):
tc = 18 + 0 + 8 = 26

---------------------------------------
Now choose min over k=0,1,2:

k=0 => 40
k=1 => 36
k=2 => 26

Minimum = 26

====================
FINAL ANSWER:
Minimum Cost = 26
====================
*/
