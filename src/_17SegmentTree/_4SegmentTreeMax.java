package _17SegmentTree;

import java.util.*;

public class _4SegmentTreeMax
{

    private int[] tree;
    private int n;

    public _4SegmentTreeMax(int[] arr)
    {
        n = arr.length;
        tree = new int[4 * n];
        build(0, 0, n - 1, arr);
    }

    private void build(int node, int start, int end, int[] arr)
    {
        if (start == end)
        {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(2 * node + 1, start, mid, arr);
        build(2 * node + 2, mid + 1, end, arr);

        tree[node] = Math.max(tree[2 * node + 1], tree[2 * node + 2]);
    }

    public void printTree()
    {
        System.out.println(Arrays.toString(tree));
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 3, 5, 7, 9};

        _4SegmentTreeMax st = new _4SegmentTreeMax(arr);

        st.printTree();
    }
}
