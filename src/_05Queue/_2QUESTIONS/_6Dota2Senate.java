package _05Queue._2QUESTIONS;

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

        // Step 1: Store indices
        for (int i = 0; i < n; i++)
        {
            if (senate.charAt(i) == 'R')
            {
                r.add(i);
            }
            else
            {
                d.add(i);
            }
        }

        // Step 2: Simulate voting rounds
        while (!r.isEmpty() && !d.isEmpty())
        {
            int ri = r.remove();
            int di = d.remove();

            if (ri < di)
            {
                r.add(ri + n);
            }
            else
            {
                d.add(di + n);
            }
        }

        // Step 3: Decide winner
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