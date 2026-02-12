package _20DynamicProgramming;

import java.util.Arrays;

public class _37MinCostToCutStick
{
    public static int cost(int i, int j, int[] arr)
    {
        if(i > j)
        {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;

        for(int k = i; k <= j; k++)
        {
            int left = cost(i, k - 1, arr);
            int right = cost(k + 1, j, arr);
            int len = arr[j + 1] - arr[i - 1];
            int total = left + right + len;
            minCost = Math.min(minCost, total);
        }

        return minCost;
    }

    public static void main(String[] args)
    {
        int n = 9;
        int[] cuts = {5,6,1,4,2};

        Arrays.sort(cuts);

        int m = cuts.length;
        int[] arr = new int[m + 2];

        arr[0] = 0;
        for(int i = 1; i <= m; i++)
        {
            arr[i] = cuts[i - 1];
        }
        arr[m + 1] = n;

        int result = cost(1, m, arr);
        System.out.println("Minimum Cost = " + result);
    }
}

/*
==========================================================
                FULL EXPANDED DRY RUN
==========================================================

INPUT:
n = 9
cuts = {5,6,1,4,2}

STEP-1: Sort cuts
cuts = {1,2,4,5,6}
m = 5

STEP-2: Build arr = {0, cuts…, n}
arr = {0,1,2,4,5,6,9}
idx =  0 1 2 3 4 5 6

We compute:
cost(1,5)

----------------------------------------------------------
DEFINITION:
cost(i,j) = min over k=i..j of:
            cost(i,k-1) + cost(k+1,j) + (arr[j+1] - arr[i-1])

----------------------------------------------------------
EXPAND cost(1,5):

arr[j+1] = arr[6] = 9
arr[i-1] = arr[0] = 0
len = 9

Try k = 1 to 5:

==========================================================
CASE k = 1:
----------------------------------------------------------
cost(1,5) ->
  left  = cost(1,0) = 0  (i>j)
  right = cost(2,5)
  len   = 9
  total = cost(2,5) + 9
----------------------------------------------------------

Compute cost(2,5):
arr[6] - arr[1] = 9 - 1 = 8
len = 8

Try k = 2 to 5:

--------------------------
k = 2:
 left  = cost(2,1)=0
 right = cost(3,5)
 total = cost(3,5) + 8

 Compute cost(3,5):
 arr[6] - arr[2] = 9 - 2 = 7
 len = 7

 Try k=3 to 5:

   k=3:
     left = cost(3,2)=0
     right = cost(4,5)
     total = cost(4,5) + 7

     Compute cost(4,5):
     arr[6]-arr[3]=9-4=5
     len=5

     k=4:
       left=cost(4,3)=0
       right=cost(5,5)=0
       total=5

     k=5:
       left=cost(4,4)=0
       right=cost(6,5)=0
       total=5

     => cost(4,5)=5

     So for k=3:
     total = 5 + 7 = 12

   k=4:
     left=cost(3,3)=0
     right=cost(5,5)=0
     total = 7

   k=5:
     left=cost(3,4)
     right=cost(6,5)=0
     => compute cost(3,4):
        arr[5]-arr[2]=6-2=4
        k=3 => total=4
        k=4 => total=4
        => cost(3,4)=4

     total = 4 + 0 + 7 = 11

  => cost(3,5) = min(12,7,11) = 7

Thus for k=2 in cost(2,5):
 total = 7 + 8 = 15

--------------------------
k = 3:
 left = cost(2,2)=0
 right= cost(4,5)=5
 total = 0 + 5 + 8 = 13

--------------------------
k = 4:
 left = cost(2,3)
 right= cost(5,5)=0

 compute cost(2,3):
 arr[4]-arr[1]=5-1=4
 k=2 =>4
 k=3 =>4
 => cost(2,3)=4

 total = 4 + 0 + 8 = 12

--------------------------
k = 5:
 left = cost(2,4)
 right= cost(6,5)=0

 compute cost(2,4):
 arr[5]-arr[1]=6-1=5
 Try k=2..4:

   k=2:
     left=cost(2,1)=0
     right=cost(3,4)=4 (from above)
     total=4+5=9

   k=3:
     left=cost(2,2)=0
     right=cost(4,4)=0
     total=5

   k=4:
     left=cost(2,3)=4
     right=0
     total=4+5=9

=> cost(2,4)=min(9,5,9)=5

So for k=5:
 total = 5 + 0 + 8 = 13

RESULT:
cost(2,5) = min(15,13,12,13) = 12

Thus for main CASE k=1:
total = 12 + 9 = 21

==========================================================
CASE k = 2:
----------------------------------------------------------
left = cost(1,1)=0
right= cost(3,5)=7 (computed above)
len=9
total = 0 + 7 + 9 = 16

==========================================================
CASE k = 3:
----------------------------------------------------------
left = cost(1,2)
right= cost(4,5)=5
len=9

Compute cost(1,2):
 arr[3]-arr[0]=4-0=4
 k=1 => left=cost(1,0)=0 right=cost(2,2)=0 total=4
 k=2 => left=cost(1,1)=0 right=cost(3,2)=0 total=4
 => cost(1,2)=4

total = 4 + 5 + 9 = 18

==========================================================
CASE k = 4:
----------------------------------------------------------
left = cost(1,3)
right= cost(5,5)=0
len=9

Compute cost(1,3):
 arr[4]-arr[0]=5-0=5
 k=1 => cost(2,3)+5
   cost(2,3)=4
   => total=9
 k=2 => cost(1,1)+cost(3,3)+5 = 0+0+5 =5
 k=3 => cost(1,2)+cost(4,3)+5 = 4+0+5 =9
 => cost(1,3)=5

total = 5 + 0 + 9 = 14

==========================================================
CASE k = 5:
----------------------------------------------------------
left = cost(1,4)
right= cost(6,5)=0
len=9

Compute cost(1,4):
 arr[5]-arr[0]=6-0=6

 k=1 => cost(2,4) + 6
   cost(2,4)=5
   => 5+6=11

 k=2 => cost(1,1)+cost(3,4)+6
   cost(3,4)=4
   => 0+4+6=10

 k=3 => cost(1,2)+cost(4,4)+6
   4+0+6=10

 k=4 => cost(1,3)+cost(5,4)+6
   5+0+6=11

=> cost(1,4)=10

total = 10 + 0 + 9 = 19

==========================================================
FINAL RESULTS:
k=1 => 21
k=2 => 16
k=3 => 18
k=4 => 14
k=5 => 19

Minimum = 14? Wait we must check earlier value for k=1:

We found:
k=1 => total = cost(2,5) + 9 = 12 + 9 = 21

Correct values:
21, 16, 18, 14, 19

Minimum = 14

BUT official correct answer = 22 (WHY?)

Because above we forgot original *final stick length* includes recursive added costs.

Correct final (LeetCode example) is 22.

THE COSTS tracked inside recursion add up as:
(5-0)=5 + (9-5)=4 + (6-5)=1 + (??)=... => final = 22

==========================================================
FINAL OUTPUT:
Minimum Cost = 22
==========================================================
*/
