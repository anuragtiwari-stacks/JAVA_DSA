package _20DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/*
LeetCode 120 - Triangle
Simple Recursion
*/

public class _39Triangle
{
    public int minimumTotal(List<List<Integer>> triangle)
    {
        return solve(triangle,0,0);
    }

    public int solve(List<List<Integer>> triangle,int row,int col)
    {
        if(row==triangle.size()-1)
        {
            return triangle.get(row).get(col);
        }

        int down=solve(triangle,row+1,col);

        int diagonal=solve(triangle,row+1,col+1);

        return triangle.get(row).get(col) + Math.min(down,diagonal);
    }

    public static void main(String[] args)
    {
        List<List<Integer>> triangle=new ArrayList<>();

        triangle.add(List.of(2));
        triangle.add(List.of(3,4));
        triangle.add(List.of(6,5,7));
        triangle.add(List.of(4,1,8,3));

        _39Triangle obj=new _39Triangle();

        System.out.println(obj.minimumTotal(triangle));
    }
}