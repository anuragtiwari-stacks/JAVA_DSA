package _5Hashing._2HashMap;

import java.util.HashMap;
import java.util.Map;

public class _1HashMapDemo {
    public static void main(String[] args) {

        // Creating HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // put()
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");
        map.put(4, "JavaScript");

        // putIfAbsent()
        map.putIfAbsent(3, "Ruby");

        // get()
        System.out.println("Get key 2: " + map.get(2));

        // containsKey() & containsValue()
        System.out.println("Contains key 1: " + map.containsKey(1));
        System.out.println("Contains value Java: " + map.containsValue("Java"));

        // size() & isEmpty()
        System.out.println("Size: " + map.size());
        System.out.println("Is Empty: " + map.isEmpty());

        // keySet()
        System.out.println("Keys: " + map.keySet());

        // values()
        System.out.println("Values: " + map.values());

        // entrySet()
        System.out.println("Key-Value pairs:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // replace()
        map.replace(2, "Go");
        map.replace(3, "C++", "Rust");

        // remove()
        map.remove(4);
        map.remove(1, "Java");

        // getOrDefault()
        System.out.println("Key 5: " + map.getOrDefault(5, "Not Found"));

        // compute()
        map.compute(2, (k, v) -> v + " Language");

        // computeIfAbsent()
        map.computeIfAbsent(5, k -> "Kotlin");

        // computeIfPresent()
        map.computeIfPresent(3, (k, v) -> v.toUpperCase());

        // forEach()
        System.out.println("Using forEach:");
        map.forEach((k, v) -> System.out.println(k + " -> " + v));

        // clear()
        map.clear();
        System.out.println("After clear(), isEmpty: " + map.isEmpty());
    }
}
