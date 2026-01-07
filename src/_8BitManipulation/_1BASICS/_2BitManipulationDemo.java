package _8BitManipulation._1BASICS;

public class _2BitManipulationDemo
{
    public static void main(String[] args)
    {
        int number = 5; // 5 in binary is 101
        int position = 1; // we want to manipulate the 2nd bit from the right (index 1)

        // Dry Run in comments for each operation

        // 1. Get Bit
        // (number >> position) shifts bits right → 101 >> 1 = 10
        // 10 & 1 = 0 → So the bit at position 1 is 0
        int getBit = (number >> position) & 1;
        System.out.println("Get Bit at position " + position + ": " + getBit);

        // 2. Set Bit
        // (1 << position) = 1 << 1 = 010
        // number | 010 = 101 | 010 = 111 → 7
        int setBit = number | (1 << position);
        System.out.println("Set Bit at position " + position + ": " + setBit);

        // 3. Clear Bit
        // (1 << position) = 1 << 1 = 010
        // ~(1 << position) = ~010 = ...101 (binary)
        // 101 & ...101 = 100 → 4
        int clearBit = number & ~(1 << position);
        System.out.println("Clear Bit at position " + position + ": " + clearBit);

        // 4. Toggle Bit
        // 101 ^ 010 = 111 → 7
        int toggleBit = number ^ (1 << position);
        System.out.println("Toggle Bit at position " + position + ": " + toggleBit);
    }
}
