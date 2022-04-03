import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;

import java.awt.event.*;
import javax.swing.*;

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
    
    public void displayMenu(ArrayList<String> menu){
        for(int i = 0; i < menu.size(); i++){
            System.out.println(i + " " + menu.get(i));
        }
    }
    
    ArrayList<String> myArray = new ArrayList<String>();
    public void addCustomer(ArrayList<String> customer){
        System.out.println("Please Print your name:");
        String userName = System.console().readLine();
        System.out.println("Hello " + userName);
        System.out.println("There are " + myArray.size() + " people in front of you");
        myArray.add(userName);
        System.out.println(myArray);
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    public void printPriceChart(String product, double price, int maxQuantity){
        double subtrack = .5;
        System.out.println(product);
        for(int i = 1; i< maxQuantity + 1; i++){
            if(i > 1){
                double newPrice = (price * i) - subtrack;
                System.out.println(i + " - $" + df.format(newPrice));
                subtrack += .5;
            }else{
                System.out.println(i + " - $" + df.format(price * i));
            }
        }
    }

    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
        
        if(menuItems.size()  == prices.size()){
            for(int i=0;i<menuItems.size() ;i++){
                System.out.println(i + ": "  + menuItems.get(i) + " -- $" + prices.get(i) );
            }
            return true;
        }else{
            return false;
        }
    }

    public void addCustomers(String name){
        System.out.println("Print a list of customers");
        String customer = System.console().readLine();

        ArrayList<String> allCustomers = new ArrayList<String>();
        allCustomers.add(customer);
        System.out.println(allCustomers);
    }

}

