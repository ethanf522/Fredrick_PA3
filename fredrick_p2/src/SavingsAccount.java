public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }

    public double getBalance(){
        return savingsBalance;
    }

    public void calculateMonthlyInterest(){
        savingsBalance += (savingsBalance * annualInterestRate) / 12;
    }

    public void modifyInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
}
