import java.util.ArrayList;

public class Item{
    public ArrayList<Object> menuItem(String name, double price){
        ArrayList<Object> indvItem = new ArrayList<Object>();
        
        indvItem.add(name);
        indvItem.add(price);
        return indvItem;
    }
}

