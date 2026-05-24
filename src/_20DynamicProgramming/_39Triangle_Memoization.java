package _20DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/*
LeetCode 120 - Triangle
Recursion + Memoization
*/

public class _39Triangle_Memoization
{
    public int minimumTotal(List<List<Integer>> triangle)
    {
        int n=triangle.size();

        Integer[][] dp=new Integer[n][n];

        return solve(triangle,0,0,dp);
    }

    public int solve(List<List<Integer>> triangle,int row,int col,Integer[][] dp)
    {
        if(row==triangle.size()-1)
        {
            return triangle.get(row).get(col);
        }

        if(dp[row][col]!=null)
        {
            return dp[row][col];
        }

        int down=solve(triangle,row+1,col,dp);

        int diagonal=solve(triangle,row+1,col+1,dp);

        return dp[row][col]= triangle.get(row).get(col) + Math.min(down,diagonal);
    }

    public static void main(String[] args)
    {
        List<List<Integer>> triangle=new ArrayList<>();

        triangle.add(List.of(2));
        triangle.add(List.of(3,4));
        triangle.add(List.of(6,5,7));
        triangle.add(List.of(4,1,8,3));

        _39Triangle_Memoization obj=new _39Triangle_Memoization();

        System.out.println(obj.minimumTotal(triangle));
    }
}