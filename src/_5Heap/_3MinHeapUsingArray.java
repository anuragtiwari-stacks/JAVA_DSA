package _5Heap;

public class _3MinHeapUsingArray
{

    private int[] heap;
    private int size;
    private int capacity;

    public _3MinHeapUsingArray(int capacity)
    {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    private int parent(int i)
    {
        return (i - 1) / 2;
    }

    private int leftChild(int i)
    {
        return 2 * i + 1;
    }

    private int rightChild(int i)
    {
        return 2 * i + 2;
    }

    public void insert(int value)
    {
        if (size == capacity)
        {
            System.out.println("Heap is full");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        while (current > 0 && heap[current] < heap[parent(current)])
        {
            int temp = heap[current];
            heap[current] = heap[parent(current)];
            heap[parent(current)] = temp;

            current = parent(current);
        }
    }

    public int removeMin()
    {
        if (size == 0)
        {
            return -1;
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapifyDown(0);

        return min;
    }

    private void heapifyDown(int index)
    {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] < heap[smallest])
        {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest])
        {
            smallest = right;
        }

        if (smallest != index)
        {
            int temp = heap[index];
            heap[index] = heap[smallest];
            heap[smallest] = temp;

            heapifyDown(smallest);
        }
    }

    public void display()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        _3MinHeapUsingArray minHeap = new _3MinHeapUsingArray(10);

        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        minHeap.insert(2);
        minHeap.insert(8);

        minHeap.display();

        System.out.println("Removed: " + minHeap.removeMin());
        minHeap.display();
    }
}

/*
========================
DRY RUN
========================

Insert order:
10, 5, 20, 2, 8

Insert 10
Heap = [10]

Insert 5
Heap = [5, 10]

Insert 20
Heap = [5, 10, 20]

Insert 2
Heap = [2, 5, 20, 10]

Insert 8
Heap = [2, 5, 20, 10, 8]

------------------------
removeMin()

min = 2
Move last element (8) to root

Heap before heapify:
[8, 5, 20, 10]

Heap after heapify:
[5, 8, 20, 10]

Final Heap:
[5, 8, 20, 10]

========================
END
========================
*/
