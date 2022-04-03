import java.util.ArrayList;
import java.util.Arrays;

class CafeUtil{
    public int getStreakGoal(int count){
        int i = 0;
        int sum = 0;
        while(i < count){
            sum = sum + (i + 1);
            i++;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double total = 0.0;
        for(int i = 0; i <prices.length; i++){
            total += prices[i];
        }
        
        return total;
    }

    public ArrayList<String> displayMenu(ArrayList<String> menu){
        for(int i = 0; i < menu.size(); i++){
            System.out.println(i + " " + menu.get(i));
        }
        return menu;
    }
}
