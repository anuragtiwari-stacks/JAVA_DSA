package _20DynamicProgramming;

// LeetCode 1671. Minimum Number of Removals to Make Mountain Array

import java.util.*;

public class _33MinRemovalsToMakeMountainArray
{
    public static int minimumMountainRemovals(int[] nums)
    {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j <= i - 1; j++)
            {
                if(nums[i] > nums[j])
                {
                    dp1[i] = Math.max(dp1[i], dp1[j]);
                }
            }
            dp1[i] += 1;
        }

        for(int i = n - 1; i >= 0; i--)
        {
            for(int j = n - 1; j >= i + 1; j--)
            {
                if(nums[i] > nums[j])
                {
                    dp2[i] = Math.max(dp2[i], dp2[j]);
                }
            }
            dp2[i] += 1;
        }

        int maxMountain = 0;
        for(int i = 1; i < n - 1; i++)
        {
            if(dp1[i] > 1 && dp2[i] > 1)
            {
                maxMountain = Math.max(maxMountain, dp1[i] + dp2[i] - 1);
            }
        }

        System.out.println("dp1: " + Arrays.toString(dp1));
        System.out.println("dp2: " + Arrays.toString(dp2));
        System.out.println("maxMountain: " + maxMountain);

        return n - maxMountain;
    }

    public static void main(String[] args)
    {
        int[] nums = {2,1,1,5,6,2,3,1};
        int result = minimumMountainRemovals(nums);
        System.out.println("final answer: " + result);
    }
}

/*
======================== DRY RUN ========================

nums = [2,1,1,5,6,2,3,1]
n = 8

----------------------
dp1 CALCULATION (LIS)
----------------------

dp1 initially = [0,0,0,0,0,0,0,0]

i=0: dp1[0]=0+1=1 → dp1=[1,0,0,0,0,0,0,0]
i=1: no j with nums[1]>nums[j] → dp1[1]=1 → [1,1,0,0,0,0,0,0]
i=2: same case → dp1[2]=1 → [1,1,1,0,0,0,0,0]
i=3: nums[3]=5
      j=0→5>2 dp1[3]=max(0,1)=1
      j=1→5>1 dp1[3]=max(1,1)=1
      j=2→5>1 dp1[3]=max(1,1)=1
      dp1[3]=1+1=2 → [1,1,1,2,0,0,0,0]
i=4: nums[4]=6
      j=0→6>2 dp1[4]=1
      j=1→6>1 dp1[4]=1
      j=2→6>1 dp1[4]=1
      j=3→6>5 dp1[4]=max(1,2)=2
      dp1[4]=2+1=3 → [1,1,1,2,3,0,0,0]
i=5: nums[5]=2
      j=0→2>2 no
      j=1→2>1 dp1[5]=1
      j=2→2>1 dp1[5]=1
      j=3→2>5 no
      j=4→2>6 no
      dp1[5]=1+1=2 → [1,1,1,2,3,2,0,0]
i=6: nums[6]=3
      j=0→3>2 dp1[6]=1
      j=1→3>1 dp1[6]=1
      j=2→3>1 dp1[6]=1
      j=3→3>5 no
      j=4→3>6 no
      j=5→3>2 dp1[6]=max(1,2)=2
      dp1[6]=2+1=3 → [1,1,1,2,3,2,3,0]
i=7: nums[7]=1
      no j with nums[7]>nums[j]
      dp1[7]=1 → [1,1,1,2,3,2,3,1]

FINAL dp1 = [1,1,1,2,3,2,3,1]

----------------------
dp2 CALCULATION (LDS)
----------------------

dp2 initially = [0,0,0,0,0,0,0,0]

i=7: dp2[7]=1 → [0,0,0,0,0,0,0,1]
i=6: nums[6]=3
      j=7→3>1 dp2[6]=1
      dp2[6]=1+1=2 → [0,0,0,0,0,0,2,1]
i=5: nums[5]=2
      j=7→2>1 dp2[5]=1
      j=6→2>3 no
      dp2[5]=1+1=2 → [0,0,0,0,0,2,2,1]
i=4: nums[4]=6
      j=7→6>1 dp2[4]=1
      j=6→6>3 dp2[4]=max(1,2)=2
      j=5→6>2 dp2[4]=max(2,2)=2
      dp2[4]=2+1=3 → [0,0,0,0,3,2,2,1]
i=3: nums[3]=5
      j=7→5>1 dp2[3]=1
      j=6→5>3 dp2[3]=max(1,2)=2
      j=5→5>2 dp2[3]=max(2,2)=2
      j=4→5>6 no
      dp2[3]=2+1=3 → [0,0,0,3,3,2,2,1]
i=2: nums[2]=1
      no j with nums[2]>nums[j]
      dp2[2]=1 → [0,0,1,3,3,2,2,1]
i=1: nums[1]=1
      dp2[1]=1 → [0,1,1,3,3,2,2,1]
i=0: nums[0]=2
      j=7→2>1 dp2[0]=1
      j=6→2>3 no
      j=5→2>2 no
      j=4→2>6 no
      j=3→2>5 no
      j=2→2>1 dp2[0]=max(1,1)=1
      j=1→2>1 dp2[0]=max(1,1)=1
      dp2[0]=1+1=2 → [2,1,1,3,3,2,2,1]

FINAL dp2 = [2,1,1,3,3,2,2,1]

----------------------
CALCULATE maxMountain
dp1 = [1,1,1,2,3,2,3,1]
dp2 = [2,1,1,3,3,2,2,1]

Check i=1..6 (peaks must not be ends)

i=1: dp1=1,dp2=1 invalid
i=2: dp1=1,dp2=1 invalid
i=3: dp1=2,dp2=3 → valid → len=2+3-1=4
i=4: dp1=3,dp2=3 → valid → len=3+3-1=5 (max)
i=5: dp1=2,dp2=2 → valid → len=2+2-1=3
i=6: dp1=3,dp2=2 → valid → len=3+2-1=4

maxMountain = 5

----------------------
FINAL ANSWER

n = 8
removals = n - maxMountain = 8 - 5 = 3

======================================================
*/
