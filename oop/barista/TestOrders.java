import java.util.ArrayList;
import java.util.HashMap;

public class TestOrders {
    public static void main(String[] args) {
    
        Item Item1 = new Item("Mocha", 12.50);
        Item Item2 = new Item("Latte", 7.99);
        Item Item3 = new Item("Drip Coffee", 10.29);
        Item Item4 = new Item("Capuccino", 3.45);

            // ======== TESTING GETTER / SETTERS ========
            // Item1.orderInfo();
            // Item1.setTheName("Latte");
            // System.out.println(Item1.getName());
            // System.out.println(Item1.getPrice());

        // Order variables -- order1, order2 etc.
        Order order1 = new Order("Lisa");  
            //Testing the Order constructor
            order1.showInfo();
        // order1.name = "Cindhuri";
        // order1.cafe = order1.typeCastCafe(Item1.get(0));
        // order1.total = order1.typeCastPrice(Item1.get(1));
        // order1.ready = true;

        // Order order2 = new Order();  
        // order2.name = "Jimmy";
        // order2.cafe = order2.typeCastCafe(Item3.get(0));
        // order2.total = order2.typeCastPrice(Item3.get(1));
        // order2.ready = true;

        // Order order3 = new Order();  
        // order3.name = "Noah";
        // order3.cafe = order3.typeCastCafe(Item4.get(0)) + ", " + order3.typeCastCafe(Item2.get(0));
        // order3.total = order3.typeCastPrice(Item4.get(1)) + order3.typeCastPrice(Item2.get(1));
        // order3.ready = false;

        // Order order4 = new Order();  
        // order4.name = "Sam";
        // order4.cafe = "2 " + order4.typeCastCafe(Item4.get(0));
        // order4.total = order4.typeCastPrice(Item4.get(1)) + order4.typeCastPrice(Item4.get(1)) ;
        // order4.ready = false;



        // Application Simulations
        // Use this example code to test various orders' updates
        // System.out.printf("Name: %s\n", order4.name);
        // System.out.printf("Drink Ordered: %s\n", order4.cafe);
        // System.out.printf("Total: $%s\n", order4.total);
        // System.out.printf("Ready: %s\n", order4.ready);
    }
}
