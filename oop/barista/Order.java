import java.util.ArrayList;

public class Order{
    private String name;
    private String cafe;
    private Boolean ready;
    private ArrayList<Item> items;

    public Order(String name) {
        this.name = name;
    }

    public Order(){
        this.name = "Guest";
    }

    // shpwing the name data for testing purposes
    public void showInfo(){
        System.out.println(name);
    }
    
    // ======== CHANGING THE TYPE CAST ========
        // price
        public double typeCastPrice(Object price){
            Object obj = price;
            Double total = new Double(obj.toString());
            return total;
        }
        // Drink Name
        public String typeCastCafe(Object drink){
            String name = drink.toString();
            return name;
        }
}