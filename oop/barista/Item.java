public class Item {
    
    // MEMBER VARIABLES
    private String name;
    private double price;
    
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    // DISPLAYS the order info
    public void orderInfo(){
        System.out.println(this.name + ": $" + this.price);
    }
    
    // GETTERS
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }

    // SETTERS
    public void setTheName(String order){
        this.name = order;
    }
    public void setThePrice(double num){
        this.price = num;
    }
    
}
