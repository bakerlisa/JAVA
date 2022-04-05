public class TestOrder {
    public static void main(String[] args) {
    
        // MENU ITEMS
        Item Item1 = new Item("Mocha", 12.50,0);
        Item Item2 = new Item("Latte", 7.99,1);
        Item Item3 = new Item("Drip Coffee", 10.29,2);
        Item Item4 = new Item("Capuccino", 3.45,3);


        CoffeeKiosk menuItems = new CoffeeKiosk();
            menuItems.addMenuItem(Item1);
            menuItems.addMenuItem(Item2);
            menuItems.addMenuItem(Item3);
            menuItems.addMenuItem(Item4);

            menuItems.displayMenu();
            menuItems.newOrder();

            // ======== TESTING GETTER / SETTERS ========
            // Item1.orderInfo();
            // Item1.setTheName("Latte");
            // System.out.println(Item1.getName());
            

        // Order variables -- order1, order2 etc.
        // Order order1 = new Order("Cindhuri");  
        //     order1.addItem(Item1);
        //     order1.addItem(Item2);
        //     order1.setTheReady(false);
        //     // System.out.println(order1.getStatusMessage());
        
        // double orderTotal = order1.getOrderTotal();
        // // System.out.println(orderTotal);

        // order1.display();

    }
}
