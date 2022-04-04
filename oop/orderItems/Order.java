public class Order{
    public String name;
    public String cafe;
    public Double total;
    public Boolean ready;

    public double getPrice(Object price){
        Object obj = price;
        Double total = new Double(obj.toString());

        // Double total = x * amount;
        return total;
    }

    public String getCafe(Object cafe){
        String name = cafe.toString();
        return name;
    }
}