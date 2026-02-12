package _17SegmentTree;

public class _2SegmentTreeQuery
{

    private int[] tree;
    private int n;

    public _2SegmentTreeQuery(int[] arr)
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

    public int query(int l, int r)
    {
        return query(0, 0, n - 1, l, r);
    }

    private int query(int node, int start, int end, int l, int r)
    {
        // Rule #1 — NO OVERLAP
        if (r < start || end < l)
        {
            return 0;
        }

        // Rule #2 — COMPLETE OVERLAP
        if (l <= start && end <= r)
        {
            return tree[node];
        }

        // Rule #3 — PARTIAL OVERLAP
        int mid = (start + end) / 2;

        int left = query(2 * node + 1, start, mid, l, r);
        int right = query(2 * node + 2, mid + 1, end, l, r);

        return left + right;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 3, 5, 7, 9};

        _2SegmentTreeQuery st = new _2SegmentTreeQuery(arr);

        System.out.println(st.query(1, 3));
    }
}

/*
QUERY DRY RUN

Array:
arr = {1, 3, 5, 7, 9}

Segment Tree already built as:
tree[0] = 25  -> [0,4]
tree[1] = 9   -> [0,2]
tree[2] = 16  -> [3,4]
tree[3] = 4   -> [0,1]
tree[4] = 5   -> [2,2]
tree[5] = 7   -> [3,3]
tree[6] = 9   -> [4,4]
tree[7] = 1   -> [0,0]
tree[8] = 3   -> [1,1]

----------------------------------
Query called:
query(1, 3)

Internally:
query(0, 0, 4, 1, 3)

----------------------------------
query(0, 0, 4)
→ partial overlap
mid = 2
→ left: query(1, 0, 2)
→ right: query(2, 3, 4)

----------------------------------
query(1, 0, 2)
→ partial overlap
mid = 1
→ left: query(3, 0, 1)
→ right: query(4, 2, 2)

query(3, 0, 1)
→ partial overlap
mid = 0
→ query(7, 0, 0) → no overlap → 0
→ query(8, 1, 1) → complete overlap → 3

Result = 3

query(4, 2, 2)
→ complete overlap → 5

Left subtree sum = 3 + 5 = 8

----------------------------------
query(2, 3, 4)
→ partial overlap
mid = 3
→ query(5, 3, 3) → complete overlap → 7
→ query(6, 4, 4) → no overlap → 0

Right subtree sum = 7

----------------------------------
Final Answer:
8 + 7 = 15

Output:
15
*/
