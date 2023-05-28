package Account;

import java.time.LocalDate;

public class Loan {
    private double amount;
    private double monthlyPayment;
    private double interestRate;
    private int months;
    private double totalAmount;
    private double totalPayment;
    private LocalDate loanStartDate, loanEndDate;

    public Loan(double amount, double monthlyPayment, double interestRate, int months, double totalAmount, double totalPayment) {
        this.amount = amount;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.months = months;
        this.totalAmount = totalAmount;
        this.totalPayment = totalPayment;

        // loan start date is current day
        LocalDate loanStartDate = LocalDate.now();
        System.out.println("The start date is today: " + loanStartDate);

        // loan end date is start date + loan term
        LocalDate loanEndDate = loanStartDate.plusMonths(months);
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
    public double getTotalAmount() {
        return totalAmount;
    }
    public double getTotalPayment() {
        return totalPayment;
    }


    public void addAmount(double amount){
        this.amount += amount;
    }
    public void addMonthlyPayment(double monthlyPayment){
        this.monthlyPayment += monthlyPayment;
    }
    public void addTotalPayment(double totalPayment){
        this.totalPayment += totalPayment;
    }

    public void makePayment(double amount){
        this.amount -= amount;
        this.totalPayment += amount;
    }

    @Override
    public String toString() {
        return "Loan Details" +
                "\nInitial Amount: " + totalAmount +
                "\nAmount Remaining: " + amount +
                "\nMonthly Payment: " + monthlyPayment +
                "\nInterest Rate: " + interestRate +
                "\nLoan start Date: " + loanStartDate +
                "\nLoan End Date: " + loanEndDate +
                "\nTotal Months: " + months +
                "\nPaid until now: " + totalPayment;
    }
}
