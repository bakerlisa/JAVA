public class TestOrder {
    public static void main(String[] args) {
    
        Item Item1 = new Item("Mocha", 12.50);
        Item Item2 = new Item("Latte", 7.99);
        Item Item3 = new Item("Drip Coffee", 10.29);
        Item Item4 = new Item("Capuccino", 3.45);

            // ======== TESTING GETTER / SETTERS ========
            // Item1.orderInfo();
            // Item1.setTheName("Latte");
            // System.out.println(Item1.getName());
            

        // Order variables -- order1, order2 etc.
        Order order1 = new Order("Cindhuri");  
            order1.addItem(Item1);
            order1.addItem(Item2);
            order1.setTheReady(false);
            // System.out.println(order1.getStatusMessage());
        
        double orderTotal = order1.getOrderTotal();
        // System.out.println(orderTotal);

        order1.display();

    }
}
