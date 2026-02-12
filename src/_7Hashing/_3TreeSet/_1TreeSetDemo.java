package _7Hashing._3TreeSet;

import java.util.TreeSet;

public class _1TreeSetDemo {
    public static void main(String[] args) {

        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(40);
        ts.add(10);
        ts.add(30);
        ts.add(20);
        ts.add(10);   // duplicate, ignored

        System.out.println(ts); // Sorted output

        // Important methods
        System.out.println("First: " + ts.first());
        System.out.println("Last: " + ts.last());
        System.out.println("Higher than 20: " + ts.higher(20));
        System.out.println("Lower than 20: " + ts.lower(20));
        System.out.println("Ceiling of 25: " + ts.ceiling(25));
        System.out.println("Floor of 25: " + ts.floor(25));

        ts.pollFirst();
        ts.pollLast();

        System.out.println("After poll: " + ts);
    }
}
