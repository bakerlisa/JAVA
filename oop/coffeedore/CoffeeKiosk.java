import java.util.Scanner; 
import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Order> orders;
    private ArrayList<Item> menu;
    

    public CoffeeKiosk(){
        this.orders = new ArrayList<Order>();
        this.menu = new ArrayList<Item>();
    }

    public void addMenuItem(String name, double price){
        Item newItem = new Item(name,price);
        menu.add(newItem);
    } 

    public void addMenuItemByInput(){
        Scanner scan = new Scanner( System.in);
        System.out.println("Are you admin Y/n");
        String admin = scan.next();
        if(admin.equals("Y")){
            System.out.println("Alright you have the ability to add menu items");
            System.out.println("Item Name");
            String name = scan.next();
            System.out.println("Item price");
            String price = scan.next();

            System.out.println();
            System.out.println("Item: " + name + " for " + price  + " has benn addded!");
        }
    }

    public void displayMenu(){
        System.out.println(" ========= MENU ========= ");

        for(int i = 0; i < menu.size();i++){
            System.out.println(menu.get(i).getIndex() + " " +  menu.get(i).getName() + " -- $" + menu.get(i).getPrice());
        }
    }

    public void newOrder(){
        // Creats name
        Scanner scan = new Scanner( System.in);
        System.out.println("Name on Order");
        String name = scan.next();

        // Creats new order
        Order newOrder = new Order(name);
        displayMenu();

        // order items
        String order = "1";

        while(!order.equals("q")){
            System.out.println("Order: type the ID of your order ");
            order = scan.next();
            if(!order.equals("q")){
                int orderNum = Integer.parseInt(order); 
                newOrder.addItem(menu.get(orderNum));
            }
        }

        // adds it to our orders arrayList
        System.out.println();
        System.out.println(newOrder.getName() + " your order of:");
        for(int i=0; i<newOrder.getItems().size();i++ ){
            // ?? Why can't I get this to work ??
            //System.out.println(newOrder.getItems().get(i).getName());
            for(int j = 0; j < menu.size();j++){
                if(menu.get(j) == newOrder.getItems().get(i)){
                    System.out.println(menu.get(j).getName() + " -- $" + menu.get(j).getPrice());
                }
            }
        }
        System.out.println("__________________________");
        System.out.println("TOTAL: " + newOrder.getOrderTotal());
    }

}
