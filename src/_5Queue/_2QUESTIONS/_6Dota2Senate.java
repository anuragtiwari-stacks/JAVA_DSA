package _5Queue._2QUESTIONS;

import java.util.*;

/*
QUESTION:
Dota2 Senate

LOGIC:
1. Senate string me 'R' (Radiant) aur 'D' (Dire) senators hote hain.
2. Do queues use karte hain:
   - ek Radiant ke indices ke liye
   - ek Dire ke indices ke liye
3. Har round me:
   - dono queues se front index nikalo
   - jiska index chhota hota hai, wahi pehle ban karta hai
   - winner ko next round ke liye index + n ke saath wapas queue me daal do
4. Jab kisi ek party ki queue empty ho jaaye,
   wahi party haar jaati hai.
*/

public class _6Dota2Senate
{

    public static String predictPartyVictory(String senate)
    {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();

        int n = senate.length();

        // Step 1: store indices
        for (int i = 0; i < n; i++)
        {
            if (senate.charAt(i) == 'R')
            {
                r.offer(i);
            }
            else
            {
                d.offer(i);
            }
        }

        // Step 2: simulate voting rounds
        while (!r.isEmpty() && !d.isEmpty())
        {
            int ri = r.poll();
            int di = d.poll();

            if (ri < di)
            {
                r.offer(ri + n);
            }
            else
            {
                d.offer(di + n);
            }
        }

        // Step 3: decide winner
        if (r.isEmpty())
        {
            return "Dire";
        }
        else
        {
            return "Radiant";
        }
    }

    public static void main(String[] args)
    {
        String senate = "RDDRR";

        String result = predictPartyVictory(senate);

        System.out.println("Winning party: " + result);
    }
}

/*
========================
DRY RUN
========================

senate = "RDDRR"
n = 5

Indices:
R queue = [0, 3, 4]
D queue = [1, 2]

Round 1:
ri = 0, di = 1
0 < 1 → R bans D
R re-added with index 0 + 5 = 5
R = [3, 4, 5]
D = [2]

Round 2:
ri = 3, di = 2
3 > 2 → D bans R
D re-added with index 2 + 5 = 7
R = [4, 5]
D = [7]

Round 3:
ri = 4, di = 7
4 < 7 → R bans D
R re-added with index 4 + 5 = 9
R = [5, 9]
D = []

D queue empty

RESULT:
Radiant wins

========================
TIME COMPLEXITY: O(n)
SPACE COMPLEXITY: O(n)
========================
END
========================
*/
