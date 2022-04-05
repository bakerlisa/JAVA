import java.util.Scanner; 
import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Order> orders;
    private ArrayList<Item> menu;

    public CoffeeKiosk(){
        this.orders = new ArrayList<Order>();
        this.menu = new ArrayList<Item>();
    }

    public void addMenuItem(Item newItem){
        menu.add(newItem);
    } 

    public void displayMenu(){
        System.out.println("MENU:");
        for(int i = 0; i < menu.size();i++){
            System.out.println(menu.get(i).getIndex() + " " +  menu.get(i).getName() + " -- $" + menu.get(i).getPrice());
        }
    }

    public void newOrder(){
        Scanner scan = new Scanner( System.in);
        Order newOrder = new Order(); 
        
        // SETS ORDERER'S NAME
        System.out.println("Name on Order: ");
        String name = scan.next();
        newOrder.setTheName(name);

        // SETS UP WHAT THEY ORDERED
        System.out.println("Order: choose by id, hit q to submit order");
        String order = "1";

        while(!order.equals("q")){
            order = scan.next();
            if(!order.equals("q")){
                int orderNum = Integer.parseInt(order); 
                newOrder.addItem(menu.get(orderNum));
            }
        }

        System.out.println("Thank you " + newOrder.getName() + " Your order will be ready shortly");
        System.out.println(newOrder.getItems());

        // ============ Now we need to loop through and doe the ritht data ============
        
    }

}
