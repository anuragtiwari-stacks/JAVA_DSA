package _7Hashing._4TreeMap;

import java.util.TreeMap;
import java.util.Map;

public class _1TreeMapDemo {
    public static void main(String[] args) {

        TreeMap<Integer, String> tm = new TreeMap<>();

        tm.put(30, "Java");
        tm.put(10, "Python");
        tm.put(20, "C++");
        tm.put(40, "Go");

        System.out.println(tm); // Sorted by keys

        // Important methods
        System.out.println("First Key: " + tm.firstKey());
        System.out.println("Last Key: " + tm.lastKey());
        System.out.println("Higher than 20: " + tm.higherKey(20));
        System.out.println("Lower than 20: " + tm.lowerKey(20));
        System.out.println("Ceiling of 25: " + tm.ceilingKey(25));
        System.out.println("Floor of 25: " + tm.floorKey(25));

        // Traversing
        for (Map.Entry<Integer, String> entry : tm.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // Remove
        tm.remove(30);

        // pollFirstEntry & pollLastEntry
        tm.pollFirstEntry();
        tm.pollLastEntry();

        System.out.println("After removal: " + tm);
    }
}
