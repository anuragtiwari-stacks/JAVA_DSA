package OA.Accenture.Numbers;

// Question: Find minimum number of houses whose combined food supply
// covers the required food for all rats

public class _10MinimumHousesForRats
{
    public static void main(String[] args)
    {
        int rats = 7;
        int foodPerRat = 2;
        int[] houses = {2, 8, 3, 5, 7};

        System.out.println(findHouses(rats, foodPerRat, houses));
    }

    static int findHouses(int rats, int foodPerRat, int[] houses)
    {
        int required = rats * foodPerRat;

        int[] prefix = new int[houses.length];

        // Prefix sum
        prefix[0] = houses[0];

        for(int i = 1; i < houses.length; i++)
        {
            prefix[i] = prefix[i - 1] + houses[i];
        }

        // Find minimum houses
        for(int i = 0; i < prefix.length; i++)
        {
            if(prefix[i] >= required)
            {
                return i + 1;
            }
        }

        return -1;
    }
}