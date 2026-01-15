package _12Greedy.PW;

import java.util.Arrays;

public class _5MinArrowsToBurstBalloons
{
    public static int findMinArrowShots(int[][] points)
    {
        if (points.length == 0)
        {
            return 0;
        }

        // Step 1: Sort by end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPos = points[0][1]; // Place arrow at end of first balloon

        // Step 2: Iterate and burst balloons
        for (int i = 1; i < points.length; i++)
        {
            if (points[i][0] > arrowPos) // Balloon starts after arrow position → new arrow
            {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }

    public static void main(String[] args)
    {
        int[][] balloons = {{10,16}, {2,8}, {1,6}, {7,12}};

        System.out.println(findMinArrowShots(balloons)); // Output: 2
    }
}

        /*
        DRY RUN for balloons = { {10,16}, {2,8}, {1,6}, {7,12} }

        Step 1: Sort by end
        After sorting → { {1,6}, {2,8}, {7,12}, {10,16} }

        Step 2: arrows = 1, arrowPos = 6
            Balloon {1,6} → bursts
            Balloon {2,8} → start=2 ≤ arrowPos=6 → also bursts with same arrow
            Balloon {7,12} → start=7 > arrowPos=6 → need new arrow
                arrows = 2, arrowPos = 12
            Balloon {10,16} → start=10 ≤ arrowPos=12 → bursts with arrow #2

        Step 3: Result = 2
        */