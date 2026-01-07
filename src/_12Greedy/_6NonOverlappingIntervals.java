package _12Greedy;

import java.util.Arrays;

public class _6NonOverlappingIntervals
{
    public static int eraseOverlapIntervals(int[][] intervals)
    {
        if (intervals.length == 0)
        {
            return 0;
        }

        // Step 1: Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int countNonOverlap = 1; // At least one interval is kept
        int prevEnd = intervals[0][1];

        // Step 2: Go through intervals
        for (int i = 1; i < intervals.length; i++)
        {
            if (intervals[i][0] >= prevEnd) // No overlap
            {
                countNonOverlap++;
                prevEnd = intervals[i][1];
            }
        }

        // Step 3: Remove rest
        return intervals.length - countNonOverlap;
    }

    public static void main(String[] args)
    {
        int[][] intervals1 = {{1,2},{2,3},{3,4},{1,3}};
        int[][] intervals2 = {{1,2},{1,2},{1,2}};
        int[][] intervals3 = {{1,2},{2,3}};

        /*
        Dry Run for intervals1 = {{1,2},{2,3},{3,4},{1,3}}
        Step 1: Sort by end → {{1,2}, {2,3}, {1,3}, {3,4}}
        Step 2:
            Keep {1,2} → prevEnd=2
            {2,3} start=2 ≥ prevEnd=2 → keep → prevEnd=3
            {1,3} start=1 < prevEnd=3 → overlap → remove
            {3,4} start=3 ≥ prevEnd=3 → keep → prevEnd=4
        countNonOverlap = 3
        intervals.length=4
        Result = 4 - 3 = 1
        */

        System.out.println(eraseOverlapIntervals(intervals1)); // 1
        System.out.println(eraseOverlapIntervals(intervals2)); // 2
        System.out.println(eraseOverlapIntervals(intervals3)); // 0
    }
}
