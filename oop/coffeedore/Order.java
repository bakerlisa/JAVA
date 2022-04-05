import java.util.ArrayList;
import java.text.DecimalFormat;

public class Order{
    private String name;
    private String cafe;
    private Boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Order(String name) {
        this.name = name;
    }

    public Order(){
        this.name = "Guest";
        this.ready = false;
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


    // ======== METHODS ========
        public void addItem(Item order){
            this.items.add(order);
        }

        public String getStatusMessage(){
            if(this.ready){
                return "Your order is ready";
            }else{
                return "Thank you for waiting. Your order will be ready soon.";
            }
        }

        public double getOrderTotal(){
            DecimalFormat df=new DecimalFormat("0.00");
            
            double total = 0.00;
            for(int i = 0; i < items.size(); i++){
                total += items.get(i).getPrice();
            }
            // makes it 2 decimals
            String formate = df.format(total); 
            double finalValue = Double.parseDouble(formate);

            return finalValue;
        }

        public void display(){
            System.out.println("Customer Name: "  + this.name);
            for(int i=0; i<this.items.size(); i++){
                System.out.println(items.get(i).getName() + "-" + items.get(i).getPrice());
            }
            System.out.println("Total: $" + getOrderTotal());
        }
}
