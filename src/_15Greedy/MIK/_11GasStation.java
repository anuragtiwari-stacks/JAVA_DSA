package _15Greedy.MIK;

//Leetcode 134
public class _11GasStation
{
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        int n = gas.length;

        for(int i = 0; i < n; i++)
        {
            // agar starting station par hi fuel kam hai, start fail
            if(gas[i] < cost[i])
            {
                continue;
            }

            // circular travel ke liye next station ka index
            int j = (i + 1) % n;

            // current station se move karne ka cost
            int costFromThisStation = cost[i];

            // next station pe milne wala gas
            int gasEarnInNextStation = gas[j];

            // first move ke baad bacha hua fuel
            int currGas = gas[i] - costFromThisStation + gasEarnInNextStation;

            // circular travel jab tak poora circle complete na ho
            while(j != i)
            {
                // agar fuel kam pad gaya to ye start fail
                if(currGas < cost[j])
                {
                    break;
                }

                // current j se move karne ka cost
                int costFromThisJ = cost[j];

                // next station par jao (circular)
                j = (j + 1) % n;

                // next station pe kitna gas milega
                gasEarnInNextStation = gas[j];

                // currGas update: purane station ka cost minus + next ka gas plus
                currGas = currGas - costFromThisJ + gasEarnInNextStation;
            }

            // agar circle complete ho gaya -> j == i
            if(j == i)
            {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        _11GasStation obj = new _11GasStation();

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(obj.canCompleteCircuit(gas, cost)); // Output: 3
    }
}

/*
------------------ DRY RUN ------------------

gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
n = 5

i = 0:
gas[0]=1 < cost[0]=3 => continue

i = 1:
gas[1]=2 < cost[1]=4 => continue

i = 2:
gas[2]=3 < cost[2]=5 => continue

i = 3:
step1:
 j = 4
 currGas = gas[3]-cost[3]+gas[4] = 4-1+5 = 8

while:
 j=4 check cost[4]=2 ok
 currGas = 8 - 2 + gas = 7
 j=0

 j=0 check cost[0]=3 ok
 currGas = 7 - 3 + gas = 6
 j=1

 j=1 check cost[1]=4 ok
 currGas = 6 - 4 + gas = 5
 j=2

 j=2 check cost[2]=5 ok
 currGas = 5 - 5 + gas = 4
 j=3

j == i -> success

RETURN 3

------------------------------------------------
*/
