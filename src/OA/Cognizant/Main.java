package OA.Cognizant;

import java.util.*;

/*
Question:
Create a Product class with the following properties:
    - productName
    - price
    - rating

Create 4 Product objects.

Sort the products based on the following conditions:
    1. Higher rating should come first.
    2. If rating is the same, lower price should come first.
    3. If rating and price are the same, sort by product name
       in alphabetical order.

Finally, print all the sorted products.
*/

class Product
{
    String productName;
    double price;
    int rating;

    Product(String productName, double price, int rating)
    {
        this.productName = productName;
        this.price = price;
        this.rating = rating;
    }

    public String toString()
    {
        return productName + " " + price + " " + rating;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Product p1 = new Product("Laptop", 55000, 4);
        Product p2 = new Product("Mobile", 25000, 5);
        Product p3 = new Product("Tablet", 25000, 5);
        Product p4 = new Product("Headphones", 3000, 4);

        // Storing all products in an array
        Product[] products = {p1, p2, p3, p4};

        /*
         * Sorting conditions:
         *
         * 1. Rating -> Higher rating first
         * 2. Price  -> Lower price first
         * 3. Name   -> Alphabetical order
         */
        Arrays.sort(products, (a, b) ->
        {
            if (a.rating != b.rating)
            {
                return Integer.compare(b.rating, a.rating);
            }

            if (a.price != b.price)
            {
                return Double.compare(a.price, b.price);
            }

            return a.productName.compareTo(b.productName);
        });

        for (Product p : products)
        {
            System.out.println(p);
        }
    }
}