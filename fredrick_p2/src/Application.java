public class Application {
    public static void main(String[] args){
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);

        saver1.modifyInterestRate(0.04);
        saver2.modifyInterestRate(0.04);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("saver1's balance after 4%% interest rate is $%.2f.\n",saver1.getBalance());
        System.out.printf("saver2's balance after 4%% interest rate is $%.2f.\n",saver2.getBalance());

        saver1.modifyInterestRate(0.05);
        saver2.modifyInterestRate(0.05);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.printf("saver1's balance after 5%% interest rate is $%.2f.\n",saver1.getBalance());
        System.out.printf("saver2's balance after 5%% interest rate is $%.2f.\n",saver2.getBalance());
    }
}
