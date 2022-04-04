public class Order{
    public String name;
    public String cafe;
    public Double total;
    public Boolean ready;

    public double typeCastPrice(Object price){
        Object obj = price;
        Double total = new Double(obj.toString());

        // Double total = x * amount;
        return total;
    }

    public String typeCastCafe(Object drink){
        String name = drink.toString();
        return name;
    }
}