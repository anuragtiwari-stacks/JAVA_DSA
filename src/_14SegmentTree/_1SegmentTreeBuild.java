package _14SegmentTree;

import java.util.*;

public class _1SegmentTreeBuild
{

    private int[] tree;
    private int n;

    public _1SegmentTreeBuild(int[] arr)
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

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public void printTree()
    {
        System.out.println(Arrays.toString(tree));
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 3, 5, 7, 9};

        _1SegmentTreeBuild st = new _1SegmentTreeBuild(arr);

        st.printTree();
    }
}

/*
DRY RUN: SegmentTreeBuild

Input array:
arr = {1, 3, 5, 7, 9}
n = 5
tree size = 4 * n = 20

Initial tree:
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

Constructor call:
build(0, 0, 4)

------------------------------------------------
build(0, 0, 4)
mid = 2
→ build(1, 0, 2)
→ build(2, 3, 4)

build(1, 0, 2)
mid = 1
→ build(3, 0, 1)
→ build(4, 2, 2)

build(3, 0, 1)
mid = 0
→ build(7, 0, 0)
→ build(8, 1, 1)

build(7, 0, 0)
start == end
tree[7] = arr[0] = 1

build(8, 1, 1)
start == end
tree[8] = arr[1] = 3

Back to build(3, 0, 1)
tree[3] = tree[7] + tree[8]
tree[3] = 1 + 3 = 4

build(4, 2, 2)
start == end
tree[4] = arr[2] = 5

Back to build(1, 0, 2)
tree[1] = tree[3] + tree[4]
tree[1] = 4 + 5 = 9

build(2, 3, 4)
mid = 3
→ build(5, 3, 3)
→ build(6, 4, 4)

build(5, 3, 3)
start == end
tree[5] = arr[3] = 7

build(6, 4, 4)
start == end
tree[6] = arr[4] = 9

Back to build(2, 3, 4)
tree[2] = tree[5] + tree[6]
tree[2] = 7 + 9 = 16

Back to build(0, 0, 4)
tree[0] = tree[1] + tree[2]
tree[0] = 9 + 16 = 25

------------------------------------------------
Final tree array:
Index : Value
0 : 25  -> sum of [0,4]
1 : 9   -> sum of [0,2]
2 : 16  -> sum of [3,4]
3 : 4   -> sum of [0,1]
4 : 5   -> sum of [2,2]
5 : 7   -> sum of [3,3]
6 : 9   -> sum of [4,4]
7 : 1   -> arr[0]
8 : 3   -> arr[1]
rest indices = 0

Output of printTree():
[25, 9, 16, 4, 5, 7, 9, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
*/
