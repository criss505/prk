package Account;

public class Plan {
//    the accunt's plan (like free,premium, platinum etc)
    private String name;
    private double interestRate;
    private double withdrawalFee, depositFee, transferFee;
    private double minBalance, maxBalance;
    private double minWithdrawal, maxWithdrawal;

    public Plan(String name, double interestRate, double withdrawalFee, double depositFee, double transferFee, double minBalance, double maxBalance, double minWithdrawal, double maxWithdrawal) {
        this.name = name;
        this.interestRate = interestRate;
        this.withdrawalFee = withdrawalFee;
        this.depositFee = depositFee;
        this.transferFee = transferFee;
        this.minBalance = minBalance;
        this.maxBalance = maxBalance;
        this.minWithdrawal = minWithdrawal;
        this.maxWithdrawal = maxWithdrawal;
    }

//    getters
    public String getName() {
        return name;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getWithdrawalFee() {
        return withdrawalFee;
    }

    public double getDepositFee() {
        return depositFee;
    }

    public double getTransferFee() {
        return transferFee;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public double getMaxBalance() {
        return maxBalance;
    }

    public double getMinWithdrawal() {
        return minWithdrawal;
    }

    public double getMaxWithdrawal() {
        return maxWithdrawal;
    }

//   setters

    public void setName(String name) {
        this.name = name;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setWithdrawalFee(double withdrawalFee) {
        this.withdrawalFee = withdrawalFee;
    }

    public void setDepositFee(double depositFee) {
        this.depositFee = depositFee;
    }

    public void setTransferFee(double transferFee) {
        this.transferFee = transferFee;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public void setMaxBalance(double maxBalance) {
        this.maxBalance = maxBalance;
    }

    public void setMinWithdrawal(double minWithdrawal) {
        this.minWithdrawal = minWithdrawal;
    }

    public void setMaxWithdrawal(double maxWithdrawal) {
        this.maxWithdrawal = maxWithdrawal;
    }


}
