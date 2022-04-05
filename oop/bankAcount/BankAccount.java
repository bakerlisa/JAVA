import java.util.Random;

class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    public static int numAccounts = 0;
    // public static double = checkingBalance + savingsBalance;
    public static String accountNumber;

    public BankAccount(){
        numAccounts++;
        accountNumber = setAccountNumber();
    }

    // SATAIC MEHTOD
    public static int AccountCount() {
        return numAccounts;
    }

    private static String returnAccountNumber(){
        return accountNumber;
    }
    


    // PIRVATE METHOD
    private static String setAccountNumber(){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String allRolls = "";
        
        int i=0;
        while(i<10){
            Random rand = new Random();
            int randInt = rand.nextInt(25); 
            allRolls += alphabet[randInt];
            i++;
        }

        return allRolls;
    }

    // GETTERS
    public double getCheckingBalance(){
        return checkingBalance;
    }
    public double getSavingsBalance(){
        return savingsBalance;
    }

    // // METHOD
    public void addToAccount(int amount, String account){
        if(account == "savings"){
            this.savingsBalance += amount;
        }else if(account == "checking"){
            this.checkingBalance += amount;
        }
    }

    public void withdrawlFromAccount(int amount, String account){
        if(account == "savings"){
            if(this.savingsBalance - amount >= 0){    
                this.savingsBalance -= amount;
            }else{
                System.out.println("Not suffient funds");
            }
        }else if(account == "checking"){
            if(this.checkingBalance - amount >= 0){        
                this.checkingBalance -= amount;
            }else{
                System.out.println("Not suffient funds");
            }
        }
    }

    public void seeAllAccountFunds(){
        System.out.println("Checking: $" + checkingBalance);
        System.out.println("Savings: $" + savingsBalance);
    }

}