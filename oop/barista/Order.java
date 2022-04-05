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

    // showing the name data for testing purposes
    public void showInfo(){
        System.out.println(name);
    }

    // ======== GETTERS / SETTERS ========
        // Getters
        public String getName(){
            return name;
        }
        public String getCafe(){
            return cafe;
        }
        public boolean getReady(){
            return ready;
        }
        public ArrayList getItems(){
            return items;
        }

        // Setters
        public void setTheName(String person){
            this.name = person;
        }
        public void setTheCafe(String drink){
            this.cafe = drink;
        }
        public void setTheReady(boolean done){
            this.ready = done;
        }
        public void setTheItems(ArrayList<Item> orders){
            this.items = orders;
        }

    // ======== METHODS ========
        public void addItem(String name, double price){
            // STOPPED HERE
            this.items.add(name);
            System.out.println(items);
        }

    // CHANGING THE TYPE CAST 
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