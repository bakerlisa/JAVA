public class TestOrder {
    public static void main(String[] args) {

        CoffeeKiosk menuItems = new CoffeeKiosk();
            // ADDS ITEMS
            menuItems.addMenuItem("Mocha", 12.50);
            menuItems.addMenuItem("Latte", 7.99);
            menuItems.addMenuItem("Drip Coffee", 10.29);
            menuItems.addMenuItem("Capuccino", 3.45);
            menuItems.addMenuItem("Muffin", 1.05);

            // DISPLAYS MENU
            // menuItems.displayMenu();

            // ADDS AN ORDER
            menuItems.newOrder();
    }
}
