package OA.Accenture.Arrays;

// Question: Find the second largest and second smallest element in an array

public class _1SecondLargestAndSecondSmallest
{
    public static void main(String[] args)
    {
        int[] arr = {10, 5, 8, 20, 3, 15};

        findSecondLargestSmallest(arr);
    }

    static void findSecondLargestSmallest(int[] arr)
    {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > largest)
            {
                secondLargest = largest;
                largest = arr[i];
            }
            else if(arr[i] > secondLargest && arr[i] != largest)
            {
                secondLargest = arr[i];
            }

            if(arr[i] < smallest)
            {
                secondSmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] < secondSmallest && arr[i] != smallest)
            {
                secondSmallest = arr[i];
            }
        }

        System.out.println("Second Largest = " + secondLargest);
        System.out.println("Second Smallest = " + secondSmallest);
    }
}