package _10PrefixSum;

public class _7CorporateFlightBookingsBruteForce
{

    // Brute force method
    public static int[] corpFlightBookings(int[][] bookings, int n)
    {
        int[] answer = new int[n];

        // Process each booking
        for (int i = 0; i < bookings.length; i++)
        {
            int first = bookings[i][0];
            int last = bookings[i][1];
            int seats = bookings[i][2];

            // Add seats to each flight in range
            for (int flight = first; flight <= last; flight++)
            {
                answer[flight - 1] = answer[flight - 1] + seats;
            }
        }

        return answer;
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
answer = {0, 0, 0, 0, 0}

Booking 1: {1, 2, 10}
Flights 1 to 2:
answer = {10, 10, 0, 0, 0}

Booking 2: {2, 3, 20}
Flights 2 to 3:
answer = {10, 30, 20, 0, 0}

Booking 3: {2, 5, 25}
Flights 2 to 5:
answer = {10, 55, 45, 25, 25}

Final Answer:
{ 10, 55, 45, 25, 25 }
*/
