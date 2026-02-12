package _10PrefixSum;

public class _7CorporateFlightBookingsOptimized
{
    // Optimized method using difference array
    public static int[] corpFlightBookings(int[][] bookings, int n)
    {
        int[] diff = new int[n];

        // Step 1: Apply difference array technique
        for (int i = 0; i < bookings.length; i++)
        {
            int first = bookings[i][0] - 1;
            int last = bookings[i][1] - 1;
            int seats = bookings[i][2];

            diff[first] = diff[first] + seats;

            if (last + 1 < n)
            {
                diff[last + 1] = diff[last + 1] - seats;
            }
        }

        // Step 2: Build prefix sum to get final answer
        for (int i = 1; i < n; i++)
        {
            diff[i] = diff[i - 1] + diff[i];
        }

        return diff;
    }

    public static void main(String[] args)
    {
        int[][] bookings =
                {
                        { 1, 2, 10 },
                        { 2, 3, 20 },
                        { 2, 5, 25 }
                };

        int n = 5;

        int[] result = corpFlightBookings(bookings, n);

        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}

/*
=====================
DRY RUN
=====================

bookings = {
  {1, 2, 10},
  {2, 3, 20},
  {2, 5, 25}
}

n = 5
diff = {0, 0, 0, 0, 0}

Booking 1: {1, 2, 10}
diff[0] += 10
diff[2] -= 10
diff = {10, 0, -10, 0, 0}

Booking 2: {2, 3, 20}
diff[1] += 20
diff[3] -= 20
diff = {10, 20, -10, -20, 0}

Booking 3: {2, 5, 25}
diff[1] += 25
(no subtraction since last flight)
diff = {10, 45, -10, -20, 0}

Prefix Sum:
index 0 → 10
index 1 → 10 + 45 = 55
index 2 → 55 - 10 = 45
index 3 → 45 - 20 = 25
index 4 → 25

Final Answer:
{ 10, 55, 45, 25, 25 }
*/
