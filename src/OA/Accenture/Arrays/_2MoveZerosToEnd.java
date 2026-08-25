package OA.Accenture.Arrays;

// Question: Move all zeros in an array to the end without changing the order of other elements

public class _2MoveZerosToEnd
{
    public static void main(String[] args)
    {
        int[] arr = {0, 1, 0, 3, 12, 0, 5};

        moveZerosToEnd(arr);

        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }

    static void moveZerosToEnd(int[] arr)
    {
        int index = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] != 0)
            {
                arr[index] = arr[i];
                index++;
            }
        }

        while(index < arr.length)
        {
            arr[index] = 0;
            index++;
        }
    }
}