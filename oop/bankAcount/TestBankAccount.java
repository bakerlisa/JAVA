public class TestBankAccount {
    public static void main(String[] args){
        // System.out.println("Hello world");

        BankAccount account1 = new BankAccount();
        // System.out.println(account1.AccountCount());
        account1.addToAccount(200,"savings");
        account1.addToAccount(2000,"checking");

        account1.withdrawlFromAccount(100,"savings");
        account1.withdrawlFromAccount(1000,"checking");

        // System.out.println(account1.getCheckingBalance());
        // System.out.println(account1.getSavingsBalance());

        account1.seeAllAccountFunds();

    }
}
