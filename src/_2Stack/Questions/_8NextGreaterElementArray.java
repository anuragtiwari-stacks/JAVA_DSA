package _2Stack.Questions;

public class _8NextGreaterElementArray
{

    public static void nextGreaterElement(int[] arr)
    {
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++)
        {
            int next = -1;

            for (int j = i + 1; j < n; j++)
            {
                if (arr[j] > arr[i])
                {
                    next = arr[j];
                    break;
                }
            }

            result[i] = next;
        }

        System.out.println("Next Greater Elements:");
        for (int i = 0; i < n; i++)
        {
            System.out.println(arr[i] + " -> " + result[i]);
        }
    }

    public static void main(String[] args)
    {
        int[] input = {4, 5, 2, 10, 8};
        nextGreaterElement(input);
    }

}
