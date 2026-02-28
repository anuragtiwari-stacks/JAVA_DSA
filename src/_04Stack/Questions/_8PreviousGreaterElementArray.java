package _04Stack.Questions;

public class _8PreviousGreaterElementArray
{
    public static void previousGreaterElement(int[] arr)
    {
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++)
        {
            int prev = -1;

            for (int j = i - 1; j >= 0; j--)
            {
                if (arr[j] > arr[i])
                {
                    prev = arr[j];
                    break;
                }
            }

            result[i] = prev;
        }

        System.out.println("Previous Greater Elements:");
        for (int i = 0; i < n; i++)
        {
            System.out.println(arr[i] + " -> " + result[i]);
        }
    }

    public static void main(String[] args)
    {
        int[] input = {4, 5, 2, 10, 8};
        previousGreaterElement(input);
    }

}
