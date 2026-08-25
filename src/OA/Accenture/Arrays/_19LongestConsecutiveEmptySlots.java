package OA.Accenture.Arrays;

// Question: Find the longest run of consecutive empty slots ('S') in a parking-lot status array

public class _19LongestConsecutiveEmptySlots
{
    public static void main(String[] args)
    {
        char[] arr = {'O', 'S', 'S', 'O', 'S', 'S', 'S', 'O'};

        System.out.println(findLongestRun(arr));
    }

    static int findLongestRun(char[] arr)
    {
        int count = 0;
        int max = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == 'S')
            {
                count++;
                max = Math.max(max, count);
            }
            else
            {
                count = 0;
            }
        }

        return max;
    }
}