package OA.Tredenece_Analytics;
/*
 * Seat Allocation Problem
 *
 * A movie theatre has N consecutive seats numbered from 1 to N.
 *
 * There are M groups of customers arriving one after another.
 * The size of each group is given in an array groups[].
 *
 * The theatre follows these rules:
 *
 * 1. Seats are allocated in the order the groups arrive.
 * 2. Each group must receive consecutive seats.
 * 3. If enough seats are available, allocate the leftmost available block
 *    of consecutive seats.
 * 4. If there are not enough seats remaining for a group, return -1 for
 *    that group.
 * 5. Once seats are allocated, they cannot be changed or freed.
 *
 * Return an array where each element represents the starting seat number
 * (1-based indexing) assigned to each group, or -1 if the group cannot
 * be accommodated.
 *
 * Example:
 *
 * Input:
 * N = 10
 * groups = {3, 5, 4, 2}
 *
 * Output:
 * [1, 4, -1, 9]
 *
 * Explanation:
 * Group 1 (3 seats) -> Seats 1 to 3
 * Group 2 (5 seats) -> Seats 4 to 8
 * Group 3 (4 seats) -> Not enough seats -> -1
 * Group 4 (2 seats) -> Seats 9 to 10
 *
 * Time Complexity: O(M)
 * Space Complexity: O(M)
 */

import java.util.*;

public class Seat_Allocation
{
    public static int[] allocateSeats(int n, int[] groups)
    {
        int booking = 0;
        int i = 0;

        int[] result = new int[groups.length];

        for(int x : groups)
        {
            if(x <= n)
            {
                result[i] = booking + 1;
                i++;
                booking = booking + x;
                n = n - x;
            }

            else if(x > n)
            {
                result[i] = -1;
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        int n = 10;
        int[] groups = {3, 5, 4, 2};

        int[] ans = allocateSeats(n, groups);

        System.out.println("Total Seats : " + n);
        System.out.println("Groups      : " + Arrays.toString(groups));
        System.out.println("Output      : " + Arrays.toString(ans));
    }
}