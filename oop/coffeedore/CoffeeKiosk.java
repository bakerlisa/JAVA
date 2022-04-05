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

    public void displayMenu(){
        System.out.println("MENU:");

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

        // order items
        String order = "";

        while(!order.equals("q")){
            order = scan.next();
            if(!order.equals("q")){
                int orderNum = Integer.parseInt(order); 
                newOrder.addItem(menu.get(orderNum));
            }
        }
        // adds it to our orders arrayList
        // orders.add(newOrder);

        System.out.println(newOrder);
        // newOrder.getItems();

    }

}
