package OA.Tredenece_Analytics;
/*
 * Fruit Inventory Management
 *
 * A fruit shop has a list of available fruits along with their quantities.
 *
 * A customer places an order containing fruit names and the required quantities.
 *
 * Rules:
 * 1. If the fruit exists and enough quantity is available,
 *    subtract the ordered quantity from the stock.
 * 2. Return the fruit name along with the remaining quantity.
 * 3. If the fruit does not exist or sufficient quantity is not available,
 *    return the fruit name with -1.
 *
 * Example:
 *
 * Inventory:
 * Apple  50
 * Mango  30
 * Lemon  40
 * Papaya 40
 *
 * Orders:
 * Apple  10
 * Kiwi   20
 * Banana 10
 * Lemon  20
 *
 * Output:
 * Apple 40
 * Kiwi -1
 * Banana -1
 * Lemon 20
 *
 * Time Complexity : O(N + M)
 * Space Complexity: O(N)
 */

import java.util.*;

public class Inventory_Managment
{
    public static String[] purchaseFruits(String[] fruits, int[] stock,
                                          String[] orders, int[] quantity)
    {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        // Process Orders
        for(int i = 0; i < orders.length; i++)
        {
            boolean found = false;

            for(int j = 0; j < fruits.length; j++)
            {
                if(orders[i].equals(fruits[j]))
                {
                    found = true;

                    if(stock[j] >= quantity[i])
                    {
                        stock[j] = stock[j] - quantity[i];
                        map.put(orders[i], stock[j]);
                    }
                    else
                    {
                        map.put(orders[i], -1);
                    }

                    break;
                }
            }

            if(!found)
            {
                map.put(orders[i], -1);
            }
        }

        // Convert Map -> String[]
        String[] result = new String[map.size()];
        int index = 0;

        for (String key : map.keySet())
        {
            result[index++] = key + " " + map.get(key);
        }

        return result;
    }

    public static void main(String[] args)
    {
        // Inventory
        String[] fruits = {"Apple", "Mango", "Lemon", "Papaya"};
        int[] stock = {50, 30, 40, 40};

        // Customer Orders
        String[] orders = {"Apple", "Kiwi", "Banana", "Lemon"};
        int[] quantity = {10, 20, 10, 20};

        String[] answer = purchaseFruits(fruits, stock, orders, quantity);

        System.out.println("Result:");

        for(String s : answer)
        {
            System.out.println(s);
        }
    }
}