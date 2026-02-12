package _3LinkedList._3PW;

public class _23SpiralMatrix
{
    static class ListNode
    {
        int val;
        ListNode next;

        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head)
    {
        int[][] matrix = new int[m][n];

        // Fill with -1
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = -1;
            }
        }

        int minR = 0;
        int maxR = m - 1;
        int minC = 0;
        int maxC = n - 1;

        ListNode curr = head;

        while (curr != null && minR <= maxR && minC <= maxC)
        {
            // left -> right
            for (int j = minC; j <= maxC && curr != null; j++)
            {
                matrix[minR][j] = curr.val;
                curr = curr.next;
            }
            minR++;

            // top -> bottom
            for (int i = minR; i <= maxR && curr != null; i++)
            {
                matrix[i][maxC] = curr.val;
                curr = curr.next;
            }
            maxC--;

            // right -> left
            for (int j = maxC; j >= minC && curr != null; j--)
            {
                matrix[maxR][j] = curr.val;
                curr = curr.next;
            }
            maxR--;

            // bottom -> top
            for (int i = maxR; i >= minR && curr != null; i--)
            {
                matrix[i][minC] = curr.val;
                curr = curr.next;
            }
            minC++;
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        // Linked List: 3 → 0 → 2 → 6 → 8 → 1 → 7 → 9 → 4 → 2 → 5 → 5 → 0
        ListNode head = new ListNode(3);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);

        int m = 3;
        int n = 5;

        int[][] result = spiralMatrix(m, n, head);
        printMatrix(result);
    }
}
