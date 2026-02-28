package _08Heap.CONCEPT;

public class _1MinHeapArray
{
    private int[] arr;
    private int size;

    public _1MinHeapArray(int capacity)
    {
        arr = new int[capacity];
        size = 0;
    }

    public void swap(int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int peek() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("Heap is Empty!");
        }
        return arr[0];
    }

    public int size()
    {
        return size;
    }

    public void add(int num) throws Exception
    {
        if (size == arr.length)
        {
            throw new Exception("Heap is Full");
        }
        arr[size++] = num;
        upheapify(size - 1);
    }

    private void upheapify(int idx)
    {
        if (idx == 0)
        {
            return;
        }

        int parent = (idx - 1) / 2;

        if (arr[idx] < arr[parent])
        {
            swap(idx, parent);
            upheapify(parent);
        }
    }

    public int remove() throws Exception
    {
        if (size == 0)
        {
            throw new Exception("Heap is Empty!");
        }

        int peek = arr[0];
        swap(0, size - 1);
        size--;
        downHeapify(0);
        return peek;
    }

    private void downHeapify(int i)
    {
        if (i >= size - 1)
        {
            return;
        }

        int lc = 2 * i + 1;
        int rc = 2 * i + 2;
        int minIdx = i;

        if (lc < size && arr[lc] < arr[minIdx])
        {
            minIdx = lc;
        }

        if (rc < size && arr[rc] < arr[minIdx])
        {
            minIdx = rc;
        }

        if (i == minIdx)
        {
            return;
        }

        swap(i, minIdx);
        downHeapify(minIdx);
    }

    public void display()
    {
        System.out.print("Heap: ");
        for (int i = 0; i < size; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception
    {
        _1MinHeapArray heap = new _1MinHeapArray(10);

        heap.add(5);
        heap.add(2);
        heap.add(9);
        heap.add(1);
        heap.add(7);

        heap.display();

        System.out.println("Removed: " + heap.remove());
        heap.display();

        System.out.println("Removed: " + heap.remove());
        heap.display();
    }
}
