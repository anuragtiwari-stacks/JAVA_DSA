package _14SegmentTree;

public class _3SegmentTreeUpdate
{

    private int[] tree;
    private int n;

    public _3SegmentTreeUpdate(int[] arr)
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

    public void update(int index, int value)
    {
        update(0, 0, n - 1, index, value);
    }

    private void update(int node, int start, int end, int index, int value)
    {
        if (start == end)
        {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        if (index <= mid)
        {
            update(2 * node + 1, start, mid, index, value);
        }
        else
        {
            update(2 * node + 2, mid + 1, end, index, value);
        }

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 3, 5, 7, 9};

        _3SegmentTreeUpdate st = new _3SegmentTreeUpdate(arr);

        st.update(2, 10);
    }
}

/*
POINT UPDATE DRY RUN

Initial array:
arr = {1, 3, 5, 7, 9}

Initial segment tree values:
tree[0] = 25  -> [0,4]
tree[1] = 9   -> [0,2]
tree[2] = 16  -> [3,4]
tree[3] = 4   -> [0,1]
tree[4] = 5   -> [2,2]
tree[5] = 7   -> [3,3]
tree[6] = 9   -> [4,4]

------------------------------------
Operation:
update(index = 2, value = 10)

Call:
update(0, 0, 4, 2, 10)

------------------------------------
update(node=0, start=0, end=4)
mid = 2
index <= mid → go LEFT

------------------------------------
update(node=1, start=0, end=2)
mid = 1
index > mid → go RIGHT

------------------------------------
update(node=4, start=2, end=2)
start == end
tree[4] = 10

------------------------------------
Back to node 1
tree[1] = tree[3] + tree[4]
tree[1] = 4 + 10 = 14

------------------------------------
Back to node 0
tree[0] = tree[1] + tree[2]
tree[0] = 14 + 16 = 30

------------------------------------
Updated array:
{1, 3, 10, 7, 9}

Updated tree:
tree[0] = 30
tree[1] = 14
tree[4] = 10
*/
