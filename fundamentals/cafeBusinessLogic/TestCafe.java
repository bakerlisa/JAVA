import java.util.ArrayList;
import java.util.Arrays;
public class TestCafe {
    public static void main(String[] args) {
        
    /* 
        You will need add 1 line to this file to create an instance 
        of the CafeUtil class. 
        Hint: it will need to correspond with the variable name used below..
    */
        CafeUtil appTest = new CafeUtil();
        int numWeeks = 10;
        /* ============ App Test Cases ============= */
    
        // TEST 1
        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(numWeeks));
    
        System.out.println("----- Order Total Test-----");
        double[] lineItems = {3.5, 1.5, 4.0, 4.5};
        System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
        
        // TEST 2
        // System.out.println("----- Display Menu Test-----");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);
    
        // TEST 3
        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            // appTest.addCustomer(customers);
            System.out.println("\n");
        }

        // BONUS: TEST 4
        // appTest.printPriceChart("Coffee",2.00,4);

        // BONUS: TEST 5
        ArrayList<Double> prices = new ArrayList<Double>();
        prices.add(12.00);
        prices.add(3.75);
        prices.add(6.99);
        prices.add(7.50);

        appTest.displayMenu(menu,prices);

        // SENSI BONUS
        ArrayList<String> allCustomers = new ArrayList<String>(); 
        System.out.println("Print a list of customers");
        String newCustomers = "";

        while(!newCustomers.equals('q')){
            Stsyem.out.println(newCustomers);
            newCustomers = appTest.addCustomers();
    
            allCustomers.add(newCustomers);
            System.out.println(allCustomers);
        }

        System.out.println(allCustomers);
        
    }
}
