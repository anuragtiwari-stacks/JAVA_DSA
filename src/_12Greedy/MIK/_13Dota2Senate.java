package _12Greedy.MIK;

import java.util.*;

// Easy simulation for Dota2 Senate
public class _13Dota2Senate
{
    public String predictPartyVictory(String senate)
    {
        List<Character> list = new ArrayList<>();
        for(char c : senate.toCharArray())
        {
            list.add(c);
        }

        int idx = 0;

        while(true)
        {
            // Count current R and D
            int R = 0, D = 0;
            for(char c : list)
            {
                if(c == 'R') R++;
                else D++;
            }

            if(R == 0)
            {
                return "Dire";
            }
            if(D == 0)
            {
                return "Radiant";
            }

            char current = list.get(idx);

            if(current == 'R')
            {
                int target = findNext(list, 'D', (idx + 1) % list.size());
                if(target != -1)
                {
                    list.remove(target);
                    // after removal adjust idx if removal was before idx
                    if(target < idx)
                    {
                        idx--;
                    }
                }
            }
            else // current == 'D'
            {
                int target = findNext(list, 'R', (idx + 1) % list.size());
                if(target != -1)
                {
                    list.remove(target);
                    if(target < idx)
                    {
                        idx--;
                    }
                }
            }

            // move circular
            idx = (idx + 1) % list.size();
        }
    }

    // find next desired char in circular way
    private int findNext(List<Character> list, char target, int start)
    {
        int n = list.size();
        for(int i = 0; i < n; i++)
        {
            int pos = (start + i) % n;
            if(list.get(pos) == target)
            {
                return pos;
            }
        }
        return -1; // not found
    }

    public static void main(String[] args)
    {
        _13Dota2Senate obj = new _13Dota2Senate();

        System.out.println(obj.predictPartyVictory("RD"));    // Radiant
        System.out.println(obj.predictPartyVictory("RDD"));   // Dire
        System.out.println(obj.predictPartyVictory("RDDR"));  // Dire
        System.out.println(obj.predictPartyVictory("DRRDR")); // Radiant
    }
}

/*
================ DRY RUN ================

Input: "RDD"

list = [R, D, D]
idx = 0

Round-1:
 current = 'R'
 find next 'D' from idx+1 => removes position 1
 list becomes [R, D]
 idx moves to 1

Round-2:
 idx=1 current='D'
 find next 'R' starting idx+1 => circular => removes R at 0
 list=[D]
 only D left -> Dire wins

=========================================
*/
