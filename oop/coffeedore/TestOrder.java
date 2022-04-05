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

    }
}
