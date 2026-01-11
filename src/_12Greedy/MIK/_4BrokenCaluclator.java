package _12Greedy.MIK;

// Leetcode 991
// Custom Logic: if startValue even then *2 else -1

public class _4BrokenCaluclator
{
    public int customCalc(int startValue, int target)
    {
        int operations = 0;

        while(startValue != target)
        {
            if(startValue % 2 == 0)
            {
                startValue = startValue * 2;
            }
            else
            {
                startValue = startValue - 1;
            }

            operations = operations + 1;

            if(startValue > target)
            {
                // Avoid infinite loop by trimming extra
                operations = operations + (startValue - target);
                startValue = target;
            }
        }

        return operations;
    }

    public static void main(String[] args)
    {
        _4BrokenCaluclator obj = new _4BrokenCaluclator();

        System.out.println(obj.customCalc(2, 10)); // Example
        System.out.println(obj.customCalc(3, 10)); // Example
        System.out.println(obj.customCalc(5, 8));  // Example
    }
}

/*
---------------- DRY RUN ----------------

Example 1:
startValue = 2, target = 10
ops = 0

2 even → *2 = 4 (ops=1)
4 even → *2 = 8 (ops=2)
8 even → *2 = 16 (ops=3)

16 > 10 → trim:
ops += 16 - 10 = 6 -? Actually 16-10=6 => ops=3+6=9
startValue = 10

FINAL ops = 9

------------------------------------------

Example 2:
startValue = 3, target = 10

3 odd → -1 = 2 (ops=1)
2 even → *2 = 4 (ops=2)
4 even → *2 = 8 (ops=3)
8 even → *2 = 16 (ops=4)

16 > 10 → trim:
ops += 6 → ops=10
startValue = 10

FINAL ops = 10

------------------------------------------
*/
