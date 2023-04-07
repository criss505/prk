package Account;

public class Loan {
    // when a loan is created, the amount is added to the user's balance but they have monthly payment
    // to pay back the loan
    private double amount;
    private double monthlyPayment;
    private double interestRate;
    private int months;
    private double totalAmount;
    private double totalInterest;
    private double totalPayment;

    public Loan(double amount, double monthlyPayment, double interestRate, int months, double totalAmount, double totalInterest, double totalPayment) {
        this.amount = amount;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.months = months;
        this.totalAmount = totalAmount;
        this.totalInterest = totalInterest;
        this.totalPayment = totalPayment;
    }

    public double getAmount() {
        return amount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getMonths() {
        return months;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void addAmount(double amount){
        this.amount += amount;
    }

    public void addMonthlyPayment(double monthlyPayment){
        this.monthlyPayment += monthlyPayment;
    }

    public void addInterestRate(double interestRate){
        this.interestRate += interestRate;
    }

    public void addMonths(int months){
        this.months += months;
    }

    public void addTotalPayment(double totalPayment){
        this.totalPayment += totalPayment;
    }

}
