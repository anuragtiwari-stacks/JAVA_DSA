package _15Greedy.MIK;

public class _4BrokenCaluclator
{
    public int brokenCalc(int startValue, int target)
    {
        int operations = 0;

        while(target > startValue)
        {
            operations++;
            if(target % 2 == 1)
            {
                target++;
            }
            else
            {
                target /= 2;
            }
        }

        return operations + (startValue - target);
    }

    public static void main(String[] args)
    {
        _4BrokenCaluclator obj = new _4BrokenCaluclator();

        System.out.println(obj.brokenCalc(3, 10)); // Expected 3
        System.out.println(obj.brokenCalc(2, 3));  // Expected 2
        System.out.println(obj.brokenCalc(5, 8));  // Expected 2
        System.out.println(obj.brokenCalc(3, 3));  // Expected 0
    }
}

/*
---------------- DRY RUN ----------------

Input:
startValue = 3, target = 10

Step 1:
target > startValue → 10 > 3
10 is even → target = 10/2 = 5
operations = 1

Step 2:
target > startValue → 5 > 3
5 is odd → target = 5 + 1 = 6
operations = 2

Step 3:
target > startValue → 6 > 3
6 is even → target = 6/2 = 3
operations = 3

Now target == startValue → stop

Final Answer = operations + (startValue - target)
              = 3 + (3 - 3)
              = 3

--------------------------------------------------

Input:
startValue = 2, target = 3

Step 1:
3 > 2 → 3 odd → target = 4, ops=1
Step 2:
4 > 2 → 4 even → target = 2, ops=2
Now target == startValue

Answer = 2 + (2-2) = 2

--------------------------------------------------

Input:
startValue = 5, target = 8

Step 1:
8 > 5 → 8 even → target=4, ops=1
Now target < startValue

Answer = ops + (startValue - target)
       = 1 + (5 - 4)
       = 2

--------------------------------------------------

Input:
startValue = 3, target = 3

target == startValue initially

Answer = 0 + (3-3) = 0

--------------------------------------------------
*/
