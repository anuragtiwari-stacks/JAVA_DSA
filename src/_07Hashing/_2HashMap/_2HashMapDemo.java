package _07Hashing._2HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class _2HashMapDemo {

    public static void main(String[] args) {

        // 1️⃣ Creating HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // 2️⃣ put() – Insert elements
        map.put(1, "Anurag");
        map.put(2, "Rahul");
        map.put(3, "Aman");

        System.out.println("Initial Map: " + map);
        // Output: Initial Map: {1=Anurag, 2=Rahul, 3=Aman}


        // 3️⃣ containsKey()
        System.out.println("Contains Key 2: " + map.containsKey(2));
        // Output: true

        System.out.println("Contains Key 5: " + map.containsKey(5));
        // Output: false


        // 4️⃣ containsValue()
        System.out.println("Contains Value 'Rahul': " + map.containsValue("Rahul"));
        // Output: true

        System.out.println("Contains Value 'Karan': " + map.containsValue("Karan"));
        // Output: false


        // 5️⃣ get()
        System.out.println("Value of key 1: " + map.get(1));
        // Output: Anurag

        System.out.println("Value of key 10: " + map.get(10));
        // Output: null


        // 6️⃣ size()
        System.out.println("Size of map: " + map.size());
        // Output: 3


        // 7️⃣ isEmpty()
        System.out.println("Is map empty? " + map.isEmpty());
        // Output: false


        // 8️⃣ keySet()
        Set<Integer> keys = map.keySet();
        System.out.println("Keys: " + keys);
        // Output: [1, 2, 3]


        // 9️⃣ values()
        Collection<String> values = map.values();
        System.out.println("Values: " + values);
        // Output: [Anurag, Rahul, Aman]


        // 🔟 entrySet() – Best way to iterate
        System.out.println("Iterating using entrySet():");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        /*
        Output:
        1 -> Anurag
        2 -> Rahul
        3 -> Aman
        */


        // 1️⃣1️⃣ remove()
        map.remove(2);
        System.out.println("After removing key 2: " + map);
        // Output: {1=Anurag, 3=Aman}


        // 1️⃣2️⃣ putIfAbsent()
        map.putIfAbsent(3, "Changed");
        map.putIfAbsent(4, "Karan");

        System.out.println("After putIfAbsent: " + map);
        // Output: {1=Anurag, 3=Aman, 4=Karan}


        // 1️⃣3️⃣ replace()
        map.replace(1, "Anurag Tiwari");
        System.out.println("After replace: " + map);
        // Output: {1=Anurag Tiwari, 3=Aman, 4=Karan}


        // 1️⃣4️⃣ getOrDefault()
        System.out.println("Get key 10: " + map.getOrDefault(10, "Not Found"));
        // Output: Not Found


        // 1️⃣5️⃣ clear()
        map.clear();
        System.out.println("After clear(): " + map);
        // Output: {}
    }
}