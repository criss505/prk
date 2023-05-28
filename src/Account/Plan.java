package Account;

public class Plan {
//    the accunt's plan (like free,premium, platinum etc)
    private String name;

    private double monthlyFee;
    private double interestRate;
    private double withdrawalFee, depositFee, transferFee;
    private double minBalance, maxBalance;
    private double minWithdrawal, maxWithdrawal;

    public Plan(String name, double monthlyFee, double interestRate, double withdrawalFee, double depositFee, double transferFee, double minBalance, double maxBalance, double minWithdrawal, double maxWithdrawal) {
        this.name = name;
        this.monthlyFee = monthlyFee;
        this.interestRate = interestRate;
        this.withdrawalFee = withdrawalFee;
        this.depositFee = depositFee;
        this.transferFee = transferFee;
        this.minBalance = minBalance;
        this.maxBalance = maxBalance;
        this.minWithdrawal = minWithdrawal;
        this.maxWithdrawal = maxWithdrawal;
    }

    public String getName() {
        return name;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public double getTransferFee() {
        return transferFee;
    }
    public double getMaxBalance() {
        return maxBalance;
    }
    public double getMonthlyFee() {
        return monthlyFee;
    }

    @Override
    public String toString() {
        return "Plan Details\n" +
                "name: '" + name + '\'' +
                "\ninterestRate: " + interestRate +
                "\nwithdrawalFee: " + withdrawalFee +
                "\ndepositFee: " + depositFee +
                "\ntransferFee: " + transferFee +
                "\nminBalance: " + minBalance +
                "\nmaxBalance: " + maxBalance +
                "\nminWithdrawal: " + minWithdrawal +
                "\nmaxWithdrawal: " + maxWithdrawal;
    }
}
