package OA.Accenture.Numbers;

// Question: Given three (x, y) points, compute the sum of the pairwise distances between them

public class _18PairwiseDistances
{
    public static void main(String[] args)
    {
        double x1 = 0;
        double y1 = 0;

        double x2 = 3;
        double y2 = 4;

        double x3 = 6;
        double y3 = 0;

        System.out.println(findDistanceSum(x1, y1, x2, y2, x3, y3));
    }

    static double findDistanceSum(double x1, double y1, double x2, double y2, double x3, double y3)
    {
        double d1 = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double d2 = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
        double d3 = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));

        return d1 + d2 + d3;
    }
}