public class Item {
    
    // MEMBER VARIABLES
    private String name;
    private double price;
    private int index;
    
    // CONSTRUCTOR
    public Item(String name, double price, int index){
        this.name = name;
        this.price = price;
        this.index = index;
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
    public int getIndex(){
        return index;
    }

    // SETTERS
    public void setTheName(String order){
        this.name = order;
    }
    public void setThePrice(double num){
        this.price = num;
    }
    public void setTheIndex(int idx){
        this.index = idx;
    }
    
}
